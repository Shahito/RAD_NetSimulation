package traceur_de_paquet;

import java.util.ArrayList;
import java.util.Arrays;


public abstract class Equipement {
	// nom et liste des interfaces et nombre d'interfaces de l'équipement
	private String name;
	private ArrayList<Interfaces> inters=new ArrayList<Interfaces>();
	private int nb_inter;
	
	// compteur d'instance (+1 à chaque équipement créé)
	private static int nbEquipement=0;
	{nbEquipement++;}
	
	// Array to store all wireless interfaces, to know which interfaces are
	// joinable through Air (class Air send packet to all wireless interfaces)
	public static ArrayList<Interfaces> allWirelessInts=new ArrayList<Interfaces>();
	
	// constructeurs
	public Equipement(int nb_inter) {
		this.name="Equipement n°"+nbEquipement+" ("+this.getClass().getSimpleName()+")";
		for(short n=0;n<nb_inter;n++) {this.inters.add(new Interfaces());}
	}
	public Equipement(String name,int nb_inter) {
		this.name=name;
		for(short n=0;n<nb_inter;n++) {this.inters.add(new Interfaces());}
	}
	public Equipement(String name,int nb_inter,ArrayList<Interfaces> inters) {
		this.name=name;
		this.nb_inter=nb_inter;
		this.inters=inters;
	}
	
	// inner class Interfaces
	public class Interfaces {
		private String name; // nom de l'interface
		private AddrIp ipaddr; // ip de l'interface
		private AddrMac macaddr; // mac de l'interface
		private Wire link; // le wire à qui est connectée à l'interface
		private Air wifilink; // même que "link" mais pour le canal Air
		private AddrMac nextmac; // retiens l'adresse mac du prochain saut
		private boolean isWireless=false; // attribut pour passer l'interface en wifi
		
		// constructeurs
		public Interfaces() {
			this.name="eth"+Integer.toString(Equipement.this.getInters().size());
			this.ipaddr=new AddrIp();
			this.macaddr=new AddrMac();
		}
		public Interfaces(String name,AddrIp ipaddr,AddrMac macaddr) {
			this.name=name;
			this.ipaddr=ipaddr;
			this.macaddr=macaddr;
		}
		
		// permet de changer les valeurs et le canal de l'interface pour en faire
		// une interface wifi
		public void setWireless(Air link) {
			this.isWireless=true;
			this.wifilink=link;
			this.link=null; // supprime le lien filaire
			this.name="wlan"+Equipement.this.getInters().indexOf(this); // on change son nom (wlan, plus courant)
		}
		// getter pour savoir si l'interface est wifi
		public boolean getWireless() {return this.isWireless;}
		
		// getters et setters
		public String getName() {return this.name;}
		public void setName(String name) {this.name=name;}
		
		public AddrIp getIpaddr() {return this.ipaddr;}
		public void setIpaddr(AddrIp ipaddr) {this.ipaddr=ipaddr;}
		
		public AddrMac getMacaddr() {return this.macaddr;}
		public void setMacaddr(AddrMac macaddr) {this.macaddr=macaddr;}
		
		public Wire getWire() {return this.link;}
		public void setWire(Wire link) {
			if(!this.isWireless) {
				this.link=link;
			}
		}

