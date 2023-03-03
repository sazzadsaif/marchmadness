package java_practice;

import java.util.*;

public class LearnArray {
    public void arrayOne(){
        String[] houses = {"Florida", "NewYork", "Missouri", "Illinois","California"};
        System.out.println(houses[0]);

        //System.out.println(Arrays.toString(houses));

        Arrays.sort(houses);
        System.out.println(Arrays.toString(houses));

        Arrays.sort(houses, Collections.reverseOrder());
        //System.out.println(Arrays.toString(houses));

        List<String> myHouses = new ArrayList<String>();
        String house = Arrays.toString(houses);
        for(int i = 0; i < houses.length; i++){
            myHouses.add(house);
        }
        System.out.println(house);


    }
}
