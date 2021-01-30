public class Clients {
	static String name;
	
public Clients() {
}
	
public Clients(String name) {
	name = Clients.name;
}
	
public static void clients(String[] args) {
	Clients computer = new Clients(name);
}

}