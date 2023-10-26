package ex02;

public class ScoreAverage {

	public static void main(String[] args) {
		int[][] scores = {
				{100, 90, 80}, //scores[0]
				{90, 80, 70}, //scores[1]
				{80, 70, 60}, //scores[2]
				{70, 60, 50},  //scores[3]
				{60, 50, 40}   //scores[4]
		};
		System.out.println(scores[0][0]);  //100
		System.out.println(scores[2][2]);  //60
		
		int total = 0;
		for(int j = 0; j <scores.length; j++) {
			for (int i =0; i < scores[j].length; i++) {
				total += scores[j][i];
			}
		}	
		/*
		for (int i = 0; i < scores[1].length; i++) {
			total += scores[1][i];
		}
		*/
		System.out.println("total:"+total);
		
		int totalLength = 0;
		for(int i = 0; i < scores.length; i++) {
			totalLength += scores[i].length;
		}
		System.out.println("average: " + ((double)total / totalLength));

	}

}
