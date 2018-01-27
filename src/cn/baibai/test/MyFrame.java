package cn.baibai.test;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import cn.baibai.test.GameFrame203taiqiu.PaintThread;

public class MyFrame extends Frame{
	

	
	/**
	 * 加载窗口
	 */
	
	public void launchFrame() {
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
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
