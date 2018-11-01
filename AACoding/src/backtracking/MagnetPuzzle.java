package backtracking;

public class MagnetPuzzle {
	public char T = 't';
	public char L = 'l';
	public char R = 'r';
	public char B = 'b';
	public int[] left = { -1, -1, 2, -1 };
	public int[] right = { 0, -1, -1, -1 };
	public int[] bottom = { -1, -1, 2 };
	public int[] top = { 2, -1, -1 };
	public int[][] result;
	public char[][] rules = { { T, T, T }, { B, B, B }, { T, L, R }, { B, L, R } };
	public final int CROSS = 2;
	public final int PLUS = 0;
	public final int MINUS = 1;
	public final int DV = 90;
	
	public MagnetPuzzle() {
		this.result = new int[rules.length][rules[0].length];
		for(int i = 0; i < result.length; i++)
			for(int j = 0; j < result[i].length; j++)
				result[i][j] = this.DV;
	}
	
	public boolean constraintSafe(int x, int y, int sign) {
		if(x - 1 >= 0 && this.result[x-1][y] == sign)
			return false;
		if(x + 1 <= this.result.length - 1 && this.result[x+1][y] == sign)
			return false;
		if(y - 1 >= 0 && this.result[x][y-1] == sign)
			return false;
		if(y + 1 <= this.result[x].length - 1 && this.result[x][y+1] == sign)
			return false;
		return true;
	}

	public boolean findSolution(int x, int y) {
		if (x == this.result.length)
			return true;
		if (y == this.result[0].length)
			return this.findSolution(x + 1, 0);
		if (this.rules[x][y] == 'b') {
			if (this.result[x - 1][y] == this.CROSS) {
				this.result[x][y] = this.CROSS;
				if (this.findSolution(x, y + 1))
					return true;
			} else {
				int otherPole = (this.result[x - 1][y] == this.PLUS) ? this.MINUS : this.PLUS;
				if (otherPole == this.PLUS && this.left[x] != 0 && this.top[y] != 0) {
					this.left[x] = (this.left[x] == -1) ? -1 : this.left[x] - 1;
					this.top[y] = (this.top[y] == -1) ? -1 : this.top[y] - 1;
					this.result[x][y] = otherPole;
					if (this.findSolution(x, y + 1))
						return true;
				} else if (otherPole == this.MINUS && this.right[x] != 0 && this.bottom[y] != 0) {
					this.right[x] = (this.right[x] == -1) ? -1 : this.right[x] - 1;
					this.bottom[y] = (this.bottom[y] == -1) ? -1 : this.bottom[y] - 1;
					this.result[x][y] = otherPole;
					if (this.findSolution(x, y + 1))
						return true;
				} else
					return false;
			}
		} else if (this.rules[x][y] == 'r') {
			if (this.result[x][y - 1] == this.CROSS) {
				this.result[x][y] = this.CROSS;
				if (this.findSolution(x, y + 1))
					return true;
			} else {
				int otherPole = (this.result[x][y - 1] == this.PLUS) ? this.MINUS : this.PLUS;
				if (otherPole == this.PLUS && this.left[x] != 0 && this.top[y] != 0) {
					this.left[x] = (this.left[x] == -1) ? -1 : this.left[x] - 1;
					this.top[y] = (this.top[y] == -1) ? -1 : this.top[y] - 1;
					this.result[x][y] = otherPole;
					if (this.findSolution(x, y + 1))
						return true;
				} else if (otherPole == this.MINUS && this.right[x] != 0 && this.bottom[y] != 0) {
					this.right[x] = (this.right[x] == -1) ? -1 : this.right[x] - 1;
					this.bottom[y] = (this.bottom[y] == -1) ? -1 : this.bottom[y] - 1;
					this.result[x][y] = otherPole;
					if (this.findSolution(x, y + 1))
						return true;
				} else
					return false;
			}
		} else {
			for (int m = 0; y < this.result.length; m++) {
				if (m == this.CROSS) {
					result[x][y] = this.CROSS;
					if (this.findSolution(x, y + 1))
						return true;
				} else if (m == this.PLUS && this.left[x] != 0 && this.top[y] != 0 && constraintSafe(x, y, m)) {
					this.left[x] = (this.left[x] == -1) ? -1 : this.left[x] - 1;
					this.top[y] = (this.top[y] == -1) ? -1 : this.top[y] - 1;
					this.result[x][y] = this.PLUS;
					if (this.findSolution(x, y + 1))
						return true;
				} else if (m == this.MINUS && this.right[x] != 0 && this.bottom[y] != 0 && constraintSafe(x, y, m)) {
					this.right[x] = (this.right[x] == -1) ? -1 : this.right[x] - 1;
					this.bottom[y] = (this.bottom[y] == -1) ? -1 : this.bottom[y] - 1;
					this.result[x][y] = this.MINUS;
					if (this.findSolution(x, y + 1))
						return true;
				}
			}
		}
		if (this.result[x][y] == this.PLUS) {
			this.left[x] = (this.left[x] == -1) ? -1 : this.left[x] + 1;
			this.top[y] = (this.top[y] == -1) ? -1 : this.top[y] + 1;
		} else if (this.result[x][y] == this.MINUS) {
			this.right[x] = (this.right[x] == -1) ? -1 : this.right[x] + 1;
			this.bottom[y] = (this.bottom[y] == -1) ? -1 : this.bottom[y] + 1;
		}
		this.result[x][y] = this.DV;
		return false;

	}

	public static void main(String[] args) {
		MagnetPuzzle p = new MagnetPuzzle();
		p.findSolution(0, 0);
		for(int i = 0; i < p.result.length; i++) {
			for(int j = 0; j < p.result[0].length; j++)
				System.out.print(p.result[i][j] + " ");
			System.out.println();
		}

	}

}
