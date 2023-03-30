package exam08;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
//그래픽을 표현하기 위해 JPanel 클래스를 상속
//키보드 이벤트 처리를 위해 KeyListener interface구현
//화면에 적, 미사일, 우주선을 동시에 그리기 위한 클래스를 만든다.
public class MyPanel extends JPanel implements KeyListener {
	Enermy enermy;
	SpaceShip spaceship;
	Missile missile;
	public MyPanel() {
		//패널에 키보드 이벤트 등록
		//키보드 이벤트가 발생했을 떄 일처리 할 객체가 우주선임
		super();
		this.addKeyListener(this);
		//패널(JPanel)은 원래 글씨를 쓰는 용도가 아니라 
		//화면구성요소들을 담는 컨테이너로 쓰이는 것
		//패널에 키보드 이벤트를 발생시키려면 다음의 두가지 메소드도 같이 사용해야함
		this.requestFocus();
		setFocusable(true);
		enermy = new Enermy("enermy.png");
		spaceship = new SpaceShip("spaceship.png");
		missile = new Missile("missile.png");
		
		class MyThread extends Thread { 
			public void run() {
				while(true) {
					//적, 미사일, 우주선의 위치를 갱신
					enermy.update();
					spaceship.update();
					missile.update();
					//화면에 다시 주기 위해 repaint를 호출
					//repaint 호출하면 paint 동작
					repaint();
					try {
						Thread.sleep(50);
					}catch(InterruptedException e){}
				}//end while
			}//end run
		}//end inner class
		Thread t = new MyThread();
		t.start();
	}//end constructor
	
	//화면에 그래픽을 표현하기 위한 메소드
	public void paint(Graphics g) {
		super.paint(g);
		enermy.draw(g);
		spaceship.draw(g);
		missile.draw(g);
	}
	//키보드가 눌렸을 때 동작
	@Override
	public void keyPressed(KeyEvent event) {
		//우주선에게 눌려진 키를 알려줌
		spaceship.keyPressed(event);
		//미사일에게 눌려진 키와 우주선의 위치를 알려줌
		missile.keyPressed(event, spaceship.x, spaceship.y);
	}
	//키보드가 누르고 뗄 떄
	@Override
	public void keyTyped(KeyEvent arg0) {}
	//키 뗄 때
	@Override
	public void keyReleased(KeyEvent arg0) {}

}