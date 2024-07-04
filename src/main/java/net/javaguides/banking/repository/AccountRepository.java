package net.javaguides.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.banking.entities.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Long> {

}
