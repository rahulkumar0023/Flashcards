import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[10];
        int count=0;
        int input;

        while(sc.hasNextInt()){
            input = sc.nextInt();

            if(input==0){
                break;
            }else{
                a[count] = input;
                count++;
            }


        }


        int[] b = new int[count];

        for(int i=0;i<b.length;i++){
            b[i] = a[i];
        }
        int[] c = new int[count];
        for(int i=0;i<c.length;i++){
            c[i] = b[i];
        }

        System.out.println(isEqual(b,c));

    }

    public static void reverseSort(int[] array){

        multiplyMinusOne(array);
        Arrays.sort(array);
    }

    public static void multiplyMinusOne(int[] array){
        for(int i=0;i<array.length;i++){
            array[i] = array[i] * -1;
        }
    }


    public static boolean isEqual(int[] a, int[] b) {
        boolean compare = false;
        Arrays.sort(b);
        if( Arrays.equals(a,b)){
            compare = true;
        }
        reverseSort(b);
        multiplyMinusOne(b);
        if( Arrays.equals(a,b)){
            compare = true;
        }
        return compare;

    }
}