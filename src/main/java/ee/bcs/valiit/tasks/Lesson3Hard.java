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
        System.out.println(i);
        int count = 1;
        System.out.println("Arva ära number vahemikus 0-99");
        while (true) {
            int pakkumus = scanner.nextInt();
            if (pakkumus != i) {
                if (pakkumus > i) {
                    System.out.println("Liiga kõrge, paku veel");
                    count++;
                } else if (pakkumus < i) {
                    System.out.println("Liiga madal, paku veel");
                    count++;
                }
            } else {
                System.out.println("Õige vastus, pakkumiste arv: "+count);
            }
        }
    }
}
