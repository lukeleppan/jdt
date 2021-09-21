package jdt.manager;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Hash passwords and authenticate passwords.
 *
 * @author Luke Leppan
 */
public final class PasswordAuth {

	public static final String ID = "jdt$";
	public static final int COST = 16;
	private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
	private static final int SIZE = 128;
	private static final Pattern LAYOUT = Pattern.compile("jdt\\$(\\d\\d?)\\$(.{43})");
	private final SecureRandom RANDOM;

	/**
	 * Create a password manager.
	 */
	public PasswordAuth() {
		iterations(COST);
		this.RANDOM = new SecureRandom();
	}

	private static int iterations(int cost) {
		return 1 << cost;
	}

	/**
	 * Hash a password.
	 *
	 * @param password the password to hash
	 *
	 * @return a secure hashed password.
	 */
	public String hash(char[] password) {
		byte[] salt = new byte[SIZE / 8];
		RANDOM.nextBytes(salt); // Randomly generate the salt
		byte[] dk = pbkdf2(password, salt, 1 << COST); // Gen hash
		byte[] hash = new byte[salt.length + dk.length];
		System.arraycopy(salt, 0, hash, 0, salt.length);
		System.arraycopy(dk, 0, hash, salt.length, dk.length);
		Base64.Encoder enc = Base64.getUrlEncoder().withoutPadding();
		return ID + COST + '$' + enc.encodeToString(hash); // Make storable
	}

	/**
	 * Authenticate a password.
	 *
	 * @param password the password to authenticate.
	 * @param token the hash to authenticate.
	 *
	 * @return true if the password and hash match
	 */
	public boolean authenticate(char[] password, String token) {
		Matcher m = LAYOUT.matcher(token); // Check format
		if (!m.matches()) {
			throw new IllegalArgumentException("Invalid token format");
		}
		int iterations = iterations(Integer.parseInt(m.group(1)));
		byte[] hash = Base64.getUrlDecoder().decode(m.group(2)); // Get the hash from the string
		byte[] salt = Arrays.copyOfRange(hash, 0, SIZE / 8); // Get salt from string
		byte[] check = pbkdf2(password, salt, iterations); //compare
		int zero = 0;
		for (int i = 0; i < check.length; ++i) {
			zero |= hash[salt.length + i] ^ check[i];
		}
		return zero == 0;
	}

	/**
	 * Run hashing algorithm.
	 *
	 * @param password the raw password
	 * @param salt the salt
	 * @param iterations the number of iterations
	 *
	 * @return the hashed password
	 */
	private static byte[] pbkdf2(char[] password, byte[] salt, int iterations) {
		KeySpec spec = new PBEKeySpec(password, salt, iterations, SIZE);
		try {
			SecretKeyFactory f = SecretKeyFactory.getInstance(ALGORITHM); // Run hash algorithm
			return f.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException ex) {
			throw new IllegalStateException("Missing algorithm: " + ALGORITHM, ex);
		} catch (InvalidKeySpecException ex) {
			throw new IllegalStateException("Invalid SecretKeyFactory", ex);
		}
	}
}
