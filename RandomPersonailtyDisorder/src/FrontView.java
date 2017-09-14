import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.ScrollPane;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import java.awt.Window.Type;
import java.awt.Color;

public class FrontView extends JFrame {

	private JPanel contentPane;
	private JTextField MsName;
	private JTextField MrName;
	private JLabel lblMr= new JLabel("Mr.");
	JLabel lblProgramDetails = new JLabel("Program Details");
	JLabel lblUserDetails = new JLabel("User Details");
	JLabel lblType = new JLabel("Enter Usage Type");
	JLabel labelPersonalities = new JLabel("Personalities");
	JRadioButton rdbtnMixedDoubles = new JRadioButton("Mixed Doubles");
	JRadioButton rdbtnPairedDoubles = new JRadioButton("Paired Doubles");
	JButton btnExit = new JButton("Exit");
	JButton btnNext = new JButton("Next >");
	JLabel lblMs = new JLabel("Ms.");
	JProgressBar progressBar = new JProgressBar();
	private JTextField perM3;
	private JTextField perF3;
	private JTextField perM5;
	private JTextField perF5;
	private JTextField perF4;
	private JTextField perM4;
	private JTextField perF1;
	private JTextField perM1;
	private JTextField perF2;
	private JTextField perM2;
	JButton btnBack = new JButton("< Back");
	private Timer timer	;
	int progressValue=1;
	private JButton btnSubmit;
	ArrayList<String> maleList=new ArrayList<>();
	ArrayList<String> femaleList=new ArrayList<>();
	private boolean function;
	private JTextArea textArea;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontView frame = new FrontView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrontView() {
		setResizable(false);
		setTitle("Random_Personality_Disorder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		
		lblProgramDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgramDetails.setBounds(22, 38, 103, 43);
		contentPane.add(lblProgramDetails);
		
		lblUserDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserDetails.setBounds(22, 92, 103, 38);
		contentPane.add(lblUserDetails);
		
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setBounds(22, 201, 103, 48);
		contentPane.add(lblType);
		labelPersonalities.setHorizontalAlignment(SwingConstants.CENTER);
		labelPersonalities.setBounds(22, 152, 103, 38);
		contentPane.add(labelPersonalities);
		rdbtnMixedDoubles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			rdbtnPairedDoubles.setSelected(false);
			}
		});
		rdbtnMixedDoubles.setBounds(159, 253, 109, 23);
		contentPane.add(rdbtnMixedDoubles);
		rdbtnPairedDoubles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnMixedDoubles.setSelected(false);
			}
		});
		
		rdbtnPairedDoubles.setBounds(303, 253, 127, 23);
		contentPane.add(rdbtnPairedDoubles);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrontView.this.setVisible(false);
				FrontView.this.dispose();
			}
		});
		btnExit.setBounds(327, 308, 81, 23);
		contentPane.add(btnExit);
		
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BackButtonAction();
			}
		});
		btnBack.setBounds(140, 308, 81, 23);
		contentPane.add(btnBack);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NextButtonAction();
				
			}
		});
		
		btnNext.setBounds(231, 308, 81, 23);
		contentPane.add(btnNext);
		
		MsName = new JTextField();
		MsName.setBounds(159, 94, 93, 20);
		contentPane.add(MsName);
		MsName.setColumns(10);
		
		MrName = new JTextField();
		MrName.setBounds(304, 94, 93, 20);
		contentPane.add(MrName);
		MrName.setColumns(10);
		
		lblMs.setHorizontalAlignment(SwingConstants.CENTER);
		lblMs.setBounds(180, 25, 46, 14);
		contentPane.add(lblMs);
		
		lblMr.setHorizontalAlignment(SwingConstants.CENTER);
		lblMr.setBounds(327, 25, 46, 14);
		contentPane.add(lblMr);
		
		progressBar.setBounds(22, 283, 408, 14);
		contentPane.add(progressBar);
		
		perM3 = new JTextField();
		perM3.setColumns(10);
		perM3.setBounds(304, 132, 93, 20);
		contentPane.add(perM3);
		
		perF3 = new JTextField();
		perF3.setColumns(10);
		perF3.setBounds(159, 132, 93, 20);
		contentPane.add(perF3);
		
		perM5 = new JTextField();
		perM5.setColumns(10);
		perM5.setBounds(304, 212, 93, 20);
		contentPane.add(perM5);
		
		perF5 = new JTextField();
		perF5.setColumns(10);
		perF5.setBounds(159, 212, 93, 20);
		contentPane.add(perF5);
		
		perF4 = new JTextField();
		perF4.setColumns(10);
		perF4.setBounds(159, 174, 93, 20);
		contentPane.add(perF4);
		
		perM4 = new JTextField();
		perM4.setColumns(10);
		perM4.setBounds(304, 174, 93, 20);
		contentPane.add(perM4);
		
		perF1 = new JTextField();
		perF1.setColumns(10);
		perF1.setBounds(159, 50, 93, 20);
		contentPane.add(perF1);
		
		perM1 = new JTextField();
		perM1.setColumns(10);
		perM1.setBounds(304, 50, 93, 20);
		contentPane.add(perM1);
		
		perF2 = new JTextField();
		perF2.setColumns(10);
		perF2.setBounds(159, 94, 93, 20);
		contentPane.add(perF2);
		
		perM2 = new JTextField();
		perM2.setColumns(10);
		perM2.setBounds(304, 94, 93, 20);
		contentPane.add(perM2);
		//textArea.setText();
	
		
		MsName.setVisible(false);
		MrName.setVisible(false);
		lblMr.setVisible(false);
		lblProgramDetails.setVisible(true);
		lblUserDetails.setVisible(true);
		lblType.setVisible(true);
		labelPersonalities.setEnabled(false);
		lblProgramDetails.setEnabled(true);
		lblUserDetails.setEnabled(false);
		lblType.setEnabled(false);
		labelPersonalities.setVisible(true);
		rdbtnMixedDoubles.setVisible(false);
		rdbtnPairedDoubles.setVisible(false);
		btnExit.setVisible(true);
		btnNext.setVisible(true);
		lblMs.setVisible(false);
		progressBar.setVisible(false);
		perM3.setVisible(false);
		perM4.setVisible(false);
		perM5.setVisible(false);
		perM2.setVisible(false);
		perM1.setVisible(false);
		perF3.setVisible(false);
		perF2.setVisible(false);
		perF1.setVisible(false);
		perF4.setVisible(false);
		perF5.setVisible(false);
		btnBack.setEnabled(false);
		
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addMaleData();
				addFemaleData();
				if(maleList.size()>0 && femaleList.size()>0){
				ProgressBarAction();
				}
				else{
					JOptionPane.showMessageDialog(FrontView.this, "Please Enter Personality Details !!");
				}
			}
		});
		btnSubmit.setBounds(231, 308, 81, 23);
		contentPane.add(btnSubmit);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(145, 38, 307, 202);
		contentPane.add(textArea);
		textArea.setText("So here it goes ,\nThe Basic version to our game we discussed yesterday \n Here are the rules \n1.ENTER THE PARTCIPANTS NAME ON NEXT PAGE\n2.ENTER THE PERSONALITIES YOU WOULD LIKE\n      TO CHOOSE FROM\n\n\n\n     You can even input less than 5 personalities \n\n try faading the code");
		
		
		
	}

	protected void NextButtonAction() {
		// TODO Auto-generated method stub
		if(lblProgramDetails.isEnabled()==true){
			lblUserDetails.setEnabled(true);
			lblProgramDetails.setEnabled(false);
			btnBack.setEnabled(true);
			lblMs.setVisible(true);
			lblMr.setVisible(true);
			MsName.setVisible(true);
			MrName.setVisible(true);
			textArea.setVisible(false);
		}
		else if(lblUserDetails.isEnabled()==true){
			if(MsName.getText().isEmpty()==true || MrName.getText().isEmpty()==true){
			JOptionPane.showMessageDialog(FrontView.this, "Please Enter User Details !!");
			}
			else{
				lblUserDetails.setEnabled(false);
				labelPersonalities.setEnabled(true);
				lblMs.setVisible(true);
				lblMr.setVisible(true);
				MsName.setVisible(false);
				MrName.setVisible(false);
				perM3.setVisible(true);
				perM4.setVisible(true);
				perM5.setVisible(true);
				perM2.setVisible(true);
				perM1.setVisible(true);
				perF3.setVisible(true);
				perF2.setVisible(true);
				perF1.setVisible(true);
				perF4.setVisible(true);
				perF5.setVisible(true);
				btnSubmit.setVisible(false);
			}
		
		}
		else if(labelPersonalities.isEnabled()==true){
			lblType.setEnabled(true);
			labelPersonalities.setEnabled(false);
			btnSubmit.setVisible(true);
			btnNext.setVisible(false);
			lblMs.setVisible(false);
			lblMr.setVisible(false);
			perM3.setVisible(false);
			perM4.setVisible(false);
			perM5.setVisible(false);
			perM2.setVisible(false);
			perM1.setVisible(false);
			perF3.setVisible(false);
			perF2.setVisible(false);
			perF1.setVisible(false);
			perF4.setVisible(false);
			perF5.setVisible(false);
			rdbtnMixedDoubles.setVisible(true);
			rdbtnPairedDoubles.setVisible(true);
			textArea.setVisible(true);
			textArea.setText("\n\n\nTYPE WHAT DOES THIS MEAN NOW ? \n MIXED DOUBLES MEAN ANY MAN AND ANY WOMAN \n PAIRED DOUBLES MEAN THE PAIR WILL BE SELECTED \n\n\n was simple i know :p");
			
			
		
		
		
		
		
		}
		
	}





	protected void BackButtonAction() {
		// TODO Auto-generated method stub
		if(labelPersonalities.isEnabled()==true){
			lblUserDetails.setEnabled(true);
			labelPersonalities.setEnabled(false);
			lblMs.setVisible(true);
			lblMr.setVisible(true);
			MsName.setVisible(true);
			MrName.setVisible(true);
			lblMs.setVisible(false);
			lblMr.setVisible(false);
			perM3.setVisible(false);
			perM4.setVisible(false);
			perM5.setVisible(false);
			perM2.setVisible(false);
			perM1.setVisible(false);
			perF3.setVisible(false);
			perF2.setVisible(false);
			perF1.setVisible(false);
			perF4.setVisible(false);
			perF5.setVisible(false);
			
			
		}
		else if(lblUserDetails.isEnabled()==true){
			lblUserDetails.setEnabled(false);
			lblProgramDetails.setEnabled(true);
			btnBack.setEnabled(false);
			textArea.setVisible(true);
			lblMs.setVisible(false);
			lblMr.setVisible(false);
			MsName.setVisible(false);
			MrName.setVisible(false);
			textArea.setText("So here it goes ,\nThe Basic version to our game we discussed yesterday \n Here are the rules \n1.ENTER THE PARTCIPANTS NAME ON NEXT PAGE\n2.ENTER THE PERSONALITIES YOU WOULD LIKE\n      TO CHOOSE FROM\n\n\n\n     You can even input less than 5 personalities \n\n try faading the code");
			
		}
		else if(lblType.isEnabled()==true){
			lblType.setEnabled(false);
			labelPersonalities.setEnabled(true);
			btnSubmit.setVisible(false);
			btnNext.setVisible(true);
			lblMs.setVisible(true);
			lblMr.setVisible(true);
			MsName.setVisible(false);
			MrName.setVisible(false);
			perM3.setVisible(true);
			perM4.setVisible(true);
			perM5.setVisible(true);
			perM2.setVisible(true);
			perM1.setVisible(true);
			perF3.setVisible(true);
			perF2.setVisible(true);
			perF1.setVisible(true);
			perF4.setVisible(true);
			perF5.setVisible(true);
			rdbtnMixedDoubles.setVisible(false);
			rdbtnPairedDoubles.setVisible(false);
			textArea.setVisible(false);
			
		}
		
	}
	
	
 
	
	protected void ProgressBarAction(){
		
		progressBar.setVisible(true);
		timer = new Timer(10 , (e)->{
			if(progressValue>=100){
				timer.stop();
				MsName.setVisible(false);
				MrName.setVisible(false);
				lblMr.setVisible(false);
				lblProgramDetails.setVisible(false);
				lblUserDetails.setVisible(false);
				lblType.setVisible(false);
				labelPersonalities.setEnabled(false);
				lblProgramDetails.setEnabled(false);
				lblUserDetails.setEnabled(false);
				lblType.setEnabled(false);
				labelPersonalities.setVisible(false);
				rdbtnMixedDoubles.setVisible(false);
				rdbtnPairedDoubles.setVisible(false);
				btnExit.setVisible(true);
				btnNext.setVisible(false);
				btnBack.setVisible(false);
				lblMs.setVisible(false);
				progressBar.setVisible(false);
				perM3.setVisible(false);
				perM4.setVisible(false);
				perM5.setVisible(false);
				perM2.setVisible(false);
				perM1.setVisible(false);
				perF3.setVisible(false);
				perF2.setVisible(false);
				perF1.setVisible(false);
				perF4.setVisible(false);
				perF5.setVisible(false);
				btnBack.setEnabled(false);
				textArea.setBounds(0,20,460,270);
				textArea.setVisible(true);
				textArea.setEnabled(true);
				btnSubmit.setVisible(false);
				
				if(rdbtnPairedDoubles.isSelected()==true){
				showResult();
				}
				else if(rdbtnMixedDoubles.isSelected()==true){
					showDifferResult();
				}
				JOptionPane.showMessageDialog(this, "Random Personality Disordered");
				
				
			}

			progressBar.setValue(progressValue);

			progressValue++;

				});

		timer.start();

	}
	
	
	private void showDifferResult() {
		int min=0;
		int max;
		if(maleList.size()>femaleList.size()){
			 max=femaleList.size()-1;
			}
			else{
			 max=maleList.size()-1;
			}
		int random=randInt(min, max);
		int random1=randInt(min,max);
		String female=femaleList.get(random);
		String male=maleList.get(random1);
		textArea.setText("\n\n\n"+"     " + MsName.getText() + "--  " +female + "  &&  " + MrName.getText()+ "--  " +male  );
		
		
	}

	

	private void showResult() {
		int min=0;
		int max;
		if(maleList.size()<femaleList.size()){
		  max=femaleList.size()-1;
		}
		else{
		 max=maleList.size()-1;
		}
		int random=randInt(min, max);
		String female=femaleList.get(random);
		String male=maleList.get(random);
		textArea.setText("\n\n\n"+"     "+ MsName.getText() + "--  " +female + "  &&  " + MrName.getText()+ "--  " +male  );
		
		
	}

	protected int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}


	protected void addMaleData(){
		
		if(perM1.getText().isEmpty()==false){
			String s1=perM1.getText();
			maleList.add(s1);
		}
		if(perM2.getText().isEmpty()==false){
			String s2=perM2.getText();
			maleList.add(s2);
		}
		if(perM3.getText().isEmpty()==false){
			String s3=perM3.getText();
			maleList.add(s3);
		}
		if(perM4.getText().isEmpty()==false){
			String s4=perM4.getText();
			maleList.add(s4);
		}
		if(perM5.getText().isEmpty()==false){
			String s5=perM5.getText();
			maleList.add(s5);
		}
		
	}
	protected void addFemaleData(){
	
	if(perF1.getText().isEmpty()==false){
		String s1=perF1.getText();
		femaleList.add(s1);
	}
	if(perF2.getText().isEmpty()==false){
		String s2=perF2.getText();
		femaleList.add(s2);
	}
	if(perM3.getText().isEmpty()==false){
		String s3=perF3.getText();
		femaleList.add(s3);
	}
	if(perF4.getText().isEmpty()==false){
		String s4=perF4.getText();
		femaleList.add(s4);
	}
	if(perF5.getText().isEmpty()==false){
		String s5=perF5.getText();
		femaleList.add(s5);
	}
	}



}







