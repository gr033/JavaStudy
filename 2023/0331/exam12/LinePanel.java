package exam12;

import java.awt.Graphics;

import javax.swing.JPanel;

public class LinePanel extends JPanel {
	int x1 = 100;
	int y1 = 100;
	int x2 = 400;
	int y2 = 100;
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(x1, y1, x2, y2);
		
	}
}
