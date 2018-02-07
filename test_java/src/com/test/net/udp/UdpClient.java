package com.test.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpClient extends Thread {
	
	private DatagramSocket socket;
	private InetAddress address;
	byte[] buf = new byte[1024];
	private DatagramPacket dp = new DatagramPacket(buf, buf.length);
	private int id;
	
	public UdpClient(int id) {
		this.id = id;
		try {
			socket = new DatagramSocket();
			address = InetAddress.getByName(null);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 25; i++) {
			String message = "Client #" + id + " ,编号 : " + i;
			try {
				socket.send(DatagramUtil.toDatagram(message, address, 65530));
				socket.receive(dp);
				System.out.println(new String(dp.getData(),0,dp.getLength()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("client start");
		for (int i = 0; i < 10; i++) {
			new UdpClient(i).start();
		}
	}
}
