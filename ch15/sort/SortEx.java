package ch15.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 정렬 알고리즘
public class SortEx {
	public static void main(String[] args) {
		/*
		 정렬은 다음 두 개의 경우에 각각 다르다
		 배열 : Arrays.sort()
		 컬렉션 : Collections.sort() // Collections s붙이는 것 주의
		 
		 기본 자료형 : Arrays.sort(변수) 매개변수 하나 밖에 못 옴
		 참조 자료형 : Arrays.sort(변수, Comparator 객체)
		 */
		
//		/---------------------------------------------
		// 기본자료형 배열
		int[] array = {8,1,6,2,4};
		
		
		Arrays.sort(array); // 정렬 (오름차순 정렬)
		System.out.println(Arrays.toString(array));
		// 그러나 내림차순 정렬이 안 됨
		//Arrays.sort(array, Comparator.reverseOrder()); // int 타입은 Comparator.reverseOrder() 불가
		// String 은 T[] 에 들어갈 수 있어 Comparator를 사용 가능 => Integer로 변경하면 가능하다
		
		//--------------------------문자열-------------------------------------------------
		Integer[] array3 = {8,1,6,2,4};
		Arrays.sort(array3, Comparator.reverseOrder());
		System.out.println(Arrays.toString(array3));
		// 기본자료형을 참조자료형으로 바꾸면 된다 (int => Integer)
		

		// 문자열 배열
		String[] array2 = {"서울","광주","제주","대구"};
		Arrays.sort(array2); // 오름차순 정렬
		System.out.println(Arrays.toString(array2));

		Arrays.sort(array2);

		// 내림차순 정렬
		Arrays.sort(array2, Comparator.reverseOrder());
		System.out.println(Arrays.toString(array2));

		Arrays.sort(array2, Comparator.reverseOrder());
		System.out.println(Arrays.toString(array2));
		
//		/----------------------------------------------------------------------------/
		// 컬렉션
		
		List<Integer> list = new ArrayList<>();
//		List<Integer> list = new ArrayList<>();
		
		list.add(8);
		list.add(1);
		list.add(6);
		list.add(2);
		list.add(4);
		System.out.println("-----------------------------------");
		System.out.println("           컬렉션 정렬                ");
		System.out.println("-----------------------------------");
		System.out.println(list); // 컬렉션 프레임워크 List 는 toString 없이도 출력이 가능하다.
		
		Collections.sort(list);
		System.out.println(list);
		
		Collections.sort(list,Comparator.reverseOrder()); // 내림차순
		System.out.println(list);


		/* --------------------------------------------------------------------------------
		 객체 정렬
		 - Comparable 인터페이스를 구현
		 - Comparator 인터페이스를 구현객체(익명구현객체 or 람다식)로 쓰는 것
		 */
		
		
		// List 안에 Map 객체가 있다고 하자
		// Map 안에는 이름, 나이 (나이순으로 정렬해야 할 때, 위의 방법으로는 할 수 없다.)
		// 커스텀 정렬을 해야 함. (2차원 정렬 등에서)
		
		List<Map<String, Object>> list2 = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "홍길동1");
		map.put("age", 20);
		list2.add(map);
		
		map = new HashMap<>(); // 새 객체를 계속 생성해야 함.
		map.put("name", "홍길동3");
		map.put("age", 10);
		list2.add(map);
		
		map = new HashMap<>();
		map.put("name", "홍길동2");
		map.put("age", 40);
		list2.add(map);
		
		Collections.sort(list2, new Comparator<Map>() { // 추상 메소드 int compare(T o1, T o2);를 재정의
			@Override
			public int compare(Map o1, Map o2) {
				return (int)o1.get("age") - (int)o2.get("age"); // 앞에 것 - 뒤에 것 = 오름차순
			// o1-o2<0 => o1을 앞으로 || o1-o2>0 => o2를 앞으로 || o1-o2=0 => 그대로 유지
			}
		});
		Collections.sort(list2, (o1, o2)->{
			return (int)o1.get("age") - (int)o2.get("age");
		});
		
		// 위는 두 번째 매개변수로 익명 구현 객체
		// 아래는 람다식

		for(Map m : list2) {
			System.out.println(m);
		}
		
		// ------------------------------------------------
		
		int[][] array4 = {
				{1,99}, {2,98}, {3,97}, {4,96}
		};
		
		Arrays.sort(array4, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});

		
		// 두 번째 값을 기준으로 오름차순 정렬
		// Collections 만이 아니라 Arrays에서도 Comparator 사용, 재정의가 가능.
		Arrays.sort(array4, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		// 람다식으로
		Arrays.sort(array4, (o1, o2) -> { // 람다식: Comparator인터페이스 내에 딱 하나 있는 추상메소드 int compare(T o1, T o2);
			return o1[1]-o2[1]; // 단 하나 뿐이기 때문에 어떤 메소드를 override하는지 적지 않을 수 있음. override할 내용만 넣기
		}); //
		
		Arrays.sort(array4, (o1, o2) -> o1[1]-o2[1]);
		for (int[] i : array4) {
			System.out.println(Arrays.toString(i));
			
		}
		
		
		
		
		
		Thread t = new Thread(()->{
			
		});
		
		
		
	}
}
