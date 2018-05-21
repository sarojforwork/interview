package com.thoughtworks.interview.target;

import org.springframework.stereotype.Component;

import com.thoughtworks.interview.model.Output;

@Component
public class StageTwoProcessor extends StageProcessor {

	@Override
	public Object processInputAndFormulateOutput() {
		return new Output(productService.getActiveProductCount(), null);
	}

}
