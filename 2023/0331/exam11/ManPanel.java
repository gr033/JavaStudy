package exam11;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ManPanel extends JPanel implements Runnable, KeyListener{
	BufferedImage man;
	BufferedImage man01;
	BufferedImage man02;
	BufferedImage man03;
	int x = 400;
	int y = 300;
	int dx = -10;
	int dy = 0;
	int n = 0;
	public ManPanel() {
		try {
			man = ImageIO.read(new File("man.png"));
			man01 = ImageIO.read(new File("man01.png"));
			man02 = ImageIO.read(new File("man02.png"));
			man03 = ImageIO.read(new File("man03.png"));
		} catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
		
		addKeyListener(this);
		this.requestFocus();
		setFocusable(true);
		
		new Thread(this).start();
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		switch(n) {
			case 0:g.drawImage(man, x, y, null); break;
			case 1:g.drawImage(man01, x, y, null); break;
			case 2:g.drawImage(man02, x, y, null); break;
			case 3:g.drawImage(man03, x, y, null); break;
		}
	}
	@Override
	public void run() {
		while(true) {
			if(x<30 || x>410) {
				dx = dx*-1;
			}
			
			if(y<0 || y>300) {
				dy = -1*dy;
			}
			
			x += dx;
			y += dy;
			n++;
			if(n==4) {
				n=0;
			}
			repaint();
			try {
				Thread.sleep(100);
			} catch (Exception e) {}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT: dx = -10;dy = 0; break;
		case KeyEvent.VK_RIGHT: dx = +10;dy = 0; break;
		case KeyEvent.VK_UP: dx = 0;dy = -10; break;
		case KeyEvent.VK_DOWN: dx = 0;dy = +10; break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}