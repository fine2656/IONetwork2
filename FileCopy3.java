package io.day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class FileCopy3 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("복사할 원폰파일명(절대경로) 입력 : ");
		String srcFilename = sc.nextLine();//복사할 소스파일 네임
		
		System.out.println("목적 파일명(절대경로) 입력 : ");
		String targetFilename = sc.nextLine();
		
		System.out.println(" 소스파일 : "+srcFilename);
		System.out.println(" 목적파일 : "+targetFilename);
		
		try {
			
			// FileInputStream생성 :  접속점이 파일인 것으로 틀정 파일에  빨대를 꽂아 파일의 내용물을 일바이트 기반으로 읽어주는 스트림
			FileInputStream fist = new FileInputStream(srcFilename);
			// FileInputStream생성 :  접속점이 파일인 것으로 틀정 파일에  빨대를 꽂아 파일의 내용물을 1byte  기반으로 기록해주는 출력노드 스트림
			FileOutputStream fost = new FileOutputStream(targetFilename);
			
			byte[] dataArr = new byte[64];
			int inputLength = 0;
			int totalbyte = 0;
			
			while((inputLength = fist.read(dataArr))!=-1) {//64바티으 만큼 읽어서 저장해라, 읽어올 길이가 없으면 -1을 읽어온다. => 이 읽어온 길이가 -1이 아니라면
			
				fost.write(dataArr,0,inputLength);
				fost.flush();
				
				totalbyte +=inputLength;
				
			}
			fost.close();
			fist.close();
			System.out.println("복사완료 !!, 총 "+totalbyte+"byte");
		} catch (IOException e) {
			e.getMessage();
		}
		
		/*catch (FileNotFoundException e) {
		System.out.println("파일의 경로가 올바르지 않습니다.");
		}*/
	}
	

}
