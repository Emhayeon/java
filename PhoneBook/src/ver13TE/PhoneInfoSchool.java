package ver13TE;

public class PhoneInfoSchool extends PhoneInfo {
	private String school;
	
	public PhoneInfoSchool(String name,String phoneNumber,String birthDay,String school) {
		super(name,phoneNumber,birthDay);
		this.school =school;
	}
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("학교:"+ school);
		System.out.println("------------------");
	}
	public String getSchool() {
		return school;
	}


}
