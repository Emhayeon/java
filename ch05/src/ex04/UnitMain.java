package ex04;

public class UnitMain {

	public static void main(String[] args) {
		Unit[] group1 = {new Marine("마린1"), new Tank("탱크1"), new Scout("스카1")};
		
		
		//(200, 200)으로 그룹1 이동
			
		/*for(int i =0; i<group1.length;i++) {
			group1[i].move(200, 200);
		}*/
	
		for(Unit unit : group1) {
		unit.move(200, 200);
		}	
		
		/*group1[0].move(200, 200);
		group1[1].move(200, 200);
		group1[2].move(200, 200);*/ //하나씩 먼저 꺼내보기
	
		
		//그룹1의 위치 확인
			
		for(Unit unit : group1) {
			unit.showPostion();
		}
		
	 	//공격
		
		for(Unit unit : group1) {
			unit.atack(300, 300);
		}
	}

}
