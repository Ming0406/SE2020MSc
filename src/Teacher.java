import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Teacher only need to do one thing, which is read the training list.
 * This training list is carried by a list of request object.
 * So the first thing is to analyze the TrainingList.txt files and generate the request list.
 * first String is the teachers' name, the second String is the class name, the rest of line is the training list.
 * So if the teacher's name equals to a requst.getTecherName then, read this request.
 */
public class Teacher extends Account{
	// analyze the TrainingList.txt file.
	String name;
	int password;
	int job;
	private ArrayList<Request> requestList = new ArrayList<Request>();
	public Teacher(String name, int password, int job) {
		super(name, password, job);
		// TODO Auto-generated constructor stub
		this.name = name;
		this.password = password;
		this.job = job;
	}

	public void checkTraining() {
		String path = "TrainingList";
		String realPath = System.getProperty("user.dir") + "\\" + path;
		try {
			FileReader fr = new FileReader(realPath);
			Scanner sc = new Scanner(fr);
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				Scanner in = new Scanner(line);
				String name = in.next();
				String workFor = in.next();
				String training = in.nextLine();
				Request request = new Request(name, workFor, training);
				//  generate the requestList
				requestList.add(request);
			}
		}catch(IOException e) {
			e.getStackTrace();
		}

		for (int i = 0; i < requestList.size(); i++) {
			// if the name is equal then print the request list.
			if (requestList.get(i).getName().equals(this.name)) {
				System.out.println("You need to work for " + requestList.get(i).getClassName() + ". You get " + requestList.get(i).getTraining());
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher("MathTeacher", 444, 4);
		teacher.checkTraining();
	}

}