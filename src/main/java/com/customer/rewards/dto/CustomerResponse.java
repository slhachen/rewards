package com.customer.rewards.dto;

import java.util.Set;

import lombok.Data;

@Data
public class CustomerResponse {

	private String name;
	private Set<CustomerTransactionResponse> monthlyTransactions;
	private Long totalRewardPoints;
	private Double totalPurchases;

}
