package io.day3;
/*
	소스 - 키보드(입력노드 스트림 System.in) - 1byte 기반
	 브릿지 스트림 InputStreamReader : 1byte 를 2 byte로 변경
	목적지 - 출력 노드 스트림- FileWriter - 2byte 기반
	-> 입력 노드 스트림을 브릿지 스트림을 통해 출력노드 스트림으로 변환해준다
	
 */
import java.io.*;
public class InputStreamReaderTest {
	

	public static void main(String[] args) {
		System.out.println("파일에 입력하실 내용을 작성하세요.");
		try {
				InputStreamReader istReader = new InputStreamReader(System.in);
				//키보드에서 입력하는 것은 1byte 기반인데 이것을 2byte 기반으로 변경한다.
				String fileName = "C://IOTestData//오늘의날씨.txt";
				FileWriter fWriter = new FileWriter(fileName);
				int input=0;
				while((input = istReader.read())!=-1) {
					//istReader.read 은 2byte씩 읽어온다
					fWriter.write(input);//fWriter로 input을 읽어오자. 
										 //write는 글자 그대로 출력
					fWriter.flush();
				}
				System.out.println("\n >>>종료합니다 .<<<");
				fWriter.close();
				istReader.close();
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
