package com.customer.rewards.controller;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.rewards.dto.CustomerResponse;
import com.customer.rewards.dto.CustomerTransactionResponse;
import com.customer.rewards.model.Customer;
import com.customer.rewards.model.CustomerTransaction;

@RestController
public class RewardsController {

	@GetMapping("/customers")
	public List<CustomerResponse> caluclateRewardPoints(@RequestBody List<Customer> customers) {
		List<CustomerResponse> response = new ArrayList<>();
		Set<CustomerTransactionResponse> transactions = new HashSet<CustomerTransactionResponse>();
		customers.stream().forEach(a -> {
			CustomerResponse obj = new CustomerResponse();
			obj.setName(a.getName());
			obj.setTotalPurchases(a.getTotalPurchases());
			obj.setTotalRewardPoints(a.getTotalRewardPoints());
			Map<Month, List<CustomerTransaction>> map = a.getTransactions().stream()
					.collect(Collectors.groupingBy(b -> b.getTransactionDate().getMonth()));
			map.keySet().stream().forEach(c -> {
				CustomerTransactionResponse transactionResponse = new CustomerTransactionResponse();
				transactionResponse.setMonth(c.toString());
				transactionResponse.setTransactions(map.get(c).stream().collect(Collectors.toSet()));
				transactions.add(transactionResponse);
			});
			obj.setMonthlyTransactions(transactions);
			response.add(obj);
		});
		return response;
	}

}
