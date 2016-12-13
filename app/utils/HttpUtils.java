package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

public class HttpUtils {

	public static final int CONN_TIMEOUT = 20000;
	public static final int SO_TIMEOUT = 60000;

	/**
	 * get
	 * 
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static HttpResult get(String url) throws ClientProtocolException,
			IOException {

		HttpResult result = new HttpResult();

		HttpClient client = new DefaultHttpClient();
		client.getParams().setParameter(
				CoreConnectionPNames.CONNECTION_TIMEOUT, CONN_TIMEOUT);// 连接时间20s
		client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
				SO_TIMEOUT);// 数据传输时间60s
		client.getParams().setParameter("http.protocol.content-charset",
				"UTF-8");// 解决中文乱码

		HttpGet get = new HttpGet(url);

		// add header
		get.setHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");

		// 发起请求
		HttpResponse response = client.execute(get);

		result.setCode(response.getStatusLine().getStatusCode());
		
		if (response.getEntity() != null) {
			HttpEntity entity = response.getEntity();
			result.setMessage(EntityUtils.toString(entity,"UTF-8"));
		}
		
		return result;
	}

	/**
	 * post
	 * 
	 * @param url
	 * @param parameters
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static HttpResult post(String url, List<NameValuePair> parameters)
			throws Exception {

		HttpResult result = new HttpResult();

		HttpClient client = new DefaultHttpClient();
		client.getParams().setParameter(
				CoreConnectionPNames.CONNECTION_TIMEOUT, CONN_TIMEOUT);// 连接时间20s
		client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT,
				SO_TIMEOUT);// 数据传输时间60s
		client.getParams().setParameter("http.protocol.content-charset",
				"UTF-8");// 解决中文乱码

		HttpPost post = new HttpPost(url);

		// add header
		post.setHeader("Content-Type",
				"application/x-www-form-urlencoded;charset=UTF-8");

		// 写入参数
		if (parameters != null) {
			post.setEntity(new UrlEncodedFormEntity(parameters, "UTF-8"));
		}

		// 发起请求
		HttpResponse response = client.execute(post);

		result.setCode(response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		StringBuffer stringBuffer = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			stringBuffer.append(line);
		}

		result.setMessage(stringBuffer.toString());

		return result;
	}

}
