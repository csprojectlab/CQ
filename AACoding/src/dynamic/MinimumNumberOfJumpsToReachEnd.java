package dynamic;


public class MinimumNumberOfJumpsToReachEnd {

	public int[] getPath(int[] parent, int minJumps) {
		int[] path = new int[minJumps];
		int pathIndex = path.length - 1;
		int index = parent.length - 1;
		while(parent[index] != -1) {
			path[pathIndex] = index;
			index = parent[index];
			pathIndex--;
		}
		System.out.print("Elements inlcuded are:(indices):  ");
		util.Util.print(path);
		return path;
	}
	
	public int minJumps(int[] arr) {
		int[] k = new int[arr.length];
		int[] parent = new int[k.length];    // To store the result.
		// Initialize with their corresponding values.
		for(int i = 0; i < arr.length; i++)
			k[i] = Integer.MAX_VALUE;
		k[0] = 0;   // This is a kind of seed value.
		parent[0] = -1;
		for(int i = 0; i < k.length; i++) {
			for(int j = 0; j < i; j++) {
				if(j + arr[j] >= i) {
					if(k[i] > 1 + k[j]) {
						k[i] = 1 + k[j];   // minimum.
						parent[i] = j;
					}
				} 					
			}
		}
		util.Util.print(k);
		util.Util.print(parent);
		this.getPath(parent, k[k.length-1]);
		return k[k.length-1];
	}
	
	public static void main(String[] args) {
		MinimumNumberOfJumpsToReachEnd j = new MinimumNumberOfJumpsToReachEnd();
		int arr[] = new int[] {2,3,1,1,2,4,2,0,1,1};
		j.minJumps(arr);
	}
}
