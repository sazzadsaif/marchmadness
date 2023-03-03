package java_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {
    public void listDemo(){
        List<String> houseList = new ArrayList<>();
        houseList.add("Florida");
        houseList.add("California");
        houseList.add("Missouri");
        houseList.add("Illinois");
        System.out.println(houseList);
        houseList.add("NewYork");
        System.out.println(houseList);
        houseList.remove("California");

        System.out.println();
        System.out.println();

        String[] houses = houseList.toArray(new String[houseList.size()]);
        System.out.println(Arrays.toString(houses));

    }
}
