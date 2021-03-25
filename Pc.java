package traceur_de_paquet;

import java.util.ArrayList;
// Classe Pc qui définit les ordinateurs fixes
public class Pc extends Computers {
	// Constructeurs
	public Pc(int nb_inter) {super(nb_inter);}
	public Pc(String name,int nb_inter) {super(name,nb_inter);}
	public Pc(String name,int nb_inter,ArrayList<Interfaces> inters) {
		super(name,nb_inter,inters);
	}
}
/*42795f536861*/









