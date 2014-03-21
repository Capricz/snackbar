package com.zliang.snackbar.core.i18n;

import java.util.Locale;

public class LocaleTest {

	public static void main(String[] args) {
		Locale[] availableLocales = Locale.getAvailableLocales();
		for (int i = 0; i < availableLocales.length; i++) {
			Locale locale = availableLocales[i];
			System.out.println("Country : "+locale.getDisplayCountry()+"("+locale.getCountry()+"), Language : "+locale.getDisplayLanguage() +"("+ locale.getLanguage()+")");
		}

	}

}
