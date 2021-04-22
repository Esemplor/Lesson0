package ee.bcs.valiit.kontroller;

import java.util.Random;
import java.util.Scanner;

public class Lesson3HardKontrolleriJaoks {
    public static void main(String[] args) {
        random("15");
    }

    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
    public static String random(String x) {
//        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int i = random.nextInt(100);
        System.out.println(i);
        int guess = Integer.parseInt(x);
        int count = 1;
        if (guess != i) {
            if (guess > i) {
                count++;
                return "Number, mis otsid, on madalam kui "+guess;
            } else if (guess < i) {
                count++;
                return "Number, mis otsid, on suurem kui "+guess;
            }
        }
        return guess+" on õige vastus! Pakkumiste arv: "+count;
    }

}

