package ver08;

public class PhoneInfo {
	private String name;
	private String phoneNumber;
	private String birthDay;
	
	// public PhoneInfo() { }
	public PhoneInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	public PhoneInfo(String name, String phoneNumber, String birthDay) {
		/*
		this.name = name;
		this.phoneNumber = phoneNumber;
		*/
		this(name, phoneNumber);
		this.birthDay = birthDay;
	}
	
	public String getName() {
		return name;
	}
	
	public void showInfo() {
		System.out.println("이름:" + name);
		System.out.println("전번:" + phoneNumber);
		if (birthDay != null && !birthDay.equals("")) {
			System.out.println("생일:" + birthDay);
		}
		// System.out.println("-------------------------");
		
	}
}