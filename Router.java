package traceur_de_paquet;

import java.util.ArrayList;
import java.util.Arrays;

public class Router extends Equipement {
	final short NB_INTER=2;
	
	public Router() {super();}
	public Router(String name) {super(name);}
	public Router(String name,ArrayList<Interfaces> inters) {super(name,inters);}
	
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
	
	@Override
	public void transfer(Packet p) {
		for(int n=0;n<NB_INTER;n++) {
			if(isInNet(p.getIp_dest(),this.getInters().get(n).getIpaddr())) {
				this.getInters().get(n).transfer(p);
			}
		}
	}
}











