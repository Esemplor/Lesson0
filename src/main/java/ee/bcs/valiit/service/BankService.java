package ee.bcs.valiit.service;


import ee.bcs.valiit.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public void createAccount(String accountNr, Double balance){
        bankRepository.createAccount(accountNr, balance);
    }
}
