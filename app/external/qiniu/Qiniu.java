package external.qiniu;

import com.qiniu.util.Auth;

public class Qiniu {
	
	private String ACCESS_KEY="ylqDh7YUUgHZ5MOIyC7FSYY3FQHchfTL2DE7Petp";
	private String SECRET_KEY="hs_AQ3-7DwNx6YlP_4vwbhRo_ejaoKp9CYacob_V";
	private String bucketName="caikunhai";
	public String URL = "http://7xr5um.com1.z0.glb.clouddn.com/";
	
	//密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    
    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        return auth.uploadToken(bucketName);
    }
    

}
