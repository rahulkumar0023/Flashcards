import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // start coding here

            char[] theChars = new char[50];



            int charsRead = reader.read(theChars, 0, theChars.length);
            while(charsRead != -1) {
                System.out.println(new String(theChars, 0, charsRead));
                charsRead = reader.read(theChars, 0, theChars.length);
            }




        }
    }
}