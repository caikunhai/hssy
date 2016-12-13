package controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;

import entities.BnsOrder;
import exporter.ExporterOrder;
import play.Play;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;
import system.init.Const;
import system.log.Logger;
import utils.BnsUtils;
import utils.CryptTool;

@Controller
public class SysController extends play.mvc.Controller {
	
	private static ByteArrayOutputStream baos;
	
	/**
	 * 附件上传
	 * @return
	 * @throws IOException
	 */
	public static Result upload() throws IOException{
		MultipartFormData body = request().body().asMultipartFormData();
		if (body != null) {
			List<FilePart> pictures = body.getFiles();
			if (pictures.size() > 0) {
				File pic = pictures.get(0).getFile();
				if (pic == null) {
					Logger.warn("上传附件","附件为空!!!");
				}
				String fileName =UUID.randomUUID()+"-"+CryptTool.getDate()+".jpg";
				//String fileUrl ="/public/uploads/"+ fileName;
				//System.out.println("------Play.application().path()----"+Play.application().path());
				//File target = new File(Play.application().path() +fileUrl);
				File target = new File(Const.FileUrl +fileName);
				FileUtils.copyFile(pic, target);
				return ok(fileName);
			}
		}
		return ok();
	}
	
	public static Result get(String name) throws IOException{
		return ok(new File(Const.FileUrl +name));
	}
	
	/**
	 * 附件下载
	 * @param id
	 * @return
	 * @throws IOException
	 */
	public static Result download(String id) throws IOException{
		BnsOrder obj =OrderController.getOderObj(id);
		if(obj==null){
			return ok();
		}
		List<File> list =new ArrayList<File>();
		String[] imgs =obj.getImgs().split(",");
		for(String img:imgs){
			File file =new File(Play.application().path() + "/public/uploads/"+img);
			if(file.exists()&&!file.isDirectory()){
				list.add(file);
	        }
		}
		
		OutputStream os = null;
		if (list.size()==0)
			return ok();
		try {
			os = new ByteArrayOutputStream();
		} catch (Exception e) {
			// TODO: handle exception
			Logger.error("附件导出", " new FileOutputStream Exception: "+ e.toString());
		}
		ZipOutputStream zos = new ZipOutputStream(os);
		BnsUtils.zipFiles(list,zos);
        
        baos = (ByteArrayOutputStream)os;
		
		// Prepare a chunked text stream
		Chunks<byte[]> chunks = new ByteChunks() {

			// Called when the stream is ready
			@Override
			public void onReady(play.mvc.Results.Chunks.Out<byte[]> out) {
				out.write(baos.toByteArray());// IOUtils.toByteArray(input)
				out.close();
				IOUtils.closeQuietly(baos);
			}
		};

		response().setContentType("application/x-download");
		response().setHeader("Content-disposition","attachment; filename=files.zip");

		// Serves this stream with 200 OK
		return ok(chunks);
	}
	
	
	public static Result unFinish(String token){
		List<BnsOrder> list =OrderController.unFinish(token);
		OutputStream os = ExporterOrder.export(list);
		return exporter2Xls(os);
	}
	
	public static Result exporter2Xls(OutputStream os){
		if(os != null)
			baos = (ByteArrayOutputStream)os;
		else{
			Logger.error("订单导出", "exporter2Xls() convert to xls fail"); 
			return ok();
		}
		
		// Prepare a chunked text stream
		Chunks<byte[]> chunks = new ByteChunks() {

			// Called when the stream is ready
			@Override
			public void onReady(play.mvc.Results.Chunks.Out<byte[]> out) {
				out.write(baos.toByteArray());// IOUtils.toByteArray(input)
				out.close();
				IOUtils.closeQuietly(baos);
			}
		};

		response().setContentType("application/x-download");
		response().setHeader("Content-disposition","attachment; filename=orders.xls");

		// Serves this stream with 200 OK
		return ok(chunks);
	}
	
}
