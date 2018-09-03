package io.day2;
/*
  >>>>File 클래스 <<<<
 자바에서 File 클래스의 객체라함은 2가지 파일 및 폴더(디렉토리)를  다 포함한다.
  
 */

import java.util.Scanner;
import java.io.*;

public class FileTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("탐색기에 존재하는 파일명을 입력하시오. ");
		String fileName= sc.nextLine();
		//C:\IOTestData\Tulips.jpg
		sc.close();
		
		File file1 = new File(fileName);
		System.out.println("파일 명 : "+file1.getName());//fileName 출력 :  파일 명을 알려줌.
		System.out.println("파일 크기 : "+file1.length());//file 사이즈
		System.out.println(" 파일의 절대경로 : "+file1.getAbsolutePath());
		System.out.println("=====================");
		System.out.println(">>>> 디렉토리 생성하기 <<<<");
		
		File dir = new File("MyDir");//프로젝트 경로 생략
		//File dir = new File("C:\myjava\IONetwork\MyDir");와 같다.
		
		
		String result = dir.exists()?"존재함":"존재하지 않음";
		System.out.println(dir.getName()+" 은 "+result);
		
		boolean bool = false;
		if(!dir.exists()) {//해당 디렉토리(MyDir)가 없으면
			bool = dir.mkdir();//=>makedirectory, 폴더를 만들어라.
			//디렉토리 MyDir 생성.
			result = bool?"디렉토리 생성 성공!":"디렉토리 생성 실패!";//bool이 true 이면 "디렉토리 생성 성공!" false 이면 "디렉토리 생성 실패!"
			System.out.println("MyDir "+ result);
		}
		/*
		탐색기에 존재하는 파일명을 입력하시오. MyDir
		파일 명 : MyDir
		파일 크기 : 0
		 파일의 절대경로 : C:\myjava\IONetwork\bin\MyDir
		=====================
		>>>> 디렉토리 생성하기 <<<<
		MyDir 은 존재하지 않음
		MyDir 디렉토리 생성 성공!
		
		탐색기에 존재하는 파일명을 입력하시오. MyDir
		파일 명 : MyDir
		파일 크기 : 0
		 파일의 절대경로 : C:\myjava\IONetwork\bin\MyDir
		=====================
		>>>> 디렉토리 생성하기 <<<<
		MyDir 은 존재함 
		 */
		else {// 해당 디렉토리가 있으면. 
			if(dir.exists()) {
				System.out.println("MyDir 디렉토리의 상대 경로 : "+dir.getPath());
				System.out.println("MyDir 디렉토리의 절대 경로 : "+dir.getAbsolutePath());
				/*
				 	MyDir 은 존재함
					MyDir 디렉토리의 상대 경로 : MyDir
					MyDir 디렉토리의 절대 경로 : C:\myjava\IONetwork\bin\MyDir
				 */
			}
		}	
		System.out.println("=====================");
		System.out.println(">>>> 디렉토리(폴더) 삭제하기 <<<<");
			/*
			 삭제하려는 디렉토리가 비어있을 때만 삭제가 가능하지 폴더 속의 서브 폴더가 존재하면, 디렉토리가 삭제되지 않음
			C://myjava/IONetwork/TestDir 이라는 빈폴더를 하나 생성한 후 아래와 같이 한다.
			 */
		File dir2 = new File("TestDir");
		if (dir2.exists()) {
			dir2.delete();
			result = bool?"디렉토리 삭제성공":"디렉토리 삭저 실피";
			System.out.println("TestDir "+result);
		}
		System.out.println("=====================");
		System.out.println(">>>> 파일 생성하기 <<<<");
		
		
		File testFile = new File("테스트.txt");
		bool = false;
		if(!testFile.exists()) {//해당 파일이 존재하지 않으면
			
			try {
				testFile.createNewFile();
				System.out.println("테스트.txt의 상대 경로 : "+testFile.getPath());
				System.out.println("테스트.txt의 절대 경로 : "+testFile.getAbsolutePath());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//파일 생성
			
			bool = testFile.delete();
			result = bool?"파일 삭제 성공":"파일 삭제 실패";
			System.out.println("테스트.txt "+result);	
				
				
		}
		
		
	}

}
