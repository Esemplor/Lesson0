package ee.bcs.valiit.tasks;

import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    public static void main(String[] args) {
        // Siia sisse võid sa kirjutada koodi, et testida kas su meetodid töötavad ilusti
        // Katseta IntelliJ shortcuti. Olles intelliJ kirjuta "sout" ja siis vajuta enter
        // System.out.println(min(1, 3)); // trükib miinimumi 1 ja 3
        Scanner scanner = new Scanner(System.in);
        System.out.println("Millist meetodit kasutada? 1:min 2:max 3:abs 4:isEven 5:min3 6:max3"); // küsib meetodi

        // kui tahad numbriga int num = scanner.nextInt(); //võtab konsoolist numbri ja viitab selle edasi
        // kui tahad sõnadega
        String funktsioon = scanner.nextLine();
        if (funktsioon.equalsIgnoreCase("min") || funktsioon.equals("1")) { // numbri puhul if(int == 1)
            System.out.println("Sisesta a"); //küsib numbri
            int a = scanner.nextInt(); //võtab konsoolist numbri
            System.out.println("Sisesta b");//küsib numbri
            int b = scanner.nextInt();//võtab konsoolist numbri
            System.out.println("Väiksem arv on "+min(a, b));//kajastab funktsiooni lahendi
        } else if (funktsioon.equalsIgnoreCase("max") || funktsioon.equals("2")) {
            System.out.println("Sisesta a");
            int a = scanner.nextInt();
            System.out.println("Sisesta b");
            int b = scanner.nextInt();
            System.out.println(max(a, b));
        } else if (funktsioon.equalsIgnoreCase("abs") || funktsioon.equals("3")) {
            System.out.println("Sisesta a");
            int a = scanner.nextInt();
            System.out.println(abs(a));
        } else if (funktsioon.equalsIgnoreCase("isEven") || funktsioon.equals("4")) {
            System.out.println("Sisesta a");
            int a = scanner.nextInt();
            if (isEven(a)){
                System.out.println("paaris");
            } else System.out.println("paaritu");
        } else if (funktsioon.equalsIgnoreCase("min3") || funktsioon.equals("5")) {
            System.out.println("Sisesta a");
            int a = scanner.nextInt();
            System.out.println("Sisesta b");
            int b = scanner.nextInt();
            System.out.println("Sisesta c");
            int c = scanner.nextInt();
            System.out.println(min3(a, b, c));
        } else if (funktsioon.equalsIgnoreCase("max3") || funktsioon.equals("6")) {
            System.out.println("Sisesta a");
            int a = scanner.nextInt();
            System.out.println("Sisesta b");
            int b = scanner.nextInt();
            System.out.println("Sisesta c");
            int c = scanner.nextInt();
            System.out.println(max3(a, b, c));
        } else {
            System.out.println("Tundmatu funktsioon");
        }
    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else return b;
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else
            return b;
    }

    // TODO tagasta a absoluut arv
    public static int abs(int a) {
        if (a < 0) {
            return (-a);
        } else
            return a;
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        } else return false;
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        }
        if (b <= a && b <= c) {
            return b;
        } else return c;
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else return c;
    }// return max(max(a, b), c); töötab ka, on lühem.
}
