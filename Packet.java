package traceur_de_paquet;
/*
 * Classe qui définit les paquets composé de l'adresse IP source,
 * de l'adresse MAC source, de l'IP destination, de la MAC de destination et
 * du message
 */
public class Packet {
	private AddrIp ip_src;
	private AddrMac mac_src;
	private AddrIp ip_dest;
	private AddrMac mac_dest;
	private String content;
	private int lastInt;
	
	public Packet(AddrIp ip_dest,String content) {
		this.ip_dest=ip_dest;
		this.content=content;
	}
	
	// Retourne l'adresse IP source
	public AddrIp getIp_src() {return ip_src;}
	// Définit l'adresse IP source 
	public void setIp_src(AddrIp ip_src) {this.ip_src=ip_src;}
	// Retourne l'adresse IP destination
	public AddrIp getIp_dest() {return ip_dest;}
	// Définit l'adresse IP destination
	public void setIp_dest(AddrIp ip_dest) {this.ip_dest=ip_dest;}
	
	// Retourne l'adresse MAC source
	public AddrMac getMac_src() {return mac_src;}
	// Définit l'adresse MAC source
	public void setMac_src(AddrMac mac_dest) {this.mac_src=mac_dest;}
	// Retourne l'adresse MAC destination
	public AddrMac getMac_dest() {return mac_dest;}
	// Définit l'adresse MAC destination
	public void setMac_dest(AddrMac mac_dest) {this.mac_dest=mac_dest;}
	
	// Retourne le message contenu dans le paquet
	public String getContent() {return content;}
	// Définit le message contenu dans le paquet
	public void setContent(String content) {this.content=content;}

	// Retourne la derniere interface par laquelle a traversé le paquet
	public int getLastInt() {return this.lastInt;}
	// Définit la derniere interface par laquelle a traversé le paquet
	public void setLastInt(int lastInt) {this.lastInt=lastInt;}
}
/*42795f536861*/









