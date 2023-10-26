package ex02;

import java.util.Scanner;

public class ArrayAccess {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//정수 5개를 저장할 공간(배열)을 생성
		int[] intArray = new int[5];
		
		for(int i = 0; i < intArray.length; i++) {
			System.out.print("입력: ");
			intArray[i] = scanner.nextInt();
		}
		
		
		//배열 intArray 출력
		System.out.println("intArray:" + intArray); //[I@59a6e353
		
		//배열의 내용을 확인
		System.out.println("---intArray---");
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i]+" ");
		}
		
		
		int max = 0;
		/*
		for (int i =0; i < intArray.length; i++) {
			if(max < intArray[i]) {
				max = intArray[i];
			}
			
		}
		*/
		
		//for-each (enhanced for-향상된for)
		//원소의 처음부터 끝까지 빼낸다.
		for (int n : intArray) {
			if (max <n) {
				max = n;
			}
		}
		
		System.out.println("가장 큰 값:" + max);
		
		scanner.close();

	}

}
