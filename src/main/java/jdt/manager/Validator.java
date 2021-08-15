package jdt.manager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.*;

/**
 * Validator to validate user information.
 *
 * @author Luke Leppan
 */
public class Validator {

	private final String firstname;
	private final String surname;
	private final String username;
	private final String email;
	private final LocalDate dob;
	private final char[] password;
	private final char[] repeatPassword;
	private final int passScore;

	/**
	 * Create Validator.
	 *
	 * @param firstname The first name entered
	 * @param surname The surname entered
	 * @param username The username entered
	 * @param email The email entered
	 * @param dob The Date of Birth entered
	 * @param password The password entered
	 * @param repeatPassword The repeated password entered
	 * @param passScore The password score generated
	 */
	public Validator(String firstname, String surname, String username, String email, LocalDate dob, char[] password,
			char[] repeatPassword, int passScore) {
		this.firstname = firstname;
		this.surname = surname;
		this.username = username;
		this.email = email;
		this.dob = dob;
		this.password = password;
		this.repeatPassword = repeatPassword;
		this.passScore = passScore;
	}

	/**
	 * Validate Existence
	 *
	 * @return true if exists.
	 */
	public boolean validateFirstname() {
		boolean valid = true;

		if (firstname.equals("")) {
			valid = false;
		}

		return valid;
	}

	/**
	 * Validate Length
	 *
	 * @return true if length correct.
	 */
	public boolean validateFirstnameLength() {
		boolean valid = true;

		if (firstname.length() > 100) {
			valid = false;
		}

		return valid;
	}

	/**
	 * Validate Existence
	 *
	 * @return true if exists.
	 */
	public boolean validateSurname() {
		boolean valid = true;

		if (surname.equals("")) {
			valid = false;
		}

		return valid;
	}

	/**
	 * Validate Length
	 *
	 * @return true if length correct.
	 */
	public boolean validateSurnameLength() {
		boolean valid = true;

		if (surname.length() > 100) {
			valid = false;
		}

		return valid;
	}

	/**
	 * Validate Username
	 *
	 * @return true if username in correct format.
	 */
	public boolean validateUsername() {
		boolean valid = true;

		Pattern usernamePatten = Pattern.compile("^(?!.*\\.\\.)(?!.*\\.$)[^\\W][\\w.]{0,25}$",
				Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
		Matcher usernameMatcher = usernamePatten.matcher(username);

		if (!usernameMatcher.find()) {
			valid = false;
		}

		return valid;
	}

	/**
	 * Validate Length
	 *
	 * @return true if length correct.
	 */
	public boolean validateUsernameLength() {
		boolean valid = true;

		if (username.length() > 25) {
			valid = false;
		}

		return valid;
	}

	/**
	 * Validate Email
	 *
	 * @return true if email in correct format.
	 */
	public boolean validateEmail() {
		boolean valid = true;

		Pattern emailPatten = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher emailMatcher = emailPatten.matcher(email);

		if (!emailMatcher.find()) {
			valid = false;
		}

		return valid;
	}

	/**
	 * Validate Length
	 *
	 * @return true if length correct.
	 */
	public boolean validateEmailLength() {
		boolean valid = true;

		if (email.length() > 255) {
			valid = false;
		}

		return valid;
	}

	/**
	 * Validate Existence
	 *
	 * @return true if exists.
	 */
	public boolean validateDOB() {
		boolean valid = true;

		if (dob == null) {
			valid = false;
		}

		return valid;
	}

	/**
	 * Validate Logic
	 *
	 * @return true if born before today.
	 */
	public boolean validateDOBLogic() {
		boolean valid = true;

		if (dob.isAfter(LocalDate.now(ZoneId.systemDefault()))) {
			valid = false;
		}

		return valid;
	}

	/**
	 * Validate Match
	 *
	 * @return true if passwords match.
	 */
	public boolean validatePasswordMatch() {
		boolean valid = true;

		if (!Arrays.equals(password, repeatPassword)) {
			valid = false;
		}

		return valid;
	}

	/**
	 * Validate Length
	 *
	 * @return true if length correct.
	 */
	public boolean validatePasswordLength() {
		boolean valid = true;

		if (password.length < 8) {
			valid = false;
		}
		return valid;
	}

	/**
	 * Validate strength
	 *
	 * @return true if password strong enough.
	 */
	public boolean validatePasswordStrength() {
		boolean valid = true;

		if (passScore < 3) {
			valid = false;
		}

		return valid;
	}
}
