package io.day2;

import java.io.FileNotFoundException;
import java.io.IOException;

/* java.lang.Exception
+-------- java.io.IOException
                       +---------- java.io.FileNotFoundException
    
[실습1] 
try ~ catch절로 아래에 발생한 예외를 모두 처리해보자. 
시작하기전 c:\myjava\sample.txt 이라는 텍스트 파일을 만든다.
sample.txt 파일의 내용은 아래와 같이 입력하고서 저장하도록 한다.
우리나라 대한민국 KoreaSeoul
My hobby is 컴퓨터프로그래밍
*/

/*
FileReader는 파일에 저장된 바이트(byte)를 유니코드 문자(char)로 변환해서 읽어 들이는 입력 클래스중 하나이다.

[참고] Stream --> byte형 배열,
Reader --> char형 배열

-------------------------------------------------------------------------------------------------------------------------------------      
FileReader 의 생성자                                                                                 설명
-------------------------------------------------------------------------------------------------------------------------------------
FileReader(File file) throws FileNotFoundException         - file로 지정된 파일에 대한 입력 스트림을 생성한다.
			                                  (file로 지정된 파일을 읽어들일수 있도록 해당 file에 빨때를 꽂는 작업이다)
                                            - throws FileNotFoundException 
                                                                                                     해당 파일이 없거나, 기타 다른 이유로 인해서 읽을수가 없을 때 예외 발생.

FileReader(String fileName) throws FileNotFoundException   - fileName로 지정한 경로의 파일에 대한 입력 스트림을 생성한다. 
			                                  (fileName로 지정된 파일을 읽어들일수 있도록 해당 fileName에 빨때를 꽂는 작업이다)     
			                                - throws FileNotFoundException 
			                                                                해당 파일이 없거나, 기타 다른 이유로 인해서 읽을수가 없을 때 예외 발생.
-------------------------------------------------------------------------------------------------------------------------------------

예1>
File file = new File("sample.txt");   // sample.txt 파일을 File 객체로 가져온다.

FileReader fr = new FileReader(file); // sample.txt 파일을 읽을 FileReader 객체를 생성한다.(빨대꽂기)
                      // sample.txt 파일을 읽을 수 있도록 sample.txt 파일에 빨대를 꽂았다. 그 빨대의 이름이 fr 이다.
                      // FileNotFoundException 예외 처리해야 함 
                      // FileReader 객체생성시 생성자 파라미터에 들어오는 파일명에 해당 파일이 없거나, 
                      // 기타 다른 이유로 인해서 읽을수가 없을 때 FileNotFoundException 발생하기 때문이다.              

int chint = 0;
String data = "";

do {
chint = fr.read();     // fr.read()메소드에 의해서 sample.txt 파일에 읽는 내용물을 한글자씩(char 단위로) 읽어가는데
             // 리턴타입은 int 이다.
             // 입.출력 오류가 발생할 경우 IOException 발생하므로 IOException 예외처리해야 함.
if (chint != -1){      // 파일내용 끝엔 눈에 보이지 않는 -1 이 있다.  
data += ((char)chint); // 읽어온 한글자에 해당하는 int형 값을 다시 char형 으로 형변환하여 마지막 글자까지 계속 붙여간다.
}
} while (chint != -1);

fr.close();                  // 스트림 연결 자원 반환(빨대제거)
System.out.println(data);    // 읽어온 글자를 출력한다.

------------------------------------------------------------------------------------------------------------
예2>
File file = new File("sample.txt");    // sample.txt 파일을 File 객체로 가져온다.

FileReader fr = new FileReader(file);  // sample.txt 파일을 읽을 FileReader 객체를 생성한다.(빨대꽂기)
                       // sample.txt 파일을 읽을 수 있도록 sample.txt 파일에 빨대를 꽂았다. 그 빨대의 이름이 fr 이다.
                       // FileNotFoundException 예외 처리해야 함 
                       // FileReader 객체생성시 생성자 파라미터에 들어오는 파일명에 해당 파일이 없거나, 
                       // 기타 다른 이유로 인해서 읽을수가 없을 때 FileNotFoundException 발생하기 때문이다.
FileReader.read() 
-- public int read(char[] cbuf, int offset,  int length)  throws IOException

Parameters:
cbuf - Destination buffer                            // 파일의 내용을 읽어서 저장시키는 장소
offset - Offset at which to start storing characters // 파일의 내용을 읽어들일때의 출발위치값. 문자열 배열의 인덱스 번호로 생각하자.
length - Maximum number of characters to read        // 파일을 읽어들일때의 몇글자까지만 읽어들일래임.
Returns:
The number of characters read, or -1 if the end of the stream has been reached  
// 읽어들인 문자(char)에 해당하는 10진수값을 리턴, 문자열의 마지막에 도달하면 -1 을 리턴
Throws:
IOException - If an I/O error occurs  // 입.출력 오류가 발생할 경우 IOException 발생
            
char[] data2 = new char[100];
fr.read(data2,0,20);  // sample.txt 파일 내용을 읽어들일때 첫번째 글자(인덱스 번호 0)부터 20글자를 읽어들여서 
          // char형 배열 data2에 저장해두는데
          // 입.출력 오류가 발생할 경우 IOException 발생하므로 IOException 예외처리해야 함.
String contents = new String(data2,5,7); // char형 배열 data2에 저장된 문자열에서 6번째 글자(인덱스 번호 5)부터 7글자만 취해온다. 

String 생성자
- String(char[] value, int offset, int count)
Allocates a new String that contains characters from a subarray of the character array argument.
문자열이 저장된 char 배열 value 에서 배열 인덱스 offset 부터 count 글자수 만큼 문자열을 가져온다.

<참고> Stream --> byte형 배열(1byte형 배열)이라서 이진파일도 읽어들일수 있음.
Reader --> char형 배열(2byte형 배열)이라서 특히 문자열 파일을 읽어들일때 많이 사용함.

fr.close();  // 스트림 연결 자원 반환(빨대제거)
System.out.println(contents);

*/
import java.io.*;

public class FileReaderTest {
//읽어 들일 파일명은 명령줄 인자(파라미터)로 주겠다.
	
public static String reading(String fileName) {
	try {
		FileReader fr= new FileReader(fileName);
		int data=0;
		String returnData = "";
		do {
			data = fr.read();	//read한개는 2byte로 읽어오는데 char 타입이다
			//파일로부터 글자(char)한개씩 읽어들임.
			//파일이 손상되었을 시 IOExceptiond이 발생됨
			if(data != -1) {//글자 1개씩 읽어와서 문자열 변수 returnData에 누적시킨다.
				returnData +=(char)data;
			}
			
		} while (data !=-1);
		
		//자원 반납
		fr.close();
		return returnData;
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		return "당신이 입력하신 "+fileName+" 파일이 없습니다. ";
	}catch (IOException e) {//IOException 은 파일이 있으나 파일이 깨졌을 때
		e.printStackTrace();
		return "당신이 입력하신 "+fileName+" 파일이 손상되었습니다. ";
	}
	//해당 파일과 노드 연결 생성(빨대 꽂기)
		
}
	public static void main(String[] args) {
		
		String str = FileReaderTest.reading(args[0]);//atgs[0]에 c:/myjava/sample.txt로 할 것이다.
		System.out.println(str);

	}
	/*
	 >>>실행하기(명령프롬프트에서)<<< 
	 C:\myjava\IONetwork\bin>java io.day2.FileReaderTest C:/myjava/sample.txt
	우리나라 대한민국 KoreaSeoul
	My hobby is 컴퓨터프로그래밍
	 */

}
