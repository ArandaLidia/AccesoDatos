import java.io.File;
import java.io.IOException;

public class gestionFicheros {

    public void trabajoFicheros(){
        //File -> ruta (absolutas o relativas)
        //absolutas C:\\adfafads\\adfasdf\\adsfdasfas
        //relativa: desde src incluido - Content Root
        File file =new File("src/resources/ejemplo1.txt");
        File carpeta=new File("src/resources/fichero");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error en la creación del fichero");
                System.out.println(e.getMessage());
            }
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getName());
            System.out.println(file.canRead());
            System.out.println(file.canWrite());
            System.out.println(file.isFile());
            System.out.println(file.isHidden());
        }

        if (!carpeta.exists()){
            carpeta.mkdir();
        }
        for (File item : carpeta.listFiles()){
            System.out.println(item.getName());
        }

        System.out.println(carpeta.list()[0]);
    }
}
