package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import dao.UserManager;


public class ToolbarPanel extends JPanel {
	
	private DeleteListener deleteListener;
	private Color color;
	private ShapePanel shapePanel;
	private ColorPanel colorPanel;
	private JButton deleteBtn;
	
	public ToolbarPanel(){
		Dimension dim=this.getPreferredSize();
		dim.width=500;
		this.setPreferredSize(dim);
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), BorderFactory.createTitledBorder("Toolbar")));
		setLayout(new BorderLayout());
		
//		shapePanel-------------------------------------------------------------
		
		shapePanel=new ShapePanel();
		
		add(shapePanel,BorderLayout.NORTH);
		
//		colorPanel-------------------------------------------------------------
		
		colorPanel=new ColorPanel();
		
		add(colorPanel,BorderLayout.CENTER);
		
//		deleteBtn--------------------------------------------------------------
		
		deleteBtn=new JButton("Clear");
		Dimension btnDim=deleteBtn.getPreferredSize();
		btnDim.height=150;
		deleteBtn.setPreferredSize(btnDim);
		add(deleteBtn,BorderLayout.SOUTH);
		
		deleteBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				UserManager.deleteShapes();
				deleteListener.clear();
			}
			
		});
		
//		
		
		
	}
	
	public void setDeleteListener(DeleteListener deleteListener){
		this.deleteListener=deleteListener;
	}
}
