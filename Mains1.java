

import javax.swing.JFrame;

class Mains1
 {
 public static void main(String[] args)
 {
	 JFrame obj=new JFrame();
	 GamePaly gameplay=new GamePaly();
	 
	 obj.setBounds(10, 10, 700, 600);
	 obj.setTitle("brick bracker game");
	 obj.setVisible(true);
	 obj.setResizable(false);
	 obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 obj.add(gameplay);
 }
 }