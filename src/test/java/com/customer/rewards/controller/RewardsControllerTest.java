package com.customer.rewards.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.customer.rewards.dto.CustomerResponse;
import com.customer.rewards.model.Customer;
import com.customer.rewards.model.CustomerTransaction;

@ExtendWith(MockitoExtension.class)
public class RewardsControllerTest {

	@InjectMocks
	private RewardsController rewardsController;

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
	public void testCaluclateRewardPoints() {
		List<CustomerResponse> list = rewardsController.caluclateRewardPoints(Arrays.asList(initilizeValues()));
		Assertions.assertEquals(list.size(), 1);
		Assertions.assertEquals(list.get(0).getTotalPurchases(), 170);
	}

}
