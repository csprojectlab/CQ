package arrays;

public class PrintLeftRotationWithoutExtraSpace {

	public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5};
		int K = 2;   // Rotate left by this factor.
		
		int mod = K % arr.length;
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[(mod + i) % arr.length] + " ");
		
		System.out.println("Right rotation:");
		int index = arr.length - K;
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[(index + i) % arr.length] + " ");
		
	}
}
