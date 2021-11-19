import java.net.Inet4Address;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainEmploye {
	private final static int PORT = 1708;
	public static void main(String[] args) throws RemoteException {
		IManageEmployes employe = new ManageEmploye();
		
		try {
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
			r.rebind("//" + ip + "/EmployeeService", employe);
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}

}
