package net.day2;
import java.net.*;
import java.util.*;
import java.io.*;
import java.time.*;

public class EchoNetServer {

	public static void main(String[] args) {

			
			final int port = 10000;
			ServerSocket srvsock = null;
			Socket sock = null;
			
			 try {
				srvsock =  new ServerSocket(port);
				System.out.println("--- EchoNetServer Ready ---");
				
			
				sock = srvsock.accept();
			
				OutputStream ostrm =   sock.getOutputStream();
				InputStream instrm = sock.getInputStream();
				

				DataOutputStream dataoutstr = new DataOutputStream(ostrm);
				DataInputStream dataInstr = new DataInputStream(instrm);
			
				/*
				OutputStreamWriter ostrmWriter = new OutputStreamWriter(dataoutstr);
			
				
				InputStreamReader instrmReader = new InputStreamReader(dataInstr);
		
				
				PrintWriter printWriter = new PrintWriter(ostrmWriter, true);
		
				
				BufferedReader bufReader = new BufferedReader(instrmReader);
				
*/
				InetAddress clientInetAddress =  sock.getInetAddress();
				String clientIP = clientInetAddress.getHostAddress();
				
				String serverMsg =  "안녕하세요 "+clientIP+"님.";
				dataoutstr.writeUTF(serverMsg);
				dataoutstr.flush();
							
				String clientMsg="";
				
				
				while((clientMsg=dataInstr.readUTF()) != null) {
					if(clientMsg.startsWith("안녕") || clientMsg.startsWith("하이")) {
						dataoutstr.writeUTF(clientIP +"님 반갑습니다.");
						dataoutstr.flush();
						
					}
					else if(clientMsg.startsWith("Time")||clientMsg.startsWith("날짜")) {
						Date now = new Date();
						String today = String.format(" %tT",now );
						dataoutstr.writeUTF(today);
						dataoutstr.flush();
					}
					dataoutstr.writeUTF(clientIP +"님 어여 나가세요~~");
					dataoutstr.flush();
				}
	/*		if(bufReader != null) bufReader.close();
			if(printWriter != null) printWriter.close();
			if(instrmReader != null)instrmReader.close();*/
			if(dataoutstr != null) dataoutstr.close();
			if(dataInstr != null) dataInstr.close();
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
