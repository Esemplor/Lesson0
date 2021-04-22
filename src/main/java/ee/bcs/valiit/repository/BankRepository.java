package ee.bcs.valiit.repository;


import ee.bcs.valiit.kontroller.CreateAccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public void createAccount(String accountNr, String name, Double balance, Boolean locked) {
        String sql = "insert into account(account_number, client_name,  balance, locked) values (:dbAccNo, :dbClientName, :dbAmount, :dbLocked)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        paramMap.put("dbClientName", name);
        paramMap.put("dbAmount", balance);
        paramMap.put("dbLocked", locked);
        jdbcTemplate.update(sql, paramMap);
    }

    //        public void createAccount2(){
//        String sql = "insert into account(account_number, balance) values (:dbAccNo, :dbAmount)";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("dbAccNo", request.getAccountNumber());
//        paramMap.put("dbAmount", request.getAmount());
//        jdbcTemplate.update(sql, paramMap);
//    }
//    public String exists(String accountNr) {
//        String sql = "select account_number from account where account_number = :dbAccno";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("dbAccNo", accountNr);
//        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
//    }

    public void lock(String accountNr) {
        String sql = "update account set locked = true where account_number = :dbAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        jdbcTemplate.update(sql, paramMap);
    }

    public void unlock(String accountNr) {
        String sql = "update account set locked = false where account_number = :dbAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        jdbcTemplate.update(sql, paramMap);
    }

    public Boolean islocked(String accountNr) {
        String sql = "select locked from account where account_number = :dbAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, Boolean.class);
    }

    public Double getBalance(String accountNr) {
        String sql = "select balance from account where account_number = :dbAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        return jdbcTemplate.queryForObject(sql, paramMap, Double.class);
    }

    public void updateBalance(String accountNr, Double balanceUpdate) {
        String sql = "update account set balance = :dbBalance where account_number = :dbAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        paramMap.put("dbBalance", balanceUpdate);
        jdbcTemplate.update(sql, paramMap);
    }
}


