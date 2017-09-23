package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ColorPanel extends JPanel{

	
	public static Color color=Color.black;
	private JRadioButton redRBtn;
	private JRadioButton blackRBtn;
	private JRadioButton blueRBtn;
	private JRadioButton greenRBtn;
	private JLabel redLbl;
	private JLabel greenLbl;
	private JLabel blackLbl;
	private JLabel blueLbl;

	public ColorPanel(){
		
		
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10), BorderFactory.createTitledBorder("Color")));
		setLayout(new GridBagLayout());
		GridBagConstraints gc=new GridBagConstraints();


		//		blackLbl---------------------------------------------------------------

		blackLbl=new JLabel("Black");
		gc.gridx=0;
		gc.gridy=0;
		gc.weightx=1;
		gc.weighty=1;
		gc.insets=new Insets(-120,0,0,0);
		gc.anchor=GridBagConstraints.LINE_END;
		
		add(blackLbl,gc);

		//		blackRBtn--------------------------------------------------------------

		blackRBtn=new JRadioButton();
		gc.gridx=1;
		gc.gridy=0;
		gc.weightx=1;
		gc.weighty=1;
		
		gc.anchor=GridBagConstraints.LINE_START;
		
		add(blackRBtn,gc);
		
		blackRBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				greenRBtn.setSelected(false);
				redRBtn.setSelected(false);
				blueRBtn.setSelected(false);
				color=Color.black;
			}
		});

		//		redLbl-----------------------------------------------------------------

		redLbl=new JLabel("Red");
		gc.gridx=0;
		gc.gridy=1;
		gc.weightx=1;
		gc.weighty=1;
		gc.insets=new Insets(-240,0,0,0);
		gc.anchor=GridBagConstraints.LINE_END;
		
		add(redLbl,gc);

		//		redRBtn----------------------------------------------------------------

		redRBtn=new JRadioButton();
		gc.gridx=1;
		gc.gridy=1;
		gc.weightx=1;
		gc.weighty=1;
		gc.anchor=GridBagConstraints.LINE_START;
		
		add(redRBtn,gc);
		
		redRBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				greenRBtn.setSelected(false);
				blackRBtn.setSelected(false);
				blueRBtn.setSelected(false);
				color=Color.red;
			}
		});

		//		blueLbl----------------------------------------------------------------

		blueLbl=new JLabel("Blue");
		gc.gridx=0;
		gc.gridy=2;
		gc.weightx=1;
		gc.weighty=1;
		gc.insets=new Insets(-360,0,0,0);
		gc.anchor=GridBagConstraints.LINE_END;
		
		add(blueLbl,gc);

		//		blueRBtn---------------------------------------------------------------

		blueRBtn=new JRadioButton();
		gc.gridx=1;
		gc.gridy=2;
		gc.weightx=1;
		gc.weighty=1;
		gc.anchor=GridBagConstraints.LINE_START;
		
		add(blueRBtn,gc);
		
		blueRBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				greenRBtn.setSelected(false);
				redRBtn.setSelected(false);
				blackRBtn.setSelected(false);
				color=Color.blue;
			}
		});

		//		greenLbl---------------------------------------------------------------

		greenLbl=new JLabel("Green");
		gc.gridx=0;
		gc.gridy=3;
		gc.weightx=1;
		gc.weighty=1;
		gc.insets=new Insets(-480,0,0,0);
		gc.anchor=GridBagConstraints.LINE_END;
		
		add(greenLbl,gc);

		//		greenRBtn--------------------------------------------------------------

		greenRBtn=new JRadioButton();
		gc.gridx=1;
		gc.gridy=3;
		gc.weightx=1;
		gc.weighty=1;
		gc.anchor=GridBagConstraints.LINE_START;
		
		add(greenRBtn,gc);
		
		greenRBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				blackRBtn.setSelected(false);
				redRBtn.setSelected(false);
				blueRBtn.setSelected(false);
				color=Color.green;
			}
		});
	}
	

	
	
}


