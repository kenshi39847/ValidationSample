package com.example.demo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.form.CalcForm;

@Component
public class CalcValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// 引数で渡されたFormが入力チェックの対処化を理論値で返す。
		return CalcForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// 対象のFormを取得する
		CalcForm form = (CalcForm) target;
		// 値が入っているかの判定
		if (form.getLeftNum() != null && form.getRightNum() != null) {
			//　左側の入力項目が奇数かつ右側の入力項目が偶数でない
			if(!((form.getLeftNum() % 2 == 1) && (form.getRightNum() % 2 == 0))) {
				// エラーの場合は引数Errorsインターフェースのrejectメソッドにエラーメッセージのキーを指定する
				errors.reject("com.example.demo.validator.CalcValidator.message");
			}
			
		}

	}

}
