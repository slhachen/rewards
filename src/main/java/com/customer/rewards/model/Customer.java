package com.customer.rewards.model;

import java.util.Set;

import lombok.Data;

@Data
public class Customer {

	private String name;
	private Set<CustomerTransaction> transactions;
	private Long totalRewardPoints;
	private Double totalPurchases;
	
	// Calculate the total reward points
	public Long getTotalRewardPoints() {
		if (transactions == null || transactions.isEmpty())
			return 0l;

		return transactions.stream().map(x -> x.getPoints().intValue()).reduce(0, (a, b) -> a + b).longValue();
	}
	
	// sum the total purchases
	public Double getTotalPurchases() {
		if (transactions == null || transactions.isEmpty())
			return 0d;

		return transactions.stream().map(x -> x.getTransactionValue().doubleValue()).reduce(0d, (a, b) -> a + b)
				.doubleValue();
	}

}
