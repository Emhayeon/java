package ex04;

public class Marine extends Unit {
	public Marine(String name) {
		super(name);
	}

	@Override
	public void atack(int x, int y) {
		
		System.out.printf("%s이(가) (%d,%d)를 총으로 공격합니다.\n",getName(),x,y);
	}
	
}
