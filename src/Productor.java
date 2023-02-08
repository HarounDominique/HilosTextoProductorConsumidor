import java.io.FileReader;
import java.io.IOException;

public class Productor extends Thread {
    private Cola cola;
    private String nombreArchivo;


    public Productor(Cola c, String nombreArchivo) {
        cola = c;
        this.nombreArchivo = nombreArchivo;
    }
/*
    public void leerFichero(){
        try {
            FileReader archivo = new FileReader(nombreArchivo);
            int c = archivo.read();
            while (c != -1) {
                System.out.print((char) c);
                c = archivo.read();
            }
            archivo.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }

 */


    public void run() {
        try {
            FileReader archivo = new FileReader(nombreArchivo);
            int c = archivo.read();
            while (c != -1) {
                c = archivo.read();
                cola.put(c);
            }
            archivo.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }
}
