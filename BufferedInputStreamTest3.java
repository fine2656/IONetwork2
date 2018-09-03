package io.day2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class BufferedInputStreamTest3 {

	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner (System.in);
			
			System.out.print("복사할 파일 명 : ");
			String srcFilename = sc.nextLine();
			File srcFile = new File(srcFilename);//입력노드 스트링
			long srcFileSize = srcFile.length();//소스파일 크기,원본파일 크기
			
			//입력 노드 스트림 : FileInputStream
			FileInputStream fist  = new FileInputStream(srcFile);
			
			//입력 노드 스트림에 보조(필터)스트림(BufferedIputStream)을 장착한다.
			BufferedInputStream bist = new BufferedInputStream(fist,10240);//오리발 장착
			//노드 스트림인 System.in(키보드)에 필터 스트림(보조스트림)을 장착함.
			//필터 스트림(보조스트림)의 용량은 10240byte 가 된다.
			
			
			//출력 노드 스트림 :파일 FileInputStream
			System.out.print("생성 할 파일 명 : ");
			String targetFilename = sc.nextLine();
			File targeFile = new File(targetFilename);//
			System.out.println("");
			//출력 노드 스트림 :파일 FileOutputStream
			FileOutputStream fost = new FileOutputStream(targeFile);
			
			//출력 노드 스트림에 보조(필터)스트림(BufferedIputStream)을 장착한다.
			BufferedOutputStream bost = new BufferedOutputStream(fost,10240);//높일수록 속도가 빠름
			//노드 스트림인 System.out(파일)에 필터 스트림(보조스트림)을 장착함.
			//필터 스트림(보조스트림)의 용량은 10240byte 가 된다.
			
			byte[] dataArr = new byte[1024];
			int inputLength =0;
			int totalbyte = 0;
			int sharpCount = 0;
			while((inputLength = bist.read(dataArr)) != -1) {
				bost.write(dataArr,0,inputLength);//배열의 저장되어진 데이터를 처음부터 쓴다.
				bost.flush();

				totalbyte +=inputLength;
				if(inputLength== 1024) {
					System.out.print("#");
					sharpCount++;
				}
				if(sharpCount % 50 ==0) System.out.println("");
				
			}
			/*System.out.println("===============================");
			System.out.println("원본 파일 크기 : "+totalbyte);
			for(int i=1;i<=totalbyte/1024;i++) {
				System.out.print("#");
				if(i !=0 && i % 50 == 0) System.out.println("");
			}
		//	System.out.println(totalbyte/1024);
			System.out.println("");
			System.out.println("===============================");*/
			
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
		
	
		
	
	
		
	
		// TODO Auto-generated method stub

	}

}
