package ver14;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class PhoneBook {
	private static PhoneBook instance = new PhoneBook();
	private PhoneBook() { /* singleton */ }
	public static PhoneBook getInstance() {
		return instance;
	}
	// --------------------------------------------------
	private JFileChooser chooser = new JFileChooser(); 
	private FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG & GIF & TXT", "jpg","png","gif","TXT");
	private Vector<PhoneInfo> vec = new Vector<>();
	private static final String FILE_NAME = "book.csv";
	private static final String SCHOOL_NUM = "1";
	private static final String COMPANY_NUM = "2";
//	private PhoneInfo[] storage = new PhoneInfo[10];
//	private int index = 0;
	
	public boolean addInfo(PhoneInfo info) {
		return vec.add(info);
		// showAll();
	}
	
	public Vector<PhoneInfo> getAll() {
		return vec;
	}
	
	// 이름으로 검색하기
	public PhoneInfo searchByName(String searchName) {
		for (int i = 0; i < vec.size(); i++) {
			PhoneInfo info = vec.get(i);
			String name = info.getName();
			if (searchName.equals(name)) {
				
				return info;
			}
		}
		return null;
		// System.out.println(searchName + "을(를) 찾지 못하였습니다.");
	}
	
	// 이름 중복 확인
	public boolean isNameDup(String searchName) {
		for (int i = 0; i < vec.size(); i++) {
			PhoneInfo info = vec.get(i);
			String name = info.getName();
			if (name.equals(searchName)) {
				return true;
			}
		}
		return false;
	}
	
	public PhoneInfo isExist(String name) {
		for (int i = 0; i < vec.size(); i++) {
			PhoneInfo info = vec.get(i);
			String savedName = info.getName();
			if (name.equals(savedName)) {
				return info;
			}
		}
		return null;
	}
	
	public boolean modify(PhoneInfo info) {
		for (int i = 0; i < vec.size(); i++) {
			if (vec.get(i).getName().equals(info.getName())) {
				vec.remove(i);
				vec.add(i, info);
				// vec.get(i) = info;
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(String name) {
		for (int i = 0; i < vec.size(); i++) {
			String savedName = vec.get(i).getName();
			if (name.equals(savedName)) {
				vec.remove(i);
				
				return true;
			}
		}
		return false;
		
	}
	
	public void save(String path) {
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(path));
			StringBuffer sb = new StringBuffer();
			for (PhoneInfo info : vec) {
				String name = info.getName();
				String phoneNumber = info.getPhoneNumber();
				String birthDay = info.getBirthDay();
				String scName = null;
				String scNum = null;
				if (info instanceof PhoneInfoSchool) {
					scName = ((PhoneInfoSchool)info).getSchool();
					scNum = SCHOOL_NUM;
				} else if (info instanceof PhoneInfoCompany) {
					scName = ((PhoneInfoCompany)info).getCompany();
					scNum = COMPANY_NUM;
				}
				sb.append(name);
				sb.append(",");
				sb.append(phoneNumber);
				sb.append(",");
				sb.append(birthDay);
				sb.append(",");
				sb.append(scName);
				sb.append(",");
				sb.append(scNum);
				sb.append("\n");
			}
			bw.write(sb.toString());
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
	public void Load() {
		chooser.setFileFilter(filter);
		int result = chooser.showOpenDialog(null);
		//System.out.println("닫기");
		 File selectedFile= chooser.getSelectedFile();
		 String path = selectedFile.getPath();
//		 System.out.println("path:"+path);
		 String fileName = path;
		 try {
			 
			 FileReader fr = new FileReader(fileName);
			 BufferedReader br = new BufferedReader(fr);
			 while (true) {
					String str = br.readLine();
					if (str == null) {
						break;
					}
//					System.out.println(str);
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
		} catch (Exception e2) {
			e2.printStackTrace();
						}
		 
	}

	
		
} // class