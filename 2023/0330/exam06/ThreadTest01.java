package exam06;
class Person extends Thread{
	private String name;
	public Person(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=10;i++) {
			System.out.println("hello"+name+"!"+i);
			try {
				Thread.sleep(100);
			}catch(Exception e) {}
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
public class ThreadTest01 {
	public static void main(String[] args) {
		Person kim = new Person("김유신");
		Person lee = new Person("이순신");
//		kim.start();
//		lee.start();
		kim.run();
		lee.run();
	}
}
