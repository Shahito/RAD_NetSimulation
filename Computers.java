package traceur_de_paquet;

import java.util.ArrayList;

public abstract class Computers extends Clients {
	
	// Définition du nombre d'interfaces pour les ordinateurs
	private int nb_inter;
	
	// constructors
	public Computers(int nb_inter) {super(nb_inter);}
	public Computers(String name,int nb_inter) {super(name,nb_inter);}
	public Computers(String name,int nb_inter,ArrayList<Interfaces> inters) {
		super(name,nb_inter,inters);
	}
	
}
/*42795f536861*/









