package configurations;

import java.util.UUID;

public class Utils {
	public static String generateRandomUser() {
		String prefix = "user_";

		String identifier = UUID.randomUUID().toString().substring(0, 3);

		return prefix + identifier;
	}

	public static String getUserFirstName() {
		String[] fullName = generateRandomUser().split("_");
		String firstName = fullName[0];
		return firstName;
	}

	public static String getUserFirstName(String strInput) {
		String[] fullName = strInput.split("_");
		String firstName = fullName[0];
		return firstName;
	}

	public static String getUserLastName() {
		String[] fullName = generateRandomUser().split("_");
		int nameLenght = fullName.length - 1;
		String lastName = fullName[nameLenght];
		return lastName;
	}

	public static String getUserLastName(String strInput) {
		String[] fullName = strInput.split("_");
		int nameLenght = fullName.length - 1;
		String lastName = fullName[nameLenght];
		return lastName;
	}
}
