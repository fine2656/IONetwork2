package net.day1;

import java.net.*;

public class InetAdrressTest {

	public static void main(String[] args) {
	
		//InetAddress 클래스 ==> IP와 관련된 클래스
		try {
			//InetAddress inet_ip = InetAddress.getByName("DESKTOP-B538J3H");
			
			//InetAddress inet_ip = InetAddress.getByName("127.0.0.1");
			//ip가 127.0.0.1은 자기자신을 가리키는 ip 주소이다
			//이것을 Loopback Address라고 부른다
			
			//InetAddress inet_ip = InetAddress.getByName("192.168.50.14");// 내 아이피 주소
			//InetAddress inet_ip = InetAddress.getByName("192.168.50.34");// 상대방 아이피 주소
			InetAddress inet_ip = InetAddress.getByName("localhost");// 
			/*	myip : 127.0.0.1
				myhostname : localhost// 자기 아이피
*/
			
			
			//C:\Windows\System32\drivers\etc : hosts file 주소,hosts file 편집
			//www.suwook.com 편집
			
			String ip = inet_ip.getHostAddress();
			System.out.println("ip : "+ip);
			String hostname = inet_ip.getHostName();
			System.out.println("hostname : "+hostname);
			
			System.out.println("------------------------------------");
			InetAddress inet_ip2 = InetAddress.getByName("www.iei.or.kr");
			String ip2 = inet_ip2.getHostAddress();
			System.out.println("ip2 : "+ip2);
			String hostname2 = inet_ip2.getHostName();
			System.out.println("hostname2 : "+hostname2);
			System.out.println("-------------------------------------");
			InetAddress[] inetAddrArr = InetAddress.getAllByName("www.google.com");
			for(int i=0;i<inetAddrArr.length;i++) {
				System.out.println(inetAddrArr[i].getHostAddress());
				/*
				 	108.177.97.99
					108.177.97.147
					108.177.97.106
					108.177.97.104
					108.177.97.103
					108.177.97.105 
				 */
			}
			//1개의 HostName에 여러개의 IP Address 를 사용하는 서버의 경우
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
