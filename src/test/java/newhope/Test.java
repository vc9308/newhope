package newhope;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
    	Map<Object, Object> map = new HashMap<Object, Object>();
    	map.put(null, null);
    	map.put(null, null);
    	map.put(3, 1);
    	map.put(3, 2);
    	map.put(null, null);
    	System.out.println(map.get(null));
    	System.out.println(map.size());

    }
}
