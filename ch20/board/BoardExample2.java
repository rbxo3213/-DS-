package ch20.board;

import java.util.Scanner;

public class BoardExample2 {
	//Field
	private Scanner scanner = new Scanner(System.in); // 여기저기서 메소드 쓰게 하려고 필드로 선언 -> 백준에서 Main클래스에 넣어도 좋겠다
	
	//Constructor
	
	//Method
	public void list() {
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("--------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n","no","writer","date","title"); // 포맷팅이라 printf
		System.out.println("--------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s \n", // 포맷팅이라 printf
				"1", "winter","2022.01.27","게시판에 오신 것을 환영합니다.");
		
		System.out.printf("%-6s%-12s%-16s%-40s \n", "2","winter","2022.01.27","올 겨울을 많이 춥습니다.");
		mainMenu();
	}
	
	public void mainMenu() {
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		System.out.println();
		
		switch(menuNo) {
			case "1" -> create();
			case "2" -> read();
			case "3" -> clear();
			case "4" -> exit();
			default -> {
				System.out.println("잘못된 입력입니다");
				list();
			}
		}
	}
	
	public void create() {
		System.out.println("*** crate() 메소드 실행됨");
		list();
	}
	public void read() {
		System.out.println("*** read() 메소드 실행됨");
		list();
	}
	public void clear() {
		System.out.println("*** clear() 메소드 실행됨");
		list();
	}
	public void exit() {
		System.out.println("*** exit() 메소드 실행됨");
		list();
	}
	
	public static void main(String args[]) {
		BoardExample2 boardExample = new BoardExample2();
		boardExample.list();
	}
}
