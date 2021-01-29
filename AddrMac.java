package traceur_de_paquet;

public class AddrMac {
	private String[] mac=new String[6];
	
	public AddrMac(String[] mac) {
		setMac(mac);
	}
	public AddrMac() {
		for(int n=0;n<6;n++) {
			this.mac[n]="ff";
		}
	}
	
	public String[] getMac() {
		return mac;
	}
	public void setMac(String[] mac) {
		for(int n=0;n<6;n++) {
			this.mac[n]=mac[n].toUpperCase();
		}
	}
	
}
