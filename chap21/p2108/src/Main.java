import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Map<String,Integer> hashMap = new HashMap<>();
        hashMap.put("Smith",30);
        hashMap.put("Anderson",31);
        hashMap.put("Lewis",29);
        hashMap.put("cook",29);
        System.out.println("HashMap:"+hashMap);

        Map<String,Integer> treeMap = new TreeMap<>(hashMap);//在这调用了putall方法。
        System.out.println("TreeMap:"+treeMap);

        Map<String,Integer> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put("Smith",30);
        linkedHashMap.put("Anderson",31);
        linkedHashMap.put("Lewis",29);
        linkedHashMap.put("cook",29);
        System.out.println(linkedHashMap.get("Lewis"));
        System.out.println(linkedHashMap);
    }
}
