package ver02;


public class PhoneBook {
	public PhoneInfo[] storage = new PhoneInfo[10];
	public int index = 0;
	
	public void addInfo(PhoneInfo info)  {
		storage[index] =info;
		index++;
	}
	
	public void showAll() {
		for(int i = 0; i < index; i++) {
			storage[i].showInfo();
		}
		
	}
	
	
}
