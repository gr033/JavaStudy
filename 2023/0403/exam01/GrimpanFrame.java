package exam01;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class GrimpanFrame extends JFrame implements ActionListener{
	GrimpanPanel pan;
	JColorChooser jcc;
	JFileChooser jfc;
	String fname = "c:/temp/my.pan";
	File file;

	public GrimpanFrame () {
		setTitle("그림판");
		pan = new GrimpanPanel();
		add(pan);
		//메뉴바 만들기
		jcc = new JColorChooser(Color.black);
		jfc = new JFileChooser("c:/temp");
		JMenuBar jmb = new JMenuBar();
		//주메뉴 만들기
		JMenu mn_save = new JMenu("파일");
		
		JMenuItem save_new = new JMenuItem("새파일");
		JMenuItem save_open = new JMenuItem("열기");
		JMenuItem save_save = new JMenuItem("저장");
		JMenuItem save_exit = new JMenuItem("종료");
		
		save_new.addActionListener(this);
		save_open.addActionListener(this);
		save_save.addActionListener(this);
		save_exit.addActionListener(this);
		
		mn_save.add(save_new);
		mn_save.add(save_open);
		mn_save.add(save_save);
		mn_save.add(save_exit);
		
		jmb.add(mn_save);
		
		JMenu mn_draw = new JMenu("그리기 도구");
		//부메뉴 만들기
		JMenuItem draw_Line = new JMenuItem("선");
		JMenuItem draw_Rect = new JMenuItem("사각형");
		JMenuItem draw_Oval = new JMenuItem("원");
		//메뉴에 이벤트를 등록
		draw_Line.addActionListener(this);
		draw_Rect.addActionListener(this);
		draw_Oval.addActionListener(this);
		//부메뉴들을 주메뉴에 담기
		mn_draw.add(draw_Line);
		mn_draw.add(draw_Rect);
		mn_draw.add(draw_Oval);
		//주메뉴를 메뉴바에 담기
		jmb.add(mn_draw);
		//색상에 대한 메뉴 만들기
		JMenu mn_Color = new JMenu("색상");
		JMenuItem Color_Black = new JMenuItem("검정색");
		JMenuItem Color_Blue = new JMenuItem("파란색");
		JMenuItem Color_Red = new JMenuItem("빨강색");
		JMenuItem Color_Green = new JMenuItem("초록색");
		JMenuItem Color_Cyan = new JMenuItem("하늘색");
		JMenuItem Color_Grey = new JMenuItem("회색");
		JMenuItem Color_MAGENTA = new JMenuItem("보라색");
		JMenuItem Color_Pink = new JMenuItem("분홍색");
		JMenuItem Color_White = new JMenuItem("흰색");
		JMenuItem Color_Yellow = new JMenuItem("노란색");
		JMenuItem Color_Other = new JMenuItem("다른 색상...");
		
		//메뉴바를 프레임에 붙이기
		mn_Color.add(Color_Black);
		mn_Color.add(Color_Blue);
		mn_Color.add(Color_Red);
		mn_Color.add(Color_Green);
		mn_Color.add(Color_Cyan);
		mn_Color.add(Color_Grey);
		mn_Color.add(Color_MAGENTA);
		mn_Color.add(Color_Pink);
		mn_Color.add(Color_White);
		mn_Color.add(Color_Yellow);
		mn_Color.add(Color_Other);
		jmb.add(mn_Color);
		
		Color_Red.addActionListener(this);
		Color_Black.addActionListener(this);
		Color_Blue.addActionListener(this);
		Color_Green.addActionListener(this);
		Color_Cyan.addActionListener(this);
		Color_Grey.addActionListener(this);
		Color_MAGENTA.addActionListener(this);
		Color_Pink.addActionListener(this);
		Color_White.addActionListener(this);
		Color_Yellow.addActionListener(this);
		Color_Other.addActionListener(this);
		
		setJMenuBar(jmb);
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void openFile() {
		try {
			int re = jfc.showOpenDialog(this);
			if(re == 0) {
				file = jfc.getSelectedFile();
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				pan.list = (ArrayList<GraphicInfo>)ois.readObject();
				pan.repaint();
			}
		} catch (Exception e2) {
			System.out.println("예외발생: "+e2.getMessage());
		}
	}
	
	public void saveFile() {
		try {
			int re = 9;
			if(file==null) {
				re = jfc.showSaveDialog(this);
			}
			if(re != 1) {
				if(re==0) {
					file = jfc.getSelectedFile();
				}
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(pan.list);
				oos.close();
				JOptionPane.showMessageDialog(this, "파일을 저장했습니다.");
				pan.isNew = false;
			}
			
		} catch (Exception e2) {
		System.out.println("예외발생: "+e2.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new GrimpanFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		System.out.println(cmd);
		switch(cmd) {
		case "선": pan.drawType=0;break;
		case "사각형": pan.drawType=1;break;
		case "원": pan.drawType=2;break;
		}
		switch(cmd) {
		case "검정색": pan.drawColor = Color.black; break;
		case "파란색": pan.drawColor = Color.blue; break;
		case "빨강색": pan.drawColor = Color.red; break;
		case "초록색": pan.drawColor = Color.green; break;
		case "하늘색": pan.drawColor = Color.cyan; break;
		case "회색": pan.drawColor = Color.gray; break;
		case "보라색": pan.drawColor = Color.magenta; break;
		case "분홍색": pan.drawColor = Color.pink; break;
		case "흰색": pan.drawColor = Color.white; break;
		case "노란색": pan.drawColor = Color.yellow; break;
		case "다른 색상...": pan.drawColor = jcc.showDialog(this, "색상선택", Color.black); break;
		}
		switch(cmd) {
		case "새파일": 
			if(pan.isNew == true){
				int re = JOptionPane.showConfirmDialog(this, "저장하시겠습니까?");
				//0.예, 1.아니오, 2.취소
				if(re==2) {return;}
				if(re==0) {
					saveFile();
				}
			}
			pan.list.clear();
			pan.repaint();
			break;
		case "열기": 
			if(pan.isNew == true) {
				int re = JOptionPane.showConfirmDialog(this, "변경된 내용을 저장하시겠습니까?");
				if(re==2) {
					return;
				}
				if(re==0) {
					saveFile();
				}
			}
			openFile();	break;
		case "저장": saveFile(); break;
		case "종료": System.exit(0); break;
		}
	}
}