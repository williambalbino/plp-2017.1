
public class Consumidor extends Thread{

	private int id;
	private Buffer buffer;
	private int totalConsumido;
		
	public Consumidor(int id, Buffer buffer, int totalConsumido) {
		super();
		this.id = id;
		this.buffer = buffer;
		this.totalConsumido = totalConsumido;
	}
	public void run(){
		for( int i = 0; i < totalConsumido ; i++){
			buffer.consumir(id);
		}
		System.out.println("\nConsumidor " + id + " concluido");
	}
	
	
	
	
	
}
