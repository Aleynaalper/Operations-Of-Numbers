import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
	
	public static void writestackout(String line) {
	File file = new File("stackOut.txt");
    try(BufferedWriter x = new BufferedWriter(new FileWriter(file,true))){
                x.write(line);
                x.newLine();
                x.close();
    } catch (IOException e) {
        System.out.println("Unable to read file " +file.toString());

    }
}
  
	public static void writequeueout(String line) {
	File file = new File("queueOut.txt");
    try(BufferedWriter x = new BufferedWriter(new FileWriter(file,true))){
                x.write(line);
                x.newLine();
                x.close();
    } catch (IOException e) {
        System.out.println("Unable to read file " +file.toString());

    }
	}
    
    public static void writequeue(String line) {
    	File file = new File("queue.txt");
        try(BufferedWriter x = new BufferedWriter(new FileWriter(file))){
                    x.write(line);
                    x.newLine();
                    x.close();
        } catch (IOException e) {
            System.out.println("Unable to read file " +file.toString());

        }   
    }
    
    public static void writestack(String line) {
    	File file = new File("stack.txt");
        try(BufferedWriter x = new BufferedWriter(new FileWriter(file))){
                    x.write(line);
                    x.newLine();
                    x.close();
        } catch (IOException e) {
            System.out.println("Unable to read file " +file.toString());

        }
    }
}
