package flashcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static Map<String, String> cdMainMap =  new LinkedHashMap<>();
    static List<String> logs = new ArrayList<>();
    static HashMap<String, Integer> hardestCards = new HashMap<>();

    public static void main(String[] args) {
        Main mainObj = new Main();
        mainObj.checkForUserInput();
    }

    private void exitProgram() {
        System.out.println("Bye bye!");
        logs.add("Bye bye!");
    }

    private void ask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many times to ask?");
        logs.add("How many times to ask?");
        int timesToAsk = Integer.parseInt(sc.nextLine());
        logs.add(Integer.toString(timesToAsk));

        Random randomGenerator = new Random();
        int mapQuestionIndex = 0;

        Object[] cardMapKeysArray = cdMainMap.keySet().toArray();
        for (int i = 0; i < timesToAsk; ++i){
            mapQuestionIndex = randomGenerator.nextInt(cdMainMap.size());
            String  key = (String)cardMapKeysArray[mapQuestionIndex];
            String value = (String) cdMainMap.get(key);

            System.out.println("Print the definition of \""+key+"\""+":");
            logs.add("Print the definition of \""+key+"\""+":");

            String answer = sc.nextLine();
            logs.add(answer);

            if(answer.equalsIgnoreCase(value)){
                System.out.println("Correct answer.");
                logs.add("Correct answer.");
            }else{

                System.out.print("Wrong answer , The correct one is \""+value+"\"");
                logs.add("Wrong answer , The correct one is \""+value+"\"");
                if(hardestCards.containsKey(key)){
                    hardestCards.computeIfPresent(key, (k,v) -> v+1);
                }else {
                    hardestCards.computeIfAbsent(key, k -> 1);
                }

                if(cdMainMap.containsValue(answer)){
                    for (Map.Entry mapElm : cdMainMap.entrySet()){
                        String k = (String) mapElm.getKey();
                        String v = (String) mapElm.getValue();
                        if(v.equals(answer)){
                            System.out.println(", you've just written the definition of \""+k+"\"");
                            logs.add(", you've just written the definition of \""+k+"\"");
                        }
                    }

                }else{
                    System.out.println();
                }

            }


        }

    }

    private void exportCards() {
        Scanner sc = new Scanner(System.in);
        System.out.println("File name:");
        logs.add("File name:");

        String fileName = sc.nextLine();
        logs.add(fileName);

        File file = new File("D:\\IntelliJ\\"+fileName);
        int counter = 0;

        try (FileWriter writer = new FileWriter(file)) {


            for(Map.Entry<String,String> mapElement : cdMainMap.entrySet()){
                writer.write(mapElement.getKey() + "," + mapElement.getValue() +"\n");
                logs.add(mapElement.getKey() + "," + mapElement.getValue() +"\n");
                counter++;
            }
            System.out.println(counter + " cards have been saved.");
            logs.add(counter + " cards have been saved.");
        } catch (IOException e) {
            System.out.printf("IO Exception while writing");
            logs.add("IO Exception while writing");
        }

    }

    private void importCards() {
        Scanner sc = new Scanner(System.in);
        System.out.println("File name:");
        logs.add("File name:");

        String fileName = sc.nextLine();
        logs.add(fileName);

        File file = new File("D:\\IntelliJ\\"+fileName);
        int counter = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] keyValue = scanner.nextLine().split(",");
                String key = keyValue[0];
                String value = keyValue[1];
                cdMainMap.put(key,value);
                counter++;
            }
            System.out.println(counter+" cards have been loaded.");
            logs.add(counter+" cards have been loaded.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            logs.add("File not found.");
        }


    }

    private void removeCard() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The card:");
        logs.add("The card:");

        String cardToRemove = sc.nextLine();
        logs.add(cardToRemove);

        if(cdMainMap.containsKey(cardToRemove)){
            cdMainMap.remove(cardToRemove);
            System.out.println("The card has been removed.\n");
            logs.add("The card has been removed.\n");
        }else{
            System.out.println("Can't remove \""+cardToRemove+"\": there is no such card.\n");
            logs.add("Can't remove \""+cardToRemove+"\": there is no such card.\n");
        }

    }

    private void checkForUserInput(){
        Main mainObj = new Main();
        Scanner sc = new Scanner(System.in);

        System.out.println("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):");
        logs.add("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):");

        String action = sc.nextLine();
        logs.add(action);

        switch(action){
            case "add" :
                mainObj.addCard();
                mainObj.checkForUserInput();
                break;
            case "remove" :
                mainObj.removeCard();
                mainObj.checkForUserInput();
                break;
            case "import" :
                mainObj.importCards();
                System.out.println();
                mainObj.checkForUserInput();
                break;
            case "export" :
                mainObj.exportCards();
                System.out.println();
                mainObj.checkForUserInput();
                break;
            case "ask" :
                mainObj.ask();
                System.out.println();
                mainObj.checkForUserInput();
                break;
            case "exit" :
                mainObj.exitProgram();
                break;
            case "log" :
                mainObj.exportLogs();
                System.out.println();
                mainObj.checkForUserInput();
                break;
            case "hardest card" :
                mainObj.findHardestCard();
                System.out.println();
                mainObj.checkForUserInput();
                break;
            case "reset stats" :
                mainObj.resetStats();
                System.out.println();
                mainObj.checkForUserInput();
                break;
        }

    }

    private void resetStats() {
        hardestCards.clear();
    }

    private void findHardestCard() {

        if(!hardestCards.isEmpty()){

            List<Map.Entry<String, Integer>> list = new LinkedList<>(hardestCards.entrySet());

            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return (o2.getValue().compareTo(o1.getValue()));
                }
            });

            HashMap<String,Integer> temp =  new HashMap<>();

            for(Map.Entry<String, Integer> m : list){
                temp.put(m.getKey(),m.getValue());
            }

            Set<Map.Entry<String,Integer>> entrySet = temp.entrySet();
            List<String> qList = new ArrayList<>();

            int hardestCount = entrySet.iterator().next().getValue();

            for(Map.Entry<String, Integer> m : entrySet){
                if(m.getValue() == hardestCount){
                    qList.add(m.getKey());
                }
            }

            if(qList.size() > 1){
                System.out.print("The hardest cards are ");
                logs.add("The hardest cards are ");
                for(int i = 0 ; i < qList.size(); i++){
                    System.out.print("\""+qList.get(i)+"\"");
                    if(i == (qList.size() - 1)){continue;}
                    System.out.print(", ");
                }
                System.out.println(". You have "+hardestCount+" errors answering them.");
                logs.add(". You have "+hardestCount+" errors answering them.");
            }else{
                System.out.print("The hardest card is \""+qList.get(0)+"\"");
                System.out.println(". You have "+hardestCount+" errors answering them.");
                logs.add("The hardest card is \""+qList.get(0)+"\"");
                logs.add(". You have "+hardestCount+" errors answering them.");
            }

        }else{
            logs.add("There are no cards with errors.");
            System.out.println("There are no cards with errors.");
        }

    }

    private void exportLogs() {

        Scanner sc = new Scanner(System.in);
        System.out.println("File name:");
        logs.add("File name:");

        String fileName = sc.nextLine();
        logs.add(fileName);

        File file = new File("D:\\IntelliJ\\"+fileName);

        try (FileWriter writer = new FileWriter(file)) {
            for(String s : logs){
                writer.write( s +" \n");
            }
            System.out.println("The log has been saved.");
            logs.add("The log has been saved.");
        } catch (IOException e) {
            System.out.printf("IO Exception while writing");
            logs.add("IO Exception while writing");
        }

    }

    private void addCard(){

        Scanner sc = new Scanner(System.in);
        System.out.println("The card:");
        logs.add("The card:");

        String key = sc.nextLine();
        logs.add(key);

            if(!cdMainMap.containsKey(key)){

                System.out.println("The definition of card:");
                logs.add("The definition of card:");

                String value = sc.nextLine();
                logs.add(value);

                    if(!cdMainMap.containsValue(value)){
                        cdMainMap.put(key,value);
                        System.out.println("The pair (\""+key+"\":\""+value+"\") has been added.\n");
                        logs.add("The pair (\""+key+"\":\""+value+"\") has been added.\n");
                    }else{
                        System.out.println("The definition \""+value+"\" already exists.\n");
                        logs.add("The definition \""+value+"\" already exists.\n");
                    }

            }else{
                System.out.println("The card \""+key+"\" already exists.\n");
                logs.add("The card \""+key+"\" already exists.\n");
            }

    }
    
}
