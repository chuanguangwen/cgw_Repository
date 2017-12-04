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
		// 接受客户端消息
		System.out.println("服务端接受："+message);
		// 给客户端发送一条消息
		session.getBasicRemote().sendText("服务端发送第一条消息："+message);
		// 服务端没3s给客户端主动推送一条消息
		int sentMessages = 0;
		while(sentMessages < 10)
		{
			Thread.sleep(3000);
			sentMessages++;
			session.getBasicRemote().sendText("服务端主动推送的第"+sentMessages+"消息");
		}
		session.getBasicRemote().sendText("服务端竹筒推送的最后一条消息");
		session.close();
	}
	
	@OnOpen
	public void onOpen()
	{
		System.out.println("客户端建立连接");
	}
	
	@OnClose
	public void onClose(){
		System.out.println("连接关闭");
	}
}
