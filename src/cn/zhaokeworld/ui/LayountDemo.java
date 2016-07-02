package cn.zhaokeworld.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

public class LayountDemo extends JFrame{

	public static void main(String[] args) {
		Dimension d = new Dimension();
		d.setSize(500, 500);
		Point point = new Point();
		point.setLocation(70, 70);
		JFrame frame = new JFrame("测试窗口和布局");
		
		frame.setSize(d);
		frame.setBackground(Color.PINK);
		frame.setLocation(point);
		Button button = new Button("HAHA");
		frame.add(button);
		frame.pack();
		
		
		frame.setVisible(true);
	}
	
}
