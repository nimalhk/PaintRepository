package model;

import java.awt.Graphics;

import gui.ColorPanel;

public class Circle extends Shape {
	
	public Circle(){
		
	}
	public Circle(Point startPoint,Point endPoint,int color){
		super(startPoint,endPoint,color);
	}

	public void draw(Graphics g){
		g.setColor(this.getColor());
		g.fillOval(Math.min(startPoint.getX(),endPoint.getX()), Math.min(startPoint.getY(), endPoint.getY()), Math.abs(startPoint.getX()-endPoint.getX()), Math.abs(startPoint.getY()-endPoint.getY()));
	}

}
