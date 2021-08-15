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

	private final String FIRSTNAME;
	private final String SURNAME;
	private final String USERNAME;
	private final String EMAIL;
	private final LocalDate DOB;
	private final char[] PASSWORD;
	private final char[] REPEAT_PASSWORD;
	private final int PASS_SCORE;

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
		this.FIRSTNAME = firstname;
		this.SURNAME = surname;
		this.USERNAME = username;
		this.EMAIL = email;
		this.DOB = dob;
		this.PASSWORD = password;
		this.REPEAT_PASSWORD = repeatPassword;
		this.PASS_SCORE = passScore;
	}

	/**
	 * Validate Existence
	 *
	 * @return true if exists.
	 */
	public boolean validateFirstname() {
		boolean valid = true;

		if (FIRSTNAME.equals("")) {
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

		if (FIRSTNAME.length() > 100) {
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

		if (SURNAME.equals("")) {
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

		if (SURNAME.length() > 100) {
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
		Matcher usernameMatcher = usernamePatten.matcher(USERNAME);

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

		if (USERNAME.length() > 25) {
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
		Matcher emailMatcher = emailPatten.matcher(EMAIL);

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

		if (EMAIL.length() > 255) {
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

		if (DOB == null) {
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

		if (DOB.isAfter(LocalDate.now(ZoneId.systemDefault()))) {
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

		if (!Arrays.equals(PASSWORD, REPEAT_PASSWORD)) {
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

		if (PASSWORD.length < 8) {
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

		if (PASS_SCORE < 3) {
			valid = false;
		}

		return valid;
	}
}
