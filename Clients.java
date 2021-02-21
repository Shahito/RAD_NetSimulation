package traceur_de_paquet;

import java.util.ArrayList;

public abstract class Clients extends Equipement {
	
	public Clients() {super();}
	public Clients(String name) {super(name);}
	public Clients(String name,ArrayList<Interfaces> inters) {super(name,inters);}
	
	@Override
	public void transfer(Packet p) {};
}
