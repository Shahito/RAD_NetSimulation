package traceur_de_paquet;

import java.util.ArrayList;

// Classe qui permet de définir les ordinateurs portables
public class Laptop extends Computers {
	
	// constructors
	public Laptop(int nb_inter) {super(nb_inter);}
	public Laptop(String name,int nb_inter) {super(name,nb_inter);}
	public Laptop(String name,int nb_inter,ArrayList<Interfaces> inters) {
		super(name,nb_inter,inters);
	}
}
/*42795f536861*/









