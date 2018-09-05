package io.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import java.util.*;


public class MainTest {

	public static void main(String[] args) {

		Student stud1 = new Student("한석규", 21, "서울시 강동구");
		Student stud2 = new Student("두석규", 22, "서울시 강서구");
		Student stud3 = new Student("세석규", 23, "서울시 강남구");
		Student stud4 = new Student("네석규", 24, "서울시 강북구");
		
		List<Student> studList = new ArrayList<Student>();
		

		studList.add(stud1);
		studList.add(stud2);
		studList.add(stud3);
		studList.add(stud4);
		
		SerializableTest serial = new SerializableTest();
		serial.objectToFileSave(studList,"C:\\IOTestData\\serializable\\sutdents.dat");
		//직렬화 시켜주는 메소드 호출
		
		//===================================================================
		
		
		Object obj = serial.getObjectFromFile("C:\\IOTestData\\serializable\\sutdents.dat");
		//역직렬화 시켜주는 메소드 호출
		if( obj != null) {
			
			List<Student> resultList = (List<Student>) obj;
			System.out.println(">>> 파일의 저장된 개개체 정보 출력하기 <<<");
			
			for(Student stud :  resultList) {
				System.out.println(stud);
			}
		}
		else {
			System.out.println("파일의 저장된 객체 정보가없습니다.");
		}

		/*>>> 메뉴 <<<
		1.회원가입
		2. 로그인
		3. 모든 회원 출력
		4.특정ID 검색*/
	}

}
