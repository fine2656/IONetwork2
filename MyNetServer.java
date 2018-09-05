package net.day1;


import java.io.*;
import java.net.*;//java.net.*은 항상 java.io.*과 같이 동반되야한다.

/*
  	===== TCP 통신방식을 이용한 예제 =====
  	-서버단 		: SeverSocket과 Socket 이 필요함.//연결 해야하는 소켓이 필요함.
  	-클라이언트단	: socket 이 필요함.
  	 
 */


public class MyNetServer {

	public static void main(String[] args) throws IOException{
		//====	ServerSocket 객체 생성하기 ====
		//ServerSocket 객체를 생성할 때는 port번호가 필요하다.
		ServerSocket serverSocket =  new ServerSocket(7777);
		
		
		while(true) {
			System.out.println("---- 클라리언트 기다리는 중 ----");
			Socket sock = serverSocket.accept();
			/*
			 	serverSocket.accept(); 메소드는 클라이언트가 접속할때까지 블럭(대기상태)으로 계속해서 머물고 있다가,
			 	클라이언트 쪽에서 서버의 해당 포트번호 (지금은 7777)로 들어오는 시도를 서버쪽에서 인지를 하는 순간 클라이언트와 서버간에 통신할 수 있는 객체인
			 	소켓객체(통신 할 있는 객체)인 이것을 리턴해준다.
			 */
			System.out.println("---- 클라이언트 가 접속해옴----");
			//접속한 클라이언트의 IP 주소를 알아오는 메소드
			
			InetAddress clientInetAddress =  sock.getInetAddress();
			String clientIP = clientInetAddress.getHostAddress();
			
			System.out.println("클라이언트의 IP 주소 : "+clientIP);
			
			/*
			 
			  서버와 클라이언트 간에 데이터를 서로 주고 받는 것은 스트림 객체를 통해서 이루어지므로 
			 먼저 소켓객체를 통해 입.출력 스트림 객체를 얻어와야 한다.			  
			 테스트를 위해서   일단 서버는 접속한 클라이언트에게 "어서오세요~!!. 192.168.50.14님" 
			 인사말을 보낼 것이다. 
			 */

			OutputStream outstr =  sock.getOutputStream();
			//1byte 기반 기본 출력 스트림을 얻어 온다.
			
			DataOutputStream dataoutstr = new DataOutputStream(outstr);
			//위에서 얻어온 기본 출력 스트림에 필터스트림(보조스트림)장착.
			
			String message = "\"어서오세요~!!"+clientIP+" 님!";
			dataoutstr.writeUTF(message);
			//dataoutstr.writeUTF(message); : 문자열 message를 UTF-8 형식으로 인코딩
			//==>UTS-8 형태의 타입으로 변 경
			//데이터 출력 스트림(DataOutputStream)에 기록한다.
			
			dataoutstr.flush();
			//데이터 출력 스트림(DataOutputStream)에 기록된 내용을 내보내는 작업.
			//즉, 클라이언트 컴퓨터에 "어서오세요~!!. 192.168.50.14님" 이라는 내용을 내보내는 것이다.
			//==================================================================
			//====클라이언트에서 보내온 메시지를 읽어서 출력하도록 한다. ====
			InputStream instrm = sock.getInputStream();
			
			DataInputStream datainstrm = new DataInputStream(instrm);
			
			String clientMsg = datainstrm.readUTF();
			System.out.println(clientIP+"님 "+ clientMsg);
			
			 if(dataoutstr != null) dataoutstr.close();
			 if(outstr != null) outstr.close();
			 if(datainstrm != null) datainstrm.close();
			 if(instrm != null) instrm.close();
			 if(sock != null)  sock.close();
			
			
		}
		

	}

}
