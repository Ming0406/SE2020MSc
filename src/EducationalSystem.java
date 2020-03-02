import java.util.ArrayList;
import java.util.Scanner;

/*
 * Overall Education System. Login the account and do the job based on the different job.
 */
public class EducationalSystem {
    private Account a = new Account("Empty", 000, 0);
    private String outCommand = "";
    
    public void printWorkList() {
    	System.out.println("************************\n" + 
    					   "*        work list     *\n" +
    					   "************************\n");
    					
    }
    
    public Account login() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input your name: ");
        String str = in.nextLine();
        System.out.println("Input your password: ");
        int password = in.nextInt();

        AccountList al = new AccountList();
        ArrayList<Account> accountList = al.getAccountList();

        for(int i = 0; i < accountList.size(); i++) {
            if(accountList.get(i).getName().equals(str) && accountList.get(i).getPassword() == password) {
                a = accountList.get(i);
                System.out.println(accountList.get(i));
                System.out.println("Login success.");
            }
        }
        System.out.println(a.getJob());
        return a;
    }


    public void action() {
        Scanner in = new Scanner(System.in);
        // job one Class Director
        if(a.getJob() == 1) {
            ClassDirector cd = new ClassDirector(a.getName(), a.getPassword(), a.getJob());
            while(!outCommand.equals("out")) {
            	printWorkList();
                System.out.println("As a class director, you can:\r\n" +
                        "1.	Give new assignment to administrator.\r\n" +
                        "2.	Quit \r\n" +
                        "");
                System.out.println("What do you want to do? ");
                int cmd = in.nextInt();
                if(cmd == 1) {
                    cd.giveNewAssignment();
                }else if(cmd == 2) {
                    outCommand = "out";
                }
            }
        }else if(a.getJob() == 2) {
            // Job 2 Administrator
            Administrator admin = new Administrator(a.getName(), a.getPassword(), a.getJob());
            while(!outCommand.equals("out")) {
            	printWorkList();
                System.out.println("As a administrator, you can:\r\n" +
                        "1.	Read orders from class director.\r\n" +
                        "2.	Print all teachers' information inside the educational system.\r\n" +
                        "3.	Send a request to PTT Director\r\n" +
                        "4.	Check PTT Director's command\r\n" +
                        "5.	Give assignment to teachers\r\n" +
                        "6.	Quit\r\n" +
                        "");
                System.out.println("What do you want to do? ");
                int cmd = in.nextInt();
                if(cmd == 1) {
                    admin.readOrder();
                }else if(cmd == 2) {
                    admin.printTeacherInfo();
                }else if(cmd == 3) {
                    admin.sendRequest();
                }else if(cmd == 4) {
                    admin.checkPTTCommand();
                }else if(cmd == 5) {
                    admin.giveOrder();
                }else if(cmd == 6) {
                    outCommand = "out";
                }
            }
        }else if(a.getJob() == 3) {
            // Job three PTTDirector
            PTTDirector ptt = new PTTDirector(a.getName(), a.getPassword(), a.getJob());
            while(!outCommand.equals("out")) {
            	printWorkList();
                System.out.println("As a class director, you can:\r\n" +
                        "1.	Send your agreements back to administrator\r\n" +
                        "2.	Quit.\r\n" +
                        "");
                int cmd = in.nextInt();
                if(cmd == 1) {
                    ptt.sendCommand();
                }else if(cmd == 2) {
                    outCommand = "out";
                }
            }
        }else if(a.getJob() == 4 || a.getJob() == 5 || a.getJob() == 6) {
            // Job 4,5,6 different teacher
            Teacher teacher = new Teacher(a.getName(), a.getPassword(), a.getJob());
            while(!outCommand.equals("out")) {
            	printWorkList();
                System.out.println("As a teacher, you can:\r\n" +
                        "1.	Check the work list from administrator\r\n" +
                        "2.	Quit.\r\n" +
                        "");
                int cmd = in.nextInt();
                if(cmd == 1) {
                    teacher.checkTraining();
                }else if(cmd == 2) {
                    outCommand = "out";
                }
            }
        }
    }
    
    /*
     * This is the main method!
     * we created several user codes for you to test:
     * name      password    job
     *	 Class     111        1 --- class director
		Admin      222        2 --- administrator
		PTT        333        3 --- PTT director
		MathTeacher 444       4 --- math teacher
		EnglishTeacher 555    5 --- English teacher
		ComputerTeacher 666   6 --- computer teacher
		
		You can use the name and password to login the system.
		Once you finish your job, you can input the number of Quit command to quit the system and changed
		another accounts
     */
    
    public static void main(String args[]) {
        EducationalSystem es = new EducationalSystem();
        es.login();
        es.action();
    }
}
