package ch15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		//HashSet 컬렉션 생성
		Set<String> set = new HashSet<String>();
		
		// 객체 저장
		set.add("Java");
		set.add("JDBC");
		set.add("JSP");
		set.add("Java"); // 중복 객체이므로 저장하지 않음
		set.add("Spring");
		
		// 저장된 객체의 수 출력
		int size = set.size();
		System.out.println("총 객체 수: "+size);
		System.out.println(set); // set내에 toString()메소드 
		System.out.println(set.toString());
		
		// Set은 인덱스가 없어 인덱스로 for문을 사용할 수 없다.
		// 향상된 for문
		for(String e : set) {
			System.out.println(e);
		}
		System.out.println();
		
		// Iterator
		Iterator iter = set.iterator();
		while(iter.hasNext()) { // Next가 있으면
			//String e = iter.next();
			System.out.println(iter.next().toString());
		}
		
		/* Object의 toString()
		public String toString() {
        	return getClass().getName() + "@" + Integer.toHexString(hashCode());
    	}
    	
    	   String 의 toString() (오버라이딩)
    	public String toString() {
        	return this;
    	}
    
		 */
		//map.getOrDefault(map,  null); // 코딩테스트 할 때 알아두면 좋은 getOrDefault
		Map<String, Integer> map = new HashMap<>();
		
		// "서울", 10
		// "부산", 5
		//map.put("서울", map.get("서울")+1);
		String[] city = {"서울","부산","광주","서울","부산","제주","서울","부산","서울","부산","부산","서울"};
		for(String c : city) {
//			map.put(c, map.get(c)+1); // 처음에는 null이어서 NullPointerException 발생
			map.put(c, map.getOrDefault(c,0)+1); // null이면 0을 리턴하는 getOrDefault사용
		}
		System.out.println(map);
		
		// map 반복
		Set<String> keys = map.keySet();
		System.out.println(keys);
		
		Iterator<String> keyIter = keys.iterator();
		while(keyIter.hasNext()) {
			String key = keyIter.next();
			System.out.println(key+":"+map.get(key));
		}
		
		System.out.println();
		
		for (String key : map.keySet()) {
			System.out.println(key+":"+map.get(key));
		}
		
		//var map2 = new HashMap<String, Integer>(); // 편하기는 하나 조심해야 함
		
		
		Map<String, Integer> map2 = new HashMap<>();
		map2.put("가", 1);
		map2.put("나", 1);
		map2.put("다", 1);
		map2.put("라", 1);
		map2.put("마", 1);
		
		for(String key : map2.keySet()) {
			System.out.println(key+":"+map2.get(key));
		}
		
	}
}
