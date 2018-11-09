import java.io.*; 
import javax.swing.*; 
import java.awt.event.*; 
import javax.swing.filechooser.*;
import java.awt.Label; 


class DecryptionScreen extends JFrame {
  
    public String source;
    public String destination;
  
    
    
    public DecryptionScreen() 
    { 
        // frame to contains GUI elements 
        JFrame f = new JFrame("file chooser"); 
        
        // set the size of the frame 
        f.setSize(400, 400); 
  
        // set the frame's visibility 
        f.setVisible(true); 
  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
        // make a panel to add the buttons and labels 
        JPanel p = new JPanel();
        p.setLayout(null);
        f.getContentPane().add(p); 
        
        JLabel lbl = new JLabel("");
        lbl.setEnabled(false);
        lbl.setBounds(26, 125, 233, 149);
        p.add(lbl);
        
        JLabel lblPath = new JLabel("path");
        lblPath.setBounds(119, 41, 255, 14);
        p.add(lblPath);
        
        JLabel l = new JLabel("File Not Chosen");
        l.setBounds(119, 16, 255, 14);
        p.add(l);
        
        JButton btnNewButton = new JButton("Start");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ImageManipulation imO= new ImageManipulation();
        		//source=source.replaceAll("\", ", "\\");
//        		System.out.println(source);
//        		System.out.println(destination);
        		imO.manipulate(source, destination,"dec");
        		
        	}
        });
        btnNewButton.setBounds(285, 188, 89, 23);
        p.add(btnNewButton);
        
        JButton btnDestination = new JButton("Destination");
        btnDestination.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
        		  
                // set the selection mode to directories only 
                j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
                
                // invoke the showsOpenDialog function to show the save dialog 
                int r = j.showOpenDialog(null); 
      
                // if the user selects a file 
                if (r == JFileChooser.APPROVE_OPTION) 
      
                { 
                    // set the label to the path of the selected file 
                    lblPath.setText(j.getSelectedFile().getAbsolutePath());
                    destination=lblPath.getText();
                } 
        	}
        });
        btnDestination.setBounds(10, 37, 89, 23);
        p.add(btnDestination);
        
 
  
        
        JButton btnSource = new JButton("Source");
        btnSource.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
        		  
                // invoke the showsOpenDialog function to show the save dialog 
                int r = j.showOpenDialog(null); 
      
                // if the user selects a file 
                if (r == JFileChooser.APPROVE_OPTION) 
      
                { 
                    // set the label to the path of the selected file 
                    l.setText(j.getSelectedFile().getAbsolutePath()); 
                   lbl.setIcon(new ImageIcon(l.getText()));
                   source=l.getText();
                } 
        	}
        });
        btnSource.setBounds(10, 11, 89, 23);
        p.add(btnSource);
        
       
        f.show(); 
    } 
    

} 