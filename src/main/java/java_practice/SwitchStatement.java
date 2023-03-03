package java_practice;

public class SwitchStatement {
    public void switchStatement(){
        char grade = 'C';

        switch(grade){
            case 'A':
                System.out.println("Excellent");
                break;
            case 'B':
                System.out.println("You are okay");
                break;
            case 'C':

            case 'D':
                System.out.println("Not good");
                break;
            default:
                System.out.println("Failed");
        }

    }
}
