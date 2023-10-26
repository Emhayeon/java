package ver12;

import java.util.Vector;

public class PhoneBook {
	private static PhoneBook instance = new PhoneBook();
//	private PhoneBook()
	private Vector<PhoneInfo> vec = new Vector<>();
//	private PhoneInfo[] storage = new PhoneInfo[10];
//	private int index = 0;
	
	public void addInfo(PhoneInfo info) throws ArrayIndexOutOfBoundsException {
		vec.add(info);
	}
	
	public void showAll() {
		for (PhoneInfo info : vec) {
			info.showInfo();
		}
		/*
		for (int i = 0; i < vec.size(); i++) {
			vec.get(i).showInfo();
		}
		*/
	}
	
	// 이름으로 검색하기
	public void searchByName(String searchName) {
		for (int i = 0; i < vec.size(); i++) {
			PhoneInfo info = vec.get(i);
			String name = info.getName();
			if (searchName.equals(name)) {
				info.showInfo();
				return;
			}
		}
		
		System.out.println(searchName + "을(를) 찾지 못하였습니다.");
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
	
	public void modify(PhoneInfo info) {
		for (int i = 0; i < vec.size(); i++) {
			if (vec.get(i).getName().equals(info.getName())) {
				vec.remove(i);
				vec.add(i, info);
				// vec.get(i) = info;
			}
		}
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
	
} // class