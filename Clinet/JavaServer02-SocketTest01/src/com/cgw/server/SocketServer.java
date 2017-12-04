package com.cgw.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
	}
	
	public static void run()
	{
		// Socket指定端口号为0-65535 ，不能与其他进程端口号冲突，否则启动时称呼会报端口占用的错误
		int servPort = 4700;
		// 创建服务端socket
		ServerSocket servSocket = null;
		int recvMsgSize = 0;
		//接受字节缓冲数组
		byte[] receivBuf = new byte[32];
		try{
			servSocket = new ServerSocket(servPort);
			while(true){
				System.out.println("服务端一起动绑定端口："+servPort);
				Socket clientSocket = servSocket.accept();
				SocketAddress clientAddress = clientSocket.getRemoteSocketAddress();
				System.out.println("收到客户端连接，ip:"+clientAddress);
				InputStream in = clientSocket.getInputStream();
				OutputStream out = clientSocket.getOutputStream();
				//接受客户端发来的数据，并原样返回给客户端
				while((recvMsgSize = in.read(receivBuf)) != -1){
					String recivedData = new String(receivBuf.toString());
					System.out.println(recivedData);
					out.write(receivBuf,0,recvMsgSize);
				}
				//释放Socket资源
				clientSocket.close();
				
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
