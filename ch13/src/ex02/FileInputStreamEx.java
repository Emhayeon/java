package ex02;

import java.io.FileInputStream;

public class FileInputStreamEx {

	public static void main(String[] args) {
		try {
			FileInputStream input = new FileInputStream("D:/Temp/test.out");
			while (true) {
				int data = input.read();
				if (data == -1) {
					break;
				}
				System.out.print(data + " ");
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}