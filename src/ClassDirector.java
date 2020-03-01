import java.util.Scanner;

/*
 * This is the class to achieve the user stories of class director.
 * As a class director, they can give their new assignment to administrators.
 * They will tell administrator what kind of teacher they need for this semester.
 * And the result will be stored inside the OrderFromClassDirector.txt
 */
public class ClassDirector extends Account{
	private String name;
	private int password;
	private int job;
	public ClassDirector(String name, int password, int job) {
		super(name, password, job);
		// TODO Auto-generated constructor stub
		this.name = name;
		this.password = password;
		this.job = job;
	}

	/*
	 * This method is to give New Assignment to teachers.
	 * Print enough guidelines to guild the class director.
	 * Then translate their command into a completed sentence like:
	 *	"class director + 'class director name' + wants a 'teacher type' teacher."
	 *	store this sentence into OrderFromClassDirector.txt
	 */
	public void giveNewAssignment() {
		System.out.println("Hello class director. Please give me your new order.");
		Scanner in = new Scanner(System.in);
		System.out.println("Please tell me what kind of teacher do you need:\r\n" +
				"1.	Math Teacher\r\n" +
				"2.	English Teacher\r\n" +
				"3.	Computer Teacher\r\n" +
				"");
		int order = in.nextInt();
		String str = "Class director ";
		str += name;
		str += " want a ";
		if(order == 1) {
			str += "math Teacher";
		}else if(order == 2) {
			str += "english Teacher";
		}else if(order == 3) {
			str += "computer Teacher";
		}else {
			System.out.println("Wrong order");
		}

		ReadWriteFiles rf = new ReadWriteFiles();
		String path = "OrderFromClassDirector";
		rf.writeFiles(path, str);
	}


	public static void main(String args[]) {
//		ClassDirector cd = new ClassDirector("Jin", 111, 1);
//		cd.giveNewAssignment();
	}
}