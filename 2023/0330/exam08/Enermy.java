package exam08;

import java.awt.event.KeyEvent;
//적은 화면의 상단에서 가로로 왔다갔다 하려고 한다.
public class Enermy extends GraphicObject {
	//적의 이동거리를 왼쪽으로 10만큼 이동하도록 초기값 설정
	int dx = -10;
	public Enermy(String name) {
		super(name);
		//처음 보이는 적의 위치를 오른쪽 끝(500,0)으로 설정
		x = 500;
		y = 0;
	}
	@Override
	public void update() {
		//적의 위치를 가로로 이동시키기 위하여 
		//x의 위치를 dx만큼 이동시킴
		//dx가 음수면 왼쪽으로 이동, 양수면 오른쪽으로 이동
		x += dx;
		//적의 위치가 왼쪽 끝에 도달하면 오른쪽으로 이동
		if(x<0) {
			dx = +10;
		}
		//적의 위치가 오른쪽 끝에 도달하면 왼쪽으로 이동
		if(x>500) {
			dx = -10;
		}
	}
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_LEFT) {
			x -=10;
		}
	}
}
