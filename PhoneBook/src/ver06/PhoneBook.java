package ver06;


public class PhoneBook {
	private PhoneInfo[] storage = new PhoneInfo[10];
	private int index = 0;
	
	public void addInfo(PhoneInfo info) throws ArrayIndexOutOfBoundsException {
		storage[index] =info;
		index++;
	}
	
	public void showAll() {
		for(int i = 0; i < index; i++) {
			if (storage[i] instanceof PhoneInfoSchool) {
				PhoneInfoSchool infoSchool = (PhoneInfoSchool)storage[i];
				infoSchool.showInfoSchool();
			} else if (storage[i] instanceof PhoneInfoCompany) {
				PhoneInfoCompany infoCompany = (PhoneInfoCompany)storage[i];
				infoCompany.showInfoCompany();
			}
			storage[i].showInfo();
		}
		
	}
	
	
}
