package ee.bcs.valiit.service;


import ee.bcs.valiit.exception.ApplicationException;
import ee.bcs.valiit.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.Objects;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public void createAccount(String accountNr, String name, Double balance, Boolean locked) {
        bankRepository.createAccount(accountNr, name, balance, locked);
    }

    public void createAccount2() {

    }

    public String lock(String accountNr) {
        if (accountNr == null) {
            return "Viga konto numbris";
        } else
            bankRepository.lock(accountNr);
            return "Konto: "+accountNr+" on nüüd lukus.";
    }

    public String unlock(String accountNr) {
        if (accountNr == null) {
            return "Viga konto numbris";
        } else
            bankRepository.unlock(accountNr);
            return "Konto: "+accountNr+" on nüüd lukust lahti.";
    }

    public String getBalance(String accountNr) {
        Boolean islocked = bankRepository.islocked(accountNr);
        if (accountNr == null) {
            return "Viga konto numbris";
        } else if (islocked) {
            throw new ApplicationException("Ei saa toiminguid teha, konto: " + accountNr + " on lukus.");
        } else {
            Double balance = bankRepository.getBalance(accountNr);
            return "Konto: " + accountNr + " jääk on: " + balance;
        }
    }

    public String deposit(String accountNr, Double deposit) {
        Boolean islocked = bankRepository.islocked(accountNr);
        if (accountNr == null) {
            return "Viga konto numbris";
        } else if (islocked) {
            throw new ApplicationException("Ei saa toiminguid teha, konto: " + accountNr + " on lukus.");
        } else if (deposit < 0) {
            throw new ApplicationException("Kontole laetav summa ei või olla negatiivne number");
        } else {
            Double balance = bankRepository.getBalance(accountNr);
            Double newBalance = balance + deposit;
            bankRepository.updateBalance(accountNr, newBalance);
            return "Summa " + deposit + " on kontole: " + accountNr + " juurde lisatud. Uus kontojääk on: " + newBalance;

        }
    }

    public String withdraw(String accountNr, Double withdraw) {
        Boolean islocked = bankRepository.islocked(accountNr);
        if (accountNr == null) {
            return "Viga konto numbris";
        } else if (islocked) {
            throw new ApplicationException("Ei saa toiminguid teha, konto: " + accountNr + " on lukus.");
        } else if (withdraw < 0) {
            throw new ApplicationException("Kontolt võetav summa ei või olla negatiivne number");
        } else if (withdraw > bankRepository.getBalance(accountNr)) {
            throw new ApplicationException("Kontol pole piisavalt vahendeid");
        } else {
            Double balance = bankRepository.getBalance(accountNr);
            Double newBalance = balance - withdraw;
            bankRepository.updateBalance(accountNr, newBalance);
            return "Summa " + withdraw + " on kontolt: " + accountNr + " välja võetud. Uus kontojääk on: " + newBalance;
        }
    }

    public String transfer(String firstAccountNr, String secondAccountNr, Double transfer) {
        Boolean islocked = bankRepository.islocked(firstAccountNr);
        Boolean islocked2 = bankRepository.islocked(secondAccountNr);
        if (firstAccountNr == null) {
            return "Viga konto numbris";
        } else if (secondAccountNr == null) {
            return "Viga konto numbris";
        } else if (islocked) {
            throw new ApplicationException("Ei saa toiminguid teha, konto: " + firstAccountNr + " on lukus.");
        } else if (islocked2) {
            throw new ApplicationException("Ei saa toiminguid teha, konto: " + secondAccountNr + " on lukus.");
        } else if (transfer < 0) {
            throw new ApplicationException("Ülekantav summa ei või olla negatiivne number") ;
        } else if (transfer > bankRepository.getBalance(firstAccountNr)) {
            throw new ApplicationException("Kontol pole piisavalt vahendeid");
        } else {
            Double balance = bankRepository.getBalance(firstAccountNr);
            Double newBalance = balance - transfer;
            bankRepository.updateBalance(firstAccountNr, newBalance);
            Double balance2 = bankRepository.getBalance(secondAccountNr);
            Double newBalance2 = balance2 + transfer;
            bankRepository.updateBalance(secondAccountNr, newBalance2);
            return "Summa " + transfer + " on kontolt: " + firstAccountNr + " üle kantud kontole: " + secondAccountNr;
        }
    }
}


