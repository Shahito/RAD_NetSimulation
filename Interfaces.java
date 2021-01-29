package traceur_de_paquet;

public class Interfaces {
	private AddrIp ipaddr=new AddrIp();
	private AddrMac macaddr=new AddrMac();
	
	public Interfaces(AddrIp ipaddr,AddrMac macaddr) {
		this.ipaddr=ipaddr;
		this.macaddr=macaddr;
	}
	public Interfaces() {}
	
	public AddrIp getIpaddr() {
		return ipaddr;
	}
	public void setIpaddr(AddrIp ipaddr) {
		this.ipaddr=ipaddr;
	}
	
	public AddrMac getMacaddr() {
		return macaddr;
	}
	public void setMacaddr(AddrMac macaddr) {
		this.macaddr=macaddr;
	}
}
