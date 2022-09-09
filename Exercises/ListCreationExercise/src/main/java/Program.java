
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> myList = new List<>();
        System.out.println(myList.contains("hello"));
        myList.add("hello");
        System.out.println(myList.contains("hello"));
    }

}
