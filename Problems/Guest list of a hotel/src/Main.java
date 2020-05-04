//put imports you need here

import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] guests = new String[8];

        int counter = 0;

        while(sc.hasNext()){
            String input = sc.nextLine();
            if(!input.equals("exit")){

                String names[] = input.split(" ");

                for(String name : names){
                    guests[counter] =  name;
                    counter++;
                }
            }else{
                break;
            }
        }
        for(int i = guests.length-1; i >= 0 ; i--){
            System.out.println(guests[i]);
        }
    }
}