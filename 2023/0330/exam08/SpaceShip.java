package exam08;

import java.awt.event.KeyEvent;

public class SpaceShip extends GraphicObject {
	public SpaceShip(String name) {
		super(name);
		//처음 우주선의 위치를 (150,350)으로 설정
		x = 150;
		y = 350;
	}
	//눌려진 방향키에 따라 우주선을 그 방향으로 이동
	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_LEFT) {x -=10;}
		if(event.getKeyCode() == KeyEvent.VK_RIGHT) {x +=10;}
		if(event.getKeyCode() == KeyEvent.VK_UP) {y -=10;}
		if(event.getKeyCode() == KeyEvent.VK_DOWN) {y +=10;}
	}
}
