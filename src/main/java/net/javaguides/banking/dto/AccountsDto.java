package net.javaguides.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountsDto {
	private long id;
	private String accountHolderName;
	private double balance;
	
	
	
}
