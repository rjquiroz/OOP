import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents an Employee that will sign up in the Employee tab.
 * An Employee has a full name, an username and an email that will be assign to him,
 * and a password.
 *
 * @author Ronald Quiroz
 */
public class Employee {
  StringBuilder name;
  String username;
  String password;
  String email;

  /**
   * Default constructor for Employee.
   */
  public Employee() {

  }

  /**
   * Constructor to assign values to the fields of an Employee.
   *
   * @param name     that will be the full name of a new Employee provided by him.
   * @param password that will be the password provided by the same new Employee.
   *                 This constructor will check with the other methods that the name and password are valid
   *                 and then will assign the username and email based off that.
   */
  public Employee(String name, String password) {
    //needed to assign name to this.name.
    StringBuilder sb = new StringBuilder(name);
    this.name = sb;

    //if name is valid (has white spaces) will assign the username and email.
    if (checkName(name)) {
      setUsername(name);
      setEmail(name);
    }
    //if not valid will give a default username and email.
    else {
      username = "default";
      email = "user@oracleacademy.Test";
    }
    //will use the same password if is valid(1 uppercase,1 lowercase, 1 special character).
    if (isValidPassword(password)) {
      this.password = password;
    }
    //if not will assign a default password.
    else {
      this.password = "pw";
    }

  }

  /**
   * set the username of the employee base of the full name provided.
   * first letter of the first name, following the full last name.
   *
   * @param name which is the full name provided by the Employee.
   */
  private void setUsername(String name) {
    //divides the full name at the white space and store it in an array of String.
    String[] user = name.split(" ");
    //takes the first character of the first name and make it lower case.
    String initialLetter = user[0].toLowerCase().substring(0, 1);
    //takes the last name lower case.
    String lastName = user[1].toLowerCase();
    //puts together both requirements.
    username = initialLetter + lastName;
  }

  /**
   * checks if the name is valid(if has white spaces or not).
   * returns a boolean.
   *
   * @param name which is the full name provided by the Employee.
   */
  private boolean checkName(String name) {
    return name.contains(" ");
  }

  /**
   * set the email of the employee base of the full name provided.
   * first name follow by a '.', then last name, then the default domain.
   *
   * @param name which is the full name provided by the Employee.
   */
  private void setEmail(String name) {
    String[] user = name.split(" ");
    String firstName = user[0].toLowerCase();
    String lastName = user[1].toLowerCase();
    email = firstName + "." + lastName + "@oracleacademy.Test";
  }

  /**
   * checks if the password is valid(if has a uppercase, a lowercase and a especial char).
   * returns a boolean.
   *
   * @param password which is the password provided by the Employee.
   */
  private boolean isValidPassword(String password) {
    //a regex statement to check if it has a lowercase, uppercase or special character.
    String regex = "^(?=.*[a-z])(?=."
            + "*[A-Z])"
            + "(?=.*[-+_!@#$%^&*., ?]).+$";

    // Compile the ReGex
    Pattern p = Pattern.compile(regex);

    // Find match between given string (the password)
    // & regex statement
    Matcher m = p.matcher(password);

    // true if matches, false if does not.
    return m.matches();
  }

  /**
   * Prints out the description of every field and data of an Employee.
   * returns a String.
   */
  public String toString() {
    return "\nEmployee Details" + "\nName : " + name + "\nUsername : " + username + "\nEmail : "
            + email + "\nInitial Password : " + password;
  }

}
