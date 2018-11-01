package arrays;

public class CountFrequencyOfNumbersInArray {
	
	public int[] countFreq(int[] arr) {
		int i = 0;
		while(i < arr.length) {
			if(arr[i] <= 0) {
				i++;
				continue;
			}
			int index = arr[i] - 1;
			if(arr[index] > 0) {
				arr[i] = arr[index];
				arr[index] = -1;
			} else {
				arr[index]--;
				arr[i] = 0;
				i++;
			}
		}
		
		for(int j = 0; j < arr.length; j++) {
			System.out.println((j+1) + " => " + Math.abs(arr[j]));
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		CountFrequencyOfNumbersInArray c = new CountFrequencyOfNumbersInArray();
		int[] arr = new int[] {2,3,3,2,5};
		c.countFreq(arr);
	}
}
