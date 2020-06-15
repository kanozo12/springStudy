package net.kanozo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import net.kanozo.domain.KanozoVO;

public class KanozoValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return KanozoVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userid", "required", "유저 아이디 값을 필수입니다.");
		KanozoVO vo = (KanozoVO) target;

		if (vo.getCode() < 0) {
			errors.rejectValue("code", "bad", "0 이하의 숫자는 올 수 없습니다.");
		}
	}
}
