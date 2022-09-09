/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author nache
 */
public class SaveableDictionary {

    private Map<String, String> dict;
    private String filename;

    public SaveableDictionary() {
        this.dict = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this.dict = new HashMap<>();
        this.filename = file;
    }

    public void add(String words, String translation) {
        if (this.dict.containsKey(words)) {
            return;
        }
        this.dict.put(words, translation);
        this.dict.put(translation, words);
    }

    public String translate(String word) {
        return this.dict.get(word);
    }

    public void delete(String word) {
        this.dict.remove(word);
        this.dict.values().remove(word);
    }

    public boolean load() {
        try {
            Scanner scan = new Scanner(Paths.get(this.filename));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] words = line.split(":");
                this.add(words[0], words[1]);
                this.add(words[1], words[0]);

            }
            return true;
        } catch (Exception e) {
            System.out.println("meow");
            return false;
        }
    }

    public boolean save() {
        try {
            PrintWriter p = new PrintWriter(this.filename);
            HashMap <String, String> checker = new HashMap<>();
            for(String word: this.dict.keySet()){
                
                checker.put(word, this.dict.get(word));
                if(!checker.containsKey(word) || !checker.containsValue(word)){
                    p.println(word + ":" + this.dict.get(word));
                }
                
            }
            p.close();           
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
