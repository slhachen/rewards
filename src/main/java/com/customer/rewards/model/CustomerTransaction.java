package com.customer.rewards.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CustomerTransaction extends Reward {

	private Long transactionId;

	private Double transactionValue;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate transactionDate;

	// Calculates the reward points for transaction
	@Override
	public Long getPoints() {
		this.points = 0l;

		if (this.transactionValue > 50 && this.transactionValue <= 100) {
			this.points += (this.transactionValue.intValue() - 50) * 1;
		}

		if (this.transactionValue > 100) {
			this.points += 50; // 1 point every dollar spent over $50
			this.points += (this.transactionValue.intValue() - 100) * 2; // 2 points every dollar spent over $100
		}

		return this.points;
	}
}
