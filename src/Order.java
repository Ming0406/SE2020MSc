import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
	public Order() {}
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
	
	public void printOrder(ArrayList<String> orderList) {
		for (int i=0; i<orderList.size(); i++) {
			System.out.println(i + ". " + orderList.get(i));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
