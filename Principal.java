import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class Principal {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
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
                System.out.println("Error al leer el archivo:");
                e.printStackTrace();
                return;
            }

            String contenido = codigo.toString().trim();
            if (contenido.isEmpty()) {
                System.out.println("El archivo está vacío o no contiene código válido.");
                return;
            }

            try {
                new Parser(contenido);
            } catch (Exception e) {
                System.out.println("Error al ejecutar el parser:");
                e.printStackTrace();
            }
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }
}
