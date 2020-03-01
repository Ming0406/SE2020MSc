import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * This class is built to read the files.
 * This class is generated to analyze the order files:
 * 	orderFromAdministrator, orderFromClassDirector, orderFromPTTDirector.
 * These three files contains many orders inside them and every line is a single order.
 * Therefore, this order is built to separate the order files line by line.
 * Every line is a single order so users can choose which order they want to solve this time.
 *
 */
public class Order {
	public Order() {}

	/*
	 * This method is to read every line of files into a string value.
	 * And use the ArrayList<String> to store all the string values.
	 */
	public ArrayList<String> getOrderList(String path){
		String realPath = System.getProperty("user.dir") + "\\" + path;
		ArrayList<String> orderList = new ArrayList<String>();
		try {

			FileReader fr = new FileReader(realPath);
			Scanner sc = new Scanner(fr);
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				orderList.add(line);
			}
		}catch(IOException e) {
			e.getStackTrace();
		}
		return orderList;
	}

	/*
	 * This method is to print the order list
	 */
	public void printOrder(ArrayList<String> orderList) {
		for (int i=0; i<orderList.size(); i++) {
			System.out.println(i + ". " + orderList.get(i));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}