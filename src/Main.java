import java.util.Scanner;
import java.util.ArrayList;

public class Main{

    static ArrayList<Integer> range = new ArrayList<>();
    //static int[] range;
    static ArrayList<Integer> primeNums = new ArrayList<>();
    static ArrayList<Integer> nonPrime = new ArrayList<>();
    public static int low;
    public static int high;
    public static void range(int low, int high){
        int i;
        if (low >= high){
            System.out.println("Error: lower-bound is larger than the upper-bound");
        }else {
            for(i = low; i <= high; i++){
                range.add(i);
            }
            findPrimes(range);
        }
    }

    public static boolean isPrime(int number) {
    if (number < 1){
        return false;
    }
    if (number <= 3){
        return true;
    }
    if (number % 2 == 0 || number % 3 == 0){
        return false;
    }
    for (int i = 5; i * i <= number; i += 6){
        if (number % i == 0 || number % (i + 2) == 0){
            return false;
        }
    }
    return true;
    }
    public static ArrayList<Integer> findPrimes(ArrayList<Integer> numbers){
        for (Integer number : numbers){
            if(isPrime(number)){
                primeNums.add(number);
            }else {
                nonPrime.add(number);
            }
        }return primeNums;
    }
    public static void printPrime(ArrayList<Integer> primeNums){
        if (primeNums.isEmpty()){
            System.out.print("{}");
        }else {
        System.out.print("{" + primeNums.get(0));
        for (Integer integer : primeNums) {
            System.out.print(", " + integer);
        }
        System.out.println("}");
    }}
    public static void printNonPrime(ArrayList<Integer> nonPrime){
        if (nonPrime.isEmpty()){
            System.out.print("{}");
        }
        System.out.print("{" + nonPrime.get(0));
        for(Integer integer : nonPrime) {
            System.out.print(", " + integer);
        }
        System.out.println("}");
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the lower-bound integer: ");
        low = Integer.parseInt(scan.nextLine());
        System.out.println("Enter the upper-bound integer: ");
        high = Integer.parseInt(scan.nextLine());
        range(low, high);
        System.out.println("Prime numbers in the range provided are: ");
        printPrime(primeNums);
        System.out.println("And non prime numbers in the range provided are: ");
        printNonPrime(nonPrime);
    }
}