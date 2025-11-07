package ch16.sec05;

public class ProblemSolv {
	public static void main(String[] args) {
		
		Solution s = new Solution();
		int n = 10;
		int[][] arr = {
				{2,3}, {1,7}, {2,4}, {3,5}
		};
		
		int n2 = 8;
		int[][] arr2 = {
				{1,9}, {3,6}, {2,5}
		};
		
		int n3 = 20000;
		int[][] arr3 = {
				{3,1}, {2,5}, {2,10}, {3,8}, {1,2}
		};
		System.out.println(s.solution(n3, arr3));
	}
}
