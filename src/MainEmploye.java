import java.net.Inet4Address;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class MainEmploye {
	private final static int PORT = 1708;
	public static void main(String[] args) throws RemoteException {
		IManageEmployes employeManager = new ManageEmploye();
		
		try {
			
			employeManager.addEmploye(123, "password123", "user1", "firstname1");
			employeManager.addEmploye(234, "password145", "user2", "firstname2");
			employeManager.addEmploye(356, "password465", "user3", "firstname3");
			employeManager.addEmploye(843, "password656", "user5", "firstname5");
			employeManager.addEmploye(2135, "password644", "user4", "firstname4");
			
			List<IEmploye> employes = employeManager.getAllEmployes();
			for(IEmploye e : employes) {
				System.out.println(e);
			}
			String ip = Inet4Address.getLocalHost().getHostAddress();
			if (ip == null || ip == "") {
				ip = "localhost";
			}
			System.out.println("################################");
			System.out.println("Try to start Employe Server ...");
			System.out.println("Ip adress : " + ip);
			System.out.println("Listen port : " + PORT);
			System.out.println("################################");
			Registry r = LocateRegistry.createRegistry(PORT);
			System.setProperty("java.rmi.server.hostname", ip);
			r.rebind("//" + ip + "/EmployeeService", employeManager);
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}

}
