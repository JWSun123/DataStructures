import javax.xml.catalog.Catalog;
import java.util.*;

public class ArrayListStart {
    public static void main(String[] args) {
        //Generic
        ArrayList<Integer> arrayList = new ArrayList<>();

        //using interface
        List<Integer> arrayList2 = new ArrayList<>();

        List<Integer> arrayList3 = new Vector<>();

        Set<Integer> set1 = new HashSet<>();

        Map<Integer, Integer> map1 = new HashMap<>();

        //Upcasting and Downcasting
        Dog dog1 = new Dog();
        Animal dog2 = new Dog();
        dog2.sound();
    }
}

interface  Animal{
    void sound();
}

class Dog implements Animal{
    @Override
    public void sound() {

    }
}
