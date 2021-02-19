package traceur_de_paquet;

import java.util.Arrays;

public class Router extends Equipement {
	private Interfaces[] inters;
	
	public Router() {
		super();
		this.inters[0]=new Interfaces();
		this.inters[1]=new Interfaces();
	}
	
	public Router(String name,Interfaces inter1,Interfaces inter2) {
		super(name);
		this.inters[0]=inter1;
		this.inters[1]=inter2;
	}

	public Interfaces[] getInters() {return inters;}
	public void setInters(Interfaces[] inters) {this.inters=inters;}
	
	public void setInter(int n,String name,short[] ip,short[] mask,String[] mac) {
		AddrIp addrip=new AddrIp(ip,mask);
		AddrMac addrmac=new AddrMac(mac);
		Interfaces inter=new Interfaces(name,addrip,addrmac);
		this.inters[n]=inter;
	}
	
}
