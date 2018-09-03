package io.day2;
import java.io.*;

public class FileReaderTest2 {
	public static String reading(String fileName) throws FileNotFoundException, IOException {
	
			FileReader fr= new FileReader(fileName);
			char[] charArr = new char[10];
			int charLength=0;
			String returnData = "";
			
			do {
				fr.read(charArr);
				//파일로부터 10글자씩 읽어온다.
				//파일이 손상되었을 시 IOExceptiond이 발생됨
				if(charLength != -1) {
					String str = new String(charArr,0,charLength);
					//String 타입의 배열을 처음부터 10개씩 읽어들임
					//읽어들인 글자 수(길이) dataLeng를 저장시킨 후
					//읽어들인 글자는 char[] 타입의 배열인 dataArr에 저장시킨다.
					//	String str = new String(charArr,0,charLength);은
					//char type의 배열인 charArr 에서 0번째  인덱스 글자부터 charLength 갯수만크 ㅁ뽑아서 String 타입으로 만든다는 말이다
					returnData +=str;
				}
				
			} while (charLength !=-1);
			
			//자원 반납
			fr.close();
			return returnData;
			

		//해당 파일과 노드 연결 생성(빨대 꽂기)
			
	}
	
	public static void main(String[] args) {
		
	
		try {
			String str = FileReaderTest2.reading(args[0]);

			System.out.println(str);
		} catch (FileNotFoundException e) {
			System.out.println("당신이 입력하신 "+args[0]+" 파일이 없습니다. ");
		} catch (IOException e) {
			System.out.println(args[0]+" 파일이 손상되었습니다. ");
		}//atgs[0]에 c:/myjava/sample.txt로 할 것이다.
	

		/*
		 >>>실행하기(명령프롬프트에서)<<< 
		 C:\myjava\IONetwork\bin>java io.day2.FileReaderTest C:/myjava/sample.txt
		우리나라 대한민국 KoreaSeoul
		My hobby is 컴퓨터프로그래밍
		 */
	}

}
