package traceur_de_paquet;

public class Wire {
	private Equipement.Interfaces inter1;
	private Equipement.Interfaces inter2;
	
	public Wire(Equipement.Interfaces inter1, Equipement.Interfaces inter2) {
		this.inter1=inter1;
		this.inter2=inter2;
		inter1.setWire(this);
		inter2.setWire(this);
	}
	
	public void send(Packet p,Equipement.Interfaces inter) {
		if(inter==this.inter1) {
			this.inter2.recv(p);
		} else if (inter==this.inter2) {
			this.inter1.recv(p);
		}
	}
}