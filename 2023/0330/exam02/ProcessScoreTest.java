package exam02;

class IllegalScore extends Exception{
	public IllegalScore(String msg) {
		super(msg);
	}
}

class ProcessScore {
	public ProcessScore(double []arr) {
		double sum = 0;
		for(double i:arr) {
			if(i<0) {
				try {
					throw new IllegalScore("점수가 음수입니다.");
				}catch(Exception e) {
					System.out.println("예외발생: "+e.getMessage());
				}
			}
			sum +=i;
		}
		double avg = sum/arr.length;
		System.out.println("평균점수: "+avg);
	}
}
public class ProcessScoreTest {

	public static void main(String[] args) {
		double a[] = {10, 50, 100, 40, 50, 90};
		ProcessScore ps = new ProcessScore(a);
	}
}
