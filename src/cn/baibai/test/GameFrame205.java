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

public class GameFrame205 extends MyFrame {  //GUI编程；AWT,swing等。 不常用，JAVA不擅长窗口软件
	
	Image img = GameUtil.getImage("images/sun_001.jpg");

	private double x=100,y=100;
	private double degree = 3.14/5;  //[0,2pi] 180 = pi;
	private double speed=15;
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
}
	