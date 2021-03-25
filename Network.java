package traceur_de_paquet;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// Classe Main qui permet de créer son réseau et de voir le comportement de chaque équipement
public class Network {
	public static void main(String[] args) throws InterruptedException {
		
		Air wlink=new Air(); // init du canal Air commun à toutes les interfaces wifi
		
		/*Map<String,Equipement> allEqui=new LinkedHashMap<>();
		int nb_inter;
		String name;
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.print("Add an equipement : "
					+ "\n\t1:Router"
					+ "\n\t2:Switch"
					+ "\n\t3:Hub"
					+ "\n\t4:Pc"
					+ "\n\t5:Laptop"
					+ "\n\t6:Tablet"
					+ "\n\n\t7: Wire"
					+ "\n\n\t0: Exit");
			switch(sc.nextInt()) {
			case 0:
				break;
			case 1:
				System.out.print("Number of ints : ");
				nb_inter=sc.nextInt();
				System.out.print("Name : ");
				name=sc.toString();
				allEqui.put(name,new Router(name,nb_inter));
			case 2:
				System.out.print("Number of ints : ");
				nb_inter=sc.nextInt();
				System.out.print("Name : ");
				name=sc.toString();
				allEqui.put(name,new Switch(name,nb_inter));
			case 3:
				System.out.print("Number of ints : ");
				nb_inter=sc.nextInt();
				System.out.print("Name : ");
				name=sc.toString();
				allEqui.put(name,new Hub(name,nb_inter));
			case 4:
				System.out.print("Number of ints : ");
				nb_inter=sc.nextInt();
				System.out.print("Name : ");
				name=sc.toString();
				allEqui.put(name,new Pc(name,nb_inter));
			case 5:
				System.out.print("Number of ints : ");
				nb_inter=sc.nextInt();
				System.out.print("Name : ");
				name=sc.toString();
				allEqui.put(name,new Laptop(name,nb_inter));
			case 6:
				System.out.print("Number of ints : ");
				nb_inter=sc.nextInt();
				System.out.print("Name : ");
				name=sc.toString();
				allEqui.put(name,new Tablet(name,nb_inter,wlink));
			case 7:
				System.out.print("First equipement : ");
				String name1=sc.toString();
				System.out.print("Which int : ");
				int int1=sc.nextInt();
				System.out.print("Second equipement : ");
				String name2=sc.toString();
				System.out.print("Which int : ");
				int int2=sc.nextInt();
				new Wire(allEqui.get(name1).getInters().get(int1),allEqui.get(name2).getInters().get(int2));
			}
			
			// ajout futur, set toutes les interfaces via console (IP,MAC)
		}
		*/
		
		Router r1=new Router("R1",2);
		// init du router r1 avec 2 interfaces
		Pc pcA=new Pc("PCA",2);
		// init du pcA avec 2 interfaces
		Pc pcB=new Pc("PCB",2);
		// init du pcB avec 2 interfaces
		
		// set des adresses du router (ip,masque et mac)
		r1.setInter(0,"eth0",new short[] {192,168,1,1},new short[] {255,255,255,0},new String[] {"bb","bb","bb","bb","bb","bb"});
		r1.setInter(1,"eth1",new short[] {10,4,1,1},new short[] {255,0,0,0},new String[] {"aa","aa","aa","aa","aa","a2"});
		
		// set des adresses du router (ip,masque et mac)
		pcA.setInter(0,"eth0",new short[] {192,168,1,2},new short[] {255,255,255,0},new String[] {"cc","cc","cc","cc","cc","cc"});
		pcB.setInter(0,"eth0",new short[] {10,4,1,2},new short[] {255,0,0,0},new String[] {"dd","dd","dd","dd","dd","dd"});
		
		// instanciation d'un lien entre l'interface eth0 du PCA vers l'interface eth0 du S1
		Wire R1toPCA=new Wire(r1.getInters().get(0),pcA.getInters().get(0));
		// instanciation d'un lien entre l'interface eth0 du PCB vers l'interface eth0 du S1
		Wire R1toPCB=new Wire(r1.getInters().get(1),pcB.getInters().get(0));
		
		// création de deux adresse "target" qui seront les deux adresses
		// sur lesquelles nous allons envoyer nos paquets
		AddrIp targ_ip=new AddrIp(new short[] {10,4,1,2},new short[] {255,0,0,0});
		AddrIp targ_ip2=new AddrIp(new short[] {192,168,1,2},new short[] {255,255,255,0});
		
		// enovie du message "Allo ?" à l'ip 192.168.2.8 sur l'interface 0 du pcA
		pcA.send(targ_ip,0,"Allo ?");
		System.out.println("-----------------------------------------");
		pcA.send(targ_ip,0,"Allo2 ?");
		System.out.println("-----------------------------------------");
		pcB.send(targ_ip2,0,"ping");
		
		System.out.println("\n\nSimulation terminée !");
	}
}
/*42795f536861*/









