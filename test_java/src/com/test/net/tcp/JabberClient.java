package com.test.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端
 * @author xhk
 */
public class JabberClient {
	
	public static void main(String[] args) throws IOException {
		InetAddress address = InetAddress.getByName(null);
		
		System.out.println("address : " + address);
		
		Socket socket = new Socket(address, JabberServer.PORT);
		
		try {
			System.out.println("socket : " + socket);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
			
			for (int i = 0; i < 10; i++) {
				out.println("howdy" + i);
				String str = in.readLine();
				System.out.println(str);
			}
			
			out.println("END");
			
		} finally {
			socket.close();
		}
	}
}
