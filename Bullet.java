package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

//Bullet文件新加了一个功能，可以穿越物体

public class Bullet {
	int x_location=150,y_location=420;
	private int width = 10;
	private int height = 10;
	private static final int X_PD = 25;
	private static final int Y_PD = 25;
	boolean U = false,D = false,L = false,R = false;
	boolean live = true;
	public MainConsole mc;
	Rectangle rpd = new Rectangle(x_location,y_location,width,height);
	
	public Bullet(int x,int y,MainConsole mc) {
		this.x_location = x;
		this.y_location = y;
		this.mc = mc;
	}
	
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x_location, y_location, width, height);
		move();
	}
	
	public void move() {
		y_location = y_location - Y_PD;

		if(y_location<0 || y_location>500) {
			live = false;
			mc.pd.remove(this);
		}
	}
	
	public boolean lives() {
		return live;
	}
	
	public Rectangle getRectange() {
		return  rpd;
	}
	
	public boolean zhuangJi(EnemyPlane a) {
		if(this.rpd.intersects(a.rd) && this.lives() == false && a.lives() == false) {
			live = false;
			return true;
		}	
		return false;
	}
	
	
}