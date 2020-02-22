import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "";
		
		try {
			String path = System.getProperty("user.dir") + "\\test";
			Scanner in=new Scanner(new File(path));
			while(in.hasNext()){
				str += in.nextLine();
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			String path = System.getProperty("user.dir") + "\\test";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			bw.write(str);
			bw.flush();
			bw.close();
			System.out.println("success");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
