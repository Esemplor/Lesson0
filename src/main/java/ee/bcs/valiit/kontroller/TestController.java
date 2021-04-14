package ee.bcs.valiit.kontroller;

import ee.bcs.valiit.solution.SolutionLesson1;
import ee.bcs.valiit.tasks.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

import javax.lang.model.element.NestingKind;


@RestController
public class TestController {
//    public static int fibonacci(int n) {
//        int a = 0;
//        int b = 1;
//        int fib = 0;
//        System.out.println(fib); // if(n==0){
//        //       return 0;         sellisel juhul fib=1 ja i=1
//        for (int i = 0; i < n; i++) {
//            a = b;
//            b = fib;
//            fib = a + b;
//            System.out.println(fib);
//        }
//        return fib;
//    }

    @GetMapping("sample/hello-world/{nameInUrl}")
    public String helloWorld(@PathVariable("nameInUrl") String name,
                             @RequestParam("action") String action) {

        return action + " " + name + ", " + " vali mitmendat fibonacci jada numbrit tahad: ";
    }

    @GetMapping("stuff/fib") //http://localhost:8080/stuff/fib?x=9
    public int fibonacci(@RequestParam("a") int a) {
        return Lesson2.fibonacci(a);
    }

    @GetMapping("stuff/min/{a}/{b}") //http://localhost:8080/stuff/min/5/9
    public int min(@PathVariable("a") int a, @PathVariable("b") int b) {
        return SolutionLesson1.min(a, b);
    }

    @GetMapping("stuff/max") //http://localhost:8080/stuff/max?a=5&b=7
    public int max(@RequestParam("a") int a, @RequestParam("b") int b) {
        return Lesson1.max(a, b);
    }

    @GetMapping("stuff/abs/{a}")
    public int abs(@PathVariable("a") int a) {
        return Lesson1.abs(a);
    }

    @GetMapping("stuff/isEven")
    public boolean isEven(@RequestParam("a") int a) {
        return Lesson1.isEven(a);
    }

    @GetMapping("stuff/min3/{a}/{b}/{c}")
    public int min3(@PathVariable("a") int a, @PathVariable("b") int b, @PathVariable("c") int c) {
        return Lesson1.min3(a, b, c);
    }

    @GetMapping("stuff/max3")
    public int max3(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) {
        return Lesson1.max3(a, b, c);
    }

    @GetMapping("stuff/reverseArray/{inputArray}") //http://localhost:8080/stuff/reverseArray/8,5,4,3
    public int[] reverseArray(@PathVariable("inputArray") int[] a) {
        return Lesson2.reverseArray(a);
    }

    @GetMapping("stuff/evenNumbers") //http://localhost:8080/stuff/evenNumbers?a=5
    public int[] evenNumbers(@RequestParam("a") int a) {
        return Lesson2.evenNumbers(a);
    }

    @GetMapping("stuff/minElement/{array}") //http://localhost:8080/stuff/minElement/9,6,7,8
    public int minElement(@PathVariable("array") int[] a) {
        return Lesson2.min(a);
    }

    @GetMapping("stuff/maxElement") //http://localhost:8080/stuff/maxElement?a=2,5,3,8
    public int maxElement(@RequestParam("a") int[] a) {
        return Lesson2.max(a);
    }

    @GetMapping("stuff/sum/{array}") //http://localhost:8080/stuff/sum/9,6,7,8
    public int sum(@PathVariable("array") int[] a) {
        return Lesson2.sum(a);
    }

    @GetMapping("stuff/sequence3n") //http://localhost:8080/stuff/sequence3n?a=4&b=8
    public int sequence3n(@RequestParam("a") int a, @RequestParam("b") int b) {
        return Lesson2.sequence3n(a, b);
    }

    @GetMapping("stuff/nArvu/{a}")
    public int[] narvu(@PathVariable("nArvu") int a) {
        return Lesson2b.exercise1(a);
    }

    @GetMapping("stuff/sampleArray") //http://localhost:8080/stuff/sampleArray
    public int[] sampleArray() {
        return Lesson2b.sampleArray();
    }

    @GetMapping("stuff/generateArray/{a}") //http://localhost:8080/stuff/generateArray/8
    public int[] generateArray(@PathVariable("a") int a) {
        return Lesson2b.generateArray(a);
    }

    @GetMapping("stuff/decreasingArray") //http://localhost:8080/stuff/decreasingArray?a=5
    public int[] decreasingArray(@RequestParam("a") int a) {
        return Lesson2b.decreasingArray(a);
    }

    @GetMapping("stuff/yl3/{a}") //http://localhost:8080/stuff/yl3/5
    public int[] yl3(@PathVariable("a") int a) {
        return Lesson2b.yl3(a);
    }

    @GetMapping("stuff/factorial") //http://localhost:8080/stuff/factorial?a=5
    public int factorial(@RequestParam("a") int a) {
        return Lesson3.factorial(a);
    }

    @GetMapping("stuff/reverseString/{a}")
    public String reverseString(@PathVariable("a") String a) {
        return Lesson3.reverseString(a);
    }

    @GetMapping("stuff/isPrime") //http://localhost:8080/stuff/isPrime?a=5
    public boolean isPrime(@RequestParam("a") int a) {
        return Lesson3.isPrime(a);
    }

    @GetMapping("stuff/sort/{a}")
    public int[] sort(@PathVariable("a") int[] a) {
        return Lesson3.sort(a);
    }

    @GetMapping("stuff/evenFibonacci")
    public int evenFibonacci(@RequestParam("a") int a) {
        return Lesson3.evenFibonacci(a);
    }

    @GetMapping("stuff/morse/{tekst}")
    public String morse(@PathVariable("tekst") String tekst) {
        return Lesson3.morseCode(tekst);
    }
//public String Lesson3Hard;
//    Random random = new Random();
//    int randomNumber = random.nextInt(100);
//    @GetMapping("stuff/random")
//    public String random(@RequestParam("a")int a){
//        int count = 1;
//        if (a != randomNumber) {
//            if (a > randomNumber) {
//                count++;
//                return "Number, mis otsid, on madalam kui "+a;
//            } else if (a < randomNumber) {
//                count++;
//                return "Number, mis otsid, on suurem kui "+a;
//            }
//        }
//        return a+" on õige vastus! Pakkumiste arv: "+count;


}
