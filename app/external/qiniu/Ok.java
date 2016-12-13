package external.qiniu;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import utils.BnsUtils;

public class Ok {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//System.out.println(new Qiniu().getUpToken());
		String fileName ="o_1b36dcfu51u7llr31pe6c2n7hp9.jpg";
		URL url =new URL(new Qiniu().URL+fileName);
		File target =new File("E://download/"+fileName);
		BnsUtils.copyFromUrl(url, target);
	}

}
