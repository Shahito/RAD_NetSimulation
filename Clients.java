package traceur_de_paquet;

import java.util.ArrayList;

// Classe qui regroupe les appareils utilisateurs (Mobiles, Ordinateurs...)
public abstract class Clients extends Equipement {
	
	public Clients(int nb_inter) {super(nb_inter);}
	public Clients(String name,int nb_inter) {super(name,nb_inter);}
	public Clients(String name,int nb_inter,ArrayList<Interfaces> inters) {
		super(name,nb_inter,inters);
	}
	
	// Redéfinition de la méthode abstraite de la classe parente
	// (vide car un client ne route aucun paquet)
	@Override
	public void transfer(Packet p) {};
	// Redéfinition de la fonction addInMacTable du switch car abstraite ici
	@Override
	public void addInIpTable(AddrIp ip_src,int lastInt) {}
}
/*42795f536861*/









