package net.javaguides.banking.mapper;

import net.javaguides.banking.dto.AccountsDto;
import net.javaguides.banking.entities.Accounts;

public class AccountsMapper {

public static Accounts mapToAccount(AccountsDto accountDto) {
	  Accounts account = new Accounts(accountDto.getId(),accountDto.getAccountHolderName(),accountDto.getBalance());
	   
	  return account;
  }
public static AccountsDto mapToAccountsDto(Accounts account) {
	            AccountsDto accountDto = new AccountsDto(
	            account.getId() , 
	            account.getAccountHolderName(),
	            account.getBalance());
	
	            return accountDto;
}
}
