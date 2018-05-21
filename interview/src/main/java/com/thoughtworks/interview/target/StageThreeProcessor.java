package com.thoughtworks.interview.target;

import org.springframework.stereotype.Component;

@Component
public class StageThreeProcessor extends StageProcessor {
	
	@Override
	public Object processInputAndFormulateOutput() {
		return productService.getProductCategories();
	}

}
