package ru.vallball.hotel_mic_admin01.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DatesValidator implements ConstraintValidator<DateValid, Booking> {

	@Override
	public boolean isValid(Booking value, ConstraintValidatorContext context) {
		return value.getEnd().isAfter(value.getStart());
	}

}
