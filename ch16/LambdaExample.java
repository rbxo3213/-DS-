package ch16;

public class LambdaExample {
	public static void main(String[] args) {
		Person person = new Person();
		
		person.action1(new Workable() { // 익명 구현 객체
			public void work(String name, String job) {
				System.out.print(name+"이 ");
				System.out.println(job+"을 합니다.");
			}
		});
		
		// 매개변수가 두 개일 경우
		person.action1((name, job)->{
			System.out.print(name+"이 ");
			System.out.println(job+"을 합니다.");
		});
		
		person.action1((name, job) -> System.out.println(name+"이 "+job+"을 하지 않습니다.")); // 실행문이 하나일 때는 중괄호 생략 가능
		
		// 매개변수가 한 개일 경우 , 괄호 생략 가능 (word) -> 를 word -> 로 작성 가능
		person.action2(word->{
			System.out.print("\""+word+"\"");
			System.out.println("라고 말합니다.");
		});
		
		person.action2(word->System.out.println("\""+word+"\"라고 외칩니다."));
	}
}
