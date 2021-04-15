package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {


    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int i = random.nextInt(100);
        int count = 0;
        System.out.println("Arva ära number vahemikus 0-99");
        while (true) {
            int pakkumus = scanner.nextInt();
            count++;
            if (pakkumus > i) {
                System.out.println("Liiga kõrge, paku veel");
            } else if (pakkumus < i) {
                System.out.println("Liiga madal, paku veel");
            } else {
                System.out.println("Õige vastus, pakkumiste arv: " + count);
//                System.out.println("Kas soovite uuesti mängida? 1 - jah, 0 - ei");
//                int uuesti = scanner.nextInt();
//                if (uuesti == 1) {
//                    i = random.nextInt(100);
//                    count = 0;
//                } else {
                break;
            }
        }
    }
}


