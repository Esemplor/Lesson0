package ee.bcs.valiit.tasks;

import java.util.HashMap;
import java.util.Map;

public class Lesson3 {
    public static void main(String[] args) {
        //System.out.println(sum(new int[]{1, 2, 3, 4}));
        //multiplyTable(5, 5);
        System.out.println(factorial(0));
        System.out.println(reverseString("Tere"));
        System.out.println(isPrime(1));
        isPrime(5);
        System.out.print(sort(new int[]{8, 5, 2, 1, 11}));
        System.out.println(evenFibonacci(9));


        // TODO siia saab kirjutada koodi testimiseks
    }


    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    public static int factorial(int x) {
        int korrutis = 1;

        for (int i = 1; i <= x; i++) {
            korrutis = korrutis * i;
        }
        return korrutis;
    }

    // TODO tagasta string tagurpidi
    public static String reverseString(String a) {
        String b = "";
        for (int i = 0; i < a.length(); i++) {
            b = b + a.charAt(a.length() - 1 - i);
        }
        return b;
    }

    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
    public static boolean isPrime(int x) {
        if (x == 1) {
            return false;
        }
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    // TODO sorteeri massiiv suuruse järgi.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    public static int[] sort(int[] a) {
        int temp = 0;
        System.out.println("Algne array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        for (int i = 0; i < a.length; i++) {  //leida minimaalne a massiivis ning paigutada uue arrey esimeseks.
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }

        }
        System.out.println("\nArray sordituna: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        return a;
    }

    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x

        int sum = 0;
        int a = 0;
        int b = 1;
        int fib = 0;
        for (int i = 0; i < x; i++) {
            a = b;
            b = fib;
            fib = a + b;
            if (fib % 2 == 0&& fib<=x) {
                sum =sum+ fib;
            }
            System.out.println(sum);
        }
        return sum;
    }

    public static String morseCode(String text) {

        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga
        Map<Character, String> morseMap = new HashMap<>();
        morseMap.put('h',"....");
        morseMap.put('e',".");
        morseMap.put('l',".-..");
        morseMap.put('o',"---");
        morseMap.put('s',"...");

//        for(int i = 0; 0<text.length();i++){
//            char c = text.charAt(i);
//        }
        String resultString = "";
        for(char c : text.toCharArray()){
            resultString+=morseMap.get(c)+" ";
        }


        return resultString.trim();
    }
}
