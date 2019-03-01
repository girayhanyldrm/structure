import java.io.IOException;
import java.util.ArrayList;

public class SecondChance {
	
	
	public int bit;
	public String data;
	
	
	
	
	
	public SecondChance(int bit, String data) {
		
		this.bit=bit;
		this.data=data;
	}
	
	public int getBit() {
		return bit;
	}

	public void setBit(int bit) {
		this.bit = bit;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	public static void degistir(){
		
	}
	
	
	public static boolean bstCall(ArrayList<SecondChance> array,String data, int point) throws IOException{
		for(int i =0;i<array.size();i++){
			if(array.get(i).data.equals(data)){
				point=i;

			}
		}
		if (Structure.bst.contains(data)) {
			array.get(point).setBit(1);
			//System.out.print("            ");
			Structure.filew.write("            ");

			return false;
		}
		//System.out.print("Page Fault  ");
		Structure.filew.write("Page Fault  ");
		Structure.pfCount++;
		return true;
	}
	
	
	public static void ekle(int bit , String data , int size,ArrayList<SecondChance> array,int index) throws IOException{
		int point = index % size;

		if(array.size()<size){
			if(bstCall(array,data,point)){   
				SecondChance object=new SecondChance(0,data);
				Structure.bst.put(data, 0);
				array.add(object);
				Structure.index=index+1;
			}

		}
		else{
			if(bstCall(array,data, point)){
				while(array.get(point).getBit()==1){
					array.get(point).setBit(0);
					Structure.chance.add(array.get(point).getData());
					index++;
					point = index%size;
				}
				Structure.bst.delete(array.get(point).getData());
				array.get(point).setBit(0);
				array.get(point).setData(data);
				Structure.bst.put(data, 0);
				Structure.index=index+1;
			}
		}
		for(int i=0;i<array.size();i++){
			//System.out.print(array.get(i).data+" ");
			Structure.filew.write(array.get(i).data+" ");

		}
		if(Structure.chance.size()>0){
			//System.out.print("Second Chance ");
			Structure.filew.write("Second Chance ");

			for(int i=0;i<Structure.chance.size();i++){
				//System.out.print(Assignment2.chance.get(i)+" ");
				Structure.filew.write(Structure.chance.get(i)+" ");

			}
		}
		Structure.chance.clear();
		//System.out.println(" ");
		Structure.filew.write("\r\n");

	}

}
