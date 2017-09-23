package model;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	
	protected Point startPoint;
	protected Point endPoint;
	protected Color color;
	
	public Shape(){
		startPoint=new Point(0,0);
		endPoint=new Point(0,0);
		color=Color.black;
	}
	
	public Shape(Point startPoint,Point endPoint,int color){
		this.setStartPoint(startPoint);
		this.setEndPoint(endPoint);
		setColor(color);
	}
	
	public abstract void draw(Graphics g);
	
	public Point getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(Point startPoint) {
		this.startPoint=startPoint;
	}
	public Point getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(Point endPoint) {
		this.endPoint=endPoint;
	}
	
	public void setColor(int n){
		switch(n){
		case 0: 
			color=Color.black;
			break;
		case 1:
			color=Color.red;
			break;
		case 2:
			color=Color.blue;
			break;
		case 3:
			color=Color.green;
			break;
		}
	}
	public void setColor(Color color){
		this.color=color;
	}
	
	public Color getColor(){
		return color;
	}
	
	public int getIntColor(){
		
		if(color.equals(Color.red))
			return 1;
		else if(color.equals(Color.blue))
			return 2;
		else if(color.equals(Color.green))
			return 3;
		else{
			return 0;
		}
	}
	
	
}
