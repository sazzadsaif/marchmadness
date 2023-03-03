package java_practice;

import java.util.Arrays;

public class StringDemo {

    public static void main(String[] args){
        String house = "Florida,NewYork,Texas,Illinois";
        System.out.println(house);
        System.out.println(Arrays.toString(house.split(" ")));
    }
}
