import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Teacher extends Account{
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
				requestList.add(request);
			}
		}catch(IOException e) {
			e.getStackTrace();
		}
		
		for (int i = 0; i < requestList.size(); i++) {
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
