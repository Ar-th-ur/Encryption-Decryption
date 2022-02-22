package com.company;


import com.company.encrtyptor_fabric.EncryptorStore;

import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		// creates table by argument type -> argument
		HashMap<String, String> commands = new HashMap<>();
		for (int i = 0; i < args.length; i += 2) {
			commands.put(args[i], args[i + 1]);
		}

		try {
			// reads all arguments
			String mode        = commands.getOrDefault("-mode", "enc");
			PrintStream output = commands.getOrDefault("-out", "").isEmpty() ?
										                     System.out :
										                     new PrintStream(commands.get("-out"));
			String algorithm   = commands.getOrDefault("-alg", "shift");
			int key            = Integer.parseInt(commands.getOrDefault("-key", "0"));
			String message     = commands.getOrDefault("-data", commands.get("-in") == null ?
			                                                "" :
			                                                 Files.readString(Path.of(commands.get("-in"))));

			// orders new encryptor
			EncryptorStore encryptorStore = new EncryptorStore();
			encryptorStore.orderEncryptor(
				algorithm,
				mode,
				message,
				key,
				output
			);
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
}
