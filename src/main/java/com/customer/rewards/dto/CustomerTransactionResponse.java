package com.customer.rewards.dto;

import java.util.Set;

import com.customer.rewards.model.CustomerTransaction;

import lombok.Data;

@Data
public class CustomerTransactionResponse {

	private String month;

	private Set<CustomerTransaction> transactions;

	private Long totalMonthRewards;

	public Long getTotalMonthRewards() {
		if (transactions == null || transactions.isEmpty())
			return 0l;

		return transactions.stream().map(x -> x.getPoints().intValue()).reduce(0, (a, b) -> a + b).longValue();
	}

}
