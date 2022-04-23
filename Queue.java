import java.util.ArrayList;

public class Queue<E> {
	
	ArrayList<Integer> y= new ArrayList<Integer>();
	
		public void enqueue(Integer a) {
			y.add(a);
		}
		
		public int dequeue() {
			int b=y.get(0);
			y.remove(0);
			return b;	
			}
		
		public int peek() {
			return y.get(0);
		}
		
		public boolean empty() {
			if(y.size()==0) {
				return true;
			}
			else {
				return false;
			}
		}
		
		public int size() {
			return y.size();
		}
		
		public String toString() {
			String result="";
			for(int i=0;i<y.size();i++) {
				result+=y.get(i)+" ";
			}
			return result;
		}

}
