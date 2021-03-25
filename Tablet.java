package traceur_de_paquet;

import java.util.ArrayList;
// Classe Tablet qui définit les tablettes appartenant à la classe parente Mobile
public class Tablet extends Mobile {
	// Constructeurs
	public Tablet(int nb_inter,Air wlink) {super(nb_inter,wlink);}
	public Tablet(String name,int nb_inter,Air wlink) {super(name,nb_inter,wlink);}
	public Tablet(String name,int nb_inter,ArrayList<Interfaces> inters,Air wlink) {
		super(name,nb_inter,inters,wlink);
	}
}
/*42795f536861*/









