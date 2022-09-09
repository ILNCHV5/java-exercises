package dictionary;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // You can test your dictionary here
        
        SaveableDictionary sd = new SaveableDictionary();
        
        sd.add("typ", "typak");
        System.out.println(sd.translate("typ"));
    }
}
