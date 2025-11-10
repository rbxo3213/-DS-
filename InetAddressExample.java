package ch19;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class InetAddressExample {
	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 IP 주소: "+ local.getHostAddress());
			
			InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
			for(InetAddress remote : iaArr) {
				System.out.println("www.naver.com IP 주소: "+ remote.getHostAddress());
			}
			String url = "https://www.egovframe.go.kr/home/sub.do?menuNo=10";
			URL urlObj = new URL(url);
			System.out.println(urlObj.getProtocol());
			System.out.println(urlObj.getQuery());
			InputStream is = urlObj.openStream();
//			Reader reader = new InputStreamReader(is);// 보조스트림(바이트->텍스트)
//			int count = 0;
//			while((count = reader.read()) != -1) {
//				System.out.print((char)count);
//			}
			// 보조 스트림 (성능향상)
			BufferedReader br = new BufferedReader(new InputStreamReader(urlObj.openStream()));
			// 성능 향상 보조스트림     <- 텍스트 기반으로 변경하는 보조스트림      <- 바이트 기반의 스트림 객체
			String line = "";
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
