import java.util.Scanner;
import java.util.ArrayList;

public class Main{

    static ArrayList<Integer> range = new ArrayList<>();
    static ArrayList<Integer> primeNums = new ArrayList<>();
    public static int low;
    public static int high;
    public static int range(int low, int high){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the lower-bound integer: ");
        low = Integer.parseInt(scan.nextLine());
        System.out.println("Enter the upper-bound integer: ");
        high = Integer.parseInt(scan.nextLine());
        int i;
        if (low >= high){
            System.out.println("Error: lower-bound is larger than the upper-bound");

        }else {
            i = 1;
            for(i = low; i <= high; i++){
                range.add(i);
                findPrime(range);
            }
        }
        return range(low, high);
    }

    public static boolean findPrime(ArrayList<Integer> range) {
        int i;
        for (i = 0; i < range.get(i); ++i) {
            if (range.get(i) <= 1) {
                return false;
            }
            if (range.get(i) <= 3) {
                primeNums.add(i);
                return true;
            }
            if (range.get(i) % 2 == 0 || range.get(i) % 3 == 0) {
                return false;
            }
            for (int x = 5; x * x <= range.get(i); x += 6) {
                if (range.get(i) % x == 0 || range.get(i) % (x + 2) == 0) {
                    return false;
                }
            }
            primeNums.add(i);
            return true;
        }return false;
    }
    public static void printArray(ArrayList<Integer> primeNums){
        System.out.print("{" + primeNums.get(0));
        for (int x = 1; primeNums.size() > x; x++){
            System.out.print(", " + primeNums.get(x));
        }
        System.out.println("}");
    }
    public static void main(String[] args) {
        range(low, high);
        printArray(primeNums);
    }
}