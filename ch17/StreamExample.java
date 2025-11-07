package ch17;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;


public class StreamExample {
	public static void main(String[] args) {
		// Set 컬렉션 생성
		Set<String> set = new HashSet<>();
		set.add("홍길동");
		set.add("신용권");
		set.add("감자바");
		
		// Stream을 이용한 요소 반복 처리
		Stream<String> stream = set.stream();
		// 람다 표현식
		stream.forEach(name->System.out.println(name));
		// stream.forEach((name)->{System.out.println(name);}); // 괄호와 중괄호 생략 가능 , stream은 일회용이므로 이대로 실행하면 에러 발생
		
		// 익명 구현 객체
//		stream.forEach(new Consumer<String>() {
//			@Override
//			public void accept(String t) { // t = name
//				System.out.println(t);
//			}
//			
//		});
		
		
		// 출력을 간단히 할 수 있다.
		set.stream().forEach(n->System.out.println(n));
	}
}
