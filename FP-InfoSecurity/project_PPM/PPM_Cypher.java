/**
 * PPM_Cypher.java
 * This class file serves as the message hidder
 * withing an image.
 * Authors: 
 * Course: SICI-4997; Final Presentation 
 */

package project_PPM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PPM_Cypher {

	private BufferedReader buffer;
	private PrintWriter writter;
	private File file;
	private Scanner filescaner;
	public static boolean canceled = false;
	private Image image, otherimage;
	private int columns,rows,max,row=0,col=0;
	private boolean first = true, second = true;

	/**
	 * Routine to select a file.
	 */
	public void fileSelect(){
		String header="";
		try {
			writter =new PrintWriter(new File("temporary.ppm"));
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Portable Pixmap Format (*.ppm)", "ppm");
			chooser.setDialogTitle("Choose an image to hide in.");
			chooser.addChoosableFileFilter(filter);
			chooser.setFileFilter(filter);
			chooser.setAcceptAllFileFilterUsed(false);

			int option = chooser.showOpenDialog(null);
			if(option == JFileChooser.APPROVE_OPTION){
				buffer = new BufferedReader(new FileReader(chooser.getSelectedFile().getAbsolutePath()));
				String line = null;
				int i =0;

				while((line = buffer.readLine()) != null ){
					@SuppressWarnings("resource")
					Scanner scn = new Scanner(line);
					if(i>2){
						if(first){
							image = new Image(columns, rows, max);	//constructs image with already gathered data
							image.setHeader(header);//adds header
							first = false;
						}
						while(scn.hasNextInt()){
							image.setColors(row, 
									col++, scn.nextInt(),scn.nextInt(),scn.nextInt());//fills image class with its colors
							if(col==image.getColumns()){
								col =0;
								row++;
							}
						}

					}
					else{
						if(i==0)
							header= scn.next();//gets tittle

						if(i==1){
							columns = scn.nextInt();//gets columns
							rows = scn.nextInt();// gets rows
						}
						else if(i==2)
							max = scn.nextInt();// gets max pixels
						i++;}
				}
				buffer.close();

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
		} catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Routine to encrypt and hide message.
	 */
	public void toNumberArray(String msg,int choice) {
		if(choice==1)
		{//if choice is an image
			String header="";
			row=0;
			col=0;
			//resets data variables
			try {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Portable Pixmap Format (*.ppm)", "ppm");
				chooser.setDialogTitle("Choose an image to hide.");
				chooser.addChoosableFileFilter(filter);
				chooser.setFileFilter(filter);
				chooser.setAcceptAllFileFilterUsed(false);

				int option = chooser.showOpenDialog(null);
				if(option == JFileChooser.APPROVE_OPTION){
					buffer = new BufferedReader(new FileReader(chooser.getSelectedFile().getAbsolutePath()));
					String line = null;
					int i =0;

					while((line = buffer.readLine()) != null ){

						@SuppressWarnings("resource")
						Scanner scn = new Scanner(line);
						while(scn.hasNext()){
							if(i>2){
								if(second){
									otherimage = new Image(columns, rows, max);	//creates another image with gathered data
									otherimage.setHeader(header);//adds header
									second = false;
								}
								while(scn.hasNextInt()){
									otherimage.setColors(row, 
											col++, scn.nextInt(),scn.nextInt(),scn.nextInt());//fills image pixels with the appropiate colors
									if(col==otherimage.getColumns()){
										col =0;
										row++;
									}
								}

							}
							else{
								if(i==0)
									header= scn.next();//gets header

								if(i==1){
									columns = scn.nextInt();//gets columns
									rows = scn.nextInt();//gets rows
								}
								else if(i==2)
									max = scn.nextInt();//gets max
								i++;}
						}
					}
					buffer.close();

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
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			}finally{
				try {
					buffer.close();
				} catch (IOException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "will not bow"+e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			msg=otherimage.toString();
		}

		byte[] bytemsg = msg.getBytes();
		int bit=-1;
		row=0;
		col=0;
		int i=0;
		ArrayList<Character> msgbinArray = new ArrayList<Character>();
		image.setCount();
		if(Byte.SIZE*bytemsg.length>image.getCount()){//compares usable pixels in image vs bytes in message to check if it fits
			JOptionPane.showMessageDialog(null, "Too big of a message");
			System.exit(0);

		}


		//
		// 
		//
		for (int j = 0; j < Byte.SIZE*bytemsg.length; j++) {
			msgbinArray.add((bytemsg[j/Byte.SIZE]<< j%Byte.SIZE & 0x80)==0?'0':'1');
			bit = Integer.parseInt(""+msgbinArray.get(j));

			while(bit!=-1){//usa -1 como sentinela
				switch (i%3) {//esconde el bit en el color correspondiente
				case 0: //si el rojo tiene espacio se le añade el bit y se sale
					if(image.getColor(row, col).getRed()!=255){
						image.setColors(row, col, image.getColor(row, col).getRed()+bit, image.getColor(row, col).getGreen(), image.getColor(row, col).getBlue());
						bit=-1;//resets sentinel
					}
					i++;
					break;
				case 1: //si el verde tiene espacio se le añade el bit y se sale
					if(image.getColor(row, col).getGreen()!=255){
						image.setColors(row, col, image.getColor(row, col).getRed(), image.getColor(row, col).getGreen()+bit, image.getColor(row, col).getBlue());
						bit=-1;//resets sentinel
					}
					i++;
					break;
				case 2: //si el azul tiene espacio se le añade el bit y se sale
					if(image.getColor(row, col).getBlue()!=255){
						image.setColors(row, col, image.getColor(row, col).getRed(), image.getColor(row, col).getGreen(), image.getColor(row, col).getBlue()+bit);
						bit=-1;//resets sentinel
					}
					i++;
					col++;
					if(col==image.getColumns()){
						col =0;
						row++;
						if(row==image.getRows()){//keeps checking if message is too big
							JOptionPane.showMessageDialog(null, "Too big of a message");
							System.exit(0);
						}
					}
					break;
				}
			}
		}

		row=col=0;//resets row and col
		writter.write(image.toString());//writes to temp
		writter.close();
//		JOptionPane.showMessageDialog(null, "All I/O closed.","Notification",JOptionPane.WARNING_MESSAGE);
		save();

	}

	/**
	 * Routine to save a file.
	 */
	public void save(){
		JOptionPane.showMessageDialog(null, "Choose where to save the file.","Information",JOptionPane.INFORMATION_MESSAGE);
		try {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Portable Pixmap Format (*.ppm)", "ppm");
			chooser.addChoosableFileFilter(filter);
			chooser.setFileFilter(filter);
			chooser.setAcceptAllFileFilterUsed(false);
			file = new File("temporary.ppm");
			filescaner = new Scanner(file);//scans temp

			int option = chooser.showSaveDialog(null);
			if(option == JFileChooser.APPROVE_OPTION){
				try(FileWriter fw = new FileWriter(chooser.getSelectedFile()+".ppm")) {
					while(filescaner.hasNextLine()){//saves temp to file on disk
						fw.write(filescaner.nextLine()+"\n");
					}
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}finally{
			try {
				buffer.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, ""+e.toString(),"Error",JOptionPane.ERROR_MESSAGE);
			}
		}		
	}
}