package ee.bcs.valiit.kontroller;


import ee.bcs.valiit.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SqlControllerServiceJaoks {


    private static Map<String, Double> accountBalanceMap = new HashMap<>();
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private BankService bankService;

    @CrossOrigin
    @GetMapping("stuff/bank5/createAccount/{accountNr}/{name}/{balance}")
    public void createAccount(@PathVariable("accountNr") String accountNr,
                              @PathVariable("name") String name,
                              @PathVariable("balance") Double balance) {
        bankService.createAccount(accountNr, name, balance);
    }

    //    @PostMapping("stuff/bank5/account")
//    public void createAccount2(@RequestBody CreateAccountRequest request) {
//        String sql = "insert into account(account_number, balance) values (:dbAccNo, :dbAmount)";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("dbAccNo", request.getAccountNumber());
//        paramMap.put("dbAmount", request.getAmount());
//        jdbcTemplate.update(sql, paramMap);
//    }
    @CrossOrigin
    @PutMapping("stuff/bank5/lock/{accountNr}")
    public String lock(@PathVariable("accountNr") String accountNr) {
        return bankService.lock(accountNr);
    }
    @CrossOrigin
    @PutMapping("stuff/bank5/unlock/{accountNr}")
    public String unlock(@PathVariable("accountNr") String accountNr) {
        return bankService.unlock(accountNr);
    }

    @CrossOrigin
    @GetMapping("stuff/bank5/getBalance/{accountNumber}")
    public String getBalance(@PathVariable("accountNumber") String accountNr) {
        return bankService.getBalance(accountNr);

    }
    @CrossOrigin
    @PutMapping("stuff/bank5/account/deposit/{accountNumber}/{deposit}")
    public String deposit(@PathVariable("accountNumber") String accountNumber,
                          @PathVariable("deposit") Double deposit) {
        return bankService.deposit(accountNumber, deposit);
    }
    @CrossOrigin
    @PutMapping("stuff/bank5/account/withdraw/{accountNumber}/{withdraw}")
    public String withdraw(@PathVariable("accountNumber") String accountNumber,
                           @PathVariable("withdraw") Double withdraw) {
        return bankService.withdraw(accountNumber, withdraw);
    }
    @CrossOrigin
    @PutMapping("stuff/bank5/account/transfer/{firstAccountNr}/{secondAccountNr}/{transfer}")
    public String transfer(@PathVariable("firstAccountNr") String firstAccountNr,
                           @PathVariable("secondAccountNr") String secondAccountNr,
                           @PathVariable("transfer") Double transfer) {
        return bankService.transfer(firstAccountNr, secondAccountNr, transfer);
    }
}