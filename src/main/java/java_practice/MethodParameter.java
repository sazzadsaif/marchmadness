package java_practice;

public class MethodParameter {

    private int salary = 50000;
    private int  increasedSalary = salary + 5000;
    public void mSalary(){
        System.out.printf(String.valueOf(increasedSalary));
    }

    public int studentSalary (int currentSalary){
        System.out.println("Student current salary is: " + currentSalary);
        return currentSalary;
    }
    public void salaryAfterIncrement(int currentSalary, int increment){
        System.out.printf("New salary after increment is: " + (currentSalary + increment));
    }
}
