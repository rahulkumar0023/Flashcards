import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();
        int[] array = new int[length];

        for(int i=0;i<length;i++){
            array[i] = sc.nextInt();
        }

        int findInt = sc.nextInt();
        int counter = 0;

        for(int a : array){
            if(a==findInt){
                counter++;
            }
        }

        System.out.println(counter);

    }
}