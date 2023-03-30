package exam02;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
	public static void main(String[] args) {
		try {
		FileWriter fw = new FileWriter("c:/temp/hello.txt");
		fw.write("hello java 파일 출력");
		fw.close();
		System.out.println("파일 생성");
		}catch(IOException e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}
}
