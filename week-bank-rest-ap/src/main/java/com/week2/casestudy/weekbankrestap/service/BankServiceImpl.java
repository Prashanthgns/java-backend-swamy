package com.week2.casestudy.weekbankrestap.service;

import com.week2.casestudy.weekbankrestap.domain.BankAccount;
import com.week2.casestudy.weekbankrestap.exception.InvalidAmountException;
import com.week2.casestudy.weekbankrestap.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional(isolation = Isolation.READ_UNCOMMITTED)
@Service
public class BankServiceImpl implements BankService{
    @Autowired
    private BankRepository repository;

    @Override
    public void createNewAccount(BankAccount ba) {
        repository.save(ba);
    }

    @Override
    public int updateAccountDetails(BankAccount ba) {
        return 0;
    }

    @Override
    public boolean activateAccount(Long acNum) {
        return false;
    }

    @Override
    public boolean deActivateAccount(Long acNum) {
        return false;
    }

    @Transactional
    @Override
    public double withdraw(Long acNum, double amt) {
        repository.withdraw(amt, acNum);
        return amt;
    }

    @Override
    public double deposit(Long acNum, double amt) throws InvalidAmountException {
        // just explanation I am using this strategy
        // it can be done in more efficient way

        if(amt <= 0) throw new InvalidAmountException("Amount Should be Non Zero Positive "+amt);

        Optional<BankAccount> op = repository.findById(acNum);

        BankAccount baOld = op.orElseThrow();
        double existingBalance = baOld.getBalance();
        double newBalance = existingBalance + amt;

        BankAccount baNew = new BankAccount();
        baNew.setBalance(newBalance);
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(baOld.getStatus());
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());

        repository.save(baNew);

//        withdraw(acNum, 10);

        return baNew.getBalance();
    }

    @Override
    public int transferMoney(Long srcAc, Long dstAc, double amt) {
        return 0;
    }

    @Override
    public BankAccount findAccountByAcNum(Long acNum) {
        return null;
    }

    @Override
    public List<BankAccount> findAllBankAccounts() {
        return null;
    }

    @Override
    public List<BankAccount> namesStartsWith(String prefix) {
        return repository.findByAcHldNmStartingWith(prefix);
    }
}
