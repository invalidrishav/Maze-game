import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements Runnable {
	/**
	 * @author Rishav
	 * @apiNote DO NOT TRY TO CHANGE ANYTHING
	 * @see Thread.sleep(); at LINE no 31.Cchange the value inside this ()
	 * @implNote Lower the number, the faster the moving speed but not 0.
	 * @serial 02
	 */
	private static final long serialVersionUID = 5124263413115891131L;
	
	private Image dbimg;
	private Graphics dbg;
	int x, y, x1, y1;// x1 and y1 are at line 54-59.
	
	// game images from resouces (line 97)
	Image go, mover, gameOver, finish, victory;
	
	//Font font = new Font("arial", Font.BOLD, 30);
	
	boolean mouseOnScreen, mouseDragged;
	
	
	public void run() {
		try {
			for(;;) {
				
				move();
				Thread.sleep(8);
			}
		}catch (Exception e) {
			System.err.print(e);
		}
	}
	
	public void move() {
		x += x1;
		y += y1;
		
		if(x<=0)
			x=0;
		if(x>=860)
			x=860;
		if(y<=30)
			y=30;
		if(y>=320)
			y=320;
	}
	
	public void setXDir(int xdir) {
		x1 = xdir;
	}
	public void setYDir(int ydir) {
		y1 = ydir;
	}
	
public class AL extends KeyAdapter {
		
		public void keyPressed(KeyEvent e){
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_LEFT || key==KeyEvent.VK_A) {
				setXDir(-1);
			}
			if(key == KeyEvent.VK_RIGHT || key==KeyEvent.VK_D) {
				setXDir(+1);
			}
			if(key == KeyEvent.VK_UP || key==KeyEvent.VK_W) {
				setYDir(-1);
			}
			if(key == KeyEvent.VK_DOWN || key==KeyEvent.VK_S) {
				setYDir(+1);
			}
			
			e.consume();
		}
		public void keyReleased(KeyEvent e){
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_LEFT || key==KeyEvent.VK_A) {
				setXDir(0);
			}
			if(key == KeyEvent.VK_RIGHT || key==KeyEvent.VK_D) {
				setXDir(0);
			}
			if(key == KeyEvent.VK_UP || key==KeyEvent.VK_W) {
				setYDir(0);
			}
			if(key == KeyEvent.VK_DOWN || key==KeyEvent.VK_S) {
				setYDir(0);
			}
			
			e.consume();
		}
	}
	
	public Main() {
		// images
		go = imageLoader.getImage("start.gif");
		mover = imageLoader.getImage("mover.gif");
		gameOver = imageLoader.getImage("gameOver.png");
		finish = imageLoader.getImage("finish.gif");
		victory = imageLoader.getImage("VICTORY.jpg");
		
		// properties
		setTitle("test no2");
		setSize(900, 350);
		setResizable(false);
		setVisible(true);
		setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// user listeners
		addKeyListener(new AL());
		
		x= 20; y= 100;
	}
	
	public void paint(Graphics g) {
		dbimg = createImage(getWidth(), getHeight());
		dbg = dbimg.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbimg, 0, 0, this);	
	}
	public void paintComponent(Graphics g) {
		//GAME IMAGES
		g.drawImage(go, 14, 50, this);
		g.drawImage(finish, 840, 230, this);
		
		
		//MOUSE COORDINATON
		g.drawString("your position:", 810, 45);
		if(mouseOnScreen)
			g.setColor(Color.red);
			g.drawString("X= "+x+", Y= "+y, 810, 60);
			
			
		//USER CONTROL MOVABLE BLOCK
		g.drawImage(mover, x, y, this);
		Rectangle mov = new Rectangle(x,y, 25, 25);
		
		
		//STATIC BLOCKS
		Rectangle s1 = new Rectangle(60,30, 135, 135);
		g.setColor(Color.green);
		g.fillRect(s1.x, s1.y, s1.width, s1.height);
		Rectangle s2 = new Rectangle(85,200, 150, 175);
		g.setColor(Color.yellow);
		g.fillRect(s2.x, s2.y, s2.width, s2.height);
		Rectangle s3 = new Rectangle(250,90, 50, 600);
		g.setColor(Color.magenta);
		g.fillRect(s3.x, s3.y, s3.width, s3.height);
		g.setColor(Color.black);
		Rectangle s4 = new Rectangle(200,25, 100, 35);
		g.setColor(Color.pink);
		g.fillRect(s4.x, s4.y, s4.width, s4.height);
		Rectangle s5 = new Rectangle(335,30, 40, 90);
		g.setColor(Color.yellow);
		g.fillRect(s5.x, s5.y, s5.width, s5.height);
		Rectangle s6 = new Rectangle(300,150, 75, 15);
		g.setColor(Color.magenta);
		g.fillRect(s6.x, s6.y, s6.width, s6.height);
		Rectangle s7 = new Rectangle(405,10, 85, 175);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(s7.x, s7.y, s7.width, s7.height);
		Rectangle s8 = new Rectangle(380,15, 55, 105);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(s8.x, s8.y, s8.width, s8.height);
		Rectangle s9 = new Rectangle(335,195, 45, 5);
		g.setColor(Color.red);
		g.fillRect(s9.x, s9.y, s9.width, s9.height);
		Rectangle s10 = new Rectangle(355,215, 95, 95);
		g.setColor(Color.black);
		g.fillRect(s10.x, s10.y, s10.width, s10.height);
		Rectangle s11 = new Rectangle(490,215, 85, 315);
		g.setColor(Color.green);
		g.fillRect(s11.x, s11.y, s11.width, s11.height);
		Rectangle s12 = new Rectangle(490,170, 110, 15);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(s12.x, s12.y, s12.width, s12.height);
		Rectangle s13 = new Rectangle(615,215, 95, 95);
		g.setColor(Color.black);
		g.fillRect(s13.x, s13.y, s13.width, s13.height);
		Rectangle s14= new Rectangle(745,95, 85, 285);
		g.setColor(Color.yellow);
		g.fillRect(s14.x, s14.y, s14.width, s14.height);
		Rectangle s15 = new Rectangle(615,175, 90, 20);
		g.setColor(Color.red);
		g.fillRect(s15.x, s15.y, s15.width, s15.height);
		Rectangle s16 = new Rectangle(525,120, 220, 20);
		g.setColor(Color.yellow);
		g.fillRect(s16.x, s16.y, s16.width, s16.height);
		Rectangle s17 = new Rectangle(525,30, 190, 55);
		g.setColor(Color.black);
		g.fillRect(s17.x, s17.y, s17.width, s17.height);
		Rectangle end = new Rectangle(840, 230, 45, 25);
		

		//COLISION NOTICE
		if( mov.intersects(s1) || mov.intersects(s2) ||
            mov.intersects(s3) || mov.intersects(s4) ||
			mov.intersects(s5) || mov.intersects(s6) ||
			mov.intersects(s7) || mov.intersects(s8) ||
			mov.intersects(s9) || mov.intersects(s10) ||
			mov.intersects(s11) || mov.intersects(s12) ||
			mov.intersects(s13) || mov.intersects(s14) ||
			mov.intersects(s15) || mov.intersects(s16) ||
			mov.intersects(s17)
		  )
		{
				g.drawImage(gameOver, 0, 0, this);
		}
		
		
		//VICTORY!!!!
		if(mov.intersects(end)) {
			g.drawImage(victory, 0, 0, this);
		}
				
		repaint();
	}
	
public static void main(String[] args) {
	Main m = new Main();
	Thread t = new Thread(m);
	t.start();
	}

}
