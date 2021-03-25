package traceur_de_paquet;

import java.util.ArrayList;

// Classe 
public abstract class Mobile extends Clients {
	
	// Définition du nombre d'interface pour les smartphones
	private int nb_inter;
	
	// Constructeur par défaut
	public Mobile(int nb_inter,Air wlink) {
		super(nb_inter);
		this.nb_inter=nb_inter;
		for(Interfaces inter:this.getInters()) {
			inter.setWireless(wlink);
		}
	}
	// Constructeur d'un smartphone nommé
	public Mobile(String name,int nb_inter,Air wlink) {
		super(name,nb_inter);
		this.nb_inter=nb_inter;
		for(Interfaces inter:this.getInters()) {
			inter.setWireless(wlink);
		}
	}
	// Constructeur d'un smartphone nommé et définition de son nombre d'interface
	public Mobile(String name,int nb_inter,ArrayList<Interfaces> inters,Air wlink) {
		super(name,nb_inter,inters);
		this.nb_inter=nb_inter;
		for(Interfaces inter:this.getInters()) {
			inter.setWireless(wlink);
		}
	}
	
}
/*42795f536861*/









