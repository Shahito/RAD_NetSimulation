package traceur_de_paquet;

import java.util.ArrayList;

public class Hub extends Equipement {
	final short NB_INTER=5;
	
	public Hub() {super();}
	public Hub(String name) {super(name);}
	public Hub(String name,ArrayList<Interfaces> inters) {super(name,inters);}
	
	@Override
	public void recv(Packet p) {
		this.dispPacket(p);
	}
	@Override
	public void transfer(Packet p) {
		for(int n=0;n<NB_INTER;n++) {
			this.getInters().get(n).transfer(p);
		}
	}
}
