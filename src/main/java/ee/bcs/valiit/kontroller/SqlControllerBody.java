package ee.bcs.valiit.kontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SqlControllerBody {


    private static Map<String, CreateAccountRequestLisa> accountBalanceMap = new HashMap<>();
    private static CreateAccountRequestLisa accountInfo = new CreateAccountRequestLisa();
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    @GetMapping("stuff/bank4/createAccount/{accountNr}/{name}/{balance}")
    public String createAccount(@PathVariable("accountNr") String accountNr,
                                @PathVariable("name") String name,
                                @PathVariable("balance") Double balance) {
        accountInfo.setAccountNr(accountNr);
        accountInfo.setName(name);
        accountInfo.setBalance(balance);
        accountInfo.setLocked(false);
        accountBalanceMap.put(accountNr, accountInfo);
        String sql = "insert into account(account_number, customer_name, balance) values (:dbAccNo, :dbName, :dbAmount)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        paramMap.put("dbName", name);
        paramMap.put("dbAmount", balance);
        jdbcTemplate.update(sql, paramMap);
        return "Konto nr: " + accountNr + " loodud. Konto jääk: " + balance + "EUR.";
    }

    @GetMapping("stuff/bank4/account")
    public Map<String, CreateAccountRequestLisa> accountList() {
        return accountBalanceMap;
    }

    @PostMapping("stuff/bank4/createAccount")
    public String createAccount2(@RequestBody CreateAccountRequestLisa request) {
        accountBalanceMap.put(request.getAccountNr(), accountInfo);
        String sql = "insert into account(account_number,customer_name,balance) values (:dbAccNo,:dbName,:dbAmount)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", request.getAccountNr());
        paramMap.put("dbName", request.getName());
        paramMap.put("dbAmount", request.getBalance());
        jdbcTemplate.update(sql, paramMap);
        return "Konto nr: " + request.getAccountNr() + "loodud.";
    }

