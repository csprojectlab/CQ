package graphadjacency;

//A number is called as a Jumping Number if all adjacent digits in it differ by 1. The difference between ‘9’ and ‘0’ is not considered as 1.
//All single digit numbers are considered as Jumping Numbers. For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are not.

public class PrintJumpingNumbersSmallerThanGivenValue {

	public PrintJumpingNumbersSmallerThanGivenValue() {
		// TODO Auto-generated constructor stub
	}
	
	public static void jumpingNumbersDFS(int number, int range) {
		if(number > range)
			return;
		System.out.print(number + " ");
		int lastDigit = number % 10;
		if(lastDigit == 0) {
			jumpingNumbersDFS((number*10) + lastDigit + 1, range);
		} else if(lastDigit == 9) {
			 jumpingNumbersDFS((number*10) + lastDigit - 1, range);
		} else {
			jumpingNumbersDFS((number*10) + lastDigit - 1, range);
			jumpingNumbersDFS((number*10) + lastDigit + 1, range);
		}
	}
	
	public static void main(String[] args) {
		int range = 500;
		for(int i = 1; i <= 9; i++)
			jumpingNumbersDFS(i, range);
	}

}
