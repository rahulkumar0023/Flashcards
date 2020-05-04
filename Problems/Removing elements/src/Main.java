import java.util.*;

class SetUtils {
   // static Set<Integer> set = new HashSet<>();
    public static Set<Integer> getSetFromString(String str) {
        Set<Integer> set = new HashSet<>();
        // write your code here
        String[] stringArray = str.split(" ");
        for(String s : stringArray){
            set.add(Integer.parseInt(s));
        }

        return set;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        // write your code here
        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()){
            Integer element = itr.next();

            if(element > 10){
                itr.remove();
            }
        }
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}