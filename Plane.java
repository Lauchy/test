package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Plane {
	int x_location;
	int y_location;
	public static final int WIDTH = 20;
	public static final int HEIGHT = 20;
	private static final int x_weiyi=15;
	private static final int y_weiyi=15;
	boolean U = false,D = false,L = false,R = false;
	boolean live = true;
	MainConsole mc;
	Rectangle rp = new Rectangle(x_location,y_location,WIDTH,HEIGHT);

	public Plane(int x,int y,MainConsole mc) {
		this.x_location = x;
		this.y_location = y;
		this.mc = mc;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);	
		g.fillRect(x_location, y_location, WIDTH,HEIGHT );
		this.move();
		shot();
	}
	
	public void move() {
		if(U && !D && !L && !R) {
			y_location = y_location - y_weiyi;
		}
		else if(!U && D && !L && !R) {
			y_location = y_location + y_weiyi;
		}
		else if(!U && !D && L && !R) {
			x_location = x_location - x_weiyi;
		}
		else if(!U && !D && !L && R) {
			x_location = x_location + x_weiyi;
		}
		
		if(x_location < 0) {
			x_location = 0;
		}
		if(y_location < 0) {
			y_location = 20;
		}
		if(x_location + Plane.WIDTH > 300) {
			x_location = 300 - Plane.WIDTH;
		}
		if(y_location + Plane.HEIGHT > 500) {
			y_location = 500 - Plane.HEIGHT;
		}
		
	}
	
	public Bullet shot() {
		if(!live) {
			return null;
		}
		Bullet m = new Bullet(x_location ,y_location,mc);
		mc.pd.add(m);
		return m;
	}
	
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		if(k == KeyEvent.VK_UP) {
			U = true;
		}
		else if(k == KeyEvent.VK_DOWN) {
			D = true;
		}
		else if(k == KeyEvent.VK_LEFT) {
			L = true;
		}
		else if(k == KeyEvent.VK_RIGHT) {
			R = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();
		if(k == KeyEvent.VK_UP) {
			U = false;
		}
		else if(k == KeyEvent.VK_DOWN) {
			D = false;
		}
		else if(k == KeyEvent.VK_LEFT) {
			L = false;
		}
		else if(k == KeyEvent.VK_RIGHT) {
			R = false;
		}

	}
	
	public boolean lives() {
		return live;
	}
	
	public Rectangle getRectange() {
		return  rp;
	}
	
	public boolean zhuangJi(EnemyPlane a) {
		if( this.rp.intersects(a.rd) && this.lives() == false && a.lives() == false) {
			this.live = false;
			return true;
		}	
		return false;
	}
	
}