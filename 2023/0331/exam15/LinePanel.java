package exam15;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class LinePanel extends JPanel implements MouseListener{
	int x1 = 100;
	int y1 = 100;
	int x2 = 400;
	int y2 = 100;
	ArrayList<GraphicInfo> list;
	
	public LinePanel() {
		list = new ArrayList<GraphicInfo>();
		addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(GraphicInfo info : list) {
			g.drawOval(info.getX1(), info.getY1(), 100, 100);
		}
//		g.drawLine(x1, y1, x2, y2);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 클릭");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
		repaint();
		System.out.println("마우스 눌림");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		list.add(new GraphicInfo(x1, y1, x2, y2));
		repaint();
		System.out.println("마우스 뗌");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("마우스 들어옴");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("마우스 나감");
	}
}
