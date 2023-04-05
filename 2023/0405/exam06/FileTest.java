package exam06;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		String path = "C:\\javaStudy\\day0405\\src\\exam06/ButtonTest.java";
		File file = new File(path);
		if(file.isDirectory()) {
			System.out.println("디렉토리입니다.");
		}else {
			System.out.println("파일입니다.");
		}
	}
}
