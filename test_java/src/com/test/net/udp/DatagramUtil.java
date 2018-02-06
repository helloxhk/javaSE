package com.test.net.udp;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class DatagramUtil {
	
	public static DatagramPacket toDatagram(String s, InetAddress addr, int port){
		byte[] buf = s.getBytes();
		return new DatagramPacket(buf , buf.length, addr, port);
	}
	
	public static String toString(DatagramPacket dp){
		return new String(dp.getData(), 0, dp.getLength());
	}
	
}
