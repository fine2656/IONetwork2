package io.day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
==== 파일 복사하기 ====
C:\IOTestData\korea.txt 을 읽어다가 동일 한 경로
C:\IOTestData\koreacopy.txt 파일을 생성하시오

 1byte씩
 
*/
public class FileCopy1 {

	public static void main(String[] args) throws IOException {		Scanner sc = new Scanner (System.in);
	
	String fileName = " C:\\\\IOTestData\\korea.txt";
	String fileCopyName =  "C:\\\\IOTestData\\koreacopy.txt";
	
	// 파일 명 입력 -> data Source가 된다
	// C:\IOTestData\korea1.txt
	
	int input=0;

	try {
		FileInputStream fist = new FileInputStream(fileName);
		while((input = fist.read()) !=-1 ) {
				
			System.out.write(input);//write는 int 타입을 갖는다
			System.out.flush();//write는 항상 flush 와 함께 쓴다.
			
			
		}//end of while
		fist.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
