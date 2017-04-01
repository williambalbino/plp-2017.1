
public class Buffer {

	private int conteudo;
	private boolean disponivel;
	
// O metodo produzir() irá colocar o item produzido pelo consumidor no buffer
	
	public synchronized void produzir(int idProdutor, int valor) {			
        while (disponivel == true) {
            try {
                System.out.println("Produtor " + idProdutor + " aguardando consumidor liberar o buffer...\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        conteudo = valor;
        System.out.println("Produtor " + idProdutor + " colocou item " + conteudo);
        disponivel = true;
    }
 
/*
 * O metodo consumir() irá consumir o item que está no buffer que foi criado pelo produtor, 
 * mas como o Produtor não enviou a notificação de que existe um item no buffer, o Consumidor
 * entrará em deadlock, porque ficará esperando eternamente o item do produtor.
 */
	
	public  synchronized int consumir(int idConsumidor) {
        while (disponivel == false) {
            try {
                System.out.println("Consumidor " + idConsumidor + " aguardando item ser produzido...\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumidor " + idConsumidor + " consumiu item " + conteudo);
        disponivel = false;
        return conteudo;
    }
	
}
