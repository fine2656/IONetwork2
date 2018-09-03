package io.day1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 	===	키보드로부터 입력 받은 것을 파일(c:\\IOTestData\result.txt)에 기록(출력)하기로한다.
  1.데이터 소스 : 키보드로부터 입력받음[노드스트림 : System.in]
  2.데이터목적지 : 결과를 특정 파일에 출력함[노드스트림 : FileOutpuStream]
  
 */
public class FileOutputStreamTest {
	/*
	    만약에  탐색기에서 
	 C:/iotestdata/result.txt 파일이 없다라면 파일을 자동으로 생성해준다.
	    단, 탐색기에서 C:/iotestdata 폴더는 존재해야 한다.
	 
	    두번째 파라미터인 append 가 true 인 경우는
	    첫번째 파라미터인 해당파일에 이미 내용물이 적혀 있는 경우일때
	    기존내용물은 그대로 두고 기존내용뒤에 새로운 내용을 덧붙여
	    추가하겠다는 말이다. 
	    
	    두번째 파라미터인 append 가 false 인 경우는
	    첫번째 파라미터인 해당파일에 이미 내용물이 적혀 있는 경우일때
	    기존내용물은 싹 지우고 새로운 내용을 새롭게 처음부터 쓰겠다는 말이다.
	  
	    그런데 만약에 두번째 파라미터를 생략하면    
	    즉, FileOutputStream fost = new FileOutputStream(filename); 이라면
	    자동적으로 false 로 인식한다.   
	*/
	public static void main(String[] args) {
		Boolean append = true;// 기존 내용에 덧붙여 주겠다.
		
		String fileName = "C:\\\\IOTestData\\result.txt";// 폴더는 반드시 존재해야하나 파일은 없어도 됨. 파일이 없으면 자동적으로 파일이 생성됨.
		int input =0;
		int totalByte=0;
		System.out.println("내용을 입력하세요[입력 하신 내용은 c:\\\\IOTestData\\result.txt 파엘로 저장됨]");
		try {
			FileOutputStream fost = new FileOutputStream(fileName,false);
			while((input = System.in.read()) != -1) {//system.in.read() : 1byte 씩 읽어온다
				fost.write(input);//
				fost.flush();
				totalByte++;
			}
			System.out.println(fileName+" 에 쓰기 완료!!");
			System.out.println(totalByte+" bytes 씀.");
			fost.close();
			System.in.close();
		} catch (FileNotFoundException e) {
			System.out.println(fileName+" 파일이 없습니다.");
			e.printStackTrace();
		}//
		catch (IOException e) {

			e.printStackTrace();
		}//

		// boolean 값이 false 이면 기존값은 지워버리고 새롭게 입력되는 값만 저장되며, true 일 경우 기존값이 저장 유지되어진다.
		
	}

}
