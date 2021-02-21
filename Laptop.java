package traceur_de_paquet;

import java.util.ArrayList;

public class Laptop extends Computers {
	
	// constructors
	public Laptop() {super();}
	public Laptop(String name) {super(name);}
	public Laptop(String name,ArrayList<Interfaces> inters) {
		super(name,inters);
	}
}
