import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

public class userMethods {
	private static Logger logger = Logger.getLogger(userMethods.class);

	public static boolean RegisterUser(User user) throws IOException {
		FileOutputStream fs = new FileOutputStream(PropertyReader.getUserFilePath());
		ObjectOutputStream os = new ObjectOutputStream(fs);
		try {
			os.writeObject(user);
			return true;
		} finally {
			if (os != null) {
				os.close();
			}
			if (fs != null) {
				fs.close();
			}
		}
	}

	public static boolean LoginUser(User user) throws IOException, ClassNotFoundException {
		FileInputStream fs = new FileInputStream(PropertyReader.getUserFilePath());
		ObjectInputStream os = new ObjectInputStream(fs);
		try {
			User userObject = (User) os.readObject();
			if (userObject.getName().equals(user.getName()) && userObject.getPassword().equals(user.getPassword())) {
				return true;
			} else {
				return false;
			}
		} finally {
			if (os != null) {
				os.close();
			}
			if (fs != null) {
				fs.close();
			}
		}
	}

	public static boolean isUserExist(User user) throws IOException, ClassNotFoundException {
		FileInputStream fs = new FileInputStream(PropertyReader.getUserFilePath());
		ObjectInputStream os = new ObjectInputStream(fs);
		try {
			User userObject = (User) os.readObject();
			if (userObject.getName().equals(user.getName())) {
				return true;
			} else {
				return false;
			}
		} finally {
			if (os != null) {
				os.close();
			}
			if (fs != null) {
				fs.close();
			}
		}
	}
}
