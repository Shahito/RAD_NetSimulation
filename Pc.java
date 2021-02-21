package traceur_de_paquet;

import java.util.ArrayList;

public class Pc extends Computers {
	public Pc() {super();}
	public Pc(String name) {super(name);}
	public Pc(String name,ArrayList<Interfaces> inters) {
		super(name,inters);
	}
}
