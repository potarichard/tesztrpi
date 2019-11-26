package hashing.openaddress;


// Like separate chaining, open addressing is a method for handling collisions. In Open Addressing, all elements are stored in the hash table itself. 
// So at any point, size of the table must be greater than or equal to the total number of keys (Note that we can increase table size by copying old data if needed).
//
// Insert(k): Keep probing until an empty slot is found. Once an empty slot is found, insert k.
//
// Search(k): Keep probing until slot’s key doesn’t become equal to k or an empty slot is reached.
//
// Delete(k): Delete operation is interesting. If we simply delete a key, then search may fail. So slots of deleted keys are marked specially as “deleted”.
// Insert can insert an item in a deleted slot, but the search doesn’t stop at a deleted slot.

public class HashMapOwn 
{

	private final static int TABLE_SIZE = 128;
    HashEntry[] table;

    HashMapOwn() 
    {
          table = new HashEntry[TABLE_SIZE];
          
          for (int i = 0; i < TABLE_SIZE; i++)
                table[i] = null;
    }


    public int get(int key) 
    {
          int hash = (key % TABLE_SIZE);
          int initialHash = -1;
          
          while (	hash != initialHash && (table[hash] == DeletedEntry.getUniqueDeletedEntry() 
      		  		|| table[hash] != null && table[hash].getKey() != key))
          {
	            if (initialHash == -1)
	                  initialHash = hash;
	
	            hash = (hash + 1) % TABLE_SIZE;
          }

          if (table[hash] == null || hash == initialHash)
        	  return -1;

          else
        	  return table[hash].getValue();

    }



    public void put(int key, int value) 
    {
          int hash = (key % TABLE_SIZE);
          int initialHash = -1;
          int indexOfDeletedEntry = -1;
          
          
          while (	hash != initialHash && (table[hash] == DeletedEntry.getUniqueDeletedEntry() 
        		  	|| table[hash] != null && table[hash].getKey() != key)) 
          {
                if (initialHash == -1)
                      initialHash = hash;

                if (table[hash] == DeletedEntry.getUniqueDeletedEntry())
                      indexOfDeletedEntry = hash;

                hash = (hash + 1) % TABLE_SIZE;
          }

          if ((table[hash] == null || hash == initialHash) && indexOfDeletedEntry != -1)
                table[indexOfDeletedEntry] = new HashEntry(key, value);

          else if (initialHash != hash)
          {
        	  if (table[hash] != DeletedEntry.getUniqueDeletedEntry() && table[hash] != null && table[hash].getKey() == key)
                 table[hash].setValue(value);
        	  else
                 table[hash] = new HashEntry(key, value);
          }
    }


    public void remove(int key) 
    {

          int hash = (key % TABLE_SIZE);
          int initialHash = -1;

          while (hash != initialHash && (table[hash] == DeletedEntry.getUniqueDeletedEntry() 
        		  || table[hash] != null && table[hash].getKey() != key)) 
          {
                if (initialHash == -1)
                      initialHash = hash;

                hash = (hash + 1) % TABLE_SIZE;
          }

          if (hash != initialHash && table[hash] != null)
                table[hash] = DeletedEntry.getUniqueDeletedEntry();
    }
	
}





















