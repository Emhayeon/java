package oc;

import java.util.Scanner;

public class WordGameApp {
	
	private static WordGameApp instance = new WordGameApp();
	private WordGameApp() { }
	public static WordGameApp getInstance() {
		return instance;
	}
	
	private Player[] players;
	private Scanner scanner = new Scanner(System.in);
	private final String START_WORD = "아버지";
	private Player prevPlayer, curPlayer;
	
	private void setPlayerNames(int count) {
		for (int i = 0; i < count; i++) {
			System.out.print("참가자의 이름을 입력하세요>>");
			players[i] = new Player();
			String name = scanner.next();
			players[i].setName(name);
		}
	}//setPlayerNames만들어서 for문을 위로 올린거
	
	public void run() {
		System.out.print("게임에 참가하는 인원은 몇명입니까>>");
		
		int count = scanner.nextInt(); 
		players = new Player[count]; // 객체가 들어갈 공간 확보{null, null, null}
		// String[] names = new String[count];
		setPlayerNames(count);
		
		
		
		System.out.println("시작하는 단어는 " + START_WORD + " 입니다.");
		int index = 0;
		while (true) {
			if (prevPlayer == null) {
				prevPlayer = new Player();
				prevPlayer.setWord(START_WORD);
			}
			curPlayer = players[index];
			System.out.print(curPlayer.getName() + ">>");
			String word = scanner.next();
			curPlayer.setWord(word);
			
			boolean result = isOk(word);
			if (result == false) {
				String name= players[index].getName();
				System.out.println(name + "이(가) 졌습니다.");
				break;
			}
			
			prevPlayer = curPlayer;
			
			
			index++;
			if (index == players.length) {
				index = 0;
			}
			
		}
		
		System.out.println("게임 종료");
		scanner.close();
		
	} // run
	
	
	public boolean isOk(String word) {
		char lastChar = prevPlayer.getLastChar();
		char firstChar = curPlayer.getFirstChar();
		if (lastChar == firstChar) {
			return true;
		}
		return false;
	}
	public void showAllPlayers() {
		for (Player player : players) {
			player.showInfo();
		}
	}
	
}