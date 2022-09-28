
public class UserService {
	public String id;
	public String name;
	private String password;

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public UserService(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "UserService [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

}
