package ver16;

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
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("PhoneInfoSchool");
		sb.append("[");
		sb.append("name=");
		sb.append(getName());
		sb.append(",phoneNumber=");
		sb.append(getPhoneNumber());
		sb.append(",birthDay=");
		sb.append(getBirthDay());
		sb.append(",school=");
		sb.append(getSchool());
		sb.append("]");
		return sb.toString();
	}


}
