package com.test.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 多客户端与服务端通信
 * 	创建多个socket，为每一个socket启动一个线程处理。
 * 	创建一个现成处理类，将socket作为参数传递进去，类内部做对应操作。
 * @author xhk
 */
public class MultyJabberClient {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws UnknownHostException, InterruptedException {
		InetAddress address = InetAddress.getByName(null);
		while(true){
			if(MultyClient.threadCounter() < 40){
				new MultyClient(address);
				Thread.currentThread().sleep(100);
			}
		}
	}

}

class MultyClient extends Thread {

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private static int counter = 0;
	private int id = counter++;
	private static int threadCounter = 0;
	
	public static int threadCounter() {
		return threadCounter;
	}
	
	public MultyClient(InetAddress ia) {
		System.out.println("Multy Client : " + id);
		threadCounter++;
		try {
			socket = new Socket(ia, 8080);
		} catch (IOException e) {}
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			start();
		} catch (IOException e) {
			try {
				socket.close();
			} catch (IOException e1) {}
		}
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 25; i++) {
				out.println("Client " + id + "编号" + i);
				String str = in.readLine();
				System.out.println(str);
			}
			out.println("END");
		} catch (IOException e) {}
		finally {
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			threadCounter--;
		}
	}
}