package ex01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {

	public static void main(String[] args) {
		String fileName = "C:\\Windows\\system.ini";
		// 스트림을 개설(빨대를 꽂는다)
		try {
			FileReader reader = new FileReader(fileName);
			while (true) {
				int data = reader.read();
				// System.out.println(data); // 59
				if (data == -1) { // EOF(End Of File)
					break;
				}
				System.out.print((char)data);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			System.out.println("파일을 읽는 도중에 문제가 발생했습니다.");
		} 

	}

}