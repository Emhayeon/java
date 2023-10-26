package ex01;

import java.util.Vector;

public class VrctorEx {

	public static void main(String[] args) {
		//vector -목록형 컬렉션
		//순서가 있다. 중복 데이터 허용
		Vector<Integer> vec1 = new Vector<Integer>();
		
		//기본용량
		int capa = vec1.capacity();//허용용량
		System.out.println("capa:"+capa);
		
		for (int i =0; i <= capa; i++) {
			//벡터에 추가 (맨뒤에추가됨)
			vec1.add(i+1); // 추가
		}
		int size = vec1.size();//실제 데이터 크기(몇개)
		System.out.println("size:" +size);
		System.out.println(vec1.capacity());
		
		System.out.println("--------------------");
		
		vec1.remove(0); //제거
		vec1.add(2, 1); //삽입
		
		for(int i =0; i < vec1.size(); i++) {
			System.out.println(vec1.get(i)); //가져오기
		}
	}

}
