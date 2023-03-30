package exam05;

class Person{
	private String name;
	public Person(String name) {
		this.name = name;
	}
	public void sayHello(){
		for(int i=1;i<=10;i++) {
			System.out.println("hello, "+name+"!"+i);
		}
	}
}
public class Test {

	public static void main(String[] args) {	
		Person kim = new Person("김유신");
		Person lee = new Person("이순신");
		kim.sayHello();
		lee.sayHello();
		
	}
}