		public AddrMac getNextmac() {
			if(!this.isWireless) {
				return nextmac;
			} else {
				return new AddrMac();
			}
		}
		public void setNextmac(AddrMac nextmac) {
			this.nextmac = nextmac;
		}
		
		
		// méthode de transfer des paquets (l'équipement ne reçoit pas, il transmet le paquet)
		public void transfer(Packet p) {
			if(!this.isWireless) { // si l'interface n'est pas wifi
				// on set la dernière interface traversées
				// puis on transfer sur le lien
				p.setLastInt(Equipement.this.getInters().indexOf(this));
				this.link.transfer(p,this);
			} else {
				// on émet sur le canal Air à tous les hotes atteignables
					this.wifilink.emit(p);
			}
		}
		// méthode de reception sur l'équipement
		public void recv(Packet p) {
			p.setLastInt(Equipement.this.getInters().indexOf(this));
			if(!(Equipement.this instanceof Clients)) {
				// si l'équipement n'est pas un client
				// on vérifie s'il le paquet lui est bien destiné
				if(Arrays.equals(p.getIp_dest().getIp(),this.ipaddr.getIp())) {
					Equipement.this.recv(p);
				} else {
					// sinon on le transfer
					Equipement.this.transfer(p);
				}
			} else { // si l'équipement est un client
				if(Arrays.equals(p.getIp_dest().getIp(),this.ipaddr.getIp())) {
					Equipement.this.recv(p);
				} else {
					// on détruit le paquet s'il nous est pas déstiné
					System.out.println(Equipement.this.getName()+" : 1 paquet détruit");
				}
			}
		}
	}
	
	// getter and setters
	public ArrayList<Interfaces> getInters() {
		return this.inters;
	}
	// setter d'une interface en particulier dans la liste d'interfaces
	public void setInter(int n,String name,short[] ip,short[] mask,String[] mac) {
		this.inters.get(n).setName(name);
		AddrIp addrip=new AddrIp(ip,mask);
		AddrMac addrmac=new AddrMac(mac);
		this.inters.get(n).setIpaddr(addrip);
		this.inters.get(n).setMacaddr(addrmac);
	}
	public String getName() {return name;}
	public void setName(String name) {this.name=name;}
	
	// méthode "disp" affiche le nom de l'équipement avec un message en entrée
	public void disp(String mes) {
		System.out.println(this.getName()+" : "+mes);
	}
	// méthode "dispContent" affiche le contenu d'un paquet avec l'équipement courant
	public void dispContent(Packet p) {
		System.out.println(this.getName()+" : "+p.getContent());
	}
	// méthode "dispPacket" affiche un paquet avec toutes les infos de son entête
	// l'équipement courant, et son contenu
	public void dispPacket(Packet p) {
		System.out.println("On "+this.getName()+" : ");
		System.out.println("Src : "+Arrays.toString(p.getIp_src().getIp())+" / "+String.join("",p.getMac_src().getMac()));
		System.out.println("Dest : "+Arrays.toString(p.getIp_dest().getIp())+" / "+String.join("",p.getMac_dest().getMac()));
		System.out.println("Content : "+p.getContent()+"\n");
	}
	
	// méthode d'envoi de paquet à une adresse IP donnée et sur une interface donnée
	public void send(AddrIp targ_ip,int n,String content) {
		if(this.inters.get(n).link!=null||this.inters.get(n).getWireless()) {
			Packet p=new Packet(targ_ip,content);
			p.setIp_src(this.inters.get(n).getIpaddr());
			p.setMac_src(this.inters.get(n).getMacaddr());
			p.setMac_dest(this.inters.get(n).getNextmac());
			System.out.println("Envoyé : ");
			this.dispPacket(p);
			this.inters.get(n).transfer(p);
		} else {
			System.out.println(this.name+" : Interface "+this.inters.get(n).name+" non connectée.\n");
		}
	}
	
	// méthode de reception du paquet
	// selon le contenu du message, certaines actions sont faites (ping,broadcast,...)
	public void recv(Packet p) {
		if(p.getContent()=="ping") {
			this.send(p.getIp_src(),0,"ping response");
		} else if (p.getContent()=="ping response") {
			this.disp("ping réussi");
		} else if(p.getContent()=="request_sw") {
			this.send(p.getIp_src(),p.getLastInt(),"response_sw");
		} else if(p.getContent()=="response_sw") {
			this.addInIpTable(p.getIp_src(),p.getLastInt());
		} else {
			System.out.println("Reçu : ");
			this.dispPacket(p);
		}
	}
	
	// abstract methods to redefined them in each child classes
	public abstract void transfer(Packet p);
	public abstract void addInIpTable(AddrIp ip_src,int lastInt);
}
/*42795f536861*/









