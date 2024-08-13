
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePaly extends JPanel implements KeyListener,ActionListener

{
    private Timer timer;
	private int palyerX=310;
	private boolean play=true;
	private int ballposX=120;
	private int ballposY=350;
	private int ballXdir=-1;
	private int ballYdir=-2;
	private int score=0;
	private int totalbricks=21;
	private int delay=-150;

	private MapGenerator map;
	public GamePaly()
	{
		map=new MapGenerator(3,7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer=new Timer(delay,this);
		//timer.schedule(null, null);
			timer.start(); 	
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.YELLOW);
		g.fillRect(1, 1, 692, 592);
		map.draw((Graphics2D)g);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692,3);
		g.fillRect(691, 0, 3, 592);
		g.setColor(Color.BLUE);


		g.fillRect(palyerX, 550, 100, 12);
		
		g.setColor(Color.RED);  
		g.fillOval(ballposX, ballposY, 20, 20);
		
		g.setColor(Color.black);
		g.setFont(new Font("MV Boli", Font.BOLD, 25));
		g.drawString("Score: " + score, 520, 30);
		
		
		if (totalbricks <= 0) { 
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(new Color(0XFF6464));
			g.setFont(new Font("MV Boli", Font.BOLD, 30));
			g.drawString("You Won, Score: " + score, 190, 300);
			
			g.setFont(new Font("MV Boli", Font.BOLD, 20));
			g.drawString("Press Enter to Restart.", 230, 350);
		}
		
		if(ballposY > 570) { 
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.BLACK);
			g.setFont(new Font("MV Boli", Font.BOLD, 30));
			g.drawString("Game Over, Score: " + score, 190, 300);
			
			g.setFont(new Font("MV Boli", Font.BOLD, 20));
			g.drawString("Press Enter to Restart", 230, 350);
				
		} 
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		if(play) 
		{
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(palyerX, 550, 100, 8))) {
				ballYdir = - ballYdir;
			}
			for( int i = 0; i<map.map.length; i++) {
				for(int j = 0; j<map.map[0].length; j++) {  
					if(map.map[i][j] > 0) {
						int brickX = j*map.brickwidth + 80;
						int brickY = i*map.brickheight + 50;
						int brickWidth= map.brickwidth;
						int brickHeight = map.brickheight;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle(ballposX, ballposY, 20,20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect) ) {
							map.setBrickvalue(0, i, j);
							totalbricks--;
							score+=5;
							
							if(ballposX + 19 <= brickRect.x || ballposX +1 >= brickRect.x + brickRect.width) 
								ballXdir = -ballXdir;
							 else {
								ballYdir = -ballYdir;
							}
						}
						
					}
					
				}
			}
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			if(ballposX < 0) { 
				ballXdir = -ballXdir;
			}
			if(ballposY < 0) {
				ballYdir = -ballYdir;
			}
			if(ballposX > 670) {
				ballXdir = -ballXdir;  
			
			}
			
		}
		repaint();
	
	}
	
	public void keyPressed(KeyEvent e) 
	{
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
        	
			if(palyerX>=600)
        	{
        		palyerX=600;
        		
        	}
        	else
        	{
        		moveRight();
        	}
        }
        
			 if(e.getKeyCode()==KeyEvent.VK_LEFT)
		        {
		        	
					if(palyerX<10)
		        	{
		        		palyerX=10;
		        		
		        	}
		        	else
		        	{
		        		moveleft();
		        	}
		        }
			 if(e.getKeyCode()==KeyEvent.VK_ENTER)
			 {
				 
		       if(!play)
		       {
		    	   play=true;
		    	   ballposX=120;
		    	   ballposY=350;
		    	   ballXdir=-1;
		    	   ballYdir=-2;
		    	   score=0;
		    	   totalbricks=21;
		    	   map=new MapGenerator(3,7);

		       }
	}
	}

	
			
	private void moveleft() 
	{
		  play=true;
	      palyerX+=-50;
	}

	private void moveRight()
	{
      play=true;
      palyerX+=+50;
	}



	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
}
	}