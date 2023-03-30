package exam03;

public class ProcessScore {
	public ProcessScore(int []score) {
		try {
			int sum = 0;
			for(int a:score) {
				if(a<0) {
					throw new IllegalScore("점수는 음수가 될 수 없습니다.");
				}
				sum +=a;
			}
			int avg = sum/score.length;
			System.out.println("평균점수: "+avg);
		}catch(Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
		
	}
}
