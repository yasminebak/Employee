import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

@SuppressWarnings("serial")
public class Employe extends UnicastRemoteObject implements IEmploye {

	private int id;
	private String password;
	private String lastname;
	private String firstname;
	private String birthday;

	public Employe() throws RemoteException {

	}

	public Employe(int id, String password, String lastname, String firstname, String birthday) throws RemoteException {
		Objects.requireNonNull(password);
		Objects.requireNonNull(lastname);
		Objects.requireNonNull(firstname);
		Objects.requireNonNull(birthday);

		if (id < 0) {
			throw new IllegalArgumentException("id can't be negative !");
		}

		this.id = id;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
		this.birthday = birthday;
	}

	@Override
	public int getId() throws RemoteException {
		return id;
	}

	@Override
	public String getLastname() throws RemoteException {
		return lastname;
	}

	@Override
	public String getFirstname() throws RemoteException {
		return firstname;
	}

	@Override
	public String getBirthday() throws RemoteException {
		return birthday;
	}

	@Override
	public void setPassword(String password) throws RemoteException {
		Objects.requireNonNull(password);
		this.password = password;
	}

	@Override
	public boolean verifIdentity(String password) throws RemoteException {
		Objects.requireNonNull(password);
		if (this.password.equals(password)) {
			return true;
		}
		return false;
	}

	public String toString() {
		return "ID : " + id + " Lastname : " + lastname + " Firstname : " + firstname + " Birthday : " + birthday;
	}
}
