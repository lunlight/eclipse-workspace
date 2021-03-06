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
	
	private JTextField[] txtLocations = new JTextField[17];
	
	protected JPanel panel;

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
			txtLocations[0] = new JTextField();
			txtLocations[0].setBounds(680, 71, 40, 35);
			contentPanel.add(txtLocations[0]);
			txtLocations[0].setColumns(10);
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
			txtLocations[1] = new JTextField();
			txtLocations[1].setColumns(10);
			txtLocations[1].setBounds(730, 71, 40, 35);
			txtLocations[1].setTransferHandler(new battleship.ValueImportTransferHandler());
			contentPanel.add(txtLocations[1]);
		}
		{
			txtLocations[2] = new JTextField();
			txtLocations[2].setColumns(10);
			txtLocations[2].setBounds(780, 71, 40, 35);
			txtLocations[2].setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(txtLocations[2]);
		}
		{
			txtLocations[3] = new JTextField();
			txtLocations[3].setColumns(10);
			txtLocations[3].setBounds(830, 71, 40, 35);
			txtLocations[3].setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(txtLocations[3]);
		}
		{
			txtLocations[4] = new JTextField();
			txtLocations[4].setColumns(10);
			txtLocations[4].setBounds(880, 71, 40, 35);
			txtLocations[4].setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(txtLocations[4]);
		}
		{
			txtLocations[5] = new JTextField();
			txtLocations[5].setColumns(10);
			txtLocations[5].setBounds(680, 137, 40, 35);
			txtLocations[5].setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(txtLocations[5]);
		}
		{
			txtLocations[6] = new JTextField();
			txtLocations[6].setColumns(10);
			txtLocations[6].setBounds(730, 137, 40, 35);
			txtLocations[6].setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(txtLocations[6]);
		}
		{
			txtLocations[7] = new JTextField();
			txtLocations[7].setColumns(10);
			txtLocations[7].setBounds(780, 137, 40, 35);
			txtLocations[7].setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(txtLocations[7]);
		}
		{
			txtLocations[8] = new JTextField();
			txtLocations[8].setColumns(10);
			txtLocations[8].setBounds(830, 137, 40, 35);
			txtLocations[8].setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(txtLocations[8]);
		}
		{
			txtLocations[9] = new JTextField();
			txtLocations[9].setColumns(10);
			txtLocations[9].setBounds(680, 207, 40, 35);
			txtLocations[9].setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(txtLocations[9]);
		}
		{
			txtLocations[10] = new JTextField();
			txtLocations[10].setColumns(10);
			txtLocations[10].setBounds(730, 207, 40, 35);
			txtLocations[10].setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(txtLocations[10]);
		}
		{
			txtLocations[11] = new JTextField();
			txtLocations[11].setColumns(10);
			txtLocations[11].setBounds(780, 207, 40, 35);
			txtLocations[11].setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(txtLocations[11]);
		}
		{
			txtLocations[12] = new JTextField();
			txtLocations[12].setColumns(10);
			txtLocations[12].setBounds(680, 274, 40, 35);
			txtLocations[12].setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(txtLocations[12]);
		}
		{
			txtLocations[13] = new JTextField();
			txtLocations[13].setColumns(10);
			txtLocations[13].setBounds(730, 274, 40, 35);
			txtLocations[13].setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(txtLocations[13]);
		}
		{
			txtLocations[14] = new JTextField();
			txtLocations[14].setColumns(10);
			txtLocations[14].setBounds(780, 274, 40, 35);
			txtLocations[14].setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(txtLocations[14]);
		}
		{
			txtLocations[15] = new JTextField();
			txtLocations[15].setColumns(10);
			txtLocations[15].setBounds(680, 340, 40, 35);
			txtLocations[15].setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(txtLocations[15]);
		}
		{
			txtLocations[16] = new JTextField();
			txtLocations[16].setColumns(10);
			txtLocations[16].setBounds(730, 340, 40, 35);
			txtLocations[16].setTransferHandler(new ValueImportTransferHandler());
			contentPanel.add(txtLocations[16]);
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
					BattleshipClient.carrier[0] = txtLocations[0].getText();
					BattleshipClient.carrier[1] = txtLocations[1].getText();
					BattleshipClient.carrier[2] = txtLocations[2].getText();
					BattleshipClient.carrier[3] = txtLocations[3].getText();
					BattleshipClient.carrier[4] = txtLocations[4].getText();
					BattleshipClient.battleship[0] = txtLocations[5].getText();
					BattleshipClient.battleship[1] = txtLocations[6].getText();
					BattleshipClient.battleship[2] = txtLocations[7].getText();
					BattleshipClient.battleship[3] = txtLocations[8].getText();
					BattleshipClient.cruiser[0] = txtLocations[9].getText();
					BattleshipClient.cruiser[1] = txtLocations[10].getText();
					BattleshipClient.cruiser[2] = txtLocations[11].getText();
					BattleshipClient.submarine[0] = txtLocations[12].getText();
					BattleshipClient.submarine[1] = txtLocations[13].getText();
					BattleshipClient.submarine[2] = txtLocations[14].getText();
					BattleshipClient.destroyer[0] = txtLocations[15].getText();
					BattleshipClient.destroyer[1] = txtLocations[16].getText();
					
					BattleshipClient.PrintLocations();
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
//	public static String[] getLocations(){
//		return txtLocations;
//	}
}