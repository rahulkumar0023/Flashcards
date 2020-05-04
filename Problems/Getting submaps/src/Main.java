import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        // put your code here
        SortedMap<Integer, String> myMap = new TreeMap<>();

        Scanner sc = new Scanner(System.in);
        String[] inputStr1 = sc.nextLine().split(" ");
        int startRange = Integer.parseInt(inputStr1[0]);
        int endRange = Integer.parseInt(inputStr1[1]);

        int mapSize = Integer.parseInt(sc.nextLine());

        for(int i = 0 ; i < mapSize ; i++){
            String[] inputStr = sc.nextLine().split(" ");
            myMap.put(Integer.parseInt(inputStr[0]), inputStr[1]);
        }

        myMap = myMap.subMap(startRange,endRange+1);
        myMap.forEach((name, phone) -> System.out.println(name + " " + phone));


    }
}