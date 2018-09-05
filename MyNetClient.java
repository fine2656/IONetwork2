package net.day1;

import java.io.*;
import java.net.*;//java.net.*은 항상 java.io.*과 같이 동반되야한다.
import java.util.*;

public class MyNetClient {

/*
  	===== TCP 통신방식을 이용한 예제 =====
  	-서버단 		: SeverSocket과 Socket 이 필요함.//연결 해야하는 소켓이 필요함.
  	-클라이언트단	: socket 이 필요함.
  	 
 */

	public static void main(String[] args) throws UnknownHostException, IOException {
	Scanner sc = new Scanner (System.in);
	
	System.out.print(">>연결 할 서버의 IP 주소 입력 :  ");
	//String serverIP  = sc.nextLine(); -> 이렇게 하면 안된다!! : 서버 IP에 192.618.50.34\r\n 의 엔터까지 읽어옴
	//엔터까지 입력되므로 192.618.50.34\r\n 은 IP로 사용하지 못한다.
	
	String serverIP = sc.next();//엔터 전까지만 들어간다.
	Socket sock = new Socket(serverIP, 7777);
	//Socket sock = new Socket("192.168.50.14", 7777);
	//Socket sock = new Socket("www.suwook.com", 7777);
	
	
	//Socket sock 이 생성되어지면 서버와 연결된 것이다.
	//먄약에 serverIP 서버와 연결이 실패되어지면, UnknownHostException, IOException 오류가 발생되어진다.
	
	System.out.println(">>>"+serverIP+" 서버와 연결됨 <<<\n");
	
	//서버쪽에서 스트림을 통해 보내온 메시지를 읽어서 출력하도록 한다.
	InputStream instrm =  sock.getInputStream();	
	//	sock.getInputStream();메소드를 사용하여 1byte 기반 기본입력스트림(InputStream) 객체를 얻어온다.
	
	DataInputStream datainstrm = new DataInputStream(instrm);
	//기본 입력스트림에 필터스트림(보조스트림, 오리발)을 장착한다.
	
	String severMessage = datainstrm.readUTF();
	//datainstrm.readUTF();은  DataInputStream 통해 받은 byte를 UTF-8형식으로 읽어 들여서 문자열 String 
	//타입으로 리턴시켜주는 메소드이다.
	
	System.out.println(">>> 서버로부터 온 메시지 : "+severMessage+" <<<");
	
	//클라이언트 쪽에서 서버쪽으로 메시지를 보내겠다
	//메시지를 보내기 위해 데이터 출력 스트림(Dataoutput Stream)을 새엇ㅇ하겠다.
	
		
	 OutputStream outstrm = sock.getOutputStream();
	 DataOutputStream dataoutstrm = new DataOutputStream(outstrm);
	 
	 String message = "네! 반갑습니다...... 응답함.....";
	 dataoutstrm.writeUTF(message);
	 dataoutstrm.flush();
	 	
	 if(dataoutstrm != null) dataoutstrm.close();
	 if(outstrm != null) outstrm.close();
	 if(datainstrm != null) datainstrm.close();
	 if(instrm != null) instrm.close();
	 if(sock != null)  sock.close();
	//if(serverSock.close()) 를 하면 안된다.
	//왜냐하면 serberSock 이 존재해야만 새로운 클라이언트의 연결을 받아 줄 수 있기 때문이다.
	sc.close();
	

	}

}
