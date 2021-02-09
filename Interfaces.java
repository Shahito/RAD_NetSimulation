package traceur_de_paquet;

public class Interfaces {
	private String name;
	private AddrIp ipaddr;
	private AddrMac macaddr;
	
	public Interfaces() {
		this.ipaddr=new AddrIp();
		this.macaddr=new AddrMac();
	}
	
	public Interfaces(AddrIp ipaddr,AddrMac macaddr) {
		this.ipaddr=ipaddr;
		this.macaddr=macaddr;
	}
	
	public String getName() {return this.name;}
	public void setName(String name) {this.name=name;}
	
	
	public AddrIp getIpaddr() {return ipaddr;}
	public void setIpaddr(AddrIp ipaddr) {this.ipaddr=ipaddr;}
	
	public AddrMac getMacaddr() {return macaddr;}
	public void setMacaddr(AddrMac macaddr) {this.macaddr=macaddr;}
	
}
