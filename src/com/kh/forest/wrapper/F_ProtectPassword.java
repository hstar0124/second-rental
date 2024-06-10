package com.kh.forest.wrapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.util.Base64;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.kh.forest.member.controller.F_MemberCreateServlet;

public class F_ProtectPassword extends HttpServletRequestWrapper {

	public F_ProtectPassword(HttpServletRequest request) {
		super(request);
		
	}
	
	@Override
	public String getParameter(String key) {
		
		String value = "";
		
		if(key != null && key.equals("password1")) {
			value = getSha512(super.getParameter("password1"));
		}else if(key != null && key.equals("password2")) {
			value = getSha512(super.getParameter("password2"));
		}else if(key != null && key.equals("account")) {
			Properties prop = new Properties();
			String fileName = F_MemberCreateServlet.class.getResource("/sql/member/aesKey.properties").getPath();
			try {
				prop.load(new FileReader(fileName));
				String key1 = prop.getProperty("key1");
				try {
					value = F_CryptoUtil.encryptAES256(super.getParameter("account"), key1);
				} catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException
						| NoSuchPaddingException | InvalidParameterSpecException | BadPaddingException
						| IllegalBlockSizeException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else {
			value = super.getParameter(key);
		}
		return value;
	}
	
	private static String getSha512(String pwd) {
		String encPwd = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = pwd.getBytes(Charset.forName("UTF-8"));
			
			md.update(bytes);
			
			encPwd = Base64.getEncoder().encodeToString(md.digest());
		
	
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return encPwd;
	}
	
}
