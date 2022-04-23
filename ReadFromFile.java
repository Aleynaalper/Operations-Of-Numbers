import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadFromFile {
	
	
	public static void readFile1(String path) {
		try {
		int i = 0 ; 
		QueueControl queue=new QueueControl();
		StackControl stack= new StackControl();
		int length= Files.readAllLines(Paths.get(path)).size();
		String[] results=new String[length];
			for (String line : Files.readAllLines(Paths.get(path))) {
				results[i++]=line;
			}
			for(int j=0; j< results.length; j++) {
				String[] a=results[j].split(" ");
				if(a[0].equals("Q")) {
					if(a.length==2) {
						queue.Queuecontrol(a[1]);
						}
					else {
						int number=Integer.parseInt(a[2]);
						queue.Queuecontrol(a[1], number);
				}
				}
				else {
					if(a.length==2) {
						stack.Stackcontrol(a[1]);
						}
					else {
						int number=Integer.parseInt(a[2]);
						stack.Stackcontrol(a[1], number);
					}
				}
				
			}
		} catch(IOException e ) {
			e.printStackTrace();

		}

	}
	
	public static ArrayList<Integer> readFile2(String path) throws IOException {
		
		ArrayList<Integer> result2 = new ArrayList<Integer>();
		FileInputStream fstream = new FileInputStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String[] result1=br.readLine().split("\\s");
		for(int i=0;i<result1.length;i++) {
			int number= Integer.parseInt(result1[i]);
			result2.add(number);	
		}
		return result2;
		}
	
	
}


