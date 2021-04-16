package ee.bcs.valiit.kontroller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Lesson4ControllerLisa {

    private static Map<String, CreateAccountRequestLisa> accountBalanceMap = new HashMap<>();

    @GetMapping("stuff/bank2/createAccount/{name}/{iban}/{balance}")
    public void createAccount(@PathVariable("name") String name,
                              @PathVariable("iban") String iban,
                              @PathVariable("balance") Double balance) {
        CreateAccountRequestLisa account = new CreateAccountRequestLisa();
        account.setName(name);
        account.setIban(iban);
        account.setBalance(balance);
        account.setLocked(false);
        accountBalanceMap.put(iban, account);
    }

    @GetMapping("stuff/bank2/account")
    public Map<String, CreateAccountRequestLisa> accountList() {
        return accountBalanceMap;
    }

    @PostMapping("stuff/bank2/createAccount")
    public void createAccount2(@RequestBody CreateAccountRequestLisa request) {
        accountBalanceMap.put(request.getIban(), request);
    }

//    @PutMapping("stuff/bank2/block/{iban}")
//    public String block(@PathVariable("iban") String iban, @RequestBody CreateAccountRequestLisa request) {
//        if (accountBalanceMap.get(iban) == null) {
//            return "Invalid account number";
//        }
//        accountBalanceMap.put(accountBalanceMap.get(iban),);
//        return "Konto: " + iban + " on nüüd lukus";
//    }


    @GetMapping("stuff/bank2/getBalance/{iban}")
    public String getBalance(@PathVariable("iban") String iban) {
        if (accountBalanceMap.get(iban) == null) {
            return "Invalid account number";
        } else if (accountBalanceMap.get(iban).getLocked()) {
            return "Account is locked";
        }
        return "Account: " + iban + " balance is: " + accountBalanceMap.get(iban).getBalance();
    }

//    @PutMapping("stuff/bank2/deposit/{deposit}")
//    public String deposit(@PathVariable("deposit") Double deposit, @RequestBody CreateAccountRequestLisa request) {
//        if (accountBalanceMap.get(request.getIban()) == null) {
//            return "Invalid account number";
//        } else if (accountBalanceMap.get(request.getIban()).getLocked()) {
//            return "Account is locked";
//        } else if (deposit > 0) {
//            accountBalanceMap.put(request.getIban(), accountBalanceMap.get(request.getIban() + deposit));
//            return "Account: " + accountBalanceMap.get(request.getIban()) + " new balance is: " + accountBalanceMap.get(request.getIban());
//        }
//    }


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