//    @PutMapping("stuff/bank4/lock/{accountNr}")
//    public String lock(@PathVariable("accountNr") String accountNr,
//                       @RequestBody CreateAccountRequestLisa request) {
//        Boolean locked = request.getLocked();
//        locked = true;
//        accountBalanceMap.put(accountNr, accountBalanceMap.get(accountNr).getLocked());
//        String sql = "select locked from account where account_number = :dbAccNo";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("dbAccNo", accountNr);
//        Boolean lukus = jdbcTemplate.queryForObject(sql, paramMap, Boolean.class);
//        lukus = true;
//        String sql2 = "update account set locked = :lukus where account_number = :dbAccNo";
//        paramMap.put("lukus", lukus);
//        jdbcTemplate.update(sql2, paramMap);
//        return "Konto: " + accountNr + " on nüüd lukus.";
//    }

    @PutMapping("stuff/bank4/unlock/{accountNr}")
    public String unlock(@PathVariable("accountNr") String accountNr) {
        String sql = "select locked from account where account_number = :dbAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        Boolean unlock = jdbcTemplate.queryForObject(sql, paramMap, Boolean.class);
        unlock = false;
        String sql2 = "update account set locked = :unlock where account_number = :dbAccNo";
        paramMap.put("unlock", unlock);
        jdbcTemplate.update(sql2, paramMap);
        return "Konto: " + accountNr + " on nüüd lukust lahti.";

    }

    @GetMapping("stuff/bank4/getBalance/{accountNumber}")
    public String getBalance(@PathVariable("accountNumber") String accountNr,
                             @RequestBody CreateAccountRequestLisa requestLisa) {
        String sql = "select locked from account where account_number = :dbAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", requestLisa.getAccountNr());
        Boolean lukus = jdbcTemplate.queryForObject(sql, paramMap, Boolean.class);
        if (lukus = true) {
            return "Ei saa toiminguid teha, konto: " + accountNr + " on lukus.";
        } else {
            String sql2 = "select balance from account where account_number = :dbAccNo";
            Map<String, Object> paramMap2 = new HashMap<>();
            paramMap.put("dbAccNo", requestLisa.getAccountNr());
            Double balance = jdbcTemplate.queryForObject(sql2, paramMap2, Double.class);
            return "Current balance: " + balance;
        }
    }

    @PutMapping("stuff/bank4/account/deposit/{accountNumber}/{deposit}")
    public String deposit(@PathVariable("accountNumber") String accountNumber,
                          @PathVariable("deposit") Double deposit) {
        String sql = "select locked from account where account_number = :dbAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNumber);
        Boolean lukus = jdbcTemplate.queryForObject(sql, paramMap, Boolean.class);
        if (lukus = true) {
            return "Ei saa toiminguid teha, konto: " + accountNumber + " on lukus.";
        } else if (accountNumber == null) {
            return "Viga konto numbris.";
        } else if (deposit < 0) {
            return "Ei saa sellist summat sisestada";
        } else {
            String sql2 = "select balance from account where account_number = :dbAccNo";
            Map<String, Object> paramMap2 = new HashMap<>();
            paramMap2.put("dbAccNo", accountNumber);
            Double dbBalance = jdbcTemplate.queryForObject(sql2, paramMap2, Double.class);
            dbBalance = dbBalance + deposit;
            String sql3 = "update account set balance = :dbBalance where account_number = :dbAccNo";
            paramMap2.put("dbBalance", dbBalance);
            jdbcTemplate.update(sql3, paramMap2);
            return deposit + "EUR on lisatud kontole number: " + accountNumber + ". Konto Jääk: " + dbBalance;
        }
    }

    @PutMapping("stuff/bank4/account/withdraw/{accountNumber}/{withdraw}")
    public String withdraw(@PathVariable("accountNumber") String accountNumber,
                           @PathVariable("withdraw") Double withdraw) {
        String sql = "select locked from account where account_number = :dbAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNumber);
        Boolean lukus = jdbcTemplate.queryForObject(sql, paramMap, Boolean.class);
        if (lukus = true) {
            return "Ei saa toiminguid teha, konto: " + accountNumber + " on lukus.";
        } else if (accountNumber == null) {
            return "Viga konto numbris.";
        } else if (withdraw < 0) {
            return "Ei saa sellist summat sisestada";
        } else {
            String sql2 = "select balance from account where account_number = :dbAccNo";
            Map<String, Object> paramMap2 = new HashMap<>();
            paramMap2.put("dbAccNo", accountNumber);
            Double dbBalance = jdbcTemplate.queryForObject(sql2, paramMap2, Double.class);
            if (dbBalance < withdraw) {
                return "Kontol pole piisavalt vahendeid";
            } else {
                dbBalance = dbBalance - withdraw;
                String sql3 = "update account set balance = :dbBalance where account_number = :dbAccNo";
                paramMap2.put("dbBalance", dbBalance);
                jdbcTemplate.update(sql3, paramMap2);
                return withdraw + "EUR on välja võetud kontol: " + accountNumber + ". Konto jääk: " + dbBalance;
            }
        }
    }

    @PutMapping("stuff/bank4/account/transfer/{firstAccountNr}/{secondAccountNr}/{transfer}")
    public String transfer(@PathVariable("firstAccountNr") String firstAccountNr,
                           @PathVariable("secondAccountNr") String secondAccountNr,
                           @PathVariable("transfer") Double transfer) {
        String sql = "select locked from account where account_number = :dbAccNo";
        String sql2 = "select locked from account where account_number = :dbAccNo2";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", firstAccountNr);
        paramMap.put("dbAccNo2", secondAccountNr);
        Boolean lukus = jdbcTemplate.queryForObject(sql, paramMap, Boolean.class);
        Boolean lukus2 = jdbcTemplate.queryForObject(sql2, paramMap, Boolean.class);
        if (lukus = true) {
            return "Ei saa toiminguid teha, konto: " + firstAccountNr + " on lukus.";
        } else if (lukus2 = true) {
            return "Ei saa toiminguid teha, konto: " + secondAccountNr + " on lukus.";
        } else if (firstAccountNr == null) {
            return "Viga konto numbris.";
        } else if (secondAccountNr == null) {
            return "Viga konto numbris.";
        } else if (transfer < 0) {
            return "Ei saa sellist summat sisestada";
        } else {
            String sql3 = "select balance from account where account_number = :dbAccNo1";
            String sql4 = "select balance from account where account_number = :dbAccNo2";
            Map<String, Object> paramMap2 = new HashMap<>();
            paramMap2.put("dbAccNo1", firstAccountNr);
            paramMap2.put("dbAccNo2", secondAccountNr);
            Double dbBalance1 = jdbcTemplate.queryForObject(sql3, paramMap2, Double.class);
            if (dbBalance1 < transfer) {
                return "Kontol pole piisavalt vahendeid";
            } else {
                Double dbBalance2 = jdbcTemplate.queryForObject(sql4, paramMap2, Double.class);
                dbBalance1 = dbBalance1 - transfer;
                dbBalance2 = dbBalance2 + transfer;
                String sql5 = "update account set balance = :dbBalance1 where account_number = :dbAccNo1";
                paramMap2.put("dbBalance1", dbBalance1);
                jdbcTemplate.update(sql5, paramMap2);
                String sql6 = "update account set balance = :dbBalance2 where account_number = :dbAccNo2";
                paramMap2.put("dbBalance2", dbBalance2);
                jdbcTemplate.update(sql6, paramMap2);
                return transfer + "EUR on kantud kontolt: " + firstAccountNr + " kontole: " + secondAccountNr + ".";

            }
        }
    }
}