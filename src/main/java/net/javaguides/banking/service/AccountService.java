package net.javaguides.banking.service;

import java.util.List;

import net.javaguides.banking.dto.AccountsDto;

public interface AccountService {
  
	AccountsDto createAccount(AccountsDto accountDto);
	
	AccountsDto getAccountById(long id);
    
	AccountsDto deposit(long id, double amount);
	
	AccountsDto withdraw(long id, double amount);
	
	List<AccountsDto> getAllAccounts();
	
	void deleteAccount(long id);
	
}
