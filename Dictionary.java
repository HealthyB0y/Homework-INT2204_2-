package BigHomework;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Dictionary extends JFrame implements ActionListener{
	
	private JButton search;
	private JFrame mainFrame ; 
   	private JLabel headerLabel;
   	private JPanel controlPanel;  
	private JMenu file,help;
	private JMenuBar list = new JMenuBar();
	private JMenuItem addWord = new JMenuItem("Add Word"),
			history = new JMenuItem("History"),
			exit = new JMenuItem("Exit");
   	protected JTextField SearchWord = new JTextField(70);
   	protected JTextArea translate = new JTextArea(100,100); 
	private JButton speak = 
			new JButton(new ImageIcon("C:\\Users\\Huy Hoang\\eclipse-workspace\\java-traning\\src\\BigHomework\\speak.png"));
	private JButton fix = 
			new JButton(new ImageIcon("C:\\Users\\Huy Hoang\\eclipse-workspace\\java-traning\\src\\BigHomework\\fix.png"));
	private JButton save = 
			new JButton (new ImageIcon("C:\\Users\\Huy Hoang\\eclipse-workspace\\java-traning\\src\\BigHomework\\save.png"));
   	private JLabel face = 
   			new JLabel(new ImageIcon("C:\\Users\\Huy Hoang\\eclipse-workspace\\java-traning\\src\\BigHomework\\image.jpeg"));
	
   	public  Dictionary(){
		prepareGUI();
	}  
	
	public static void main(String[] args){
		Dictionary Dictionary = new Dictionary();        
		Dictionary.showDictionary();
	}   
   
	private void prepareGUI(){
		search = new JButton ("Search");
		search.setBounds(350, 5, 100, 26);
		search.addActionListener(this);
		
		mainFrame = new JFrame("Dictionary");
		mainFrame.setSize(500,500);
		
		headerLabel = new JLabel("",JLabel.CENTER ); 
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		Dimension mainSize = new Dimension(700,450);
		controlPanel.setPreferredSize(mainSize);
		
		JScrollPane scrollPane = new JScrollPane(translate);
		translate.setEditable(false);
		translate.setBounds (200,60,500,387);
		translate.setBackground(Color.white);
		
		
		SearchWord.setBounds(15,5,330,25);
		SearchWord.setEditable(true);
		
		
		speak.setBounds(200,30,35,28);
		speak.addActionListener(this);
		
		
		fix.setBounds(240,30,35,28);
		fix.addActionListener( this);
		
		
		save.setBounds(280,30,35,28);
		save.addActionListener( this);
		
		file = new JMenu("File");
		help = new JMenu("Help");
		file.add(addWord);
		file.add(history);
		file.add(exit);
		list.add(file);
		list.add(help);
		
	}
   
	private void showDictionary(){	
	    mainFrame.add(search);
	    mainFrame.add(speak);
	    mainFrame.add(fix);
	    mainFrame.add(save);
	    mainFrame.add(SearchWord);
		mainFrame.add(translate);
	    mainFrame.add(headerLabel);
	    mainFrame.add(controlPanel);
	    mainFrame.add(face);
	    mainFrame.pack();
	    mainFrame.setJMenuBar(list);
	    mainFrame.setResizable(false);
	    mainFrame.setVisible(true);  
	    mainFrame.addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent windowEvent){
	    	System.exit(0);
	    }        
	    });
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == fix) {
			SearchWord.setEditable(false);
			translate.setEditable(true);
		}
		if(e.getSource() == save) {
			SearchWord.setEditable(true);
			translate.setEditable(false);
		}
		
	}
}
