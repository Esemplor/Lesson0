package ee.bcs.valiit.kontroller;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@RestController
public class Lesson4Controller {

    private static Map<String, Double> accountBalanceMap = new HashMap<>();

    @GetMapping("stuff/bank/createAccount/{accountNr}/{balance}")
    public void createAccount(@PathVariable("accountNr") String accountNr, @PathVariable("balance") Double balance) {
        accountBalanceMap.put(accountNr, balance);
    }

    @GetMapping("stuff/bank/account")
    public Map<String, Double> accountList() {
        return accountBalanceMap;
    }

    @PostMapping("stuff/bank/account")
    public void createAccount2(@RequestBody CreateAccountRequest request) {
        accountBalanceMap.put(request.getAccountNumber(), request.getAmount());

    }

    @PutMapping("stuff/bank/account/deposit/{juurde}")
    public void juurde(@PathVariable("juurde") Double juurde, @RequestBody CreateAccountRequest request) {
        if (accountBalanceMap.get(request.getAccountNumber()) == null) {
            return;
        } else if (juurde > 0) {
            accountBalanceMap.put(request.getAccountNumber(), accountBalanceMap.get(request.getAccountNumber()) + juurde);
        }
    }

    @PutMapping("stuff/bank/account/withdraw/{maha}")
    public void maha(@PathVariable("maha") Double maha, @RequestBody CreateAccountRequest request) {
        if (accountBalanceMap.get(request.getAccountNumber()) == null) {
            return;
        } else if (accountBalanceMap.get(request.getAccountNumber()) < maha) {
            return;
        } else if (maha > 0) {
            accountBalanceMap.put(request.getAccountNumber(), accountBalanceMap.get(request.getAccountNumber()) - maha);
        }
    }

    @PutMapping("stuff/bank/account/deposit/{firstAccountNr}")
    public String transfer(@PathVariable("firstAccountNr") String firstAccountNr,
                          @RequestBody CreateAccountRequest request) {
        double firstAccountBalance = accountBalanceMap.get(firstAccountNr);
        if(firstAccountBalance>=request.getAmount()){
            firstAccountBalance = firstAccountBalance - request.getAmount();
            accountBalanceMap.replace(firstAccountNr, firstAccountBalance);

            double secondAccountBalance = accountBalanceMap.get(request.getAccountNumber());
            secondAccountBalance=secondAccountBalance+ request.getAmount();
            accountBalanceMap.replace(request.getAccountNumber(),secondAccountBalance);
            return request.getAmount() + " transfer from: "+firstAccountNr+" to "+ request.getAccountNumber();

        }else {
            return "Insufficient funds";
        }

    }


//    @GetMapping("stuff/bank/getBalance/{accountNumber}")
//    public String getBalance(@PathVariable("accountNumber") String accountNr) {
//        return "Current balance: " + accountBalanceMap.get(accountNr);
//    }
//
//    @GetMapping("stuff/bank/depositMoney/{accountNumber}/{deposit}")
//    public String depositMoney(@PathVariable("accountNumber") String accountNr, @PathVariable("deposit") Double
//            deposit) {
//        if (accountBalanceMap.get(accountNr) == null) {
//            return "Invalid account";
//        } else if (deposit > 0) {
//            accountBalanceMap.put(accountNr, accountBalanceMap.get(accountNr) + deposit);
//            return "New balance: " + accountBalanceMap.get(accountNr);
//        } else {
//            return "Invalid deposit amount";
//        }
//    }
//
//    @GetMapping("stuff/bank/withdrawMoney/{accountNumber}/{withdraw}")
//    public String withdrawMoney(@PathVariable("accountNumber") String
//                                        accountNr, @PathVariable("withdraw") Double
//                                        withdraw) {
//        if (accountBalanceMap.get(accountNr) == null) {
//            return "Invalid account";
//        } else if (withdraw > 0) {
//            accountBalanceMap.put(accountNr, accountBalanceMap.get(accountNr) - withdraw);
//            return "New balance: " + accountBalanceMap.get(accountNr);
//        } else {
//            return "Invalid deposit amount";
//        }
//    }
//
//    @GetMapping("stuff/bank/transfer/{transfer1}/{transfer2}/{transaction}")
//    public String transfer(@PathVariable("transfer1") String transfer1,
//                           @PathVariable("transfer2") String transfer2,
//                           @PathVariable("transaction") Double transaction) {
//        if (accountBalanceMap.get(transfer1) == null) {
//            return "Invalid account";
//        } else {
//            if (accountBalanceMap.get(transfer2) == null) {
//                return "Invalid account";
//            } else {
//                if (transaction < 0) {
//                    return "Invalid withdraw amount";
//                } else if (accountBalanceMap.get(transfer1) < transaction) {
//                    return "Insufficient funds";
//                } else if (accountBalanceMap.get(transfer2) < 0) {
//                    return "Can't transfer to a negative account";
//                } else {
//                    accountBalanceMap.put(transfer1, accountBalanceMap.get(transfer1) - transaction);
//                    accountBalanceMap.put(transfer2, accountBalanceMap.get(transfer2) + transaction);
//                    return "New account balance: " + accountBalanceMap.get(transfer1);
//                }
//            }
//        }
//    }

    public static void main(String[] args) {


    }

}
