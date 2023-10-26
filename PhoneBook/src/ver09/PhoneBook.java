package ver09;


public class PhoneBook {
	private PhoneInfo[] storage = new PhoneInfo[10]; //storage에 데이터 있음
	private int index = 0;
	
	public void addInfo(PhoneInfo info) throws ArrayIndexOutOfBoundsException {
		storage[index] = info;
		index++;
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
	//수정 
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
	//삭제
	public boolean delete(String name) {
		for(int i = 0; i < index; i++) {
			String savedName = storage[i].getName();
			if(name.equals(savedName)) {
				storage[i] = null; //해당위치의 삭제처리 구현
				for(int j = i; j < index; j++) {
					storage[j] =storage[j+1];//삭제된데이터 데이터자리에 뒷데이터 붙여넣기 작업
				}
				storage[index-1] = null;
				index--;
				return true; //사용자 아니고 메인한테 알림 'System.out.println();'메인에서
			}
		}
		return false;
	}
	
} // class