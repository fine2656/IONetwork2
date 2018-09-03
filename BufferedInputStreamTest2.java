package io.day2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputStreamTest2 {

	public static void main(String[] args) {


		
		try {
			String srcFilename = "C:\\IOTestData\\Tulips.jpg";
			File srcFile = new File(srcFilename);//입력노드 스트링
			long srcFileSize = srcFile.length();//소스파일 크기,원본파일 크기
			
			//입력 노드 스트림 : FileInputStream
			FileInputStream fist  = new FileInputStream(srcFile);
			
			//입력 노드 스트림에 보조(필터)스트림(BufferedIputStream)을 장착한다.
			BufferedInputStream bist = new BufferedInputStream(fist,4096);//오리발 장착
			//노드 스트림인 System.in(키보드)에 필터 스트림(보조스트림)을 장착함.
			//필터 스트림(보조스트림)의 용량은 1024byte 가 된다.
			
			
			//출력 노드 스트림 :파일 FileInputStream
			String targetFilename = "C:\\IOTestData\\튜울립.jpg";
			File targeFile = new File(targetFilename);//
			
			//출력 노드 스트림 :파일 FileOutputStream
			FileOutputStream fost = new FileOutputStream(targeFile);
			
			//출력 노드 스트림에 보조(필터)스트림(BufferedIputStream)을 장착한다.
			BufferedOutputStream bost = new BufferedOutputStream(fost,4096);//높일수록 속도가 빠름
			//노드 스트림인 System.out(파일)에 필터 스트림(보조스트림)을 장착함.
			//필터 스트림(보조스트림)의 용량은 1024byte 가 된다.
			
			byte[] dataArr = new byte[512];
			int inputLength =0;
			int totalbyte = 0;
			int whileCount=0;
			while((inputLength = bist.read(dataArr)) != -1) {
				bost.write(dataArr,0,inputLength);//배열의 저장되어진 데이터를 처음부터 쓴다.
				bost.flush();

				totalbyte +=inputLength;
				int percent = (int)(((double)totalbyte/srcFileSize)*100); 
				System.out.println(percent+"% 복사중");
			}
			System.out.println("===============================");
			System.out.println("whileCount : "+whileCount);
			System.out.println("총 "+totalbyte+"byte 읽고 "+" 파일에 씀");
			
			System.out.println("===============================");
			
			bost.close();
			fost.close();
					
			bist.close();//오리발 제거으
			fist.close();//자원 해제
			
		} catch (FileNotFoundException e) {
			System.out.println("파일의 경로가 올바르지 않습니다.");
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	
		
	
	
		
	}

}
