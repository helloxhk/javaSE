package com.test.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多客户端与服务端通信
 * 	每接受到一个socket请求，创建一个线程去处理它。
 * 	将socket传入一个线程类，在类内部做处理。
 * @author xhk
 */
public class MultyJabberServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		System.out.println("start");
		try {
			while(true){
				Socket accept = server.accept();
				try {
					new Thread(new MultyServer(accept)).start();;
				} catch (Exception e) {
					accept.close();
				}
			}
		} finally {
			server.close();
		}
	}
}

class MultyServer implements Runnable {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	public MultyServer(Socket socket) {
		this.socket = socket;
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			while(true){
				try {
					String str = in.readLine();
					if("END".equals(str)){
						break;
					}
					System.out.println(str);
					out.println(str);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {}
		finally{
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}