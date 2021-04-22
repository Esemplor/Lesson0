package ee.bcs.valiit.tasks;

import org.springframework.core.style.ToStringCreator;

import java.util.Arrays;

public class Lesson2b {
    public static void main(String[] args) {
        exercise1(5);
        System.out.println(Arrays.toString(sampleArray()));
        System.out.println(Arrays.toString(generateArray(5)));
        System.out.println(Arrays.toString(decreasingArray(-5)));
        System.out.println(Arrays.toString(yl3(5)));
    }

    // TODO trüki välja n arvu
    // näiteks
    // sisend: 5
    // trüki välja: 1 2 3 4 5
    public static int [] exercise1(int n) {
        int[] arvud = new int[n];
        for (int i = 1; i <= n; i++) {
            arvud[i-1] = i;
        }
        return arvud;
    }

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray() {
        int[] numbrid = new int[5];
        for (int i = 0; i < numbrid.length; i++) {
            numbrid[i] = i + 1;
        }
        return numbrid;
    }

    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}
    public static int[] generateArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    // TODO
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0
    public static int[] decreasingArray(int n) {
        if (n >= 0) {
            int[] array = new int[n + 1];
            for (int i = 0; i < n; i++) {
                array[i] = n - i;
            }
            return array;
        } else {
            int[] array = new int[-n + 1];
            for (int i = n; i <= 0; i++) {
                array[-n + i] = i;
            }
            return array;
        }
    }


    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n) {
        int[] kolm = new int[n];
        for (int i = 0; i < n; i++) {
            kolm[i] = 3;
        }
        return kolm;
    }
}
