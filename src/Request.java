/*
 * Request is the to store the information of teacher training.
 * 	This object contains three useful information:
 * 	1. Who is this teacher
 * 	2. Which class this teacher need to join.
 * 	3. Which training this teacher need to undertake.
 *
 * This object will be used to when administrator send the request to PTTDirector
 * and the teacher read the training list coming from administrator.
 */
public class Request {
	private String name;
	private String training;
	private String className;

	public Request(String a, String className, String training) {
		name = a;
		this.training = training;
		this.className = className;
	}

	public void sendRequest() {
		String str = "";
		str += "Hello, PTT Director! ";
		str += "We arranged " + name + " to work for " + className + " and take a " + training;

		String path = "OrderFromAdministrator";
		ReadWriteFiles rf = new ReadWriteFiles();
		rf.writeFiles(path, str);
	}

	public String getName() {
		return name;
	}

	public String getTraining() {
		return training;
	}

	public String getClassName() {
		return className;
	}


}
