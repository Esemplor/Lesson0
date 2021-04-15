//package ee.bcs.valiit.kontroller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Lesson4ControllerLisa {
//
//    private static Map<String, CreateAccountRequestLisa> accountBalanceMap = new HashMap<>();
//
//    @GetMapping("stuff/bank/createAccount/{name}/{accountNr}/{balance}")
//    public void createAccount(@PathVariable("name")String name,@PathVariable("accountNr") String accountNr, @PathVariable("balance") Double balance) {
//        accountBalanceMap.put(accountNr,);
//    }
//
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
//}
