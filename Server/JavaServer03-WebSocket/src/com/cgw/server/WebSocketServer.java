package com.cgw.server;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebSocketServer {
	@OnMessage
	public void onMessage(String message , Session session) throws IOException , InterruptedException{
		// ���ܿͻ�����Ϣ
		System.out.println("����˽��ܣ�"+message);
		// ���ͻ��˷���һ����Ϣ
		session.getBasicRemote().sendText("����˷��͵�һ����Ϣ��"+message);
		// �����û3s���ͻ�����������һ����Ϣ
		int sentMessages = 0;
		while(sentMessages < 10)
		{
			Thread.sleep(3000);
			sentMessages++;
			session.getBasicRemote().sendText("������������͵ĵ�"+sentMessages+"��Ϣ");
		}
		session.getBasicRemote().sendText("�������Ͳ���͵����һ����Ϣ");
		session.close();
	}
	
	@OnOpen
	public void onOpen()
	{
		System.out.println("�ͻ��˽�������");
	}
	
	@OnClose
	public void onClose(){
		System.out.println("���ӹر�");
	}
}
