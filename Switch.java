package traceur_de_paquet;

public class Switch extends Equipement {
	final int NB_INTER=5;
	
	private Interfaces[] inters=new Interfaces[NB_INTER];
	
	public Switch() {
		super();
		this.setName("Switch");
		for(short n=0;n<NB_INTER;n++) {this.inters[n]=new Equipement.Interfaces();}
	}
	public Switch(String name) {super(name);}
	public Switch(String name,Interfaces[] inters) {
		super(name);
		for(short n=0;n<NB_INTER;n++) {this.inters[n]=inters[n];}
	}
	
	
	
	public Interfaces[] getInters() {return inters;}
	public void setInters(Interfaces[] inters) {this.inters = inters;}
	
	public void setInter(int n,String name,short[] ip,short[] mask,String[] mac) {
		AddrIp addrip=new AddrIp(ip,mask);
		AddrMac addrmac=new AddrMac(mac);
		Interfaces inter=new Interfaces(name,addrip,addrmac);
		this.inters[n]=inter;
	}
	
	public void recv(Packet p) {
		this.dispPacket(p);
	}
	public void transfer(Packet p) {
		for(int n=0;n<NB_INTER;n++) {
			this.inters[n].send(p);
		}
	}
}
