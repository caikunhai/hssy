package exporter;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

import controllers.CompanyController;
import entities.BnsOrder;
import system.log.Logger;
import utils.BnsUtils;

public class ExporterOrder {

	public static OutputStream export(List<BnsOrder>vos){
		OutputStream outputStream = null;
		if (vos == null)
			return null;
		try {
			outputStream = new ByteArrayOutputStream();
		} catch (Exception e) {
			// TODO: handle exception
			Logger.error("订单导出", " new FileOutputStream Exception: "+ e.toString());
		}

		boolean ok = false;
		List<String> titles = ExporterOrder.getTitles();
		try {
			// 创建工作薄
			HSSFWorkbook wb = new HSSFWorkbook();
			String sheetname = "导出的内容";
			// 创建工作表
			HSSFSheet sheet = wb.createSheet(sheetname);

			// 创建标题行
			HSSFRow row1 = sheet.createRow(0);
			// 居中显示
			HSSFCellStyle cellStyle = wb.createCellStyle();

			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			addTitles(cellStyle, row1, titles);
			// 添加内容
			ok = ExporterOrder.addContents(sheet, cellStyle, vos, 1);

			sheet.setColumnWidth(0, 3500);
			sheet.setColumnWidth(1, 3500);
			sheet.setColumnWidth(2, 3500);
			sheet.setColumnWidth(3, 3500);

			// 写入到导出流
			wb.write(outputStream);
		} catch (FileNotFoundException e) {
			Logger.error("订单导出", "FileNotFoundException error: "+ e.toString());
		} catch (Exception e) {
			// TODO: handle exception
			Logger.error("订单导出", "Exception error: " + e.toString());
		}
		return outputStream;
	}

	/**
	 * 获取某月的统计信息列表导出文件的标题内容
	 * 
	 * @return
	 */
	private static List<String> getTitles() {
		List<String> titles = new ArrayList<String>();

		titles.add("订单编号");
		titles.add("订单状态");
		titles.add("拍摄日期");
		titles.add("下单商家");
		titles.add("客户姓名");
		titles.add("身份证号");
		titles.add("联系电话");
		titles.add("拍摄风格");
		titles.add("拍摄景点");
		titles.add("订购住宿");
		titles.add("是否接送");
		titles.add("总费用");
		return titles;
	}

	/**
	 * 添加导出文件的所有内容
	 * @param sheet
	 * @param cellStyle
	 * @param vos
	 * @param startRow
	 * @return
	 */
	public static boolean addContents(HSSFSheet sheet, HSSFCellStyle cellStyle,List<BnsOrder> vos, int startRow) {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm"); //格式化为 hhmmss
		boolean ok = false;
		if (sheet == null)
			return false;
		if (cellStyle == null)
			return false;
		if (vos == null)
			return false;
		if (startRow < 0)
			return false;
		try {
			for (int i = 0; i < vos.size(); i++) {
				// 创建行
				HSSFRow row = sheet.createRow(startRow + i);
				// 组织一行的内容
				List<String> data = new ArrayList<String>();
				BnsOrder vo = vos.get(i);
				
				data.add( vo.getCode());
				data.add( BnsUtils.stateName(vo.getState()));
				data.add( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(vo.getTakeTime()) );
				data.add( CompanyController.name4Company(vo.getCreatedUser()) );
				data.add( vo.getCustomer() );
				data.add( vo.getIdcard() );
				data.add( vo.getMobile() );
				data.add( vo.getCloth() );
				data.add( vo.getSite() );
				data.add( vo.getHotel() );
				data.add( vo.getPickup()==0?"否":"是" );
				data.add( vo.getMoney()+"" );
				
				// 添加一行的内容
				addRowContent(cellStyle, row, data);
				data.clear();
				data = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.error("订单导出", "error: " + e.toString());
		}

		return ok;
	}
	
	public static boolean addRowContent(HSSFCellStyle cellStyle, HSSFRow row,
			List<String> data) {
		boolean ok = false;
		if (cellStyle == null)
			return false;
		if (row == null)
			return false;
		if (data == null)
			return false;
		try {
			for (int i = 0; i < data.size(); i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				// 居中显示
				cell.setCellStyle(cellStyle);
				// 设置单元格0的值
				cell.setCellValue(data.get(i));
			}
			ok = true;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.error("订单导出", "addRowContent() error: " + e.toString());
		}
		return ok;
	}
	
	public static boolean addTitles(HSSFCellStyle cellStyle, HSSFRow row,List<String> titles) {
		boolean ok = false;
		if (cellStyle == null)
			return false;
		if (row == null)
			return false;
		if (titles == null)
			return false;
		try {
			for (int i = 0; i < titles.size(); i++) {
				HSSFCell cell = row.createCell(i);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				// 居中显示
				cell.setCellStyle(cellStyle);
				// 设置单元格0的值
				cell.setCellValue(titles.get(i));
			}
			ok = true;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.error("订单导出", "addTitles() error: " + e.toString());
		}
		return ok;
	}



}