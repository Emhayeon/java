package ver07;

public class PhoneInfoCompany extends PhoneInfo {
	private String company;

	public PhoneInfoCompany (String name,String phoneNumber,String birthDay,String company) {
		super(name,phoneNumber,birthDay); 
		this.company = company;
		
	}

	
	public void showInfoCompany() {
		showInfo();
		System.out.println("회사:"+ company);
		System.out.println("------------------");
	}

	

	

	
	

	
	
}
