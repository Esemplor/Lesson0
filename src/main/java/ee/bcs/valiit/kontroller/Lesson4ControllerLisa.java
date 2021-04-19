package ee.bcs.valiit.kontroller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson4ControllerLisa {

    private static Map<String, CreateAccountRequestLisa> accountBalanceMap = new HashMap<>();

    @GetMapping("stuff/bank2/createAccount/{name}/{accountNr}/{balance}")
    public void createAccount(@PathVariable("name") String name,
                              @PathVariable("accountNr") String accountNr,
                              @PathVariable("balance") Double balance) {
        CreateAccountRequestLisa account = new CreateAccountRequestLisa();
        account.setName(name);
        account.setAccountNr(accountNr);
        account.setBalance(balance);
        account.setLocked(false);
        accountBalanceMap.put(accountNr, account);
    }

    @GetMapping("stuff/bank2/account")
    public Map<String, CreateAccountRequestLisa> accountList() {
        return accountBalanceMap;
    }

    @PostMapping("stuff/bank2/createAccount")
    public void createAccount2(@RequestBody CreateAccountRequestLisa request) {
        accountBalanceMap.put(request.getAccountNr(), request);
    }

//    @PutMapping("stuff/bank2/block/{iban}")
//    public String block(@PathVariable("iban") String iban,
//                        @RequestBody CreateAccountRequestLisa request) {
//        if (accountBalanceMap.get(iban) == null) {
//            return "Invalid account number";
//        }
//        accountBalanceMap.put(accountBalanceMap.get(iban),);
//        return "Konto: " + iban + " on nüüd lukus";
//    }


    @GetMapping("stuff/bank2/getBalance/{accountNr}")
    public String getBalance(@PathVariable("accountNr") String accountNr) {
        if (accountBalanceMap.get(accountNr) == null) {
            return "Invalid account number";
        } else if (accountBalanceMap.get(accountNr).getLocked()) {
            return "Account is locked";
        }
        return "Account: " + accountNr + " balance is: " + accountBalanceMap.get(accountNr).getBalance();
    }

    @PutMapping("stuff/bank2/deposit/{deposit}")
    public String deposit(@PathVariable("deposit") Double deposit, @RequestBody CreateAccountRequestLisa request) {
        if (accountBalanceMap.get(request.getAccountNr()) == null) {
            return "Invalid account number";
        } else if (accountBalanceMap.get(request.getAccountNr()).getLocked()) {
            return "Account is locked";
        } else if (deposit < 0) {
            return "Invalid deposit amount.";
        } else {
            accountBalanceMap.put(request.getAccountNr(), accountBalanceMap.get(request.getAccountNr() + deposit));
            return "Account: " + accountBalanceMap.get(request.getAccountNr()) + " new balance is: " + accountBalanceMap.get(request.getAccountNr());
        }
    }


//    @GetMapping("stuff/bank/getBalance/{accountNumber}")
//    public String getBalance(@PathVariable("accountNumber") String accountNr) {
//        CreateAccountRequestLisa getBalance = accountBalanceMap.get(accountNr);
//        double balance = getBalance.getAmount();
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
}
