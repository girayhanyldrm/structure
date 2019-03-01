import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import java.util.ArrayList;

public class Structure { 

	private static Scanner input;
	public static  Priority pq;
	public static FileWriter filew;
	public static int index=0;
	public static ArrayList<String> array=new ArrayList<String>();   
	public static ArrayList<SecondChance> array2=new ArrayList<SecondChance>();
	public static ArrayList<String> array3 = new ArrayList<String>();
	public static int memorySize;
	public static int pfCount=0;
	public static BST<String, Integer> bst = new BST<String, Integer>();
	public static ArrayList<String> chance= new ArrayList<String>();

	public static void main(String[] args) throws IOException{
		String type = null;	
		File file = new File(args[0]);
		filew = new FileWriter("output.txt");
		long timeStart =System.currentTimeMillis();
		try{

			input = new Scanner(file);
			while(input.hasNextLine()){
				String data = input.nextLine();
				String[] veri=data.split(" ");
				
				if(veri[0].equals("SetMemory")){
					memorySize=Integer.parseInt(veri[1]);
					for(int i=0;i<memorySize;i++){
						array.add(" ");
					}
					filew.write("Memory "+memorySize+"\r\n");
				}
				
				else if(veri[0].equals("setReplacement")){
					
					type=veri[1];
					if (type.equals("PriorityQueue")) {
						pq = new Priority();
						filew.write("Priority Queue Page Replacement\r\n");
						
					}
					else if(type.equals("FIFO")) {
						filew.write("FIFO Page Replacement\r\n");

					}
					else if (type.equals("SecondChance")) {
						filew.write("Second Chance Page Replacement\r\n");

					}
					filew.write("Binary Search Tree\r\n");

				}
				
				else if(veri[0].equals("Read")){
					
					if(type.equals("FIFO")){

						Fifo.ekle(veri[1], array, index);
						

					}
					else if(type.equals("SecondChance")){
						SecondChance.ekle(0,veri[1],memorySize,array2,index);
					}
					
					else if(type.equals("PriorityQueue")){
						
						pq.addMemory(veri[1], memorySize);
							
					}
				}
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		long timeEnd = System.currentTimeMillis();
		long timeDelta = timeEnd-timeStart;
		double times =timeDelta/1000.0;
		Structure.filew.append(String.valueOf(pfCount)+"\r\n");
		Structure.filew.write("Execution Time: "+String.valueOf(times+"\r\n"));
		Structure.filew.close();
}
	
	
}