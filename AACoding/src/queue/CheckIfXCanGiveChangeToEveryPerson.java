package queue;

/*
 * Given an array of N integers where Ai denotes the currency of note that the i-th person has. 
 * The possible currencies are 5, 10 and 20. All the N people are standing in a queue waiting to
 *  buy an ice-cream from X which costs Rs 5. Initially, X has an initial balance of 0. Check if X
 *   will be able to provide change to every people who are waiting to buy an ice-cream.
 *   
 *   Input:a[] = {5, 5, 5, 10, 20}
Output: YES
When the fourth person chance comes to buy an ice-cream, X has three Rs 5
change, hence X gives him 1, and now when the fifth person
comes to buy the ice-cream, X has two Rs 5 and one Rs 10 note, hence he
gives him one Rs 10 and one Rs 5 note.

Input: a[] = {5, 10, 10, 20}
Output: NO
 */
public class CheckIfXCanGiveChangeToEveryPerson {

	public boolean canGiveChange(int[] arr) {
		int fiveCount = 0;
		int tenCount = 0;
		int i = 0;
		while(i < arr.length) {
			if(arr[i] == 5)
				fiveCount++;
			else if(arr[i] == 10) {
				if(fiveCount > 0) {
					fiveCount--;
					tenCount++;
				} else
					return false;
			} else if(arr[i] == 20) {
				if(fiveCount > 0 && tenCount > 0) {
					fiveCount--;
					tenCount--;					
				} else if(fiveCount >= 3)
					fiveCount -= 3;
				else
					return false;
			}
			i++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]  {5, 5, 5, 10, 20};
		int[] arr1 = new int[] {5, 10, 10, 20};
		CheckIfXCanGiveChangeToEveryPerson c = new CheckIfXCanGiveChangeToEveryPerson();
		boolean ans = c.canGiveChange(arr1);
		System.out.println("Can give: " + ans);
	}
	
}
