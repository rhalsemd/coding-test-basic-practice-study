import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer line = new StringBuffer();
        line.append(in.readLine());

        try{
            line.delete(0, line.indexOf("U"));
            line.delete(1, line.indexOf("C"));
            line.delete(2, line.indexOf("P"));
            line.delete(3, line.lastIndexOf("C"));
        } catch(StringIndexOutOfBoundsException e){
            System.out.println("I hate UCPC");
            System.exit(0);
        } finally {
            System.out.println("I love UCPC");
        }
    }
}