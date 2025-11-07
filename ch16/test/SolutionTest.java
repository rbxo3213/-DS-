package ch16.test;

import java.util.Arrays;

public class SolutionTest {
	public static void main(String[] args) {
		int n = 4;
		int[] amounts = {1000000, 490000, 700000, 290000};
		
		int n2 = 6;
		int[] amounts2 = {30000, 70000, 10000};
		Solution s = new Solution();
		
		int[] arr = s.solution(n, amounts);
		System.out.println(Arrays.toString(arr));
		
		int[] arr2 = s.solution(n2, amounts2);
		System.out.println(Arrays.toString(arr2));
	}
}
