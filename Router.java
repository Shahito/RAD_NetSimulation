package traceur_de_paquet;

public class Router {
	private Interfaces inter1;
	private Interfaces inter2;
	
	public Router() {
		inter1=new Interfaces();
		inter2=new Interfaces();
	}
	
	public Router(AddrIp ipaddr1,AddrMac macaddr1,AddrIp ipaddr2,AddrMac macaddr2) {
		inter1.setIpaddr(ipaddr1);
		inter1.setMacaddr(macaddr1);
		inter2.setIpaddr(ipaddr2);
		inter2.setMacaddr(macaddr2);
	}
	
}
