package ex04;

public class Scout extends Unit{
	public Scout(String name) {
		super(name);
	}

	@Override
	public void atack(int x, int y) {
		System.out.printf("%s이(가) (%d,%d)를 미사일로 공격합니다.\n",getName(),x,y);
	}
	
}
