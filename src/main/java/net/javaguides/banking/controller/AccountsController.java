package net.javaguides.banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.banking.dto.AccountsDto;
import net.javaguides.banking.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

	private AccountService accountService;
	
	public AccountsController(AccountService accountService) {
		this.accountService = accountService;
	}

//Add Account REST API
	@PostMapping
	public ResponseEntity<AccountsDto> addAccount(@RequestBody AccountsDto accountDto){
		return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);		
	}
//Get Account REST API
	
	@GetMapping("/{id}")
	public ResponseEntity<AccountsDto> getAccountById(@PathVariable long id){
		AccountsDto accountsDto = accountService.getAccountById(id);
		return ResponseEntity.ok(accountsDto);
	}

//Deposit REST API
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountsDto> deposit(@PathVariable long id, @RequestBody Map<String, Double>request){
		Double amount = request.get("amount");
		AccountsDto accountsDto = accountService.deposit(id, amount );
		return ResponseEntity.ok(accountsDto);
	}
//Withdraw REST API
    @PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountsDto> getAccountById(@PathVariable long id, @RequestBody Map<String, Double>request){
		Double amount = request.get("amount");
		AccountsDto accountsDto = accountService.withdraw(id, amount );
		return ResponseEntity.ok(accountsDto);
		
	}
//Get all accounts REST API
   @Getmapping
    public ResponseEntity<List<AccountsDto>> getAllAccounts(){
    	List<AccountsDto> accounts = accountService.getAllAccounts();
    	return ResponseEntity.ok(accounts);
    }

//Delete account REST API
   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteAccount(@PathVariable long id){
	   accountService.deleteAccount(id);
	   return ResponseEntity.ok("Account is deleted Succcessfully");
   }

}
