import java.util.ArrayList;
import java.util.Scanner;

/*
 * Administrator is most complex class, because administrators need to connect all other three teaching staff.
 * Summarize the function of Administrator class:
 * 	1. read the order from class directors.
 * 	2. send the requirement to PTT directors.
 * 	3. read the agreement from PTT directors.
 * 	4. generate the training list and send to teachers.
 */

public class Administrator extends Account{

	private String name;
	private int password;
	private int job;
	private ArrayList<String> OFromClass = new ArrayList<String>();
	private ArrayList<String> OFromPTT = new ArrayList<String>();
	public Administrator(String name, int password, int job) {
		super(name, password, job);
		// TODO Auto-generated constructor stub
		this.name = name;
		this.password = password;
		this.job = job;
	}

	// read the order form class director. Using the .getOrderList() of order class.
	public void readOrder() {
		String path = "OrderFromClassDirector";
		Order order = new Order();
		OFromClass = order.getOrderList(path);
		order.printOrder(OFromClass);
	}

	// print all teachers information.
	public void printTeacherInfo() {
		AccountList a = new AccountList();
		ArrayList<Account> accountList = a.getAccountList();
		for (int i=0 ; i<accountList.size(); i++) {
			if(accountList.get(i).getJob() == 4 || accountList.get(i).getJob() == 5 || accountList.get(i).getJob() == 6) {
				System.out.println(accountList.get(i));
			}
		}

	}

	// Give request to PTT Director, the result will be stored in the OderFromAdministrator.txt.
	public void sendRequest() {
		AccountList a = new AccountList();
		ArrayList<Account> accountList = a.getAccountList();
		System.out.println("Now, we are generating the work list, which will be sent to PTT director.");
		System.out.println("Who need to be trained? You can choose from teachers' list: ");

		for (int i=0 ; i<accountList.size(); i++) {
			if(accountList.get(i).getJob() == 4 || accountList.get(i).getJob() == 5 || accountList.get(i).getJob() == 6) {
				System.out.print(accountList.get(i).getName() + " |");
			}
		}

		Scanner in =  new Scanner(System.in);
		String name = in.nextLine();

		System.out.println("Which class do you want to send them? Choose from below");
		for (int i=0 ; i<accountList.size(); i++) {
			if(accountList.get(i).getJob() == 1) {
				System.out.print(accountList.get(i).getName() + " |");
			}
		}
		String className = in.nextLine();
		System.out.println("Write down the training of the teacher:");
		String training = in.nextLine();
		Request request = null;
		for (int i=0; i<accountList.size(); i++) {
			if(accountList.get(i).getName().equals(name)) {
				request = new Request(accountList.get(i).getName(), className, training);
				request.sendRequest();
			}
		}
	}

	// checkPTTComand is check the order from PTT Director
	public void checkPTTCommand() {
		Order order = new Order();
		String path = "OrderFromPTTDirector";
		OFromPTT = order.getOrderList(path);
		order.printOrder(OFromPTT);
	}

	// give the training list to teachers.
	public void giveOrder() {
		AccountList a = new AccountList();
		Scanner in = new Scanner(System.in);
		System.out.println("Select a teacher:");
		ArrayList<Account> accountList = a.getAccountList();
		for (Account account : accountList) {
			if (account.getJob() == 4 || account.getJob() == 5 || account.getJob() == 6) {
				System.out.print(account.getName() + " |");
			}
		}

		String str = in.nextLine();
		str += " ";
		System.out.println("Which class do you want to send them? Choose from below");
		for (int i=0 ; i<accountList.size(); i++) {
			if(accountList.get(i).getJob() == 1) {
				System.out.print(accountList.get(i).getName() + " |");
			}
		}
		str += in.nextLine();
		str += " ";
		System.out.println("Write down a training:");
		str += in.nextLine();
		String path = "TrainingList";
		ReadWriteFiles rf = new ReadWriteFiles();
		rf.writeFiles(path, str);
	}

	// Test the Administrator
	public static void main(String args[]) {
		Administrator a = new Administrator("Jin", 222, 2);
		System.out.println("**************READ THE CLASS DIRECTORS' ORDER*********************");
		a.readOrder();
		System.out.println("**************CHECK THE PTT DIRECTORS' COMMAND*********************");
		a.checkPTTCommand();
		System.out.println("**************GIVE ORDER TO TEACHERS*****************************");
		a.giveOrder();
		System.out.println("**************CHECK THE PTT DIRECTORS' COMMAND*********************");
		a.checkPTTCommand();
	}
}
