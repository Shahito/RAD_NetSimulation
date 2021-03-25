package traceur_de_paquet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
// Classe qui définit un switch
public class Switch extends Equipement {
	private int nb_inter;
	// Tableau associatif entre adresse MAC et interfaces
	private Map<String,Interfaces> macTable=new HashMap<>();
	// Constructeurs
	public Switch(int nb_inter) {
		super(nb_inter);
	}
	public Switch(String name,int nb_inter) {
		super(name,nb_inter);
		this.nb_inter=nb_inter;
	}
	public Switch(String name,int nb_inter,ArrayList<Interfaces> inters) {
		super(name,nb_inter,inters);
		this.nb_inter=nb_inter;
	}
	// Retourne le tableau associatif
	public Map<String,Interfaces> getMacTable() {return this.macTable;}
	// Fonction broadcast si il ne connait pas déjà l'adresse destination demandée
	public void broadcastRequest(AddrIp ipaddr,int lastInt) {
		for(int n=0;n<this.nb_inter;n++) {
			if(n!=lastInt) {
				this.send(ipaddr,n,"request_sw");
			}
		}
	}
	// Fonction associant l'adresse IP à l'interface à laquelle elle est connecté
	public void addInIpTable(AddrIp ipaddr,int lastInt) {
		this.macTable.put(ipaddr.toString(),this.getInters().get(lastInt));
	}
	/*
	 *  Fonction transfer qui redirige le paquet reçu à une interface qu'il connaît
	 *  si il ne connaît pas, appel de la fonction broadcastRequest qui demande à
	 *  toutes les interfaces si elles sont l'adresse IP demandée
	 */
	@Override
	public void transfer(Packet p) {
		if(!(this.macTable.containsKey(p.getIp_src().toString()))) {
			this.macTable.put(p.getIp_src().toString(),this.getInters().get(p.getLastInt()));
		}
		if(this.macTable.containsKey(p.getIp_dest().toString())) {
			this.macTable.get(p.getIp_dest().toString()).transfer(p);
		} else {
			this.broadcastRequest(p.getIp_dest(),p.getLastInt());
		}
		
	}
}
/*42795f536861*/









