package traceur_de_paquet;

import java.util.ArrayList;

// Classe Hub qui définit l'équipement de type hub
public class Hub extends Equipement {
	// Définition du nombre d'interface d'un hub
	private int nb_inter;
	
	public Hub(int nb_inter) {super(nb_inter);}
	public Hub(String name,int nb_inter) {super(name,nb_inter);}
	public Hub(String name,int nb_inter,ArrayList<Interfaces> inters) {super(name,nb_inter,inters);}
	
	// Fonction qui permet de recevoir le paquet qu'on nous envoie si on est la destination
	@Override
	public void recv(Packet p) {
		this.dispPacket(p);
	}
	
	// Fonction transfer qui envoie les paquets qu'elles reçoient sur toutes les interfaces
	@Override
	public void transfer(Packet p) {
		for(int n=0;n<this.nb_inter;n++) {
			p.setMac_dest(this.getInters().get(n).getNextmac());
			System.out.println("Transféré : ");
			this.dispPacket(p);
			this.getInters().get(n).transfer(p);
		}
	}
	// Fonction addInMacTable abstraite ici car elle sert au switch
	@Override
	public void addInIpTable(AddrIp ip_src,int lastInt) {}
}
/*42795f536861*/









