package traceur_de_paquet;

import java.util.Arrays;

public class Equipement {
	private String name;
	
	private static int nbEquipement = 0;
	 
	{nbEquipement++;}
	
	public Equipement() {
		this.name="Equipement n°"+nbEquipement+" ("+this.getClass().getSimpleName()+")";
	}
	public Equipement(String name) {
		this.name=name;
	}
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public Equipement getEquipement() {return this;}
	
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
		
		public Equipement getE() {return Equipement.this.getEquipement();}
		
		public void send(Packet p) {
			if(link!=null) {
				this.link.send(p,this);
			} else {
				System.out.println(Equipement.this.getName()+" : Interface "+this.name+" non connectée.");
			}
		}
		public void recv(Packet p) {
			if(Equipement.this.getClass().getName()=="traceur_de_paquet.Router") {
				System.out.println("On router b");
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
	
	public void dispContent(Packet p) {
		System.out.println(this.getName()+" : "+p.getContent());
	}
	public void dispPacket(Packet p) {
		System.out.println("\nOn "+getName()+" : ");
		System.out.println("Src : "+Arrays.toString(p.getIp_src().getIp())+" / "+String.join("",p.getMac_src().getMac()));
		System.out.println("Dest : "+Arrays.toString(p.getIp_dest().getIp()));
		System.out.println("Content : "+p.getContent()+"\n");
	}
	public void send(AddrIp targ_ip,int n,String content) {}
	public void recv(Packet p) {}
	public void transfer(Packet p) {}
}