import java.io.IOException;

public class Priority {
	
	private MaxPQ<String> queue;  
		
	public Priority() {
		
		this.queue= new MaxPQ<>();
	}
	
	
	public void addMemory(String data, int size) throws IOException{
		
		if(Structure.bst.contains(data)) {					
			//System.out.print("            ");
			Structure.filew.write("            ");

		}
		
		else {				
			Structure.pfCount++;

			if(Structure.array3.size() < size){ 
				queue.insert(data);
				Structure.bst.put(data, 0);
				Structure.array3.add(data);
				//System.out.print("Page Fault  ");
				Structure.filew.write("Page Fault  ");
			}
			
			else {				
				String max = queue.max();
				queue.delMax();
				Structure.bst.deleteMax();
				int indexNum = Structure.array3.indexOf(max);	
				Structure.array3.set(indexNum, data);				
				queue.insert(data);
				Structure.bst.put(data, 0);
				//System.out.print("Page Fault  ");
				Structure.filew.write("Page Fault  ");

			}
			
		}
		
		for(int i=0;i<Structure.array3.size();i++){
			//System.out.print(Assignment2.array3.get(i)+" ");
			Structure.filew.write(Structure.array3.get(i)+" ");

		}
		
		//System.out.println(" ");
		Structure.filew.write("\r\n");

	}

}
