package ver04;

public class PhoneInfo {
	
	private String name;
	private String tel;
	private String birth;
	
	public PhoneInfo(String name, String tel) {
		this.name = name;
		this.tel = tel;
		
		
	}
	
	public PhoneInfo(String name, String tel,String birth) {
		/*this.name = name;
		this.tel = tel;*/
		this(name,tel); //간단
		this.birth = birth;
	}
	
	public void showInfo() {
		System.out.println("이름:"+ name);
		System.out.println("전번:"+ tel);
		if(birth != null && !birth.equals("")) {
			System.out.println("생일:"+ birth); //if다시해봐 ['==':~이면,'!=:~아니면]'차이
		}
		System.out.println("-----------------------");
	}
}
