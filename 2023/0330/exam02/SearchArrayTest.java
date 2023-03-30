package exam02;

class NotFoundException extends Exception {
	public NotFoundException(String msg) {
		super(msg);
	}
}

class SearchArray {
	public SearchArray(int []arr, int b) {
		int i;
		for(i=0;i<arr.length;i++) {
			if(b == arr[i]) {
				break;
			}
		}
		if(i<arr.length) {
			System.out.println("찾고자하는 값은 배열"+i+"번째 있습니다.");
		}else {
			try {
			throw new NotFoundException("배열에 데이터가 없습니다.");
			}catch(Exception e) {
				System.out.println("예외발생: "+e.getMessage());
			}
		}
	}
}

public class SearchArrayTest {
	public static void main(String[] args) {
		int []data = {20, 30, 40, 100, 9, 7};
		SearchArray sa = new SearchArray(data, 20);
		SearchArray sa2 = new SearchArray(data, 200);
	}
}
