package io.day1;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
=== c:\iotestdata\korea.txt 파일을 읽어서
            그 내용을 모니터(콘솔화면)에 출력하는 예제 ===
            
1. 데이터소스 : 파일로 부터 읽어들임(노드스트림: FileInputStream) 
2. 데이터목적지 : 결과물을 모니터에 출력(노드스트림: System.out)

>>>> FileInputStream
   - Node 스트림(접속점이 파일인 입력스트림)
   - 1byte 기반 스트림.
  
>>>>> System.out :
              부모클래스가 추상클래스 OutputStream(기본 출력 스트림) 타입인 것으로서
              접속점(빨대)이 콘솔화면(모니터)인 출력 스트림(PrintStream)이다.
              
 -- Node(접속점)가 콘솔화면(모니터)인 출력스트림이다.
 -- 1byte 기반 스트림이다.
 -- 주요 메소드 : println(String str),
               print(String str),
               write(int b)                  
*/
public class FileInputStream1 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner (System.in);
		System.out.print("읽을 파일의 이름 (절대경로) 입력 : ");
		
		String fileName = sc.nextLine();
		// 파일 명 입력 -> data Source가 된다
		// C:\IOTestData\korea1.txt
		
		int input=0;
		int totalByte =0;
		try {
			FileInputStream fist = new FileInputStream(fileName);
			while((input = fist.read()) !=-1 ) {
				/*
				  fist.read();메소드는 해당 파일에서 데이터를 1byte 씩 읽어서 int 타입으로 리턴해준다.
				  만약에 파일의 내용물에서 읽어들일 데이터가 없다라면 -1을 return 시켜준다.
				   => 파일속의 내용물이 끝이 아니라면 계속해서 while{}을 실행해라.
				 */
				
				//콘솔 화면에 추력 
				
				System.out.write(input);//write는 int 타입을 갖는다
				System.out.flush();//write는 항상 flush 와 함께 쓴다.
				totalByte++;
				
				
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
		
		System.out.println("총 : "+totalByte);
		
		
		
	
		
		
		
		

	}

}
