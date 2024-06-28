import java.util.LinkedList;

public class HashTable {
    private LinkedList<Item>[] table;
    private int size;
    private int hashFunction;
    private int collisionCount;

    @SuppressWarnings("unchecked")
    public HashTable(int size, int hashFunction) {
        this.size = size;
        this.hashFunction = hashFunction;
        this.collisionCount = 0;
        this.table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash1(String key) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash = (hash * 31 + c) % size;
        }
        return hash;
    }

    private int hash2(String key) {
        int hash = 7;
        for (char c : key.toCharArray()) {
            hash = (hash * 31 + c) % size;
        }
        return hash * 17 % size;
    }

    private int getHash(String key) {
        if (hashFunction == 1) {
            return hash1(key);
        } else {
            return hash2(key);
        }
    }

    public void insert(Item item) {
        int hash = getHash(item.negocio);
        if (!table[hash].isEmpty()) {
            collisionCount++;
        }
        table[hash].add(item);
    }

    public Item search(String key) {
        int hash = getHash(key);
        for (Item item : table[hash]) {
            if (item.negocio.equals(key)) {
                return item;
            }
        }
        return null;
    }

    public int getCollisionCount() {
        return collisionCount;
    }
}
