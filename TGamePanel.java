import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TGamePanel extends JPanel implements ActionListener
{

	private static final long serialVersionUID = 1L;
	static final int WIDTH = 900;
	static final int HEIGHT = 900;
	int x=0;
	int fill=0;
	public String winner="draw";
	public String Turn="O";
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
//	JLabel l;
    TGamePanel() 
	{
		this.setBackground(Color.DARK_GRAY);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		b1=new JButton("1");
		b2=new JButton("2");
		b3=new JButton("3");
		b4=new JButton("4");
		b5=new JButton("5");
		b6=new JButton("6");
		b7=new JButton("7");
		b8=new JButton("8");
		b9=new JButton("9");
		b10=new JButton("play again");
		b11=new JButton("cancel");
		this.setVisible(true);
		this.setLayout(new GridLayout(4,3));
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		this.add(b6);
		this.add(b7);
		this.add(b8);
		this.add(b9);
		b1.setFont(new Font("+", Font.PLAIN, 200));
	    b2.setFont(new Font("-", Font.PLAIN, 200));
	    b3.setFont(new Font("*", Font.PLAIN, 200));
	    b4.setFont(new Font("%", Font.PLAIN, 200));
	    b5.setFont(new Font("/", Font.PLAIN, 200));
	    b6.setFont(new Font("=", Font.PLAIN, 200));
	    b7.setFont(new Font("=", Font.PLAIN, 200));
	    b8.setFont(new Font("=", Font.PLAIN, 200));
	    b9.setFont(new Font("=", Font.PLAIN, 200));
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		draw(graphics);
	}
	

	
	public void check() 
	{
		for (int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = b1.getText() + b2.getText() + b3.getText();
				break;
			case 1:
				line = b4.getText() + b5.getText() + b6.getText();
				break;
			case 2:
				line = b7.getText() + b8.getText() + b9.getText();
				break;
			case 3:
				line = b1.getText() + b4.getText() + b7.getText();
				break;
			case 4:
				line = b2.getText() + b5.getText() + b8.getText();
				break;
			case 5:
				line = b3.getText() + b6.getText() + b9.getText();
				break;
			case 6:
				line = b1.getText() + b5.getText() + b9.getText();
				break;
			case 7:
				line = b3.getText() + b5.getText() + b7.getText();
				break;
			}
			
			if (line.equals("XXX")) 
			{
				winner="X";
				switch (a) {
				case 0:
					 b1.setBackground(Color.GREEN); b2.setBackground(Color.GREEN);  b3.setBackground(Color.GREEN);;
					break;
				case 1:
					b4.setBackground(Color.GREEN); b5.setBackground(Color.GREEN); b6.setBackground(Color.GREEN);
					break;
				case 2:
					b7.setBackground(Color.GREEN); b8.setBackground(Color.GREEN); b9.setBackground(Color.GREEN);
					break;
				case 3:
					b1.setBackground(Color.GREEN); b4.setBackground(Color.GREEN); b7.setBackground(Color.GREEN);
					break;
				case 4:
					b2.setBackground(Color.GREEN); b5.setBackground(Color.GREEN); b8.setBackground(Color.GREEN);
					break;
				case 5:
					b3.setBackground(Color.GREEN); b6.setBackground(Color.GREEN);  b9.setBackground(Color.GREEN);
					break;
				case 6:
					b1.setBackground(Color.GREEN); b5.setBackground(Color.GREEN);  b9.setBackground(Color.GREEN);
					break;
				case 7:
					b3.setBackground(Color.GREEN); b5.setBackground(Color.GREEN); b7.setBackground(Color.GREEN);
					break;
				}
				repaint();
			}
			else if (line.equals("OOO")) 
			{
				winner="O";
				switch (a) {
				case 0:
					 b1.setBackground(Color.GREEN); b2.setBackground(Color.GREEN);  b3.setBackground(Color.GREEN);;
					break;
				case 1:
					b4.setBackground(Color.GREEN); b5.setBackground(Color.GREEN); b6.setBackground(Color.GREEN);
					break;
				case 2:
					b7.setBackground(Color.GREEN); b8.setBackground(Color.GREEN); b9.setBackground(Color.GREEN);
					break;
				case 3:
					b1.setBackground(Color.GREEN); b4.setBackground(Color.GREEN); b7.setBackground(Color.GREEN);
					break;
				case 4:
					b2.setBackground(Color.GREEN); b5.setBackground(Color.GREEN); b8.setBackground(Color.GREEN);
					break;
				case 5:
					b3.setBackground(Color.GREEN); b6.setBackground(Color.GREEN);  b9.setBackground(Color.GREEN);
					break;
				case 6:
					b1.setBackground(Color.GREEN); b5.setBackground(Color.GREEN);  b9.setBackground(Color.GREEN);
					break;
				case 7:
					b3.setBackground(Color.GREEN); b5.setBackground(Color.GREEN); b7.setBackground(Color.GREEN);
					break;
				}
				repaint();
			}
		}
		if(fill==9 && winner.equals("draw"))
		{
			repaint();
		}
	}
	
	public void draw(Graphics graphics) {
		
		if (winner.equals("X")||winner.equals("O")) 
		{
			gameOver(graphics);		
		} 
		else if(fill==9 && winner.equals("draw"))
		{
			gameOver(graphics);
		}
		else 
		{
			graphics.setColor(Color.RED);
			graphics.setFont(new Font("Sans serif", Font.ROMAN_BASELINE, 25));
			FontMetrics metrics = getFontMetrics(graphics.getFont());
			graphics.drawString("Turn: " + Turn,400,700);
		}
	}

	public void gameOver(Graphics graphics) 
	{
		if(fill==9 && winner.equals("draw"))
		{
			graphics.setColor(Color.red);
			graphics.setFont(new Font("Sans serif", Font.ROMAN_BASELINE, 50));
			FontMetrics metrics = getFontMetrics(graphics.getFont());
			graphics.drawString("Game Over",300,700);
			
			graphics.setColor(Color.white);
			graphics.setFont(new Font("Sans serif", Font.ROMAN_BASELINE, 25));
			metrics = getFontMetrics(graphics.getFont());
			graphics.drawString("" + winner,400,750);
			b1.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
			b4.setEnabled(false);
			b5.setEnabled(false);
			b6.setEnabled(false);
			b7.setEnabled(false);
			b8.setEnabled(false);
			b9.setEnabled(false);
		}
		else
		{
			graphics.setColor(Color.red);
			graphics.setFont(new Font("Sans serif", Font.ROMAN_BASELINE, 50));
			FontMetrics metrics = getFontMetrics(graphics.getFont());
			graphics.drawString("Game Over", 300,700);
			
			graphics.setColor(Color.white);
			graphics.setFont(new Font("Sans serif", Font.ROMAN_BASELINE, 25));
			metrics = getFontMetrics(graphics.getFont());
			graphics.drawString("Winner: " + winner,400,750);
			b1.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
			b4.setEnabled(false);
			b5.setEnabled(false);
			b6.setEnabled(false);
			b7.setEnabled(false);
			b8.setEnabled(false);
			b9.setEnabled(false);
		}

	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object obj=e.getSource();
		if(obj==b1)
		{
			if(x==0&&(b1.getText()).equals("1"))
			{
				b1.setText("O");
				check();
				x=1; Turn="X";
				fill++;
			}
			else if(x==1&&(b1.getText()).equals("1"))
			{
				b1.setText("X");
				check();
				x=0;
				Turn="O";
				fill++;
			}
		}
		if(obj==b2)
		{
			if(x==0&&(b2.getText()).equals("2"))
			{
				b2.setText("O");
				check();
				x=1;
				Turn="X";
				fill++;
			}
			else if(x==1&&(b2.getText()).equals("2"))
			{
				b2.setText("X");
				check();
				x=0;
				Turn="O";
				fill++;
			}
		}
		if(obj==b3)
		{
			if(x==0&&(b3.getText()).equals("3"))
			{
				b3.setText("O");
				check();
				x=1;
				Turn="X";
				fill++;
			}
			else if(x==1&&(b3.getText()).equals("3"))
			{
				b3.setText("X");
				check();
				x=0;
				Turn="O";
				fill++;
			}
		}
		if(obj==b4)
		{
			if(x==0&&(b4.getText()).equals("4"))
			{
				b4.setText("O");
				check();
				x=1;
				Turn="X";
				fill++;
			}
			else if(x==1&&(b4.getText()).equals("4"))
			{
				b4.setText("X");
				check();
				x=0;
				Turn="O";
				fill++;
			}
		}
		if(obj==b5)
		{
			if(x==0&&(b5.getText()).equals("5"))
			{
				b5.setText("O");
				check();
				x=1;
				Turn="X";
				fill++;
			}
			else if(x==1&&(b5.getText()).equals("5"))
			{
				b5.setText("X");
				check();
				x=0;
				Turn="O";
				fill++;
			}
		}
		if(obj==b6)
		{
			if(x==0&&(b6.getText()).equals("6"))
			{
				b6.setText("O");
				check();
				x=1;
				Turn="X";
				fill++;
			}
			else if(x==1&&(b6.getText()).equals("6"))
			{
				b6.setText("X");
				check();
				x=0;
				Turn="O";
				fill++;
			}
		}
		if(obj==b7)
		{
			if(x==0&&(b7.getText()).equals("7"))
			{
				b7.setText("O");
				check();
				x=1;
				Turn="X";
				fill++;
			}
			else if(x==1&&(b7.getText()).equals("7"))
			{
				b7.setText("X");
				check();
				x=0;
				Turn="O";
				fill++;
			}
		}
		if(obj==b8)
		{
			if(x==0&&(b8.getText()).equals("8"))
			{
				b8.setText("O");
				check();
				x=1;
				Turn="X";
				fill++;
			}
			else if(x==1&&(b8.getText()).equals("8"))
			{
				b8.setText("X");
				check();
				x=0;
				Turn="O";
				fill++;
			}
		}
		if(obj==b9)
		{
			if(x==0&&(b9.getText()).equals("9"))
			{
				b9.setText("O");
				check();
				x=1;
				Turn="X";
				fill++;
			}
			else if(x==1&&(b9.getText()).equals("9"))
			{
				b9.setText("X");
				check();
				x=0;
				Turn="O";
				fill++;
			}
		}
		repaint();
	}
		
}