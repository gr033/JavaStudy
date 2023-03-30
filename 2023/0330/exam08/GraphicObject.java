package exam08;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GraphicObject {
	BufferedImage img = null;			//출력한 이미지 변수
	int x=0, y=0;						//이미지 출력 좌표
	
	public GraphicObject(String name) {
		try {
			img = ImageIO.read(new File(name));	//이미지 객체 생성
		}catch(IOException e) {
			System.out.println("예외발생"+e.getMessage());
			System.exit(0);
		}
	}
	public void update() {}				//그래픽 객체(적, 미사일, 플레이어)의 위치를 변경시키는 메소드
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);	//그래픽 객체(적, 미사일, 플레이어)를 화면에 그리는 메소드
	}
	public void keyPressed(KeyEvent event) {}	
	//미사일은 스페이스바를 누르면 발사, 플레이어는 방향키가 눌러진 방향으로 이동시키도록 하기 위해 
	//키보드 이벤트 처리를 위한 메소드
}