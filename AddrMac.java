package traceur_de_paquet;

// Classe AddrMac qui définit la composition d'une adresse MAC
public class AddrMac {
	private String[] mac=new String[6];
	
	// Définit une adresse MAC à 6 caractères pour un constructeur sans paramètre
	public AddrMac() {
		for(int n=0;n<6;n++) {
			this.mac[n]="ff";
		}
	}
	
	// Définition de l'adresse MAC p
	public AddrMac(String[] mac) {setMac(mac);}
	
	// Retourne l'adresse MAC
	public String[] getMac() {return this.mac;}
	
	// Initialise l'adresse MAC
	public void setMac(String[] mac) {
		for(int n=0;n<6;n++) {
			this.mac[n]=mac[n].toUpperCase();
		}
	}
	
}
/*42795f536861*/









