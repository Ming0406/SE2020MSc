import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Account {
	
	private String name = "";
	private int password = 0;
	private int job = 0;
	public Account(String name, int password, int job){
		this.name = name;
		this.password = password;
		this.job = job;
	}
	
	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		}catch(CloneNotSupportedException e) {
			e.getStackTrace();
		}
		return o;
	}
	
	public String toString() {
		return "my name is " + name + ", my job is " + job;
	}
	
	
	public static void main(String arg[]) {
		String name;
		int password;
		int job;
		ArrayList<Account> accountList = new ArrayList<Account>();
		String fn = System.getProperty("user.dir") + "\\Employee Information";
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
		
		for (int i = 0; i < accountList.size(); i++) {
			System.out.println(accountList.get(i));
		}
	}

	public String getName() {
		return name;
	}

	public int getPassword() {
		return password;
	}

	public int getJob() {
		return job;
	}
}
