package exam08;

import java.awt.event.KeyEvent;

public class Missile extends GraphicObject {
	boolean launched = false;
	public Missile (String name) {
		super(name);
		y = -200;
	}
//	미사일을 발사해야하는지 판별하기 위한 변수
//	launched가 true 일때만 미사일을 움직이게 하려 함
//	미사일 객체 생성시에 미사일을 표현할 그림 파일명을 전달받아 
//	부모클래스(GraphicObject)의 생성자에게 전달
	@Override
	public void update() {
		if(launched) {
			y-=1;
		}
		//화면에서 미사일의 위치가 벗어났으면 미사일 발사를 중지한다.
		if(y<-100) {
			launched = false;
		}
	}
	//플레이어의 위치(x,y)와 키보드 이벤트를 매개변수로 전달받아
	//눌러진 키가 스페이스바라면 그 위치에서 미사일을 발사 하도록 한다.
	public void keyPressed(KeyEvent event, int x, int y) {
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			launched = true;	//미사일을 발사
			this.x = x;			//미사일의 x좌표를 매개변수로 전달받은 플레이어의 x
			this.y = y;			//미사일의 y좌표를 매개변수로 전달받은 플레이어의 y
		}
	}
}
