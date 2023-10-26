package ex02;

public class ReturnArray {

	public static void main(String[] args) {
		int[] array = makeArray();
		int[] array2 = makeArray();
		int sum = getSum(array); //1 2 3 4 들어있음
		System.out.println("sum:"+sum);
		System.out.println("array:" +array);
		System.out.println("array2:" +array2);
		
		
		array[0] = 100;
		for (int i : array) {
			System.out.print(i+" "); 
		}
		long time = System.currentTimeMillis();
		System.out.println("time: "+ time);
		
	}
	public static int[] makeArray() {
		int[] temp =  new int[4];  //기본값으로 초기화
		return temp;
	}
	
	public static int getSum(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			data[i] = i + 1;
			sum += data[i];
		}
		return sum;
	}
}
