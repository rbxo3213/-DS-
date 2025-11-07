package ch16.sec05;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public int solution (int tickets, int[][] requests) {
		int soldTickets = 0;
		// request{등급, 티켓구매수}
		// 높은 등급 먼저, 티켓구매수 후순위, 티켓수량보다 더 구매하려 할 시 넘어감.
		
		// 등급 오름차순 정렬 후 tickets에서 티켓 수량만큼 빼면 될 것 같다.
		
		Arrays.sort(requests, new Comparator<int[]>() {
			@Override
			public int compare(int[]o1, int[]o2) {
				if(o1[0]!=o2[0]) {
					return o1[0]-o2[0];
				} else {
					return o2[1]-o1[1];
				}
			}
		});
		
	
		for (int[] a : requests) {
			if(tickets<a[1]) continue;
			tickets-=a[1];
			soldTickets+=a[1];
		}

		return soldTickets;
	}
}