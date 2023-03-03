package java_practice;

public class Student {
    int a;
    static int b;


    public Student(){
        b++;
    }
    public void showData(){
        System.out.println("Value of a = " + a);
        System.out.println("Value o b =  " + b);
    }
    public static void increment(){
        b++;
        //a++;
    }
}
