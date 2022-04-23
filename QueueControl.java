import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class QueueControl {
	
	static Queue<Integer> queue=new Queue<Integer>();
	
	public static void FirstQueue() throws IOException {
		ArrayList<Integer> stack1=ReadFromFile.readFile2("queue.txt");
		for(int i=0; i<stack1.size();i++) {
			queue.enqueue(stack1.get(i));
		}
	}

	
	public void Queuecontrol(String control) {
		if(control.equals("sortElements")) {
			sortElements();
		}
		else if(control.equals("distinctElements")) {
			distinctElements();
		}
		else if(control.equals("calculateDistance")) {
			calculateDistance();
		}
			
		
	}
	public void Queuecontrol(String control, int number) {
			if(control.equals("addOrRemove")) {
				addOrRemove(number);
			}
			else if(control.equals("removeGreater")) {
				removeGreater(number);
				
			}
			else if(control.equals("reverse")) {
				reverse(number);
			}
		}
	
	public void sortElements() {
	int[] array=new int[queue.size()];
	int size=queue.size();
			
			for(int i=0; i<size;i++) {
				int value=queue.dequeue();
				array[i]=value;
			}
			
			int n = array.length; 
			
	        for (int k = 0; k < n-1; k++) {
	            for (int j = 0; j < n-k-1; j++) {
	                if (array[j] > array[j+1]) {
	                    int temp = array[j]; 
	                    array[j] = array[j+1]; 
	                    array[j+1] = temp; 
	                }
	            }
			}
	        
	        for(int i=0;i<array.length;i++) {
				queue.enqueue(array[i]);
			} 
	        Write.writequeueout("After sortElements:");
	        Write.writequeueout(queue.toString());
	        Write.writequeue(queue.toString());
		
	}
	
	public void distinctElements() {
		HashSet<Integer> hashset = new HashSet<Integer>();
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		int size=queue.size();
			
			for(int i=0; i<size;i++) {
				int value=queue.dequeue(); 
				arraylist.add(value);//*
				hashset.add(value);	
			}
			
			int differents=hashset.size(); //*
			for(int i =0;i<arraylist.size();i++) { //*
				queue.enqueue(arraylist.get(i)); //*
			}
			Write.writequeueout("After distinctElement:");
			Write.writequeueout("Total distinct element="+differents);
			Write.writequeue(queue.toString());
	}
	
	public void calculateDistance() {
		ArrayList<Integer> arraylist = new ArrayList<Integer>(); 

		int[] array=new int[queue.size()];
		int size=queue.size();
			
			for(int i=0; i<size;i++) {
				int value=queue.dequeue();
				arraylist.add(value);
				array[i]=value;
			}
			
			int j=0;
			int distance=0;
			while(j<array.length-1) {
				for(int i=j+1; i<array.length;i++) {
					int value=Math.abs(array[i]-array[j]);
					distance+=value;
				}
				j++;		
			}
			for(int i =0;i<arraylist.size();i++) { //*
				queue.enqueue(arraylist.get(i));
			}
			
			Write.writequeueout("After calculateDistance:");
			Write.writequeueout("Total distance="+distance);
			Write.writequeue(queue.toString());
		
	}
	
	public void addOrRemove(int number) {
		if(number>0) {
			Random random=new Random(); 
			int i=0;
			while(number>i) {
			int a=random.nextInt(50);
			queue.enqueue(a);
			i++;
			}
		}
		else {
			int i=0;
			while(-number>i) {
				int a=queue.dequeue();
				i++;
				}	
		}
		
		Write.writequeueout("After addOrRemove "+number+":");
	    Write.writequeueout(queue.toString());
	    Write.writequeue(queue.toString());
		
	}
	public void removeGreater(int number) {
		int[] array=new int[queue.size()];
		int j=queue.size();
				
				for(int i=0; i<j;i++) {
					int value=queue.dequeue();
					array[i]=value;
				}
				
				for(int i=0;i<array.length;i++) {
					if(array[i]>number) {
						continue;
					}
					else {
					queue.enqueue(array[i]);
					}
				}
				
				Write.writequeueout("After removeGreater "+number+":");
				Write.writequeueout(queue.toString());
				Write.writequeue(queue.toString());
		
	}
	public void reverse(int number) {
		int[] array=new int[queue.size()];
		int size=queue.size();
		
		for(int i=0; i<size;i++) {
			int value=queue.dequeue();
			array[i]=value;
		}
		for(int i=number-1;i>=0;i--) {
			queue.enqueue(array[i]);
		}
		for(int i=number;i<array.length;i++) {
			queue.enqueue(array[i]);
		}
		
		Write.writequeueout("After reverse "+number+":");
		Write.writequeueout(queue.toString());
		Write.writequeue(queue.toString());
	}
}
