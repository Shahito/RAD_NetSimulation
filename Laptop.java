package traceur_de_paquet;

public class Laptop extends Computers {
	public Laptop() {super();}
	public Laptop(String name,Interfaces inters[]) {
		super(name);
		this.setInters(inters);
	}
}
