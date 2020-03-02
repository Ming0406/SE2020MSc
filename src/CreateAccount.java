import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * This class allowed teaching staff to create their own account
 * Account object requires three things: name, password and job
 * using a string variables to carry them and write into a txt file.
 */
public class CreateAccount {

	public String createAccount() {
		String str = "";
		Scanner in = new Scanner(System.in);
		System.out.println("input your account name:");
		str += in.nextLine();
		str += " ";
		System.out.println("input your password:");
		str += in.nextLine();
		str += " ";
		System.out.println("Input your job:\r\n" +
				"(1)	class director\r\n" +
				"(2)	administrator\r\n" +
				"(3)	PPT director\r\n" +
				"(4)	Math teacher\r\n" +
				"(5)	English teacher\r\n" +
				"(6)	Computer teacher\r\n" +
				"");
		str += in.nextLine();
		str += "\n";

		String path = "Employee Information";
		ReadWriteFiles rf = new ReadWriteFiles();
		rf.writeFiles(path, str);
		System.out.println("Account has been created");
		return str;
	}

	public ArrayList<Account> getAccountList() {
		String name;
		int password;
		int job;
		ArrayList<Account> accountList = new ArrayList<Account>();
		String fn = "Employee Information";
		return getAccounts(accountList, fn);
	}

	public ArrayList<Account> getAccounts(ArrayList<Account> accountList, String fn) {
		String name;
		int password;
		int job;
		try {
			FileReader fr = new FileReader(fn);
			Scanner sc = new Scanner(fr);
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				Scanner sl = new Scanner(line);
				name = sl.next();
				password = sl.nextInt();
				job = sl.nextInt();
				Account account = new Account(name, password, job);
				accountList.add(account);
			}
		}catch(IOException e) {
			e.getStackTrace();
		}

		return accountList;
	}

	public void checkYourJob(String name, int password) {
		ArrayList<Account> accountList = getAccountList();
		for(int i = 0; i<accountList.size(); i++) {
			Account account = accountList.get(i);
			if(account.getName().equals(name) && account.getPassword() == password) {
				System.out.println("your job is " + account.getJob());
			}
		}
	}


	public static void main(String arg[]) {
		CreateAccount ca = new CreateAccount();
		ca.createAccount();
	}
}