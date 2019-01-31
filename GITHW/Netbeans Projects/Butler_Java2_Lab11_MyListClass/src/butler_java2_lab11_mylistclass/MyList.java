package butler_java2_lab11_mylistclass;

import java.util.ArrayList;

public class MyList<T extends Number> {
    
    ArrayList<T> myList = new ArrayList<>();
 
    public void add(T a) {
        myList.add(a);
    }
 
    public T largest() {
        T value = myList.get(0);
        for (int i = 1; i < myList.size(); i++) {
            if (myList.get(i).doubleValue() > value.doubleValue()) {
                value = myList.get(i);
            }
        }
        return value;
    }
 
    public T smallest() {
        T value = myList.get(0);
        for (int i = 1; i < myList.size(); i++) {
            if (myList.get(i).doubleValue() < value.doubleValue()) {
                value = myList.get(i);
            }
        }
        return value;
    }
    
}
