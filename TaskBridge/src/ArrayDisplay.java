import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ArrayDisplay {
	private int[][] arr;
	private int row, col;
	Scanner sc = new Scanner(System.in);

	void getInput() throws IOException {
		System.out.println("Enter Row value");
		row = sc.nextInt();
		System.out.println("Enter Colonm value");
		col = sc.nextInt();
		
		arr = new int[row][col];
		System.out.println("Enter Row*col value");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		print(arr,row,col);

	}
	

	public static void print(int[][] array,int row,int col) throws IOException {
		  OutputStream os = System.out;
		  PrintWriter writer = new PrintWriter(new OutputStreamWriter(os));
		  System.out.println("Enterd Values are::");
		  try {
		    for (int i=0;i<row;i++) {
		    	for(int j=0;j<col;j++)
		    	{
		      writer.println(array[i][j]);
		    	}
		    }
		    writer.flush();
		  } finally {
		    writer.close();
		  }
		}

	
	
	public static void main(String[] args) throws IOException {
		ArrayDisplay ob=new ArrayDisplay();
		ob.getInput();
		

		

	}

}
