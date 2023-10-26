package ex04;

public abstract class Unit {
	private String name;
	private int x, y; //현재위치
	
	
	
	public Unit(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}



	public void move(int x, int y) {
		System.out.printf("%s이(가) (%d,%d)으로 이동합니다.\n",name,x,y);
		this.x =x;
		this.y =y;
		
	}
	
	public abstract void atack(int x, int y); 
	
	
	public void showPostion() {
		System.out.printf("%s이(가) (%d, %d)에 있습니다.\n",name,x,y);
	}
}
