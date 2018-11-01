package stack;

import java.util.Stack;

/*
 *  if a[i] < a[i+1] then delete element at i.
 *  deleting this element may trigger a chain, therefore delete others as well.
 */
public class DeleteArrayElementsSmallerThanOrBecomeSmaller {

	// print the stack elements in reverse order.
	public void printStack(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			int top = stack.pop();
			this.printStack(stack);
			System.out.print(top + " ");
		}
			
	}
	
	public void deleteElements(int[] arr, int K) {
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		int i = 1;		
		while(i < arr.length) {
			while(K > 0 && !stack.isEmpty() && stack.peek() < arr[i]) {
				stack.pop();   // Delete this element.
				K--;
			}
			stack.push(arr[i]);
			i++;
		}
		this.printStack(stack);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {20,10,25,30,40};
		int K = 2;   // Only do k deletions.
		System.out.print("Before deletion: ");
		util.Util.print(arr);
		DeleteArrayElementsSmallerThanOrBecomeSmaller d = new DeleteArrayElementsSmallerThanOrBecomeSmaller();
		d.deleteElements(arr, K);
		
	}
}
