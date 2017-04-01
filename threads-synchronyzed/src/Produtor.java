
public class Produtor extends Thread{
		
	private int id;
	private Buffer buffer;
	private int totalProduzido;
	
	public Produtor(int id, Buffer buffer, int totalProduzido) {
		super();
		this.id = id;
		this.buffer = buffer;
		this.totalProduzido = totalProduzido;
	}

	public void run(){
		for(int i = 1; i <= totalProduzido; i++){
			buffer.produzir(id, i);
		}
		System.out.println("\nProdutor " + id + " concluído");
	}

	
	
	
	
	
	
}
