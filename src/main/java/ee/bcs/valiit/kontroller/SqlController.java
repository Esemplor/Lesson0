package ee.bcs.valiit.kontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@RestController
public class SqlController {


private static Map<String, Double> accountBalanceMap = new HashMap<>();
@Autowired
private NamedParameterJdbcTemplate jdbcTemplate;


    @GetMapping("stuff/bank3/createAccount/{accountNr}/{balance}")
    public void createAccount(@PathVariable("accountNr") String accountNr,
                              @PathVariable("balance") Double balance) {
        String sql = "insert into account(account_number, balance) values (:dbAccNo, :dbAmount)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        paramMap.put("dbAmount", balance);
        jdbcTemplate.update(sql, paramMap);
    }
    @PostMapping("stuff/bank3/account")
    public void createAccount2(@RequestBody CreateAccountRequest request) {
        String sql = "insert into account(account_number, balance) values (:dbAccNo, :dbAmount)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo",request.getAccountNumber());
        paramMap.put("dbAmount",request.getAmount());
        jdbcTemplate.update(sql,paramMap);
    }

    @GetMapping("stuff/bank3/getBalance/{accountNumber}")
    public String getBalance(@PathVariable("accountNumber") String accountNr) {
        String sql = "select balance from account where account_number = :dbAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        Double balance = jdbcTemplate.queryForObject(sql, paramMap,Double.class);
        return "Current balance: " +balance;
    }

    @PutMapping("stuff/bank3/account/deposit/{juurde}")
    public void juurde(@PathVariable("juurde") Double juurde,
                       @RequestBody CreateAccountRequest request) {
        String sql = "insert into account(account_number, balance) values (:dbAccNo, :dbAmount)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", request.getAccountNumber());
        paramMap.put("dbAmount", request.getAmount()+juurde);
        jdbcTemplate.update(sql, paramMap);
    }

    @PutMapping("stuff/bank3/account/withdraw/{maha}")
    public void maha(@PathVariable("maha") Double maha,
                     @RequestBody CreateAccountRequest request) {
        String sql = "insert into account(account_number, balance) values (:dbAccNo, :dbAmount)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", request.getAccountNumber());
        paramMap.put("dbAmount", request.getAmount()-maha);
        jdbcTemplate.update(sql, paramMap);
    }

//    @PutMapping("stuff/bank/account/transfer/{firstAccountNr}")
//    public String transfer(@PathVariable("firstAccountNr") String firstAccountNr,
//                           @RequestBody CreateAccountRequest request) {
//        double firstAccountBalance = accountBalanceMap.get(firstAccountNr);
//        if(firstAccountBalance>=request.getAmount()){
//            firstAccountBalance = firstAccountBalance - request.getAmount();
//            accountBalanceMap.replace(firstAccountNr, firstAccountBalance);
//
//            double secondAccountBalance = accountBalanceMap.get(request.getAccountNumber());
//            secondAccountBalance=secondAccountBalance+ request.getAmount();
//            accountBalanceMap.replace(request.getAccountNumber(),secondAccountBalance);
//            return request.getAmount() + " transfer from: "+firstAccountNr+" to "+ request.getAccountNumber();
//
//        }else {
//            return "Insufficient funds";
//        }
//    }
//    public static void main(String[] args) {
//    }

}
