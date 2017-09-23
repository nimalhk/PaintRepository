package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import dao.UserManager;
import model.Circle;
import model.Line;
import model.Point;
import model.Rectangle;
import model.Shape;

public class PaintPanel extends JPanel {


	private Shape shape;
	private List<Shape> shapes;
	private Shape currentShape;
	public PaintPanel(){
		
		setBackground(Color.white);	
		shapes=UserManager.getShapes();
		if (shapes==null){
			shapes=new ArrayList<Shape>();
		}

		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				currentShape=null;
				shape.setEndPoint(new Point(e.getX(),e.getY()));

				shapes.add(shape);
				UserManager.addShape(shape);
				repaint();
				System.out.println("mouse released");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if(ShapePanel.shape instanceof Line){
					currentShape=shape=new Line();
				}
				else if(ShapePanel.shape instanceof Circle){
					currentShape=shape=new Circle();
				}
				else if(ShapePanel.shape instanceof Rectangle){
					currentShape=shape=new Rectangle();
				}
				shape.setStartPoint(new Point(e.getX(),e.getY()));
				shape.setColor(ColorPanel.color);
				System.out.println("mouse pressed");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {


			}
		});



		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				shape.setEndPoint(new Point(e.getX(),e.getY()));
				currentShape.setEndPoint(new Point(e.getX(),e.getY()));
				repaint();
				System.out.println("mouse dragged");
			}
		});
	}



	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		for(Shape s:shapes){
			s.draw(g);
		}
		if(currentShape!=null)
			currentShape.draw(g);
	}

	public void clearShapes(){
		shapes.clear();
	}
	
	
}
