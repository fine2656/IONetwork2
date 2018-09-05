package io.day3;
/*
	소스 -- 파일 => C:\IOTestData\myprofile.txt : FileReader
	
		보조 스트림 (필터 스트림, 오리발) BufferedReader
		 		
	 목적지 -- 파일 => C:\IOTestData\myprofile복사.txt :  	FileWriter
	 	보조 스트림 (필터 스트림, 오리발) BufferedWriter/PrintWriter
*/
import java.io.*;


public class PrintWriterTest {

	public static void main(String[] args) {
		try {
			//소스파일 이름 
			String srcFileName = "C:\\IOTestData\\myprofile.txt";
				
			FileReader fReader = new FileReader(srcFileName);//2byte 기반의 입력노드 스트림 생성.(빨대 꽂기)
			BufferedReader bufReader = new BufferedReader(fReader,1024);//입력 필터 스트림(보조스트림/오리발) 생성 -> 노드 프트림의 속도를 빠르게 하기 위해서 노드스트림의 오리발 달기.
			
			//-------------------------------------------------------------------
			//목적지 파일 이름
			String trgFileName = "C:\\IOTestData\\myprofile복사2.txt";
			FileWriter fWriter = new FileWriter(trgFileName, false);//2byte 기반의 출력노드 스트림 생성.(빨대 꽂기)
			PrintWriter printWriter = new PrintWriter(fWriter,true);//PrintWriter printWriter = new PrintWriter(fWriter,true) 에서
			//두번째 파라미터인 값에 true를 주면 개행문자를(엔터)를 만날때마다 자동으로 flush() 메소드가 자동으로 작동한다. -> autoflush.
			
			String strLine ="";
			
			while( (strLine = bufReader.readLine()) != null) {//readLine(): 한줄 전체를 읽어오는 것(속도가 빠름), Return Type : String.) 
				printWriter.println(strLine);
			}
			System.out.println("파일 복사 완료!!");
			
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

}
