package com.company.encrtyptor_fabric;

import java.io.PrintStream;

/**
 * Basic class that helps to create Encryptors and manipulate this
 **/
public abstract class EncryptorFactory {

	/**
	 * Creates encryptor that satisfies specified algorithm name
	 * @param algorithm name of encryptor
	 * @return Encryptor that satisfies algorithm name
	 */
	abstract Encryptor createEncryptor(String algorithm);

	/**
	 * Encrypts the text with the specified parameters
	 * @param algorithm shift / unicode
	 * @param mode      encrypt / decrypt
	 * @param message   the text to be encrypted
	 * @param key       indent
	 * @param output    where to print after operation
	 */
	public Encryptor orderEncryptor(String algorithm, String mode, String message, int key, PrintStream output) {
		Encryptor encryptor = createEncryptor(algorithm);
		if (encryptor == null) {
			System.out.println("No encryptor with this algorithm");
			return null;
		}
		encryptor.encrypt(mode, message, key, output);
		return encryptor;
	}
}
