package backtracking;

public class LongestRouteInMatrixWithHurdles {
	
	public int longestRoute(int[][] map, int sx, int sy, int dx, int dy) {
		boolean[][] visited = new boolean[map.length][map[0].length];
		return this.longestRoute(sx, sy, dx, dy, map, visited, 0);
	}
	
	public int longestRoute(int sx, int sy, int dx, int dy, int[][] map, boolean[][] visited, int distance) {
		visited[sx][sy] = true;
		if(sx == dx && sy == dy) {
			visited[sx][sy] = false;
			return distance;
		}
		int fromTop = 0;
		int fromLeft = 0;
		int fromRight = 0;
		int fromBottom = 0;
		if(sx - 1 >= 0 && map[sx-1][sy] != 0 && !visited[sx-1][sy])
			fromTop = this.longestRoute(sx-1, sy, dx, dy, map, visited, distance + 1);  
		if(sy - 1 >= 0 && map[sx][sy-1] != 0 &&!visited[sx][sy-1])
			fromLeft = this.longestRoute(sx, sy-1, dx, dy, map, visited, distance + 1);
		if(sx + 1 <= map.length - 1 && map[sx+1][sy] != 0 && !visited[sx+1][sy])
			fromBottom = this.longestRoute(sx+1, sy, dx, dy, map, visited, distance + 1);
		if(sy + 1 <= map[sx].length - 1 && map[sx][sy+1] != 0 && !visited[sx][sy+1])
			fromRight = this.longestRoute(sx, sy+1, dx, dy, map, visited, distance + 1);
		visited[sx][sy] = false;
		return Math.max(Math.max(fromRight, fromLeft), Math.max(fromTop, fromBottom));			
	}
	
	public static void main(String[] args) {
		int[][] map = {
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
		        { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
		        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		    };
		LongestRouteInMatrixWithHurdles r = new LongestRouteInMatrixWithHurdles();
		System.out.println("Longest Path Length: " + r.longestRoute(map, 0, 0, 1, 7));
	}
	
}
