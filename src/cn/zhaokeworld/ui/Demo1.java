package cn.zhaokeworld.ui;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JRadioButtonMenuItem;

public class Demo1 extends JFrame {
	public Demo1() {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("文件");
		menuBar.add(menu);
		
		JMenuItem menuItem_2 = new JMenuItem("打开");
		menuItem_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("打开文件选择器");
				JFileChooser file = new JFileChooser("/user/zhaoke/");
				file.setDialogTitle("打开");
				file.showOpenDialog(getContentPane());
				File f = file.getSelectedFile();
				System.out.println(f);
			}
		});
		menu.add(menuItem_2);
		
		JRadioButtonMenuItem rdbtnmntmJlkjkj = new JRadioButtonMenuItem("jlkjkj");
		menu.add(rdbtnmntmJlkjkj);
		
		JMenuItem menuItem = new JMenuItem("保存");
		menu.add(menuItem);
		getContentPane().setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(0, 0, 300, 300);
		getContentPane().add(editorPane);
		
	}

	public static void main(String[] args) {
		JFrame j = new Demo1();
		j.setBounds(30, 30, 300, 300);
		j.setVisible(true);
		
	}
}
