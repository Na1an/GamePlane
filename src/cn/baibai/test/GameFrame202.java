package cn.baibai.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 窗口物体沿着水平和纵向轨迹移动
 * @author yuchen
 *
 */

public class GameFrame202 extends Frame {  //GUI编程；AWT,swing等。 不常用，JAVA不擅长窗口软件
	
	Image img = GameUtil.getImage("images/sun_001.jpg");
	
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
	private boolean left;
	private boolean up;
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img,(int)x,(int)y,null);
		/*
		if(left) {
			x -= 13;
		}else {
			x += 13;
		}
		
		if(x>500-30) {
			left = true;
		}
		
		if(x<0) {
			left = false;
		}
		*/
		if(up) {
			y -= 13;
		}else {
			y += 13;
		}
		
		if(y>500-30) {
			up = true;
		}
		
		if(y<30) {
			up = false;
		}
		
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
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   // 1s = 1000ms;
			}
		}
	}



	public static void main(String[] args) {
		GameFrame202 gf = new GameFrame202();
		gf.launchFrame();
	}

}
