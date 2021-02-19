package traceur_de_paquet;

public class Packet {
	private AddrIp ip_src;
	private AddrIp ip_dest;
	private AddrMac mac_src;
	private String content;
	
	public Packet(AddrIp ip_src,AddrIp ip_dest,AddrMac mac_src,String content) {
		this.ip_src=ip_src;
		this.ip_dest=ip_dest;
		this.mac_src=mac_src;
		this.content=content;
	}
	
	public AddrIp getIp_src() {return ip_src;}
	public void setIp_src(AddrIp ip_src) {this.ip_src=ip_src;}
	public AddrIp getIp_dest() {return ip_dest;}
	public void setIp_dest(AddrIp ip_dest) {this.ip_dest=ip_dest;}
	
	public AddrMac getMac_src() {return mac_src;}
	public void setMac_src(AddrMac mac_src) {this.mac_src=mac_src;}
	
	public String getContent() {return content;}
	public void setContent(String content) {this.content=content;}
}
