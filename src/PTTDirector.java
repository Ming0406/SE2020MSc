import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PTTDirector extends Account{
	private String name;
	private int password;
	private int job;
	private ArrayList<String> orderList = new ArrayList<String>();
	public PTTDirector(String name, int password, int job) {
		super(name, password, job);
		// TODO Auto-generated constructor stub
		this.name = name;
		this.password = password;
		this.job = job;
	}	
	
	public void sendCommand() {
		String path = "OrderFromAdministrator";
		String fn = System.getProperty("user.dir") + "\\" + path;
		Order o = new Order();
		orderList = o.getOrderList(path);
		System.out.println("Which order do you want to solve? ");
		o.printOrder(orderList);
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		String order = orderList.get(num);
		System.out.println("How do you gonna handle this request? approve/disapprove");
		System.out.println(" --" + order);
		Scanner sc = new Scanner(System.in);
		String comment = "";
		comment += sc.nextLine();
		
		String cmd = order + "( PTTDirector: " + comment + ")";
		ReadWriteFiles rf = new ReadWriteFiles();
		String path2 = "OrderFromPTTDirector";
		rf.writeFiles(path2, cmd);
	}
	
	public static void main(String args[]) {
		PTTDirector pd = new PTTDirector("name", 222, 2);
		pd.sendCommand();
	}
}
