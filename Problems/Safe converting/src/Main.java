import java.util.Scanner;

public class Main {

    public static int convert(Long val) {
        // write your code here
        long l = 0;

        if(val != null){
            if(val > Integer.MAX_VALUE){
                l = Integer.MAX_VALUE;
            }else if(val < Integer.MIN_VALUE){
               l = Integer.MIN_VALUE;
            }else{
                l = val;
            }
        }


        return (int)l;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String val = scanner.nextLine();
        Long longVal = "null".equals(val) ? null : Long.parseLong(val);
        System.out.println(convert(longVal));
    }
}