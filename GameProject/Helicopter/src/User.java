import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
	private String name;
	private String password;
	private Date date;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
