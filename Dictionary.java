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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import swingJFrame.SwingContainerDemo;
public class Dictionary extends JFrame implements WindowListener{
	private JButton search = new JButton ("Search");
   private JFrame mainFrame; 
   private 	JList listWord = new JList();
   private JLabel headerLabel;	//   private JLabel statusLabel;
   private JPanel controlPanel;  
   protected JTextField SearchWord = new JTextField(70);	// ô nh?p t? c?n tra
   protected JTextArea translate = new JTextArea(100,100); 	// nghia c?a t? dó
 
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
      translate.setEditable(false);
      translate.setLineWrap(true);
      JScrollPane scrollPane = new JScrollPane(translate);
	  SearchWord.setBounds(300,5,290,25);
	  translate.setBounds (200,60,490,385);
	  translate.setBackground(Color.white);
      search.setBounds(592, 5, 100, 24);
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      Dimension mainSize = new Dimension(700,450);
      controlPanel.setPreferredSize(mainSize);
	  listWord.setBounds(7, 35, 180, 410);
   }
   
   private void showDictionary(){
	   mainFrame.setResizable(false);
	      mainFrame.add(listWord);
	      mainFrame.add(search);
		  mainFrame.add(SearchWord);
	      mainFrame.add(translate);
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