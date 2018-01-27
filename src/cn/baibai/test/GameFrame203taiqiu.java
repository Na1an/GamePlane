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

public class GameFrame203taiqiu extends Frame {  //GUI编程；AWT,swing等。 不常用，JAVA不擅长窗口软件
	
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
	private double degree = 3.14/5;  //[0,2pi] 180 = pi;
	private double speed=12;
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img,(int)x,(int)y,null);
		
		if(speed>0) {
			speed -=0.15; 
		}else {
			speed = 0;
		}
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if(y>500-30 || y<30) {
			degree = -degree;
		}
		
		if(x<0 || x>500-50) {
			degree = Math.PI - degree;
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
					Thread.sleep(150);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   // 1s = 1000ms;
			}
		}
	}



	public static void main(String[] args) {
		GameFrame203taiqiu gf = new GameFrame203taiqiu();
		gf.launchFrame();
	}

}
