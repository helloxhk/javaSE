package com.test.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * @author xhk
 */
public class JabberServer {

	public static final int PORT = 8080;
	
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(PORT);
		
		System.out.println("start");
		
		try {
			Socket accept = server.accept();
			
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(accept.getInputStream()));
				PrintWriter out = new PrintWriter(new OutputStreamWriter(accept.getOutputStream()),true);
				while(true){
					String str = in.readLine();
					if("END".equals(str)){
						break;
					}
					System.out.println("echo : " + str);
					out.println(str);
				}
			} finally {
				accept.close();
			}
			
		} finally {
			server.close();
		}
	}

}
