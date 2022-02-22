package com.company.encryptors;

import com.company.encrtyptor_fabric.Encryptor;

import java.util.Arrays;
import java.util.List;

/**
 * Shifts the code of letter only
 **/
public class ShiftEncryptor extends Encryptor {
	private final List<String> alphabetLower = Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""));
	private final List<String> alphabetUpper = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));

	@Override
	public char shift(int key, char c) {
		if (!Character.isLetter(c)) {
			return c;
		}
		String letter = String.valueOf(c);
		return Character.isUpperCase(c) ? getNextLetter(letter, key, alphabetUpper) :
		       getNextLetter(letter, key, alphabetLower);
	}

	private char getNextLetter(String letter, int key, List<String> alphabet) {
		return alphabet.get((alphabet.size() + alphabet.indexOf(letter) + key) % alphabet.size()).toCharArray()[0];
	}
}
