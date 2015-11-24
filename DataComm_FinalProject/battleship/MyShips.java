package battleship;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MyShips extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	
	protected JPanel panel;
	
	protected static String[] myLocations = new String[17];

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			MyShips dialog = new MyShips();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public MyShips() {
		setBounds(100, 100, 995, 590);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(680, 71, 40, 35);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblCarrierBattleshipCruiser = new JLabel("<html><p>\r\n<br><br>\r\nCARRIER\r\n<br><br><br><br>\r\nBATTLESHIP\r\n<br><br><br><br>\r\nCRUISER\r\n<br><br><br><br>\r\nSUBMARINE\r\n<br><br><br><br>\r\nDESTROYER\r\n</p><html>");
			lblCarrierBattleshipCruiser.setVerticalAlignment(SwingConstants.TOP);
			lblCarrierBattleshipCruiser.setHorizontalAlignment(SwingConstants.LEFT);
			lblCarrierBattleshipCruiser.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblCarrierBattleshipCruiser.setBounds(680, 11, 260, 382);
			contentPanel.add(lblCarrierBattleshipCruiser);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(730, 71, 40, 35);
			textField_1.setTransferHandler(new battleship.ValueImportTransferHandler());
			contentPanel.add(textField_1);
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(780, 71, 40, 35);
			textField_2.setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(textField_2);
		}
		{
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(830, 71, 40, 35);
			textField_3.setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(textField_3);
		}
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(880, 71, 40, 35);
			textField_4.setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(textField_4);
		}
		{
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(680, 137, 40, 35);
			textField_5.setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(textField_5);
		}
		{
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(730, 137, 40, 35);
			textField_6.setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(textField_6);
		}
		{
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(780, 137, 40, 35);
			textField_7.setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(textField_7);
		}
		{
			textField_8 = new JTextField();
			textField_8.setColumns(10);
			textField_8.setBounds(830, 137, 40, 35);
			textField_8.setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(textField_8);
		}
		{
			textField_9 = new JTextField();
			textField_9.setColumns(10);
			textField_9.setBounds(680, 207, 40, 35);
			textField_9.setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(textField_9);
		}
		{
			textField_10 = new JTextField();
			textField_10.setColumns(10);
			textField_10.setBounds(730, 207, 40, 35);
			textField_10.setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(textField_10);
		}
		{
			textField_11 = new JTextField();
			textField_11.setColumns(10);
			textField_11.setBounds(780, 207, 40, 35);
			textField_11.setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(textField_11);
		}
		{
			textField_12 = new JTextField();
			textField_12.setColumns(10);
			textField_12.setBounds(680, 274, 40, 35);
			textField_12.setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(textField_12);
		}
		{
			textField_13 = new JTextField();
			textField_13.setColumns(10);
			textField_13.setBounds(730, 274, 40, 35);
			textField_13.setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(textField_13);
		}
		{
			textField_14 = new JTextField();
			textField_14.setColumns(10);
			textField_14.setBounds(780, 274, 40, 35);
			textField_14.setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(textField_14);
		}
		{
			textField_15 = new JTextField();
			textField_15.setColumns(10);
			textField_15.setBounds(680, 340, 40, 35);
			textField_15.setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(textField_15);
		}
		{
			textField_16 = new JTextField();
			textField_16.setColumns(10);
			textField_16.setBounds(730, 340, 40, 35);
			textField_16.setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(textField_16);
		}
		{
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(10, 11, 660, 496);
			contentPanel.add(panel);
			panel.setLayout(new GridLayout(0, 12, 0, 0));
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					BattleshipClient.carrier[0] = textField.getText();
					BattleshipClient.carrier[1] = textField_1.getText();
					BattleshipClient.carrier[2] = textField_2.getText();
					BattleshipClient.carrier[3] = textField_3.getText();
					BattleshipClient.carrier[4] = textField_4.getText();
					BattleshipClient.battleship[0] = textField_5.getText();
					BattleshipClient.battleship[1] = textField_6.getText();
					BattleshipClient.battleship[2] = textField_7.getText();
					BattleshipClient.battleship[3] = textField_8.getText();
					BattleshipClient.cruiser[0] = textField_9.getText();
					BattleshipClient.cruiser[1] = textField_10.getText();
					BattleshipClient.cruiser[2] = textField_11.getText();
					BattleshipClient.submarine[0] = textField_12.getText();
					BattleshipClient.submarine[1] = textField_13.getText();
					BattleshipClient.submarine[2] = textField_14.getText();
					BattleshipClient.destroyer[0] = textField_15.getText();
					BattleshipClient.destroyer[1] = textField_16.getText();
					
					BattleshipClient.printLocations();
					BattleshipClient.myBoard.setVisible(false);
				}
			});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
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
				btn.setFont(new Font("Tahoma", Font.PLAIN, 11));
//				btn.setDropTarget(new DropTarget(textField_15, ,));
//				btn.setDragEnabled(true);
				btn.setTransferHandler(new battleship.ValueExportTransferHandler((String)btn.getText()));
				btn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        JButton button = (JButton) e.getSource();
                        ValueExportTransferHandler handle = (ValueExportTransferHandler) button.getTransferHandler();                 
                        handle.exportAsDrag(button, e, TransferHandler.COPY);
                    }
                });
				panel.add(btn);
			}
		}
	}
	
	public static String[] getLocations()
	{
		return myLocations;
	}
}
