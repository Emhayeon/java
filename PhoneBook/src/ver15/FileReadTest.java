package ver15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class FileReadTest {

	public static void main(String[] args) {
		String fileName = "D:/Temp/data.csv";
		try {
			Vector<PhoneInfo> vec = new Vector<>();
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			while (true) {
				String str = br.readLine();
				if (str == null) {
					break;
				}
//				System.out.println(str);
				StringTokenizer tokenizer = new StringTokenizer(str, ",");
				String name = tokenizer.nextToken();
				String phoneNumber = tokenizer.nextToken();
				String birthDay = tokenizer.nextToken();
				String scName = tokenizer.nextToken();
				String scNum = tokenizer.nextToken();
				PhoneInfo info = null;
				switch (scNum) {
				case "1":
					info = new PhoneInfoSchool(name, phoneNumber, birthDay, scName);
					break;
				case "2":
					info = new PhoneInfoCompany(name, phoneNumber, birthDay, scName);
					break;
				}
				vec.add(info);
			}
			System.out.println(vec);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}