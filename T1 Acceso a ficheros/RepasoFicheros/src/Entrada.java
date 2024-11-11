import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Entrada {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\Lidia\\Documents\\CFGS DAM\\CONTRASEÑA PORTAL UNIVERSIDAD.txt"); //suponemos que existe el fichero
        FileReader fr = new FileReader(f);
        int c;
        while ((c = fr.read()) != -1) {
            char letra = (char) c;
            System.out.print(letra);
        }
    }
}
