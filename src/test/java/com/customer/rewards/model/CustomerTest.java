package com.customer.rewards.model;

import java.time.LocalDate;
import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

	public final Customer customer = new Customer();

	public final CustomerTransaction customerTransaction = new CustomerTransaction();

	public Customer initilizeValues() {
		customer.setName("testing name");
		customerTransaction.setTransactionId(1l);
		customerTransaction.setTransactionDate(LocalDate.now());
		customerTransaction.setTransactionValue(170.0);
		customer.setTransactions(Collections.singleton(customerTransaction));
		return customer;
	}

	@Test
	public void testCustomerObj() {
		initilizeValues();
		Assertions.assertEquals(customer.getTotalRewardPoints(), 190);
	}
}
