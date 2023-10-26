package ex01;

import java.util.Scanner;

public class RPS {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int winSore = 0; 
		
		for (int i = 1; i <= 5; i++) {
			System.out.print("입력(1.가위 2.바위 3.보):");
			
			int user = scanner.nextInt();
			
			int com = (int)(Math.random()*3)+1;
			System.out.println("com: "+com);
			
			String result = "";
			
			
			switch (user) {
			case 1:
				switch(com) {
				case 1:
					result = "비김";
					winSore += 1;
					break;
				case 2:
					result = "짐";
					winSore += 0;
					
					break;
				case 3:
					result = "이김";
					winSore += 3;
					break;
				
				}//switch(com)
				break;
			case 2:
				switch(com) {
				case 1:
					result = "이김";
					winSore += 3;
					break;
				case 2:
					result = "비김";
					winSore += 1;
					break;
				case 3:
					result = "짐";
					winSore += 0;
					break;
				
				}//switch(com)
				break;
			case 3:
				switch(com) {
				case 1:
					result = "짐";
					winSore += 0;
					break;
				case 2:
					result = "이김";
					winSore += 3;
					break;
				case 3:
					result = "비김";
					winSore += 1;
					break;
				
				}//switch(com)
				break;
			}//switch(user)
			
			System.out.println(result);
			System.out.println("승점: "+ winSore);
	
			
		}//for문 끝
		scanner.close();
	}//main

}//class
