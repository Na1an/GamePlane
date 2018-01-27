package cn.baibai.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 游戏窗口、游戏基本知识测试类
 * @author yuchen
 *
 */

public class GameFrame extends Frame {  //GUI编程；AWT,swing等。 不常用，JAVA不擅长窗口软件
	
	Image img = GameUtil.getImage("images/sun.jpg");
	
	
	
	/**
	 * 加载窗口
	 */
	public void launchFrame() {
		setSize(500,500);
		setLocation(100,100);
		setVisible(true);
		
		new PaintThread().start();  //启动重画线程
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private double x=100,y=100;
	
	@Override
	public void paint(Graphics g) {
		g.drawLine(100, 100, 200, 200);
		g.drawRect(100, 100, 200, 200);
		g.drawOval(100, 100, 200, 200);
		
		Font f = new Font("",Font.BOLD,100);
		g.setFont(f);
		g.drawString("i love you", 200, 200);
		
		//g.fillRect(100, 100, 20, 20);
		
		Color c = g.getColor();
		g.setColor(Color.red); //钩子函数，多态，用的别人的笔，记得重新设置回什么颜色
		g.fillOval(300,300,20,20);
		g.setColor(c);
		
		g.drawImage(img,(int)x,(int)y,null);
		
		x += 3;
		y += 3;
	
	}
	
	/**
	 * 定义一个重画窗口的线程类，是一个内部类
	 * @author yuchen
	 *
	 */
	
	class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   // 1s = 1000ms;
			}
		}
	}



	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.launchFrame();
	}

}
