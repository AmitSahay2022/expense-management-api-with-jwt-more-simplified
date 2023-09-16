package com.sahayji.exp.management.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//----------------Not part of the project-----------------------------
public class Password {
     public static void main(String[] args) {
		PasswordEncoder pE=new BCryptPasswordEncoder();
		String encode = pE.encode("test1234");
		System.out.println(encode);
	}
}
