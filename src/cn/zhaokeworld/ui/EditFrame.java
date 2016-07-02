package cn.zhaokeworld.ui;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.GridLayout;

public class EditFrame extends JFrame{

	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem_2, menuItem;
	private JPanel panel;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private File f ;
	
	public EditFrame(){
		init();
	}
	
	public void init(){
		setSize(700, 600);
		setLocation(100,100);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menu = new JMenu("文件");
		menuBar.add(menu);
		
		menuItem_2 = new JMenuItem("打开");
		menuItem_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfc = new JFileChooser("/user/zhaoke/");
				jfc.setDialogTitle("打开");
				int r = jfc.showOpenDialog(null);
				if(r == JFileChooser.APPROVE_OPTION){
					f = jfc.getSelectedFile();
					try(
							FileReader fr = new FileReader(f);
							) {
						char[] buf = new char[1024];
						int len = 0;
						StringBuilder sb = new StringBuilder();
						while((len=fr.read(buf))!=-1){
							sb.append(new String(buf, 0, len));
						}
						textArea.setText(sb.toString());
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			}
		});
		menu.add(menuItem_2);
		
		menuItem = new JMenuItem("保存");
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfc = new JFileChooser("/user/zhaoke/");
				jfc.setDialogTitle("保存");
				int r = jfc.showSaveDialog(null);
				if(r==JFileChooser.APPROVE_OPTION){
					f = jfc.getSelectedFile();
					if(!f.exists()){
						try {
							f.createNewFile();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					try(
							FileWriter fw = new FileWriter(f);
							) {
						fw.write(textArea.getText());
						fw.flush();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		menu.add(menuItem);
		
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(new GridLayout(1, 1));
		
		textArea = new JTextArea();
//		textArea.setSize(500, 500);
//		panel.add(textArea);
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrollPane);
	}
	
	public static void main(String[] args) {
		new EditFrame().setVisible(true);
	}
}
