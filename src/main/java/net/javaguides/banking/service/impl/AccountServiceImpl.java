package net.javaguides.banking.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.stereotype.Service;

import net.javaguides.banking.dto.AccountsDto;
import net.javaguides.banking.entities.Accounts;
import net.javaguides.banking.mapper.AccountsMapper;
import net.javaguides.banking.repository.AccountRepository;
import net.javaguides.banking.service.AccountService;



@Service
public class AccountServiceImpl implements AccountService{
   
	private AccountRepository accountRepository;
   
    public AccountServiceImpl(AccountRepository accountRepository) {
    	this.accountRepository = accountRepository;
    }
	
	
	public AccountsDto createAccount(AccountsDto accountDto ) {
    	 Accounts account = AccountsMapper.mapToAccount(accountDto);
         Accounts savedAccount =  accountRepository.save(account);
		 return AccountsMapper.mapToAccountsDto(savedAccount);
     }


	
	
	@Override
	public AccountsDto getAccountById(long id) {
		
	Accounts account = accountRepository
			.findById(id)
			.orElseThrow(() -> new RuntimeException("Account does not exists"));
		    
	
	return AccountsMapper.mapToAccountsDto(account);
	}

	public AccountsDto deposit(long id, double amount) {
		Accounts account = accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exists"));
			    
		double total = account.getBalance() + amount;
		account.setBalance(total);
		Accounts savedAccount = accountRepository.save(account);
		return AccountsMapper.mapToAccountsDto(savedAccount);
	}
 //withdraw REST API  
	@Override
	public AccountsDto withdraw(long id, double amount) {
		Accounts account = accountRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Account does not exists"));
		
		if(account.getBalance() < amount) {
			throw new RuntimeException("Insufficient Amount");
		}
		
		
		double total = account.getBalance() - amount;
		account.setBalance(total);
		Accounts savedAccount = accountRepository.save(account);
        
		return AccountsMapper.mapToAccountsDto(savedAccount);
}
   
	@Override

	public List<AccountsDto> getAllAccounts(){
    	   List<Accounts> accounts = accountRepository.findAll();
    	   return accounts.stream().map((account)->AccountsMapper.mapToAccountsDto(account))
    	   .collect(Collectors.toList());
    	
    }
    
    @Override
    public void deleteAccount(long id) {
    	Accounts account = accountRepository
    			.findById(id)
    			.orElseThrow(() -> new RuntimeException("Account does not exists"));
    		    
    	accountRepository.deleteById(id);
    }
}
