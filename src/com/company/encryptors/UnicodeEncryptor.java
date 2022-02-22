package com.company.encryptors;

import com.company.encrtyptor_fabric.Encryptor;

/**
 * Shifts the code of symbol
 **/
public class UnicodeEncryptor extends Encryptor {

	@Override
	public char shift(int key, char c) {
		return (char) (c + key);
	}
}
