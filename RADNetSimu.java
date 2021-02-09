package traceur_de_paquet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RADNetSimu {
	public static void main(String[] args) throws IOException {
		
		short[] ip1 = {10,4,110,1};
		short[] mask1={255,0,0,0};
		AddrIp ipaddr1 = new AddrIp(ip1,mask1);
		String[] mac1={"ef","ae","d7","fd","29","38"};
		AddrMac macaddr1 = new AddrMac(mac1);
		
		System.out.println(Arrays.toString(ipaddr1.getIp()));
		System.out.println(Arrays.toString(ipaddr1.getMask()));
		System.out.println(Arrays.toString(macaddr1.getMac()));
	}
}
