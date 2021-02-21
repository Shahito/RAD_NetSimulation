package traceur_de_paquet;

public class AddrIp {
	private short[] ip=new short[4];
	private short[] mask=new short[4];
	
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
	public AddrIp(short[] ip,short[] mask) {
		setIp(ip);
		setMask(mask);
	}
	
	public short[] getIp() {return this.ip;}
	
	public void setIp(short[] ip) {
		for(int n=0;n<4;n++) {
			this.ip[n]=ip[n];
		}
	}

	public short[] getMask() {return this.mask;}
	
	public void setMask(short[] mask) {
		for(int n=0;n<4;n++) {
			this.mask[n]=mask[n];
		}
	}
}
