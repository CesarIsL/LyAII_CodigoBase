import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Principal {
    
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false); // Quitar la opción "todos los archivos"
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de texto", "txt"));
        int result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            StringBuilder codigo = new StringBuilder();

            try (BufferedReader lector = new BufferedReader(new FileReader(file))) {
                String linea;
                while ((linea = lector.readLine()) != null) {
                    codigo.append(linea).append(" ");
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo:");
                e.printStackTrace();
                return;
            }

            String contenido = codigo.toString().trim();
            if (contenido.isEmpty()) {
                System.out.println("El archivo está vacío o no contiene código válido.");
                return;
            }

            // Confirmación de lectura
            System.out.println("Archivo cargado: " + file.getName());
            System.out.println("Contenido del archivo:\n------------------------");
            System.out.println(contenido);
            System.out.println("------------------------\n");

            try {
                 new Parser(contenido);

                System.out.println("-------------------------------\n");

            } catch (Exception e) {
                System.err.println("Error al ejecutar el parser:");
                e.printStackTrace();
            }

        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }
}
