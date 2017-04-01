
public class Buffer {

	private int conteudo;
	private boolean livre;
	
	public synchronized void produzir(int idProdutor, int valor) {
        while (livre == true) {
            try {
                System.out.println("Produtor " + idProdutor + " aguardando consumidor liberar o buffer...\n");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        conteudo = valor;
        System.out.println("Produtor " + idProdutor + " colocou item " + conteudo);
        livre = true;
        notifyAll();
    }
 
	public synchronized int consumir(int idConsumidor) {
        while (livre == false) {
            try {
                System.out.println("Consumidor " + idConsumidor + " aguardando item ser produzido...\n");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumidor " + idConsumidor + " consumiu item " + conteudo);
        livre = false;
        notifyAll();
        return conteudo;
    }
	
}
