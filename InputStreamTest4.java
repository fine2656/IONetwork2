package io.day1;

import java.io.IOException;

public class InputStreamTest4 {

	public static void main(String[] args) throws IOException {

			byte[] dataArr = new byte[10];
			
			
			int inputLength = 0;
			int totalByte = 0;
			
			
				while((inputLength = System.in.read(dataArr)) !=-1) {
					//키보드로 Ctrl +c (강제종료) 누르지 않으면 계속 실행한다.
					
					/* System.in.read(dataArr)은 입력한 데이터가 "대한민국서울시동대문구"+"엔터"이라면 이볅한 내용에서
					  배열dataArr의 크기만큼 (ex 10byte) 크기만큼 읽어들인다.("대한민국서")읽어들인 "대한민국서"을 
					 dataArr에 저장시키고, 읽어들인 크기( 지금은 10byte)를 return 시킨다.
					  반복문의 첫번째 일때는 
					  dataArr에는 "대한민국서" 이 들어가고, inputLength 에는 10이 들어간다	
					  반복문의 두번째 일때는 
					  dataArr에는 "울시동대문" 이 들어가고, inputLength 에는 10이 들어간다		
					    반복문의 세번째 일때는 
					  dataArr에는 "구엔터" 이 들어가고, inputLength 에는 4이 들어간다			 
					*/
					System.out.write(dataArr,0 , inputLength);//입력한 글자 그대로 출력
					//-> 배열 dataArr에 저장된 데이터에서 시작점이 0번째 index부터(처음부터) inputLength byte수만큼 출력해라
					System.out.flush();
					totalByte +=inputLength;
					
				}
				System.out.println("총 : "+ (totalByte-2)+" byte");
				System.in.close();//입력노드(키보드)연결 닫기, 안해줘도 됨
				System.out.close();//출력노드(모니터)연결닫기
				



	}

}
