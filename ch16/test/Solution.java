package ch16.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*
 	배열: Arrays.sort()
 	컬렉션 : Collections.sort()
 	기본자료형 : Arrays.sort(변수)
 	참조자료형 : Arrays.sort(변수, new Comparator<>(){});
 */
public class Solution {
	public int[] solution(int n, int[] amounts) {
		int[] answer = new int[n];
		// n행, m명
		// 물품번호 오름차순, 자본 내림차순
		// 자본 1등은 자본 2등+10000원을 지불하고 상품을 낙찰받음
		// 자본 1등이 다수일 경우 참가번호가 빠른 사람이 자본을 전부 지불하고 상품을 낙찰받음.
		// 참가자의 자본이 모두 0원일 때 낙찰 금액은 0원
		List<Integer>list = new ArrayList<>();
		// 자본순으로 내림차순 정렬하고 시작
		for(int i : amounts) {
			list.add(i);
		}
		Collections.sort(list, Comparator.reverseOrder());
		
		System.out.println(list);
		
		// 이제부터 내림차순 하는데, 비교해서 같으면 맨 앞의 것을 0으로 만들고 다시 내림차순 정렬.
		for(int i =0; i<n; i++) {
			if((int)list.get(0)==(int)list.get(1) && list.get(0)!=0) {
				answer[i]+=list.get(0);
				list.set(0, 0);
				Collections.sort(list, Comparator.reverseOrder());
				System.out.println("1"+list);
			} else if (list.get(0)>list.get(1) && list.get(1)!=0) {
				int pay = list.get(1)+10000;
				answer[i]+=pay;
				list.set(0, list.get(0)-pay);
				Collections.sort(list, Comparator.reverseOrder());
				System.out.println("2"+list);
				//System.out.println(list.get(0)+" "+list.get(1));
			} else if (list.get(0)!=0 && list.get(1)==0) {
				answer[i]+=list.get(0);
				list.set(0, 0);
				Collections.sort(list, Comparator.reverseOrder());
				System.out.println("3"+list);
			} else if (list.get(0)==0){
				answer[i]+=0;
				Collections.sort(list, Comparator.reverseOrder());
				System.out.println("4"+list);
			} else {
				//System.out.println("5");
			}
//			Collections.sort(list, new Comparator<Integer>() {
//				@Override
//				public int compare(Integer a, Integer b) {
//					if (a==b) {
//						answer[i] = list.get(0);
//						list.set(0, 0);
//					}
//				}
//			});
		}
		/*
		 m행 2열 배열을 만든다
		  
		 
		 */
		
		return answer;
	}
}
