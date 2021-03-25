package traceur_de_paquet;

import java.util.Arrays;

// Classe AddrIp qui définit la composition d'une adresse IP
public class AddrIp {
	private short[] ip=new short[4];
	private short[] mask=new short[4];
	
	// Définit une IP par défaut pour un constructeur sans paramètre
	public AddrIp() {
		this.ip[0]=192;
		this.ip[1]=168;
		this.ip[2]=1;
		this.ip[3]=1;
		this.mask[0]=255;
		this.mask[1]=255;
		this.mask[2]=255;
		this.mask[3]=0;
	}
	
	// Définition d'une adresse avec l'IP et le masque donné en paramètre
	public AddrIp(short[] ip,short[] mask) {
		setIp(ip);
		setMask(mask);
	}
	
	// Retourne l'IP de l'interface
	public short[] getIp() {return this.ip;}
	
	// Initialise l'IP de l'interface
	public void setIp(short[] ip) {
		for(int n=0;n<4;n++) {
			this.ip[n]=ip[n];
		}
	}
	
	// Retourne le masque réseau
	public short[] getMask() {return this.mask;}
	
	// Initialise le masque réseau
	public void setMask(short[] mask) {
		for(int n=0;n<4;n++) {
			this.mask[n]=mask[n];
		}
	}
	
	// Methode permettant d'afficher l'IP et le masque
	public String toString() {
		return Arrays.toString(this.getIp())+Arrays.toString(this.getMask());
	}
}
/*42795f536861*/









