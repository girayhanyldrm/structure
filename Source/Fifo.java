import java.io.IOException;
import java.util.ArrayList;

public class Fifo {

	
	public static boolean bst(ArrayList<String> array,String data){ 
       if(!array.contains(data)){
    	   return true;
       }
       return false;
	}
	
	public static void ekle(String data,ArrayList<String> array,int index) throws IOException{
		int size=array.size();
		int point = index % size;
		
		if(bst(array,data)){
			array.set(point,data);
			Structure.index=index+1;
			Structure.filew.write("Page Fault  ");
			//System.out.print("Page Fault  ");
			Structure.pfCount++;
		}
		
		else{
			//System.out.print("    	    ");
			Structure.filew.write("    	    ");

		}
		for(int i=0;i<size;i++){
			//System.out.print(array.get(i)+" ");
			Structure.filew.write(array.get(i)+" ");
		}
		//System.out.println(" ");
		Structure.filew.write("\r\n");
	}
}
