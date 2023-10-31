package ex05;

import java.lang.Thread.State;

public class MainThreadEx {

	public static void main(String[] args) {
		Thread th = Thread.currentThread();//현재 실행중인 스레드
		long id =  th.getId();
		System.out.println("id:"+id);
		int priority = th.getPriority();
		System.out.println("priority: "+priority);
		State state = th.getState();
		System.out.println("state: "+state);
	}

}
