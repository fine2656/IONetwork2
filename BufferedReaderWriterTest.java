/*
 	소스 -- 파일 => C:\IOTestData\myprofile.txt : FileReader
 	
 		보조 스트림 (필터 스트림, 오리발) BufferedReader
 		 		
 	 목적지 -- 파일 => C:\IOTestData\myprofile복사.txt :  	FileWriter
 	 	보조 스트림 (필터 스트림, 오리발) BufferedWriter/PrintWriter
 */
package io.day3;

import java.io.*;

public class BufferedReaderWriterTest {

	public static void main(String[] args) {
		try {
			//소스파일 이름 
			String srcFileName = "C:\\IOTestData\\myprofile.txt";
				
			FileReader fReader = new FileReader(srcFileName);//2byte 기반의 입력노드 스트림 생성.(빨대 꽂기)
			BufferedReader bufReader = new BufferedReader(fReader,1024);//입력 필터 스트림(보조스트림/오리발) 생성 -> 노드 프트림의 속도를 빠르게 하기 위해서 노드스트림의 오리발 달기.
			
			//-------------------------------------------------------------------
			//목적지 파일 이름
			String trgFileName = "C:\\IOTestData\\myprofile복사.txt";
			FileWriter fWriter = new FileWriter(trgFileName, false);//2byte 기반의 출력노드 스트림 생성.(빨대 꽂기)
			BufferedWriter  bufWriter = new BufferedWriter(fWriter, 1024);//출력 필터 스트림(보조스트림/오리발) 생성 -> 노드 프트림의 속도를 빠르게 하기 위해서 노드스트림의 오리발 달기.
			
			String strLine ="";
			
			while( (strLine = bufReader.readLine()) != null) {//readLine(): 한줄 전체를 읽어오는 것(속도가 빠름), Return Type : String.) 
				//bufReader.readLine() 메소드는 1줄 단위로 읽어와서 읽어온 내용을 String 타입으로 반환해준다.
				//한줄을 읽어오되 엔터전까지 읽어 온다.
				bufWriter.write(strLine);
				//줄바꿈한다.
				bufWriter.newLine();// newLine(): 줄바꿈 => or bufWriter.write("\r\n") : 줄바꿈
				bufWriter.flush();
				
			}
			System.out.println("파일 복사 완료!!");
			
			bufWriter.close();
			fWriter.close();
			bufReader.close();
			fReader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
/*
 >>>> 실행하기 <<<<
 C:\myjava\IONetwork\bin>java io.day3.BufferedReaderWriterTest
파일 복사 완료!!

  
 */
}
