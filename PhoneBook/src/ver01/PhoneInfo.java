package ver01;

public class PhoneInfo {
	
	public String name;
	public String tel;
	public String birth;
	
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
		System.out.println("이름:"+ this.name);
		System.out.println("전번:"+ this.tel);
		if(this.birth != null) {
			System.out.println("생일:"+ this.birth); //if다시해봐 ['==':~이면,'!=:~아니면]'차이
		}
		System.out.println("-----------------------");
	}
}
