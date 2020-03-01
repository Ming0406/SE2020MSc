import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadWriteFiles {

	/*
	 * This is the class to generate the method to read and write all the files.
	 * The method below is to write new lines below an existing text files.
	 * In order to achieve this you need to use BufferReader to read the existing file first, store them into a string value
	 * Then using BufferWriter to write the files.
	 */
	public String writeFiles(String path, String text) {
		// BufferReader, read the file into a String
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

		// BufferWriter, write the new line below that string.
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