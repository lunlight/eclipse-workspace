package battleship;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.DefaultCaret;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JProgressBar;

import java.awt.SystemColor;

public class BattleshipClient
{
	protected static JTextArea textArea;
	protected static boolean hit = false;
	
	protected static String[] carrier = new String[5];
	protected static String[] battleship = new String[4];
	protected static String[] cruiser = new String[3];
	protected static String[] submarine = new String[3];
	protected static String[] destroyer = new String[2];
	protected static String[] myLocation = new String[17];
	
	protected static MyShips myBoard;
	
	protected static JPanel panel;
	protected static JPanel panel_1;
	protected static JPanel panel_2;
	protected static JPanel panel_3;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BattleshipClient window = new BattleshipClient();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		myBoard = new MyShips();
		myBoard.setTitle("Select your ship locations.");
		myBoard.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		myBoard.setVisible(true);
		myBoard.setAlwaysOnTop(true);
	}

	/**
	 * Create the application.
	 */
	public BattleshipClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setBounds(100, 100, 1250, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		

		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 280, 500);
		panel.setLayout(null);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("My Ships");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 260, 29);
		panel.add(lblNewLabel);

		JProgressBar progressBar_CARRIER = new JProgressBar();
		progressBar_CARRIER.setBounds(10, 56, 260, 14);
		progressBar_CARRIER.setForeground(Color.RED);
		panel.add(progressBar_CARRIER);

		JProgressBar progressBar_BATTLESHIP = new JProgressBar();
		progressBar_BATTLESHIP.setBounds(10, 92, 260, 14);
		progressBar_BATTLESHIP.setForeground(Color.RED);
		panel.add(progressBar_BATTLESHIP);

		JProgressBar progressBar_CRUISER = new JProgressBar();
		progressBar_CRUISER.setBounds(10, 124, 260, 14);
		progressBar_CRUISER.setForeground(Color.RED);
		panel.add(progressBar_CRUISER);

		JProgressBar progressBar_SUBMARINE = new JProgressBar();
		progressBar_SUBMARINE.setBounds(10, 159, 260, 14);
		progressBar_SUBMARINE.setForeground(Color.RED);
		panel.add(progressBar_SUBMARINE);

		JProgressBar progressBar_DESTROYER = new JProgressBar();
		progressBar_DESTROYER.setBounds(10, 194, 260, 14);
		progressBar_DESTROYER.setForeground(Color.RED);
		panel.add(progressBar_DESTROYER);

		JLabel lblNewLabel_SHIPS = new JLabel("<html><p>\r\nCARRIER\r\n<br><br>\r\nBATTLESHIP\r\n<br><br>\r\nCRUISER\r\n<br><br>\r\nSUBMARINE\r\n<br><br>\r\nDESTROYER\r\n</p><html>");
		lblNewLabel_SHIPS.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_SHIPS.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_SHIPS.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_SHIPS.setLabelFor(panel);
		lblNewLabel_SHIPS.setBounds(10, 38, 260, 223);
		panel.add(lblNewLabel_SHIPS);

		JLabel lblMyBoard = new JLabel("My Board");
		lblMyBoard.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyBoard.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMyBoard.setBounds(10, 219, 260, 29);
		panel.add(lblMyBoard);

		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.control);
		//		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(290, 0, 697, 500);
		panel_1.setLayout(new GridLayout(12, 12));
		frame.getContentPane().add(panel_1);

		JScrollPane scroll = new JScrollPane (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(991, 0, 243, 500);
		frame.getContentPane().add(scroll);




		textArea = new JTextArea();
		scroll.setViewportView(textArea);
		textArea.setBackground(Color.DARK_GRAY);
		textArea.setForeground(Color.GREEN);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		ActionListener[] actionListeners = new ActionListener[144];
		ActionListener[] actionListeners2 = new ActionListener[144];
		for(int i = 0; i < 144; i++)
		{
			actionListeners[i] = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton btn = (JButton)e.getSource();
					String location = btn.getText();
					//					JOptionPane.showMessageDialog(null, name);
					WriteInConsole("Attacked position: " + location);					
					sendAttack(location);
					if (hit == true)
						btn.setBackground(Color.GREEN);
					else
						btn.setBackground(Color.RED);
					btn.setEnabled(false);
				}
			};
			
