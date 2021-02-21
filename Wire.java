package traceur_de_paquet;

import java.util.ArrayList;

public class Wire {
	private ArrayList<Equipement.Interfaces> inters=new ArrayList<Equipement.Interfaces>(2);
	
	public Wire(Equipement.Interfaces inter1, Equipement.Interfaces inter2) {
		this.inters.add(inter1);
		this.inters.add(inter2);
		inter1.setWire(this);
		inter2.setWire(this);
	}
	
	public void transfer(Packet p,Equipement.Interfaces inter) {
		if(inter==this.inters.get(0)) {
			this.inters.get(1).recv(p);
		} else if (inter==this.inters.get(1)) {
			this.inters.get(0).recv(p);
		}
	}
}