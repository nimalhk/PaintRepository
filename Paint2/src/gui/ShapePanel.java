package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.Circle;
import model.Line;
import model.Rectangle;
import model.Shape;

public class ShapePanel extends JPanel{
	
	public static Shape shape=new Line();
	private JButton lineBtn;
	private JButton circleBtn;
	private JButton rectangleBtn;
	
	public ShapePanel(){
		
		Dimension dim=getPreferredSize();
		dim.height=500;
		setPreferredSize(dim);
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), BorderFactory.createTitledBorder("shape")));
		setLayout(new GridBagLayout());
		GridBagConstraints gc=new GridBagConstraints();	
		
		
//		lineBtn----------------------------------------------------------------
		
		lineBtn=new JButton("Line");
		gc.gridx=0;
		gc.gridy=0;
		gc.weightx=1;
		gc.weighty=1;
		gc.anchor=GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,0,0);
		add(lineBtn,gc);
		
		lineBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			shape=new Line();
			}
		});
		
//		circleBtn--------------------------------------------------------------
		
		circleBtn=new JButton("Circle");
		gc.gridx=0;
		gc.gridy=1;
		gc.weightx=1;
		gc.weighty=1;
		gc.anchor=GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,0,0);
		add(circleBtn,gc);
		
		circleBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			shape=new Circle();
			}
		});
		
//		rectangleBtn-----------------------------------------------------------
		
		rectangleBtn=new JButton("rectangle");
		gc.gridx=0;
		gc.gridy=2;
		gc.weightx=1;
		gc.weighty=1;
		gc.anchor=GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,0,0);
		add(rectangleBtn,gc);
		
		rectangleBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			shape=new Rectangle();
			}
		});
		
	}

}
