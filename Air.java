package traceur_de_paquet;

// Classe permettant de simuler le média de l'air pour la connexion wifi
public class Air {
	public Air() {}
	// Envoie des broadcasts aux équipements équipés d'une carte réseau wifi
	public void emit(Packet p) {
		for(Equipement.Interfaces inter:Equipement.allWirelessInts) {
			inter.recv(p);
		}
	}
}
/*42795f536861*/