//			actionListeners[i] = new ActionListener("myLocation") {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					JButton btn = (JButton)e.getSource();
//					String location = btn.getText();
//					
//				}
//			};
		}

		for(int i = 0; i < 144; i++)
		{	
			JButton btn = null;
			if(i < 12){
				btn = new JButton("A"+(i+1));
			}else if(i < 24){
				btn = new JButton("B"+(i-11));
			}else if(i < 36){
				btn = new JButton("C"+(i-23));
			}else if(i < 48){
				btn = new JButton("D"+(i-35));
			}else if(i < 60){
				btn = new JButton("E"+(i-47));
			}else if(i < 72){
				btn = new JButton("F"+(i-59));
			}else if(i < 84){
				btn = new JButton("G"+(i-71));
			}else if(i < 96){
				btn = new JButton("H"+(i-83));
			}else if(i < 108){
				btn = new JButton("I"+(i-95));
			}else if(i < 120){
				btn = new JButton("J"+(i-107));
			}else if(i < 132){
				btn = new JButton("K"+(i-119));
			}else if(i < 144){
				btn = new JButton("L"+(i-131));
			}
			
			btn.setBackground(Color.BLUE);
			btn.setForeground(Color.WHITE);
			btn.addActionListener(actionListeners[i]);
			panel_1.add(btn);
		}
		panel_2 = new JPanel();
		panel_2.setBounds(0, 350, 794, 122);
		frame.getContentPane().add(panel_2);
	}
	
	private static void WriteInConsole(String str)
	{
		textArea.append("\n"+str);
	}

	protected static void printLocations()
	{
		String str = "CARRIER: [" + carrier[0];
		for(int i = 1; i < carrier.length; i++)
		{
			str+= ", " +carrier[i];
		}
		WriteInConsole(str+="]");
		
		str = "BATTLESHIP: [" + battleship[0];
		for(int i = 1; i < battleship.length; i++)
		{
			str+= ", " +battleship[i];
		}
		WriteInConsole(str+="]");
		
		str = "CRUISER: [" + cruiser[0];
		for(int i = 1; i < cruiser.length; i++)
		{
			str+= ", " +cruiser[i];
		}
		WriteInConsole(str+="]");
		
		str = "SUBMARINE: [" + submarine[0];
		for(int i = 1; i < submarine.length; i++)
		{
			str+= ", " +submarine[i];
		}
		WriteInConsole(str+="]");
		
		str = "DESTROYER: [" + destroyer[0];
		for(int i = 1; i < destroyer.length; i++)
		{
			str+= ", " +destroyer[i];
		}
		WriteInConsole(str+="]");
		
		int count = 0;
		for (String string : carrier){ myLocation[count++] = string;}
		for (String string : battleship){ myLocation[count++] = string;}
		for (String string : cruiser){ myLocation[count++] = string;}
		for (String string : submarine){ myLocation[count++] = string;}
		for (String string : destroyer){ myLocation[count++] = string;}
		
		panel_3 = new JPanel();
		panel_3.setBounds(10, 253, 260, 236);
		panel_3.setLayout(new GridLayout(12, 12));
		panel.add(panel_3);

		for(int i = 0; i < 144; i++){
			JButton btn = null;
			if(i < 12){
				btn = new JButton("A"+(i+1));
			}else if(i < 24){
				btn = new JButton("B"+(i-11));
			}else if(i < 36){
				btn = new JButton("C"+(i-23));
			}else if(i < 48){
				btn = new JButton("D"+(i-35));
			}else if(i < 60){
				btn = new JButton("E"+(i-47));
			}else if(i < 72){
				btn = new JButton("F"+(i-59));
			}else if(i < 84){
				btn = new JButton("G"+(i-71));
			}else if(i < 96){
				btn = new JButton("H"+(i-83));
			}else if(i < 108){
				btn = new JButton("I"+(i-95));
			}else if(i < 120){
				btn = new JButton("J"+(i-107));
			}else if(i < 132){
				btn = new JButton("K"+(i-119));
			}else if(i < 144){
				btn = new JButton("L"+(i-131));
			}
			btn.setBackground(Color.BLUE);
//			btn.setVisible(true);
			panel_3.setVisible(true);
			panel_3.add(btn);
		}

		int countArray = 0;
		for(int i = 0; i < 144; i++){
//			JButton btn = (JButton) panel_3.;
			
			JButton btn = new JButton();
			
			String string1 = btn.getText();
			String string2 = myLocation[countArray];
			
			if (string1.equals(string2)){
				System.out.println(string1 + ":::" + string2);
				btn.setBackground(Color.GRAY);
				count++;
				count++;
			}
		}
	}
	
	private void sendAttack(String point)
	{

		//send thru sockect the xy location
		//hit = socket.send(point)
	}
	
	private void receiveAttack(String lctn)
	{
		//search the ships array to decide if hit == true or not
		JOptionPane.showMessageDialog(null, "Your enemy hit you in the location: " + lctn);
		
//		if()
//		;
//		else if()
	}



















}