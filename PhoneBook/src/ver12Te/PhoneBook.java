package ver12Te;



import java.util.Vector;

public class PhoneBook {
	private static PhoneBook instance = new PhoneBook();
	private PhoneBook() { /* singleton */ }
	public static PhoneBook getInstance() {
		return instance;
	}
	// --------------------------------------------------
	
	private Vector<PhoneInfo> vec = new Vector<>();
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
			if (name.equals(name)) {
				
				return info;
			}
		}
		return null;
//		System.out.println(searchName + "을(를) 찾지 못하였습니다.");
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
	
} // class