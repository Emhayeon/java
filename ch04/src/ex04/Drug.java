package ex04;

public class Drug {

	private void 열내리기() {
		System.out.println("열을 내립니다.");
	}
	
	private void 콧물멈추기() {
		System.out.println("콧물을 멈춥니다.");
	}
	
	private void 기침멈추기() {
		System.out.println("기침을 멈춥니다.");
	}
	
	public void 치료하기() {//캡슐화
		열내리기();
		기침멈추기();
		콧물멈추기();
	}
}
