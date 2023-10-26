package ver09;

public class PhoneInfoSchool extends PhoneInfo {
	private String school;
	
	public PhoneInfoSchool(String name,String phoneNumber,String birthDay,String school) {
		super(name,phoneNumber,birthDay);
		this.school =school;
	}

	public void showInfoSchool() {
		showInfo();
		System.out.println("학교:"+ school);
		System.out.println("------------------");
	}

}
