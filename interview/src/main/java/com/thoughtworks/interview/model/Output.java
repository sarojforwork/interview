package com.thoughtworks.interview.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Output {
	Integer count;
	Integer totalValue;
	
	
	public Output() {}

	public Output(Integer count, Integer totalValue) {
		super();
		this.count = count;
		this.totalValue = totalValue;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Integer totalValue) {
		this.totalValue = totalValue;
	}
}
