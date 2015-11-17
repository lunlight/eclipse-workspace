package project_PPM;

import java.awt.Color;

public class Image {

	private Color[][] colors;
	int rows,columns,max;
	String header;
	long count;

	public Image( int columns,int rows, int max) {
		this.rows = rows;
		this.columns = columns;
		this.max = max;
		this.colors = new Color[columns][rows];
	}
	public Color getColor(int row, int col) {
		return colors[col][row];
	}
	public void setColors(int row, int col,int r, int g, int b) {
		colors[col][row]=new Color(r,g,b);
	}
	public int getRows() {
		return rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}

	public void setHeader(String header) {
		this.header = header;
	}
	public void setCount() {
		for (int i = 0; i < rows; i++) {
//			System.out.println("working...");
			for (int j = 0; j < columns; j++) {
				if(this.getColor(i, j).getRed()!=255)
					count++;
				if(this.getColor(i, j).getGreen()!=255)
					count++;
				if(this.getColor(i, j).getBlue()!=255)
					count++;
			}

		}
	}
	public long getCount() {
		return count;
	}
	@Override
	public String toString() {
		StringBuilder s= new StringBuilder();
		s.append(header+"\n"+columns+" "+ rows+"\n"+max+"\n");
		for (int i = 0; i < rows; i++) {
//			System.out.println("ToString is working...");
			for (int j = 0; j < columns; j++) {
				s.append(this.getColor(i, j).getRed()+" "+this.getColor(i, j).getGreen()+" "+this.getColor(i, j).getBlue()+" ");
			}
			s.append("\n");
		}
		return s.toString();
	}


}
