package org.bobo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map.Entry;


public class HttpUtils {

	//logger
	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	public static void  main(String args[]){
		//String url  ="http://mail.op.okjiaoyu.cn/sender/mail?tos=chengwenbo@okjiaoyu.cn&subject=OKAY mock 更改密码&content=123123";
		//String url  ="http://172.18.4.248:4000/sender/mail?tos=chengwenbo@okjiaoyu.cn&subject=OKAY mock 更改密码&content=123123";
		String url  ="http://mail.op.okjiaoyu.cn/sender/mail";
		HashMap<String, String> params = new HashMap<>();
		//邮件主题
		params.put("subject", "Test邮件主题111");
		//收件人列表,多个用逗号隔开
		params.put("tos","chengwenbo@okjiaoyu.cn");
		//发送内容
		params.put("content","Test发送的内容");

		try {
			String retStr  = sendPost(url,params);
			logger.info("==retStr= {}",retStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static String sendGet(String url, HashMap<String, String> params) throws Exception {
		String result = "";
		BufferedReader in = null;
		try {
			String param = parseParams(params);//
			String urlNameString = url + "?" + param;
			URL getUrl = new URL(urlNameString);
			URLConnection connection = getUrl.openConnection();

			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			connection.connect();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception e2) {
				throw e2;
			}
		}
		return result;
	}


	public static String sendPost(String url, HashMap<String, String> params) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL postUrl = new URL(url);
			URLConnection connection = postUrl.openConnection();

			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			connection.setDoOutput(true);
			connection.setDoInput(true);

			out = new PrintWriter(connection.getOutputStream());

			String param = parseParams(params);
			out.print(param);
			out.flush();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (out != null)out.close();
				if (in != null)in.close();
			} catch (IOException e2) {
				throw e2;
			}
		}
		return result;
	}


	private static String parseParams(HashMap<String, String> map) {
		StringBuffer sb = new StringBuffer();
		if (map != null) {
			for (Entry<String, String> e : map.entrySet()) {
				sb.append(e.getKey()).append("=").append(e.getValue()).append("&");
			}
			sb.substring(0, sb.length() - 1);
		}
		return sb.toString();
	}
}
