package traceur_de_paquet;

public class Computers extends Clients {
	private Interfaces[] inters=new Interfaces[2];
	
	public Computers() {super();}
	public Computers(String name) {super(name);}
	
	public Interfaces[] getInters() {return inters;}
	public void setInters(Interfaces[] inters) {this.inters=inters;}
	
	public void setInter(int n,String name,short[] ip,short[] mask,String[] mac) {
		AddrIp addrip=new AddrIp(ip,mask);
		AddrMac addrmac=new AddrMac(mac);
		Interfaces inter=new Interfaces(name,addrip,addrmac);
		this.inters[n]=inter;
	}
	
	public void send(AddrIp targ_ip,int n,String content) {
		Packet p=new Packet(this.inters[n].getIpaddr(),targ_ip,this.inters[n].getMacaddr(),content);
		this.inters[n].send(p);
	}
	public void recv(Packet p) {
		this.dispPacket(p);
	}
}
