package ver13TE;

public class PhoneInfoCompany extends PhoneInfo {
	private String company;

	public PhoneInfoCompany (String name,String phoneNumber,String birthDay,String company) {
		super(name,phoneNumber,birthDay); 
		this.company = company;
		
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("회사:"+ company);
		System.out.println("------------------");
	}

	public String getCompany() {
		return company;
	}

	

	

	
	

	
	
}
