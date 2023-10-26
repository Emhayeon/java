package oc;



public class Player {
	private String name;
	private String word;
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void showInfo() {
		System.out.println("name"+":"+ word);
	}
	
	public char getFirstChar() {
		return word.charAt(0);
	}
	public char getLastChar() {
		return word.charAt(word.length() - 1);
	}
	
}