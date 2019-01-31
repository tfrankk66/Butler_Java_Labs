package butler_java2_lab11_mylistclass;

public class Butler_Java2_Lab11_MyListClass {

    public static void main(String[] args) {
        
        MyList<Integer> intMyList = new MyList<Integer>();
        
        System.out.println("Integer MyList object created and integers added...");
        intMyList.add(58);
        intMyList.add(200);
        intMyList.add(586);
        intMyList.add(57);
        intMyList.add(22);
        System.out.println("Largest number from integer MyList Object: " + intMyList.largest());
        System.out.print("Smallest number from integer MyList Object: " + intMyList.smallest());
        
        MyList<Double> doubleMyList = new MyList<Double>();
        
        System.out.println("\n\nDouble MyList object created and doubles added...");
        doubleMyList.add(89.0);
        doubleMyList.add(59.4);
        doubleMyList.add(8.3);
        doubleMyList.add(9.0);
        doubleMyList.add(819.0);
        System.out.println("Largest number from double MyList Object: " + doubleMyList.largest());
        System.out.print("Smallest number from double MyList Object: " + doubleMyList.smallest());
        
    }
    
}
