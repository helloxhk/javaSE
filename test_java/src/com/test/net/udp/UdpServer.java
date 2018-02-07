package com.test.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
	public static void main(String[] args) {
		System.out.println("server start");
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		try {
			@SuppressWarnings("resource")
			DatagramSocket socket = new DatagramSocket(65530);
			try {
				while(true){
					socket.receive(dp);
					String str = DatagramUtil.toString(dp) + "IP" + dp.getAddress() + "PORT" + dp.getPort();
					System.out.println(str);
					DatagramPacket p = DatagramUtil.toDatagram(str, dp.getAddress(), dp.getPort());
					socket.send(p);
				}
				
			} catch (IOException e) {
				System.out.println("packet x");
			}
		} catch (SocketException e) {
			System.out.println("socket x");
		}
	}
}
