package io.day4;

import java.io.*;

public class SerializableTest {//객체를 분쇄하는 리스트
	

	public void objectToFileSave (Object obj, String saveFileName ) {
		//직렬화
		//==입력받은 객체 obj를 파일 saveFilename로 저장하기==
		try {
				
				FileOutputStream fost = new FileOutputStream(saveFileName,false);//노드스트림 생성 -> 빨대
				BufferedOutputStream bufOst = new BufferedOutputStream(fost,1024);//필터 스트림 생성 ->오리발 생성
				ObjectOutputStream objOst = new ObjectOutputStream(bufOst);//객체 obj 를 파일(saveFileName)에  기록하는(저장하는) 스트림을 생성.
				
				
				objOst.writeObject(obj); //objOst을 사용하여 객체 obj 를 파일(saveFileName)에  기록하기(저장하기)
					
				objOst.close();
				bufOst.close();
				fost.close();
			
		} catch (FileNotFoundException e) {
				e.printStackTrace();//FileOutputStream fost = new FileOutputStream(saveFileName,false);/
		} catch (IOException e) {
				e.printStackTrace();//ObjectOutputStream objOst = new ObjectOutputStream(bufOst);
		}
	}
	public Object getObjectFromFile(String fileName) {
		//역직렬화 
		//C:\IOTestData\serializable
		
		// == 파일 filename로 부터 읽어서 객체 obj로 변환하기 ===
		Object obj = new Object();
		try {
				FileInputStream fist = new FileInputStream(fileName);//노드스트림 생성 -> 빨대, 파일 읽어오기
				BufferedInputStream bufIst = new BufferedInputStream(fist,1024);//필터 스트림 생성 ->오리발 생성
		
				ObjectInputStream objIst = new ObjectInputStream(bufIst);//filename 을 읽어서  객체로  만들어주는 스트림 생성하기
		
				obj = objIst.readObject();//objIst을 사용하여 파일 filename 에 기록(저장)되어졌던 것을 객체로 만들기.

				
				objIst.close();
				bufIst.close();
				fist.close();
				
				return obj;

				
		}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}catch (FileNotFoundException e) {
				e.printStackTrace();
		}catch (IOException e) {
				e.printStackTrace();
				
		}

		return obj;
	
	}

	
}
