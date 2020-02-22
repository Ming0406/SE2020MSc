import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadWriteFiles {
	
	
	public String writeFiles(String path, String text) {
		String str = "";
		try {
			String realPath = System.getProperty("user.dir") + "\\" + path;
			Scanner in=new Scanner(new File(realPath));
			while(in.hasNext()){
				str += in.nextLine();
				str += "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		str += text;
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			bw.write(str);
			bw.flush();
			bw.close();
			System.out.println("success");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	
	public void readFile(String path) {
		String realPath = System.getProperty("user.dir") + "\\" + path;
		String str = "";
		try {
			Scanner in=new Scanner(new File(realPath));
			while(in.hasNext()){
				str += in.nextLine();
				str += "\n";
			}
		}catch(IOException e) {
			e.getStackTrace();
		}
		
		System.out.println(str);
	}
}
