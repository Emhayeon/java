package ver05;


public class PhoneBook {
	private PhoneInfo[] storage = new PhoneInfo[10];
	private int index = 0;
	
	public void addInfo(PhoneInfo info) throws ArrayIndexOutOfBoundsException {
		storage[index] =info;
		index++;
	}
	
	public void showAll() {
		for(int i = 0; i < index; i++) {
			storage[i].showInfo();
		}
		
	}
	
	
}
