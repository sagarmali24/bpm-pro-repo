package com.cch.processrecipes.processemployeemapping;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * @author Sagar Mali,Dada Gaikvad 
 *
 */

@Component
public class ProcessEmpMappingFormValidator implements Validator
{
	@SuppressWarnings("unchecked")
	@Override
	public boolean supports(Class clazz)
	{
		return ProcessEmpMapping.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object model, Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emp_id","required.emp_id", "Emp Id is required.");
	}

}
