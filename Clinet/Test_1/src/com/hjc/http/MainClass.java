package com.hjc.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/*
 * java.net����ʼ�����������ص�API
 */
public class MainClass {
	public static void main(String[] args)
	{
		try {
			String destination = "http://www.baidu.com";
			//����URL
			URL url = new URL(destination);
			//�����ӣ�ǿ��ת��ΪHttpURLConnection
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			
			//��ȡ������������BufferedReader���з�װ
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sBuffer = new StringBuffer();
			String line = "";
			//��ȡ�������е�����
			while((line = reader.readLine()) != null) {
				sBuffer.append(line).append("\r\n");
			}
			//��ӡ״̬��
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