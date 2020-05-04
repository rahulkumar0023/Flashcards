import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int[] A = new int[length];

        for(int i=0;i<length;i++){
            A[i] = sc.nextInt();
        }


        int lastElement = A[length-1];
        for (int i = length -1 ; i > 0 ; i--)
            A[i] = A[i-1];
        A[0] = lastElement;

        System.out.println(Arrays.toString(A).replaceAll("[\\[|\\]\\,]", ""));

       /* for(int i=0;i<length;i++){
            System.out.print(A[i]+"  ");
        }*/


    }
}