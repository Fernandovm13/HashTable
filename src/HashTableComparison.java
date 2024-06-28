import java.util.Random;

public class HashTableComparison {
    public static void compare() {
        // Crear dos hash tables con tamaño grande para evitar colisiones
        HashTable ht1 = new HashTable(200003, 1); // Método de hashing 1
        HashTable ht2 = new HashTable(200003, 2); // Método de hashing 2

        // Generar datos de prueba aleatorios
        Random random = new Random();
        long totalInsertionTime1 = 0;
        long totalInsertionTime2 = 0;
        long totalSearchTime1 = 0;
        long totalSearchTime2 = 0;
        int numRecords = 100000; // Número de registros a insertar y buscar

        // Generar datos de prueba aleatorios para inserción
        for (int i = 0; i < numRecords; i++) {
            Item item = generateRandomItem();

            // Medir tiempo de inserción en la HashTable 1
            long startTime = System.nanoTime();
            ht1.insert(item);
            long endTime = System.nanoTime();
            totalInsertionTime1 += (endTime - startTime);

            // Medir tiempo de inserción en la HashTable 2
            startTime = System.nanoTime();
            ht2.insert(item);
            endTime = System.nanoTime();
            totalInsertionTime2 += (endTime - startTime);
        }

        // Calcular tiempos promedio de inserción
        long avgInsertionTime1 = totalInsertionTime1 / numRecords;
        long avgInsertionTime2 = totalInsertionTime2 / numRecords;

        // Generar clave aleatoria para búsqueda y medir tiempos
        for (int i = 0; i < numRecords; i++) {
            String randomKey = generateRandomString(10);

            // Medir tiempo de búsqueda en la HashTable 1
            long startTime = System.nanoTime();
            ht1.search(randomKey);
            long endTime = System.nanoTime();
            totalSearchTime1 += (endTime - startTime);

            // Medir tiempo de búsqueda en la HashTable 2
            startTime = System.nanoTime();
            ht2.search(randomKey);
            endTime = System.nanoTime();
            totalSearchTime2 += (endTime - startTime);
        }

        // Calcular tiempos promedio de búsqueda
        long avgSearchTime1 = totalSearchTime1 / numRecords;
        long avgSearchTime2 = totalSearchTime2 / numRecords;

        // Mostrar tiempos promedio y colisiones
        System.out.println("Tiempo promedio de inserción (HashTable 1): " + avgInsertionTime1 + " ns");
        System.out.println("Tiempo promedio de inserción (HashTable 2): " + avgInsertionTime2 + " ns");
        System.out.println("Tiempo promedio de búsqueda (HashTable 1): " + avgSearchTime1 + " ns");
        System.out.println("Tiempo promedio de búsqueda (HashTable 2): " + avgSearchTime2 + " ns");
        System.out.println("Cantidad de colisiones (HashTable 1): " + ht1.getCollisionCount());
        System.out.println("Cantidad de colisiones (HashTable 2): " + ht2.getCollisionCount());
    }

    // Generar un Item aleatorio para propósitos de prueba
    private static Item generateRandomItem() {
        Random random = new Random();
        return new Item(
            generateRandomString(10),  // negocio
            generateRandomString(10),  // nombre
            generateRandomString(15),  // dirección
            generateRandomString(10),  // ciudad
            generateRandomString(2),   // estado
            random.nextInt(100000),    // código postal
            random.nextDouble(),       // latitud
            random.nextDouble()        // longitud
        );
    }

    // Generar una cadena aleatoria de longitud dada
    private static String generateRandomString(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
