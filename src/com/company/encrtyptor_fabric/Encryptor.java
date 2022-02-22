package com.company.encrtyptor_fabric;

import java.io.PrintStream;
import java.util.List;

/**
 * Class to encrypt text
 **/
public abstract class Encryptor {

	/**
	 * Performs the specified operation (encryption or decryption) and print result to output
	 **/
	public void encrypt(String mode, String message, int key, PrintStream output) {
		if (!List.of("dec", "enc").contains(mode)) {
			key = 0;
		} else if (mode.equals("dec")) {
			key = -key;
		}
		output.print(encrypt(message, key));
	}

	/**
	 * Encrypts the text with the specified key
	 **/
	private String encrypt(String message, int key) {
		StringBuilder result = new StringBuilder();
		for (char c : message.toCharArray()) {
			result.append(shift(key, c));
		}
		return result.toString();
	}

	/**
	 * Shifts the character code by <code>key</code>
	 **/
	abstract public char shift(int key, char c);
}
