public class HashTable {
    public static class DataItem {
    private int key;
    private int data;

    public DataItem(int key, int data) {
        this.key = key;
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    public int getData() {
        return data;
    }   
}

    private DataItem[] hashArray;    
    private int size;
    private DataItem dummyItem;

    public HashTable(int size) {
        this.size = size;
        hashArray = new DataItem[size];
        dummyItem = new DataItem(-1, -1);
    }

    public int hashCode(int key) {
        return key % size;
    }
  
    public void insert(DataItem item) {
        // save the key
        int key = item.getKey();

        //get the hash 
        int hashIndex = hashCode(key);

        //find an empty or a deleted cell
        while(hashArray[hashIndex] != null && hashArray[hashIndex].getKey() != -1) {
            //go to next cell
            ++hashIndex;
            //wrap around the table
            hashIndex %= size;
        }

        hashArray[hashIndex] = item;        
    }

    public DataItem delete(DataItem item) {
        int key = item.getKey();

        //get the hash 
        int hashIndex = hashCode(key);

        while(hashArray[hashIndex] != null) {
            if(hashArray[hashIndex].getKey() == key) {
                DataItem temp = hashArray[hashIndex]; 
                //assign a dummy item at deleted position
                hashArray[hashIndex] = dummyItem; 
                return temp;
            }             
            //go to next cell
            ++hashIndex;
            //wrap around the table
            hashIndex %= size;
        }        
        return null;        
    }

    public void display() {
        for(int i = 0; i < size; i++) {
            if(hashArray[i] != null) {
                System.out.print("(" + hashArray[i].getKey() + ", " + hashArray[i].getData() + ") ");
            }   
            else {
                System.out.print("NULL ");
            }
        }

        System.out.println("");
    }

    public DataItem search(int key) {               
        //get the hash 
        int hashIndex = hashCode(key);

        while(hashArray[hashIndex] != null) {
            if(hashArray[hashIndex].getKey() == key)
                return hashArray[hashIndex]; 
            
            //go to next cell
            ++hashIndex;
            //wrap around the table
            hashIndex %= size;
        }        
        return null;        
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(20);

        hashTable.insert(new DataItem(1, 20));
        hashTable.insert(new DataItem(2, 70));
        hashTable.insert(new DataItem(42, 80));
        hashTable.insert(new DataItem(4, 25));
        hashTable.insert(new DataItem(12, 44));
        hashTable.insert(new DataItem(14, 32));
        hashTable.insert(new DataItem(17, 11));
        hashTable.insert(new DataItem(13, 78));
        hashTable.insert(new DataItem(37, 97));

        hashTable.display();

        DataItem item = hashTable.search(37);

        if(item != null) {
            System.out.println("Element found: " + item.getData());
        }
        else {
            System.out.println("Element not found");
        }

        hashTable.delete(item);
	
        item = hashTable.search(37);

        if(item != null) {
            System.out.println("Element found: "+ item.getData());
        }
        else {
            System.out.println("Element not found");
        }
    }
}