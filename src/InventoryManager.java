import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InventoryManager {
    public static void main(String[] args) {
        HashTable ht1 = new HashTable(200003, 1); // Tamaño primo para reducir colisiones
        HashTable ht2 = new HashTable(200003, 2);

        String line;
        String splitBy = ",";
        String filePath = "src/negocios.csv"; // Ruta relativa al archivo CSV

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Ignorar la primera línea (encabezados)
            while ((line = br.readLine()) != null) {
                String[] negocio = line.split(splitBy);
                if (negocio.length >= 8) {
                    try {
                        Item item = new Item(
                            negocio[0], negocio[1], negocio[2], negocio[3], negocio[4],
                            Integer.parseInt(negocio[5]), Double.parseDouble(negocio[6]), Double.parseDouble(negocio[7])
                        );
                        ht1.insert(item);
                        ht2.insert(item);
                        System.out.println(item); // Mostrar el registro leído
                    } catch (NumberFormatException e) {
                        System.err.println("Error de formato en la línea: " + line);
                    }
                } else {
                    System.err.println("Línea inválida (no tiene suficientes campos): " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
            e.printStackTrace();
        }

        // Realizar la comparación de tiempos
        HashTableComparison.compare();
    }
}
