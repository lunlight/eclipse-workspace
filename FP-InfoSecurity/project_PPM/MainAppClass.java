/**
 * MainAppClass.java
 * This class file is the main GUI menu for the
 * Stego Image Application.
 * Authors: 
 * Course: SICI-4997; Final Presentation 
 */

package project_PPM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainAppClass {

	PPM_Cypher hidder = new PPM_Cypher();
	public static JFrame frame;

	/**
	 * Default Constructor.
	 */
	public MainAppClass(){
		initialize();
	}

	/**
	 * Creates and shows Stego Image GUI Application.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(508, 235);
		frame.getContentPane().setLayout(null);

		//
		// bot�n para esconder mensaje
		//
		JButton btnHideMessage = new JButton("Esconder mensaje");
		btnHideMessage.setToolTipText("Esconde el mensaje en la foto.");
		btnHideMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				JOptionPane.showMessageDialog(null, "Escoger la foto donde se va a guardar el mensaje.","Information",JOptionPane.INFORMATION_MESSAGE);
				hidder.fileSelect();
				if(!PPM_Cypher.canceled){
					try {
						String msg = JOptionPane.showInputDialog("Entra el mensaje a ocultar:");
						hidder.toNumberArray(msg,0);
					} catch (NullPointerException e){
					}
				}
				frame.setVisible(true);
				PPM_Cypher.canceled = false; // resets file choosing cancelation
			}
		});
		btnHideMessage.setBounds(15, 41, 150, 150);
		frame.getContentPane().add(btnHideMessage);

		//
		// bot�n para esconder imagen
		//
		JButton btnHideImage = new JButton("Esconder Imagen");
		btnHideImage.setToolTipText("Hide an image within another image.");
		btnHideImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				JOptionPane.showMessageDialog(null, "Escoger la foto donde se va a guardar el mensaje.","Information",JOptionPane.INFORMATION_MESSAGE);
				hidder.fileSelect();
				if(!PPM_Cypher.canceled){
					try {
						JOptionPane.showMessageDialog(null, "Selecciona la imagen que se va a esconder.","Information",JOptionPane.INFORMATION_MESSAGE);
						hidder.toNumberArray("",1);
					} catch (Exception ex) {
						ex.printStackTrace();
					} 
				}
				frame.setVisible(true);
				PPM_Cypher.canceled = false; // resets file choosing cancelation
			}
		});
		btnHideImage.setBounds(175, 41, 150, 150);
		frame.getContentPane().add(btnHideImage);

		JLabel lblChooseAnOption = new JLabel("SELECCIONE UN BOT\u00D3N...");
		lblChooseAnOption.setBounds(15, 10, 185, 19);
		frame.getContentPane().add(lblChooseAnOption);

		//
		// bot�n para decifrar lo que se escondi�
		//
		JButton btnDecypherMessage = new JButton("Decifrar mensaje");
		btnDecypherMessage.setToolTipText("Reveal a hidden image.");
		btnDecypherMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
					JOptionPane.showMessageDialog(null, "Escoge la imagen original.");
					new PPM_Decypher().fileSelect();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				} 	
				frame.setVisible(true);
				PPM_Decypher.canceled = false; // resets file choosing cancelation
			}
		});
		btnDecypherMessage.setBounds(335, 41, 150, 150);
		frame.getContentPane().add(btnDecypherMessage);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setTitle("Stego App");
		frame.setVisible(true);
	}

	/**
	 * Serves as the entry point for the application.
	 */
	public static void main(String[] args) {
		try {
			new MainAppClass();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error starting program. Application closed.","Exception",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		} 
	}
}