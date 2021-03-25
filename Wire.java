package traceur_de_paquet;

import java.util.ArrayList;
// Classe Wire qui définit les câbles reliant les équipements
public class Wire {
	private ArrayList<Equipement.Interfaces> inters=new ArrayList<Equipement.Interfaces>(2);
	// Constructeur qui initialise un objet wire reliant 2 interfaces
	public Wire(Equipement.Interfaces inter1, Equipement.Interfaces inter2) {
		this.inters.add(inter1);
		this.inters.add(inter2);
		inter1.setWire(this);
		inter1.setNextmac(inter2.getMacaddr());
		inter2.setWire(this);
		inter2.setNextmac(inter1.getMacaddr());
	}
	//  Fonction transfer qui va transférer le paquet à l'interface de destination
	public void transfer(Packet p,Equipement.Interfaces inter) {
		if(inter==this.inters.get(0)) {
			this.inters.get(1).recv(p);
		} else if (inter==this.inters.get(1)) {
			this.inters.get(0).recv(p);
		}
	}
}
/*42795f536861*/









