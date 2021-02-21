package traceur_de_paquet;

public class Network {
	public static void main(String[] args) {
		Router r1=new Router("R1");
		Pc pcA=new Pc("PCA");
		Pc pcB=new Pc("PCB");
		
		/*
		r1.setInter(0,"eth1",new short[] {10,4,1,1},new short[] {255,0,0,0},new String[] {"aa","aa","aa","aa","aa","a2"});
		r2.setInter(0,"eth1",new short[] {10,4,1,2},new short[] {255,0,0,0},new String[] {"aa","aa","aa","aa","aa","a7"});
		
		Wire R1toR2=new Wire(r1.getInters().get(0),r2.getInters().get(0));
		*/
		
		r1.setInter(0,"eth0",new short[] {192,168,1,1},new short[] {255,255,255,0},new String[] {"aa","aa","aa","aa","aa","a1"});
		r1.setInter(1,"eth1",new short[] {10,4,1,1},new short[] {255,0,0,0},new String[] {"aa","aa","aa","aa","aa","a2"});
		
		pcA.setInter(0,"eth0",new short[] {192,168,1,2},new short[] {255,255,255,0},new String[] {"aa","aa","aa","aa","aa","a3"});
		pcB.setInter(0,"eth0",new short[] {10,4,1,2},new short[] {255,0,0,0},new String[] {"aa","aa","aa","aa","aa","a4"});
		
		Wire R1toPCA=new Wire(r1.getInters().get(0),pcA.getInters().get(0));
		// instanciation d'un lien entre l'interface eth0 du PCA vers l'interface eth0 du S1
		Wire R1toPCB=new Wire(r1.getInters().get(1),pcB.getInters().get(0));
		// instanciation d'un lien entre l'interface eth0 du PCB vers l'interface eth0 du S1
		
		AddrIp targ_ip=new AddrIp(new short[] {10,4,1,2},new short[] {255,0,0,0});
		pcA.send(targ_ip,0,"Ce message s'affiche sur PC B a été reçu sur l'interface eth0 depuis l'ip 192.168.1.2");
		//pcA.send(targ_ip,0,"Ce message s'affiche sur PC B a été reçu sur l'interface eth0 depuis l'ip 192.168.1.2");
	}
}
