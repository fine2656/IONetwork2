package io.day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
==== 파일 복사하기 ====
C:\IOTestData\korea2.txt 을 읽어다가 동일 한 경로
C:\IOTestData\korea2copy.txt 파일을 생성하시오

 bytep[] 을 사용하여 64byte 로  생성.
 
*/
public class FileCopy2 {

	public static void main(String[] args) {

		String fileName = "C:\\IOTestData\\korea.txt";
		String fileName2 = "C:\\IOTestData\\korea2copy.txt";
		// 파일 명 입력 -> data Source가 된다
		// C:\IOTestData\korea2.txt
		
		byte[] dataArr = new byte[64];
		
		int inputLength=0;
		Boolean append = true;// 기존 내용에 덧붙여 주겠다.
	
		try {
			FileInputStream fist = new FileInputStream(fileName);
			while((inputLength = fist.read(dataArr)) !=-1 ) {
				System.out.write(dataArr,0,inputLength);//write는 int 타입을 갖는다
							//	읽어올 데이터 , 읽어오기 시작하는 부분, 까지 읽어야 하는 부분
				System.out.flush();//write는 항상 flush 와 함께 쓴다.
				FileOutputStream fost = new FileOutputStream(fileName2,false);
				fost.write(dataArr,0,inputLength);//
				fost.flush();
				
				}//end of while
			//fist.close();
			//fost.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	// TODO Auto-generated method stub

}

}


