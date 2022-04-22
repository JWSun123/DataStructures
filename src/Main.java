public class Main {
    public static void main(String[] args) {
        CustomArrayOfInt array = new CustomArrayOfInt();
        array.add(5);
        array.add(7);
        array.add(9);
        array.add(11);
        System.out.println(array.toString());
        System.out.println("size: " + array.size());

        array.deleteByIndex(1);
        System.out.println("delete index 1: "+array.toString());

        System.out.println("get index 1: " + array.get(1));

        array.insertValueAtIndex(88, 1);
        System.out.println(array.toString());

        array.clear();
        System.out.println(array.toString());
    }
}
