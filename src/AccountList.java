import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountList {
	private ArrayList<Account> accountList = new ArrayList<Account>();

	// this class is to scann the employee list and generate an arrayList to store all the information.
	public ArrayList<Account> getAccountList(){
		String name;
		int password;
		int job;
		String fn = System.getProperty("user.dir") + "\\Employee Information";
		return getAccounts(accountList, fn);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountList a = new AccountList();
		ArrayList<Account> accountList = a.getAccountList();
		for (int i = 0; i < accountList.size(); i++) {
			System.out.println(accountList.get(i));
		}

	}

}
