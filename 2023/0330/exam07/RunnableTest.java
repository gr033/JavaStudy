package exam07;
class Person implements Runnable{
	private String name;
	public Person(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("hello"+name+"!"+i);
			try {
				Thread.sleep(100);
			}catch(Exception e) {}
		}
		
	}
}
public class RunnableTest {
	public static void main(String[] args) {
		Person kim = new Person("김유신");
		Person lee = new Person("이순신");
//		kim.start();
//		lee.start();
//		Thread t1 = new Thread(kim);
//		Thread t2 = new Thread(lee);
//		t1.start();
//		t2.start();
		new Thread(kim).start();
		new Thread(lee).start();
	}
}