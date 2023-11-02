package ex03;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class TextCopy {
	public static void main(String[] args) {
		// C:/Windows/system.ini -> D:/Temp/system.txt 복사
		File src = new File("C:/Windows/system.ini");
		File dest = new File("D:/Temp/system.txt");
		// 파일 객체로는 읽기/쓰기 작업 안됨
		try {
			FileReader reader = new FileReader(src);
			FileWriter writer = new FileWriter(dest);
			while (true) {
				int data = reader.read();
				if (data == -1) {
					break;
				}
				writer.write(data);
			}
			System.out.println("파일 복사 완료");
			reader.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}