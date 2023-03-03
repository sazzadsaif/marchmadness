package java_practice;

import java.util.HashMap;
import java.util.Map;

public class LearnHashMap {
    HashMap<String,Integer> hashMap = new HashMap<>();

    public void roleNumber(){
        hashMap.put("Sazzad",991433);
        hashMap.put("Blood",991425);
        hashMap.put("Apu",991413);
        hashMap.put("Riaz",991332);
        hashMap.put("Jewel", 991440);

        //System.out.println("Get Apu's id " + hashMap.get("Apu"));
        System.out.println(hashMap);
        System.out.println(hashMap.size());
        System.out.println(hashMap.containsKey("Sazzad"));
        if(hashMap.containsKey("Blood")){
            Integer a = (hashMap.get("Jewe"));
            String b = String.valueOf(hashMap.get("Blood"));
            System.out.println("Value of key" + "\"Blood\" is " + a );
            System.out.println("Value of key" + "\"Jewel\" is " + b );
        }


        //for(Map.Entry<String,Integer> map : hashMap.entrySet()){
            //System.out.println(map.getKey() + "  " + map.getValue());

        }

    }
//}
