package BigHomework;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import swingJFrame.SwingContainerDemo;
public class Dictionary extends JFrame implements WindowListener{
	private JButton search = new JButton ("Search");
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;  
   protected JTextField SearchWork = new JTextField(70);
   protected JTextArea textArea = new JTextArea(100,100);
   
   public  Dictionary(){
	   prepareGUI();
   }   
   public static void main(String[] args){
	   Dictionary Dictionary = new Dictionary();        
	   Dictionary.showDictionary();
   }   
   private void prepareGUI(){
      mainFrame = new JFrame("Dictionary");
      mainFrame.setSize(500,500);    
      headerLabel = new JLabel("",JLabel.CENTER ); 
      textArea.setEditable(false);
      textArea.setLineWrap(true);
      JScrollPane scrollPane = new JScrollPane(textArea);
	  SearchWork.setBounds(300,5,290,25);
      textArea.setBounds (5,35,680,355);
      textArea.setBackground(Color.white);
      search.setBounds(592, 5, 100, 24);
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      Dimension mainSize = new Dimension(700,400);
      controlPanel.setPreferredSize(mainSize);
      mainFrame.setResizable(false);
      mainFrame.add(search);
	  mainFrame.add(SearchWork);
      mainFrame.add(textArea);
      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.pack();
      mainFrame.setVisible(true);  
      mainFrame.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent windowEvent){
 	        System.exit(0);
          }        
       });
   }
   private void showDictionary(){
	   
   }
@Override
public void windowActivated(WindowEvent e) {
	// TODO Auto-generated method stub
}
@Override
public void windowClosed(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowClosing(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowDeactivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowDeiconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowIconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
	
}	
}