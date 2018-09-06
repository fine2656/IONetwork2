package net.day2;

import java.net.*;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import java.io.*;


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
public class EchoNetClient {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		try {
			
		System.out.println("연결 할 서버의 IP 주소 입력 : ");
		String serverIp = sc.next();
		
		//1.통신하기 위한 Socket 객체 생성
		final int port = 10000;
	
			Socket sock = new Socket(serverIp, port);
		
		//2. 스트림 생성하기.
			OutputStream ostrm =   sock.getOutputStream();
			InputStream instrm = sock.getInputStream();
			
			OutputStreamWriter ostrmWriter = new OutputStreamWriter(ostrm);
			//1byte 기반의 output Stream 객체를 2byte 기반으로 바꾸어 주는 것이다.
			
			InputStreamReader instrmReader = new InputStreamReader(instrm);
			//1byte 기반의 output Stream 객체를 2byte 기반으로 바꾸어 주는 것이다.
			
			
			PrintWriter printWriter = new PrintWriter(ostrmWriter, true);
			//두번째 파라미터가 True 임으로 엔터를 만나면 자동 auto flucsh 가 벌생핟다.
			
			BufferedReader bufReader = new BufferedReader(instrmReader);

			String strMsg = bufReader.readLine();//서버쪽에서 보내온 메시지를 한줄씩 읽어온다
		
			System.out.println("From "+serverIp+">> "+strMsg);//서버쪽에서 보내온 메시지를 화면에 출력해라
			
			//=== 클라이언트가 서버쪽으로 키보드로 입력한 내용을 보내도록 한다.
			
			InputStreamReader kbIstrReader = new InputStreamReader(System.in);
			//1byte 기반인 InputStream인 System.in 을  2byte 기반으로 바꾸어 주는 것이다.
			
			BufferedReader kbBufReader = new BufferedReader(kbIstrReader,512);
			//필터 스트림(보조스트림,오리발) 장착하기
			
			String clientSendMsg = "";// 널이 아님!!
			//키보드로 입력받는 스트링을 생성해야한다.
			
			while((clientSendMsg = kbBufReader.readLine()) !=null) {//글자 타이핑이 아무것도 없을때
				//키보드로 Ctrl+C 가 null 이므로 While 문을 탈출 한다.				
				printWriter.println(clientSendMsg);//서버쪽으로 클라이언트의 메시지를 보내기
				strMsg = bufReader.readLine();
				System.out.println(serverIp+strMsg);
				//서버쪽으로부터 메시지를 읽어와서 (받아서) 화면에 출력해주기
			}
			if(bufReader != null) bufReader.close();
			if(printWriter != null) printWriter.close();
			if(instrmReader != null)instrmReader.close();
			if(instrm != null) instrm.close();
			if(ostrm != null) ostrm.close();
			if(sock != null) sock.close();

			System.out.println(">>> EcoNoetClient 종료 <<<");

		} catch (IOException e) {
	
			
			
			
			e.printStackTrace();
		}
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
