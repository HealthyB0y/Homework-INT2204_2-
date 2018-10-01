package BigHomework;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Dictionary extends JFrame implements WindowListener{
	private JButton search = new JButton ("Search");
	private JFrame mainFrame; 
   	private JList listWord = new JList();
   	private JLabel headerLabel;	//   private JLabel statusLabel;
   	private JPanel controlPanel;  
   	protected JTextField SearchWord = new JTextField(70);	// ô nhập từ cần tra
   	protected JTextArea translate = new JTextArea(100,100); 	// nghĩa của từ đó
   	ImageIcon imageSpeak = new ImageIcon("C:\\Users\\Huy Hoang\\eclipse-workspace\\java-traning\\src\\BigHomework\\speak.png");
   	ImageIcon imageFix = new ImageIcon("C:\\Users\\Huy Hoang\\eclipse-workspace\\java-traning\\src\\BigHomework\\fix.png");
	private JButton speak = new JButton(imageSpeak);
	private JButton fix = new JButton(imageFix);
   
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
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		Dimension mainSize = new Dimension(700,450);
		controlPanel.setPreferredSize(mainSize);
		JScrollPane scrollPane = new JScrollPane(translate);
		translate.setBounds (200,60,490,385);
		translate.setBackground(Color.white);
		SearchWord.setBounds(300,5,290,25);
		search.setBounds(592, 5, 100, 24);
		speak.setBounds(200,30,35,30);
		fix.setBounds(240,30,35,30);
		listWord.setBounds(7, 35, 180, 410);
	}
   
	private void showDictionary(){
		mainFrame.setResizable(false);
		mainFrame.add(listWord);
	    mainFrame.add(search);
	    mainFrame.add(speak);
	    mainFrame.add(fix);
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