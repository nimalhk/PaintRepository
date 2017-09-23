package model;

import java.awt.Graphics;

import gui.ColorPanel;

public class Line extends Shape {
	
	public Line(){
		
	}
	
	public Line(Point startPoint,Point endPoint,int color){
		super(startPoint,endPoint,color);
	}
	
	public void draw(Graphics g){
		g.setColor(this.getColor());
		g.drawLine(startPoint.getX(), startPoint.getY(),endPoint.getX(),endPoint.getY());
	}
}
