package ee.bcs.valiit.tasks;

import java.util.Arrays;
import java.util.concurrent.LinkedTransferQueue;

public class Lesson2 {

    public static void main(String[] args) {
        //System.out.println(sum(new int[]{1, 2, 3, 4}));
        //multiplyTable(5, 5);
        fibonacci(1);


        // TODO siia saab kirjutada koodi testimiseks
    }

    // TODO loe funktsiooni sisendiks on täisarvude massiiv
    // TODO tagasta massiiv mille elemendid on vastupidises järiekorras
    public static int[] reverseArray(int[] inputArray) {
        int[] peegel = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            peegel[i] = inputArray[(inputArray.length - 1) - i];
        }
        return peegel;
    }


    // TODO tagasta massiiv mis sisaldab n esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    public static int[] evenNumbers(int n) {
        int[] paaris = new int[n];
        for (int i = 0; i < n; i++) {
            paaris[i] = (i + 1) * 2;
        }
        return paaris;
    }

    // TODO, leia massiivi kõige väiksem element
    public static int min(int[] x) { // 4 2 5 1 9
        int minElement = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] < minElement) {
                minElement = x[i];
            }
        }
        return minElement;
    }

    // TODO, leia massiivi kõige suurem element
    public static int max(int[] x) {
        int maxElement = x[0];
        for (int i = 1; i < x.length; i++) {
            if (x[i] > maxElement) {
                maxElement = x[i];
            }
        }
        return maxElement;
    }

    // TODO, leia massiivi kõigi elementide summa
    public static int sum(int[] x) {
        int summa = x[0];
        for (int i = 1; i < x.length; i++) {
            summa = summa + x[i];
        }
        return summa;
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void multiplyTable(int x, int y) {

        for (int j = 1; j <= y; j++) {
            for (int i = 1; i <= x; i++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element. Võid eeldada, et n >= 0
    public static int fibonacci(int n) {
        int a = 0;
        int b = 1;
        int fib = 0;
        System.out.println(fib); // if(n==0){
        //       return 0;         sellisel juhul fib=1 ja i=1
        for (int i = 0; i < n; i++) {
            a = b;
            b = fib;
            fib = a + b;
            System.out.println(fib);
        }
        return fib;
    }

    // TODO
    // Kujutame ette numbrite jada, kus juhul kui number on paaris arv siis me jagame selle 2-ga
    // Kui number on paaritu arv siis me korrutame selle 3-ga ja liidame 1. (3n+1)
    // Seda tegevust teeme me niikaua kuni me saame vastuseks 1
    // Näiteks kui sisend arv on 22, siis kogu jada oleks:
    // 22 -> 11 -> 34 -> 17 -> 52 -> 26 -> 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
    // Sellise jada pikkus on 16
    // Kirjutada programm, mis peab leidma kõige pikema jada pikkuse mis jääb kahe täis arvu vahele
    // Näiteks:
    // Sisend 10 20
    // Siis tuleb vaadata, kui pikk jada tuleb kui esimene numbr on 10. Järgmisen tuleb arvutada number 11 jada pikkus.
    // jne. kuni numbrini 20
    // Tagastada tuleb kõige pikem number
    // Näiteks sisendi 10 ja 20 puhul on vastus 20


    //tehke tsükkel x-st y-ni
    //kutsuge iga väärtuse korral välja meetodit getSeqLength
    //salvestage maha kõige suurem ja funktsiooni lõpus tagastage see
    public static int sequence3n(int x, int y) {
        int max = 0;
        for (int i = x; i <= y; i++) {
            int count = 1;
            int value = i;
            while (value > 1) {
                if (value % 2 == 0) {
                    value = value / 2;
                } else {
                    value = value * 3 + 1;
                }
                count++;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }


        // x = 1 - 4
        //x = 2 - 1
        //x = 3 - 10
        //x = 4 - 2
        //x = 5 - 16
        //x = 6 - 3
        //x = 7 - 22
        //x = 8 - 4
        //  public static int nextElement(int x){
        //tagasta sequence järgmine element
        // for(i = 0; i)
        //  }
        //x = 1 - 1
        //x = 2 - 2
        //x = 4 - 3
        //x = 5 - 6
        //kutsuge välja meetodit nextElement kuni vastus tuleb 1
        //tagastage korduste arv + 1
        //  public static int getSeqLength(int x){

        // }
}
