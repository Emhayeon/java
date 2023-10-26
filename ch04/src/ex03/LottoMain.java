package ex03;


public class LottoMain {

	public static void main(String[] args) {
		LottoMachine machine = new LottoMachine();
		machine.setBalls();
		machine.shuffle();
		machine.showAllBalls();
		System.out.println("---------------------");
		machine.show6balls();
	}

}
