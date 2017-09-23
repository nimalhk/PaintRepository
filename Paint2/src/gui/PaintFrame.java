package gui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import dao.UserManager;

public class PaintFrame extends JFrame{
	
	
	private ToolbarPanel toolbarPanel;
	private PaintPanel paintPanel;
	
	public PaintFrame(){
	
		super("Paint");
		setBounds(700,100,2000,1500);
		setLayout(new BorderLayout());
		
		addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		       UserManager.currentUser=null;
		    }
		});
		
//		toolbarPanel-----------------------------------------------------------
		
		toolbarPanel=new ToolbarPanel();
		
		toolbarPanel.setDeleteListener(new DeleteListener(){

			@Override
			public void clear() {
				paintPanel.clearShapes();
				paintPanel.repaint();
			}
			
		});
		
		add(toolbarPanel,BorderLayout.LINE_END);
		
//		paintPanel-------------------------------------------------------------
		
		paintPanel=new PaintPanel();
		
		
		
		add(paintPanel,BorderLayout.CENTER);
		
		
	}
	
	
}
