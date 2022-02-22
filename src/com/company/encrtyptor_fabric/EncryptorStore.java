package com.company.encrtyptor_fabric;

import com.company.encryptors.ShiftEncryptor;
import com.company.encryptors.UnicodeEncryptor;

/**
 * Class that creates encryptor by specified method
 **/
public class EncryptorStore extends EncryptorFactory {

	/**
	 * Creates encryptor by specified name
	 **/
	@Override
	Encryptor createEncryptor(String algorithm) {
		switch (algorithm.toLowerCase()) {
			case "unicode":
				return new UnicodeEncryptor();
			case "shift":
				return new ShiftEncryptor();
			default:
				return null;
		}
	}
}
