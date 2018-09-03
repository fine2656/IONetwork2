package io.day2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class FileWriterTest {
	
	public static void filecopy(String srcfileName,String targetfileName) throws FileNotFoundException, IOException {
		
		//해당 소스파일과 노드연결생성(빨대꽂기)
		FileReader fr= new FileReader(srcfileName);
		//해당 타겟파일에 노드 연결 생성(빨대 꽂기)
		FileWriter fw = new FileWriter(targetfileName);
		
		
		char[] charArr = new char[10];
		int charLength=0;
		//String returnData = "";
		
		do {
			fr.read(charArr);
			//파일로부터 10글자씩 읽어온다.
			//파일이 손상되었을 시 IOExceptiond이 발생됨
			if(charLength != -1) {
				fw.write(charArr,0,charLength);
				fw.flush();
			}
		} while (charLength !=-1);
		
		System.out.println("파일 복사 완료");
		//자원 반납
		fr.close();
		fw.close();
		

	//해당 파일과 노드 연결 생성(빨대 꽂기)
		
}

public static void main(String[] args) {
	

	try {
		String str = FileWriterTest.filecopy(args[0],args[1]);//
		//atgs[0]에 c:/myjava/sample.txt로 할 것이다
		//atgs[1]에 c:/myjava/samplecopy.txt로 할 것이다
		//System.out.println(str);
	} catch (FileNotFoundException e) {
		System.out.println("당신이 입력하신 "+args[0]+" 파일이 없습니다. ");
	} catch (IOException e) {
		System.out.println(args[0]+" 파일이 손상되었습니다. ");
	}


	/*
	 >>>실행하기(명령프롬프트에서)<<< 
	 C:\myjava\IONetwork\bin>java io.day2.FileReaderTest C:/myjava/sample.txt
	우리나라 대한민국 KoreaSeoul
	My hobby is 컴퓨터프로그래밍
	 */
}


}
