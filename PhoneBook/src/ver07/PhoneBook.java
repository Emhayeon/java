package ver07;


public class PhoneBook {
	private PhoneInfo[] storage = new PhoneInfo[10];
	private int index = 0;
	
	public void addInfo(PhoneInfo info) throws ArrayIndexOutOfBoundsException {
		storage[index] =info;
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
	//이름으로 검색하기
	public void searchByName(String searchName) {
		for(int i = 0; i < index; i++) {
			PhoneInfo info = storage[i];
			String name = info.getName();
			if(searchName.equals(name)) {
				if(info instanceof PhoneInfoSchool){
					PhoneInfoSchool pis = (PhoneInfoSchool)info; //다운캐스팅
					pis.showInfoSchool();
				} else if (info instanceof PhoneInfoCompany){
					PhoneInfoCompany pic = (PhoneInfoCompany)info;
					pic.showInfoCompany();
				}//찾은경우 
				
				//break; //반복필요없음  못찾으면 다음꺼 한다 else아녀
				return; 
			} 
		}//꺼내오기
		
		System.out.println(searchName + "을(를) 찾지 못하였습니다.");
	}
	
	//이름 중복 확인
	public boolean  isNameDup(String searchName) {
		for(int i = 0; i < index; i++) {
			PhoneInfo info = storage[i];
			String name = info.getName();
		if(name.equals(searchName)) {
			return true;
			}
		}
		return false;
	}
}//class
