package io.day1;

import java.io.IOException;
import java.io.PrintStream;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class InputStreamTest3 {

	public static void main(String[] args) throws IOException {
		int input =0;
		int totalByte =0;
		
		while((input = System.in.read()) != -1) {
			
		
			if( input != 13 && input != 10) {
				//키보드로부터 입력받은 것이 엔터가 아니라면
				totalByte++;
				System.out.println("totalByte : "+totalByte);
				System.out.print("화면에 출력[write(input)] : ");
				System.out.write(input);
				System.out.flush();	
				
			}
			else {
				//키보드로부터 입력받은 것이 엔터라면
				System.out.println("");
			}
			
		}
		System.out.println("총 입력된 totalBytes : "+totalByte);
	}

}
