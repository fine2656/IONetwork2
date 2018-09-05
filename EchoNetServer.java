package net.day1;

import java.net.*;
import java.util.*;
import java.io.*;
import java.time.*;

/*
	===== TCP 통신방식을 이용한 예제 =====
	-서버단 		: SeverSocket과 Socket 이 필요함.//연결 해야하는 소켓이 필요함.
	-클라이언트단	: socket 이 필요함.
	 
	 >>>>> 구현할 내용 <<<<<
	 ==> Client 가 Server 에 접속을 하면 
	 
	 1. 클라이언트는 서버로부터  "안녕하세요 ? IP주소 님" 이라는 인사마를 받는다.
	 2. 클라이언트는 키보드 입력을 통해 서버쪽에 다음과 같은 메시지를 보낸다. 
	 	2.1 "안녕하세요? " 또는 "하이" 라는 메시지를 클라이언트가 서버쪽으로 보내면 서버는 클라이언트에게
	 		"IP 주소님 반갑습니다!!"라는 메시지를 보낸다.
	 	2.2 "오늘 날짜는 ?" 이라는 메시지가 클라이언트가 서버쪽으로 보내면 서버는 클라이언트에게  오늘의 날짜를 보내준다.
	 	2.3 기타 다른 메시지를 보내면 서버쪽으로 보내면 서버는 "IP주소님 어여 나가세요~~!!" 라는 메시지를 클라이언트로 보낸다
	 	
	 
*/

public class EchoNetServer {

	public static void main(String[] args) {
	//1. 서버 소켓 생성
	final int port = 6000;//숫자가 바뀌지 않는다
	ServerSocket srvsock = null;
	Socket sock = null;
	
	 try {
		srvsock =  new ServerSocket(port);//포트번호 6000 사용하는 소켓 객체를 생성
		
		System.out.println("--- EchoNetServer Ready ---");
		
	//2. 통신하기 위한 소켓 객체 생성하기.
		sock = srvsock.accept();
	//3. Socket sock을 사용하여 클라이언트에게 데이터를 보내는 (출력) 연결 통로인 Stream 생성.
	//	 Socket sock을 사용하여 클라이언트에게 데이터를 받는 (입력) 연결 통로인 Stream 생성.	
		OutputStream ostrm =   sock.getOutputStream();
		InputStream instrm = sock.getInputStream();
		
		OutputStreamWriter ostrmWriter = new OutputStreamWriter(ostrm);
		//1byte 기반의 아우output Stream 객체를 2byte 기반으로 바꾸어 주는 것이다.
		
		InputStreamReader instrmReader = new InputStreamReader(instrm);
		//1byte 기반의 아우output Stream 객체를 2byte 기반으로 바꾸어 주는 것이다.
		
		
		PrintWriter printWriter = new PrintWriter(ostrmWriter, true);
		//두번째 파라미터가 True 임으로 엔터를 만나면 자동 auto flucsh 가 벌생핟다.
		
		BufferedReader bufReader = new BufferedReader(instrmReader);
		

		InetAddress clientInetAddress =  sock.getInetAddress();
		String clientIP = clientInetAddress.getHostAddress();
		
		String serverMsg =  "안녕하세요 "+clientIP+"님.";
		printWriter.println(serverMsg);
		
		
		//==== 클라이언트 쪽에서 보내온 메시지를 받아서 적절하게 응답해주기 ====
		String clientMsg="";//null이 아님, 클라이언트에서 보내온 메시지
		
		
		while((clientMsg=bufReader.readLine()) != null) {
			if(clientMsg.startsWith("안녕") || clientMsg.startsWith("하이")) printWriter.println(clientIP +"님 반갑습니다.");
			else if(clientMsg.startsWith("오늘날짜")||clientMsg.startsWith("날짜")) {
				Date now = new Date();
				String today = String.format(" %tT",now );
				printWriter.println(today);
			}
			printWriter.println(clientIP +"님 어여 나가세요~~");
		}
	if(bufReader != null) bufReader.close();
	if(printWriter != null) printWriter.close();
	if(instrmReader != null)instrmReader.close();
	if(instrm != null) instrm.close();
	if(ostrm != null) ostrm.close();
	if(sock != null) sock.close();
	if(srvsock != null) srvsock.close();

		
		
	 } catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println(">>>EchoNetServer 종료 <<<");
	}

}
