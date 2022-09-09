
import java.lang.reflect.Array;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nache
 */
public class List<Type> {

    private Type[] list;
    private int firstFree;

    public List() {
        this.list = (Type[]) new Object[10];
        this.firstFree = 0;
    }

    public void add(Type value) {
        if (this.firstFree == this.list.length) {
            this.grow();
        }
        this.list[firstFree] = value;
        firstFree++;
    }

    private void grow() {
        int newSize = this.list.length + this.list.length / 2;
        Type[] newValues = (Type[]) new Object[newSize];
        for (int i = 0; i < newValues.length; i++) {
            newValues[i] = this.list[i];
        }
        this.list = newValues;
    }

    public boolean contains(Type word) {
        return indexOfValue(word) >= 0;
    }

    public void remove(Type value) {
        int indexOfValue = indexOfValue(value);
        if(indexOfValue < 0){
            return;
        }
        this.moveToTheLeft(indexOfValue);
        this.firstFree --;
    }

    public int indexOfValue(Type value) {
        for (int i = 0; i < this.firstFree; i++) {
            if (this.list[i].equals(value) || this.list[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private void moveToTheLeft(int fromIndex) {
        for (int i = fromIndex; i < this.firstFree - 1; i++) {
            this.list[i] = this.list[i + 1];
        }
    }
    
    public Type value(int index){
        if(index >= 0){
            return this.list[index];
        }       
        throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.firstFree + "]");

    }
    
    public int size(){
        return this.firstFree;
    }

}
