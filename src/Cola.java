public class Cola {
    private int numero;
    private boolean disponible = false;//inicialmente cola vacia

    public synchronized int get() {
        if (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        disponible = false;
        notify();
        return numero;
    }

    public synchronized void put(int valor) {
        if (disponible){
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        numero = valor;
        disponible = true;
        notify();
    }
}
