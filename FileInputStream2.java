package io.day1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileInputStream2 {

	public static void main(String[] args) {

			String fileName = "C:\\IOTestData\\korea.txt";
			String fileName2 = "C:\\IOTestData\\korea1copy.txt";
			// 파일 명 입력 -> data Source가 된다
			// C:\IOTestData\korea2.txt
			
					
			int input=0;
			Boolean append = true;// 기존 내용에 덧붙여 주겠다.
		
			try {
				FileInputStream fist = new FileInputStream(fileName);
				while((input = fist.read()) !=-1 ) {
					System.out.write(input);//write는 int 타입을 갖는다
								//	읽어올 데이터 , 읽어오기 시작하는 부분, 까지 읽어야 하는 부분
					System.out.flush();//write는 항상 flush 와 함께 쓴다.
					FileOutputStream fost = new FileOutputStream(fileName2,true);
					fost.write(input);//
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
