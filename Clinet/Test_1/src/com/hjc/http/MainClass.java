package com.hjc.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/*
 * java.net包中始于网络操作相关的API
 */
public class MainClass {
	public static void main(String[] args)
	{
		try {
			String destination = "http://www.baidu.com";
			//定义URL
			URL url = new URL(destination);
			//打开连接，强制转换为HttpURLConnection
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			
			//获取输入流，并用BufferedReader进行封装
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sBuffer = new StringBuffer();
			String line = "";
			//读取返回流中的内容
			while((line = reader.readLine()) != null) {
				sBuffer.append(line).append("\r\n");
			}
			//打印状态码
			System.out.println("Http response code ================> " + conn.getResponseCode());
			System.out.println("Http response ================> " + sBuffer);
			conn.disconnect();
		}catch (MalformedURLException a){
			a.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}