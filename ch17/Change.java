package ch17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Change {

	public static void main(String[] args) {
	/*
	 배열 <-> 리스트 간 변환
	 */
	int[] array1 = {1,2,3};
//	List<Integer>list = new ArrayList<>(array1); 이렇게는 안됨
	
	// List로 변환
	List<Integer> list1 = new ArrayList<>();
	for(int i =0; i<array1.length; i++) {
		list1.add(array1[i]);
	}
	System.out.println(list1);
	
	// List로 변환 2
	List<Integer> list2 = Arrays.asList(// List로 변환
			Arrays.stream(array1).boxed().toArray(Integer[]::new)); // Integer[] 배열로 변환
	System.out.println(list2);
	
	
	// 리스트를 기본자료형(int) 배열로 변환 (매우 많이 쓰므로 숙지) 코테에서 마지막은 int[] 배열로 리턴해야 함
	// answer=list.stream().mapToInt(i->i).toArray();
	
	int[] array2 = list1.stream().mapToInt(i->i).toArray(); // for문 사용보다 훨씬 낫다. 손에 익을 때까지 쳐보기. list1이후로 어느 코드에서도 똑같다
	// for문으로 하기
	int[] array3 = new int[list1.size()];
	for(int i =0; i<array3.length; i++) {
		array3[i] = list1.get(i);
	}
	System.out.println(Arrays.toString(array3));
	
	// 문자열
		String[] array4 = {"김길동","박길동","홍길동"};
		List<String> list3 = Arrays.asList(Arrays.stream(array4).toArray(String[]::new)); // Stream을 String[]배열로 바꾸고 List로 바꾸기(asList)
		
		String[] array5 = list3.stream().toArray(String[]::new);
		System.out.println(Arrays.toString(array5));
		
		
	}
}
