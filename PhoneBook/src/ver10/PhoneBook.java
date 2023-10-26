package ver10;


public class PhoneBook {
	private PhoneInfo[] storage = new PhoneInfo[10];
	private int index = 0;
	
	public void addInfo(PhoneInfo info) throws ArrayIndexOutOfBoundsException {
		if (index >= storage.length) {
			PhoneInfo[] newStorage = new PhoneInfo[storage.length * 2];
			/*
			for (int i = 0; i < storage.length; i++) {
				newStorage[i] = storage[i];
			}
			
			*/
			
			System.arraycopy(storage, 0, newStorage, 0, storage.length);
			storage = newStorage;
			newStorage = null;
		}
		System.out.println("index:" + index);
		storage[index] = info;
		index++; // 10
		
	}
	
	public void showAll() {
		
		for (int i = 0; i < index; i++) {
			if (storage[i] instanceof PhoneInfoSchool) {
				PhoneInfoSchool infoSchool = (PhoneInfoSchool)storage[i];
				infoSchool.showInfoSchool();
			} else if (storage[i] instanceof PhoneInfoCompany) {
				PhoneInfoCompany infoCompany = (PhoneInfoCompany)storage[i];
				infoCompany.showInfoCompany();
			}
			// storage[i].showInfo();
		}
	}
	
	// 이름으로 검색하기
	public void searchByName(String searchName) {
		for (int i = 0; i < index; i++) {
			PhoneInfo info = storage[i];
			String name = info.getName();
			if (searchName.equals(name)) {
				if (info instanceof PhoneInfoSchool) {
					PhoneInfoSchool pis = (PhoneInfoSchool)info;
					pis.showInfoSchool();
				} else if (info instanceof PhoneInfoCompany) {
					PhoneInfoCompany pic =  (PhoneInfoCompany)info;
					pic.showInfoCompany();
				}
				return;
			}
		}
		
		System.out.println(searchName + "을(를) 찾지 못하였습니다.");
	}
	
	// 이름 중복 확인
	public boolean isNameDup(String searchName) {
		for (int i = 0; i < index; i++) {
			PhoneInfo info = storage[i];
			String name = info.getName();
			if (name.equals(searchName)) {
				return true;
			}
		}
		return false;
	}
	
	public PhoneInfo isExist(String name) {
		for (int i = 0; i < index; i++) {
			PhoneInfo info = storage[i];
			String savedName = info.getName();
			if (name.equals(savedName)) {
				return info;
			}
		}
		return null;
	}
	
	public void modify(PhoneInfo info) {
		for (int i = 0; i < index; i++) {
			if (storage[i].getName().equals(info.getName())) {
				storage[i] = info;
			}
		}
	}
	
	public boolean delete(String name) {
		for (int i = 0; i < index; i++) {
			String savedName = storage[i].getName();
			if (name.equals(savedName)) {
				storage[i] = null;
				for (int j = i; j < index; j++) {
					storage[j] = storage[j+1];
				}
				storage[index-1] = null;
				index--;
				return true;
			}
		}
		return false;
		
	}
	
} // class