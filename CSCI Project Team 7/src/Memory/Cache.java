package Memory;

import java.util.Vector;
import java.util.logging.Logger;

public class Cache {
	
    public static Vector<MemoryData> cache = new Vector<MemoryData>(16);
    final Logger logging = Logger.getLogger("Cache");

    /**
     * add element to cache
     */
    public void addElementToCache(MemoryData newData) {
        cache.add(0, newData);
        cache.setSize(16);
    }

     /**
     * Get a value from the cache first if found it is a cache hit, if it does not exist, cache miss
     */
    public int get(int address) {
        //check cache
        for (int i = 0; i < cache.size(); i++) {
            MemoryData current = cache.elementAt(i);
            if (current.address == address) {
                logging.info("Cache HIT!");
                return current.value;
            }
        }
        logging.info("Cache Miss!");
        logging.severe("Did not find info on the address, check if you have valid address");
        return 0;
    }


    public String ToBinaryString(int value) {
        String a = Integer.toBinaryString(value);// Change to BinaryString
        String Stringlength = "" + 16;
        String format = "%0numberd".replace("number", Stringlength);
        return String.format(format, Long.valueOf(a));//
    }

    /**
     * Print each value of the cache.
     */
    public void PrintCache() {
        int address;
        int value;
        logging.info("CACHE DUMP ...");
        for (int i = 0; i < cache.size(); i++) {
            address = cache.get(i).address;
            value = cache.get(i).value;
            logging.info("DUMP:CACHE #" + i + " [" + ToBinaryString(address) + "(" + address + ")" + "]=>" + ToBinaryString(value) + "(" + value + ")");
        }
        logging.info("TOTAL DUMPED " + cache.size() + " CACHE LOGS.");
    }
    
    public void ClearCache() {
    	cache.clear();
    	cache.setSize(16);
    }
}
