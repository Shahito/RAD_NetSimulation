package traceur_de_paquet;

public class Pc extends Computers {
	public Pc() {super();}
	public Pc(String name) {super(name);}
	public Pc(String name,Interfaces inters[]) {
		super(name);
		this.setInters(inters);
	}
	
	public Interfaces getInters(short n) {
		return this.getInters()[n];
	}
}
