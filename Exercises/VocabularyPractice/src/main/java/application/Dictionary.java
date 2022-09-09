package application;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nache
 */
public class Dictionary {
    
    private HashMap<String, String> translations;
    private List<String> randoms;

    public Dictionary() {
        this.translations = new HashMap<>();
        this.randoms = new ArrayList<>();
        
    }
    
    public void add(String word, String translation){
        if(this.translations.keySet().contains(word)){
            return;
        }
        this.translations.put(word, translation);
        this.randoms.add(word);
    }
    
    public String get(String word){
        return this.translations.get(word);
    }
    
    public String getRandom(){
        Random rand = new Random();
        return this.randoms.get(rand.nextInt(this.randoms.size()));
    }
    
    public Boolean contains(String word){
        if(this.translations.keySet().contains(word)){
            return true;
        }
        return false;
    }

    
    
}
