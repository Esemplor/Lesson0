package ee.bcs.valiit.kontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Lesson3HardController {
    int count = 1;
    public String Lesson3Hard;
    Random random = new Random();
    int randomNumber = random.nextInt(100);

    @GetMapping("stuff/random")
    public String random(@RequestParam("a") int a) {
        if (a > randomNumber) {
            count++;
            return "Number, mis otsid, on madalam kui " + a;
        } else if (a < randomNumber) {
            count++;
            return "Number, mis otsid, on suurem kui " + a;
        } else {
            String tekst = " on õige vastus! Pakkumiste arv: " + count;
            randomNumber = random.nextInt(100);
            count = 0;
            return tekst;
        }

    }
}