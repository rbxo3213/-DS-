package ch17.sec04;

public class ProblemSolv {
	public static void main(String[] args) throws Exception{
		String a = "KOREAKOREAKOREAKOREAKOREAKOREA";
		String b = "SAMSUNGSAMSUNGSAMSUNGSAMSUNGSA";
		String c = "GALAXYGALAXYGALAXYGALAXYGALAXY";
		String d = "DDDDADDDDADDDDADDDDADDDDADDDDA";
		System.out.println(problemSolv(a));
		System.out.println(problemSolv(b));
		System.out.println(problemSolv(c));
		System.out.println(problemSolv(d));
	}
	public static int problemSolv(String s) {
		int[] arr = new int[200];
		for(int i =0; i<s.length(); i++) {
			int tmp = (int)s.charAt(i);
			arr[tmp]++;
		}
		int min = 0;
		arr[min] = 99;
		for(int i =0; i<arr.length; i++) {
			
			if (arr[min]>arr[i] && arr[i]>0) {
				min=i;
			}
		}
		
		return (int)(s.length()/arr[min]);
	}
}
