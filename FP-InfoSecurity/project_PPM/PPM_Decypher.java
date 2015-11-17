/**
 * PPM_Decypher.java
 * Course: SICI-4997; Final Presentation 
 */

package project_PPM;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PPM_Decypher {
	
	public static boolean canceled = false;

	/**
	 * Routine to select a file.
	 */
	public void fileSelect(){
		try {
			PrintWriter writter = new PrintWriter(new File("output.txt"));
			byte[] bytes = null,bytes2=null;
			String s1,s2;
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Portable Pixmap Format (*.ppm)", "ppm");
			chooser.setDialogTitle("Choose the original image.");
			chooser.addChoosableFileFilter(filter);
			chooser.setFileFilter(filter);
			chooser.setAcceptAllFileFilterUsed(false);

			int option = chooser.showOpenDialog(null);
			if(option == JFileChooser.APPROVE_OPTION){
				bytes =Files.readAllBytes(chooser.getSelectedFile().toPath());//reads whole file
			}
			else if (option == JFileChooser.CANCEL_OPTION){
				canceled = true;
				MainAppClass.frame.setVisible(true);
				return;
			}
			else{
				canceled = true;
				MainAppClass.frame.setVisible(true);
				return;
			}

			JOptionPane.showMessageDialog(null, "Escoge la Stego Imagen.","Information",JOptionPane.INFORMATION_MESSAGE);

			chooser = new JFileChooser();
			chooser.setDialogTitle("Choose the Stego Image (original altered).");
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			chooser.addChoosableFileFilter(filter);
			chooser.setFileFilter(filter);
			chooser.setAcceptAllFileFilterUsed(false);

			option = chooser.showOpenDialog(null);

			if(option == JFileChooser.APPROVE_OPTION){
				bytes2 =Files.readAllBytes(chooser.getSelectedFile().toPath());//reads whole file

			}
			else if (option == JFileChooser.CANCEL_OPTION){
				canceled = true;
				MainAppClass.frame.setVisible(true);
				return;
			}
			else{
				canceled = true;
				MainAppClass.frame.setVisible(true);
				return;
			}
			s2= new String(bytes, "UTF-8");//prepara los archivos
			s1= new String(bytes2, "UTF-8");

			Scanner scan1 = new Scanner(s1);//lee los string
			Scanner scan2 = new Scanner(s2);
			for (int i = 0; i < 3; i++) {//quita los header
				scan1.nextLine();
				scan2.nextLine();
			}
			int[] letter= new int[8];//este arreglo tendrá el valor binario de cada caractér
			int count =0;
			String temp = scan1.nextLine();//comienza a leer
			Scanner tempscan1 = new Scanner(temp);
			loop://el loop se acabacuando no se cumple el while
				while(scan2.hasNext()){//verifica que quede algo mas
					String temp2 = scan2.nextLine();
					@SuppressWarnings("resource")
					Scanner tempscan2 = new Scanner(temp2);

					while(tempscan2.hasNextInt()) {//lee los numeros
						int frst = tempscan1.nextInt(), 
								scnd=tempscan2.nextInt();
						if(frst!=255){
							letter[count++]=frst-scnd;//hacela compración de el archivo origina y el stegoimagen
							if(count==8){
								String temp1 ="";
								boolean flag = false;
								for (int i : letter) {//va creando el string del mensaje
									if(!flag&&i==1)
										flag=true;
									temp1=temp1+i;
								}
								if(!flag)
									break loop;//se sale del ciclo
								//convierte a caracteres 
								writter.write((char)Integer.parseInt(Long.toHexString(Long.parseLong(temp1,2)),16));
								letter= new int[8];//borra el arreglo
								count=0;
							}
						}
					}
				}
			writter.close();
			//JOptionPane.showMessageDialog(null, "All I/O closed.","Notification",JOptionPane.WARNING_MESSAGE);
			save();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error1",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Routine to save a file.
	 */
	public void save(){
		JOptionPane.showMessageDialog(null, "Choose where to save the file.","Information",JOptionPane.INFORMATION_MESSAGE);
		try {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Portable Pixmap Format (.ppm)", "ppm");
			chooser.addChoosableFileFilter(filter);
			FileNameExtensionFilter filter2 = new FileNameExtensionFilter("Text File (.txt)", "txt");
			chooser.addChoosableFileFilter(filter2);
			chooser.setFileFilter(filter);
			chooser.setAcceptAllFileFilterUsed(false);

			int option = chooser.showSaveDialog(null);
			if(option == JFileChooser.APPROVE_OPTION){
				String[] ext = chooser.getFileFilter().getDescription().split("[(]");
				ext = ext[1].split("[)]");
				String extension=ext[0];
				try(FileWriter fw = new FileWriter(chooser.getSelectedFile()+extension)) {
					byte[] bytesou =Files.readAllBytes(Paths.get("output.txt"));

					fw.write(new String(bytesou, "UTF-8"));
					fw.close();
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}		
	}
}