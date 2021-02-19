package traceur_de_paquet;

import java.io.IOException;
import java.util.Arrays;

public class Network {
	public static void main(String[] args) throws IOException {
		Switch s1=new Switch("Switch1"); // création du switch S1
		Pc pcA=new Pc("PC A"); // création du PC A
		Pc pcB=new Pc("PC B"); // création du PC B
		
		for(short n=0;n<s1.getInters().length;n++) {
			s1.setInter(n,"eth"+String.valueOf(n),new short[] {192,168,1,n},new short[] {255,255,255,0},new String[] {"aa","aa","aa","aa","aa","a"+String.valueOf(n)});
		} // on init toutes les interfaces dans la même range (plus simple pour l'exemple, une interface peut ne pas être init)
		
		pcA.setInter(0,"eth0",new short[] {192,168,1,2},new short[] {255,255,255,0},new String[] {"aa","aa","aa","aa","aa","aa"});
		pcA.setInter(1,"eth1",new short[] {10,4,110,2},new short[] {255,0,0,0},new String[] {"bb","bb","bb","bb","bb","bb"});
		// on init les deux interfaces du PC A
		pcB.setInter(0,"eth0",new short[] {192,168,1,3},new short[] {255,255,255,0},new String[] {"cc","cc","cc","cc","cc","cc"});
		pcB.setInter(1,"eth1",new short[] {10,4,110,3},new short[] {255,0,0,0},new String[] {"dd","dd","dd","dd","dd","dd"});
		// on init les deux interfaces du PC B
		
		Wire S1toPCA=new Wire(s1.getInters()[0],pcA.getInters()[0]);
		// instanciation d'un lien entre l'interface eth0 du PCA vers l'interface eth0 du S1
		Wire S1toPCB=new Wire(s1.getInters()[1],pcB.getInters()[0]);
		// instanciation d'un lien entre l'interface eth0 du PCB vers l'interface eth0 du S1
		
		AddrIp targ_ip=new AddrIp(new short[] {192,168,1,3},new short[] {255,255,255,0});
		pcA.send(targ_ip,0,"Ce message s'affiche sur PC B a été reçu sur l'interface eth0 depuis l'ip 192.168.1.2");
	}
}
