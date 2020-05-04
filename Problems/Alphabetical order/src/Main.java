import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] stringArr = sc.nextLine().split(" ");
        boolean compareFlag = true;

        for(int i = 0; i < stringArr.length - 1; i++ ){

           if(!stringArr[i].isEmpty()){
               if(stringArr[i].length() > stringArr[i+1].length()){
                   compareFlag = false;
               }else {
                   if((stringArr[i].compareTo(stringArr[i+1])) > 0){
                       compareFlag = false;
                   }else{
                       compareFlag = false;
                   }
               }
           }


        }

        System.out.println( compareFlag);

    }
}