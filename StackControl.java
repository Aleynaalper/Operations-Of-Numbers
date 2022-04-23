import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class StackControl {
	
	static Stack<Integer> stack=new Stack<Integer>();
	
	public static void FirstStack() throws IOException {
		ArrayList<Integer> stack1=ReadFromFile.readFile2("stack.txt");
		for(int i=stack1.size()-1; i>=0;i--) {
			stack.push(stack1.get(i));
		}
	}

	
	public void Stackcontrol(String control) {
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
	public void Stackcontrol(String control, int number) {
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
		int[] array=new int[stack.size()];
		int size=stack.size();
		
		for(int i=0; i<size;i++) {
			int value=stack.pop();
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
	        
	        for(int i=array.length-1;i>=0;i--) {
				stack.push(array[i]);
			} 
	        Write.writestackout("After sortElements:");
	        Write.writestackout(stack.toString());
	        Write.writestack(stack.toString());
		}

	
	public void distinctElements() {
		HashSet<Integer> hashset = new HashSet<Integer>();
		ArrayList<Integer> arraylist = new ArrayList<Integer>(); //*
		int size=stack.size();
		
		for(int i=0; i<size;i++) {
			int value=stack.pop(); 
			arraylist.add(value);//*
			hashset.add(value);	
		}
		
		int differents=hashset.size(); //*
		for(int i = arraylist.size()-1;i>=0;i--) { //*
			stack.push(arraylist.get(i)); //*
		}
		
		Write.writestackout("After distinctElement:");
		Write.writestackout("Total distinct element="+differents);
		Write.writestack(stack.toString());
		
	}
	
	public void calculateDistance() {
		ArrayList<Integer> arraylist = new ArrayList<Integer>(); 

		int[] array=new int[stack.size()];
		int size=stack.size();
			
			for(int i=0; i<size;i++) {
				int value=stack.pop();
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
		for(int i = arraylist.size()-1;i>=0;i--) { //*
			stack.push(arraylist.get(i)); //*
		}
		
		Write.writestackout("After calculateDistance:");
		Write.writestackout("Total distance="+distance);
	
	}
	
	public void addOrRemove(int number) {
		if(number>0) {
			Random random=new Random(); //okey
			int i=0;
			while(number>i) {
			int a=random.nextInt(50);
			stack.push(a);
			i++;
			}
		}
		else {
			int i=0;
			while(-number>i) {
				int a=stack.pop();
				i++;
				}	
		}
		Write.writestackout("After addOrRemove "+number+":");
	    Write.writestackout(stack.toString());
	    Write.writestack(stack.toString());
	}
	
	public void removeGreater(int number) {
		
	int[] array=new int[stack.size()];
	int j=stack.size();
			
			for(int i=0; i<j;i++) {
				int value=stack.pop();
				array[i]=value;
			}
			
			for(int i=array.length-1;i>=0;i--) {
				if(array[i]>number) {
					continue;
				}
				else {
				stack.push(array[i]);
				}
			}
			Write.writestackout("After removeGreater "+number+":");
			Write.writestackout(stack.toString());
			Write.writestack(stack.toString());
	}
	public void reverse(int number) {
		
		int[] array=new int[stack.size()];
		int j=stack.size();
		
		for(int i=0; i<j;i++) {
			int value=stack.pop();
			array[i]=value;
		}
		for(int i=array.length-1;i>=number;i--) {
			stack.push(array[i]);
		}
		
		for(int i=0;i<number;i++) {
			stack.push(array[i]);
		}

		Write.writestackout("After reverse "+number+":");
		Write.writestackout(stack.toString());
		Write.writestack(stack.toString());
		
	}
}
