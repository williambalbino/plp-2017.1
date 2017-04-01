
public class Main {

	public static void main(String[] args) {
		
		Buffer buffer = new Buffer();
		
		Produtor produtor = new Produtor(1, buffer, 0);
		Consumidor consumidor = new Consumidor(1, buffer, 3);
		
		produtor.start();
		consumidor.start();
		
	}
	
}
