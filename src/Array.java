import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] intArray = new int[10];
        int length = intArray.length;

        intArray[5] = 10;

        Person[] persons = new Person[5];
        persons[0] = new Person("Sun", "123123123");

        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);
        }
        //another way to define an array.
        int[] array = new int[]{1, 2, 3, 4, 5};

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the array:");

        try {
            int size = input.nextInt();
            if (size > 0) {
                int[] userArray = new int[size];
                System.out.println("The prime numbers in the array:");
                for (int i = 0; i < userArray.length; i++) {
                    userArray[i] = (int) (Math.random() * 99 + 1);
                    if (isPrime(userArray[i])) {
                        System.out.print(userArray[i] + ", ");
                    }
                }
            } else {
                throw new IllegalArgumentException("Must be greater than 1.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Input Invalid! Must be an integer.");
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

class Person {
    String name;
    String tel;

    Person(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
