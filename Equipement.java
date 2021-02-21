package traceur_de_paquet;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Equipement {
	private String name;
	protected ArrayList<Interfaces> inters=new ArrayList<Interfaces>();
	
	// Equipement instance counter
	private static int nbEquipement=0;
	{nbEquipement++;}
	
	// constructors
	public Equipement() {
		this.name="Equipement n°"+nbEquipement+" ("+this.getClass().getSimpleName()+")";
	}
	public Equipement(String name) {
		this.name=name;
		for(short n=0;n<5;n++) {this.inters.add(new Interfaces());}
	}
	public Equipement(String name,ArrayList<Interfaces> inters) {
		this.name=name;
		this.inters=inters;
	}
	
	// inner class
	public class Interfaces {
		private String name;
		private AddrIp ipaddr;
		private AddrMac macaddr;
		private Wire link;
		
		public Interfaces() {
			this.name="Interface "+nbEquipement+" ("+this.getClass().getSimpleName()+")";
			this.ipaddr=new AddrIp();
			this.macaddr=new AddrMac();
		}
		public Interfaces(AddrIp ipaddr,AddrMac macaddr) {
			this.ipaddr=ipaddr;
			this.macaddr=macaddr;
		}
		public Interfaces(String name,AddrIp ipaddr,AddrMac macaddr) {
			this.name=name;
			this.ipaddr=ipaddr;
			this.macaddr=macaddr;
		}
		
		public String getName() {return this.name;}
		public void setName(String name) {this.name=name;}
		
		public AddrIp getIpaddr() {return this.ipaddr;}
		public void setIpaddr(AddrIp ipaddr) {this.ipaddr=ipaddr;}
		
		public AddrMac getMacaddr() {return this.macaddr;}
		public void setMacaddr(AddrMac macaddr) {this.macaddr=macaddr;}
		
		public Wire getWire() {return this.link;}
		public void setWire(Wire link) {this.link=link;}
		
		public void transfer(Packet p) {
			if(link!=null) {
				this.link.transfer(p,this);
			} else {
				System.out.println(Equipement.this.getName()+" : Interface "+this.name+" non connectée.");
			}
		}
		public void recv(Packet p) {
			if(Equipement.this.getClass().getName()=="traceur_de_paquet.Router") {
				if(Arrays.equals(p.getIp_dest().getIp(),this.ipaddr.getIp())) {
				Equipement.this.recv(p);
				} else {
					Equipement.this.transfer(p);
				}
			} else if (Equipement.this.getClass().getName()=="traceur_de_paquet.Switch") {
				if(Arrays.equals(p.getIp_dest().getIp(),this.ipaddr.getIp())) {
					Equipement.this.recv(p);
				} else {
					Equipement.this.transfer(p);
				}
			} else {
				if(Arrays.equals(p.getIp_dest().getIp(),this.ipaddr.getIp())) {
					Equipement.this.recv(p);
				} else {
					System.out.println(Equipement.this.getName()+" : 1 paquet détruit");
				}
			}
		}
	}
	
	// getter and setters
	public ArrayList<Interfaces> getInters() {
		return this.inters;
	}
	public void setInters(ArrayList<Interfaces> inters) {
		this.inters=inters;
	}
	public void setInter(int n, String name, short[] ip,short[] mask,String[] mac) {
		AddrIp addrip=new AddrIp(ip,mask);
		AddrMac addrmac=new AddrMac(mac);
		Interfaces inter=new Interfaces(name,addrip,addrmac);
		this.inters.set(n,inter);
	}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	
	public void dispContent(Packet p) {
		System.out.println(this.getName()+" : "+p.getContent());
	}
	public void dispPacket(Packet p) {
		System.out.println("\nOn "+this.getName()+" : ");
		System.out.println("Src : "+Arrays.toString(p.getIp_src().getIp())+" / "+String.join("",p.getMac_src().getMac()));
		System.out.println("Dest : "+Arrays.toString(p.getIp_dest().getIp()));
		System.out.println("Content : "+p.getContent()+"\n");
	}
	
	public void send(AddrIp targ_ip,int n,String content) {
		Packet p=new Packet(this.inters.get(n).getIpaddr(),targ_ip,this.inters.get(n).getMacaddr(),content);
		this.inters.get(n).transfer(p);
	}
	
	public void recv(Packet p) {
		this.dispPacket(p);
	}
	
	// redefined methods
	public abstract void transfer(Packet p);
}










