package traceur_de_paquet;

import java.util.ArrayList;
import java.util.Arrays;

// Classe Router qui définit les routeurs
public class Router extends Equipement {
	// Nombre d'interface du routeur
	private int nb_inter;
	// Constructeurs
	public Router(int nb_inter) {
		super(nb_inter);
		this.nb_inter=nb_inter;
	}
	public Router(String name,int nb_inter) {
		super(name,nb_inter);
		this.nb_inter=nb_inter;
	}
	public Router(String name,int nb_inter,ArrayList<Interfaces> inters) {
		super(name,nb_inter,inters);
		this.nb_inter=nb_inter;
	}
	// Fonction permettant de savoir si addrip1 est dans le même réseau que addrip2
	public boolean isInNet(AddrIp addrip1,AddrIp addrip2) {
		short[] ip1=addrip1.getIp();
		short[] mask1=addrip1.getMask();
		short[] ip2=addrip2.getIp();
		short[] mask2=addrip2.getMask();
		
		if(Arrays.equals(mask1,mask2)) {
			for(int n=0;n<4;n++) {
				if ((ip1[n]&mask1[n])!=(ip2[n]&mask2[n])) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	// Fonction transfer qui redirige le paquet reçu à une autre équipement que le routeur connait
	@Override
	public void transfer(Packet p) {
		for(int n=0;n<this.nb_inter;n++) {
			if(isInNet(p.getIp_dest(),this.getInters().get(n).getIpaddr())) {
				p.setMac_dest(this.getInters().get(n).getNextmac());
				System.out.println("Transféré : ");
				this.dispPacket(p);
				this.getInters().get(n).transfer(p);
			}
		}
	}
	// Fonction addInMacTable vide car abstraite et ne sert qu'au switch
	@Override
	public void addInIpTable(AddrIp ip_src,int lastInt) {}
}
/*42795f536861*/









