package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
       
        account = new BankAccount(100.0);
    }

    @AfterEach
    void tearDown() {
        
        account = null;
    }

    @Test
    void depositAddsToBalance() {
        account.deposit(50.0);

        assertEquals(150.0, account.getBalance());
    }

    @Test
    void withdrawTakesFromBalance() {
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance());
    }

    @Test
    void withdrawingTooMuchThrows() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(500.0));
    }
}
