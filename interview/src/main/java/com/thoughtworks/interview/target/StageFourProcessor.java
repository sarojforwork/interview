package com.thoughtworks.interview.target;

import org.springframework.stereotype.Component;

import com.thoughtworks.interview.model.Output;

@Component
public class StageFourProcessor extends StageProcessor {

	@Override
	public Object processInputAndFormulateOutput() {
		return new Output(null, productService.getActiveProductsValue());
	}

}
