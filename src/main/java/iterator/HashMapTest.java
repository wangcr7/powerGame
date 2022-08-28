package iterator;


import java.util.HashMap;
import java.util.Map;

/**
 * @program: WChi_Add_2020
 * @description:
 * @author: wang chi
 * @create: 2020-05-24 14:57
 */
public class HashMapTest {

    public static void main(String[] args) {

        System.out.println(1);

        Map map = new HashMap();

        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "1");
        map.put("5", "2");
        map.put("6", "3");
        map.put("7", "1");
        map.put("8", "2");
        map.put("9", "3");
        map.put("10", "1");
        map.put("11", "2");
        map.put("12", "3");
        map.put("13", "3");


//        System.out.println(map.size());

        Map hashMap = new HashMap(map);
    }
}
