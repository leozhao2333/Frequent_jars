/*
 * User Management
 * Provides an API to:   * Enumerate the user base   * Create new users   * Gather specific user's information   * Change a user's information  User information include things like:   * Whether or not the user account is `enabled` or not   * Username/password credentials as well as API keys   * Contact information such as `first_name`, `last_name`, `organization` and `email_address`   * Group membership - membership of a `group` is used to grant access to services and features   * Tenant membership - membership of a `tenant` is used to assign users specific `roles` in a organization   * Additional details - each user may have a collection of custom key-value pairs  For details about authentication, refer to the [authentication specification](/oauth/swagger.json).
 *
 * OpenAPI spec version: 1.1.37
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.quadient.dataservices.users.invoker;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-02-01T12:44:38.974-08:00")
public class StringUtil {
  /**
   * Check if the given array contains the given value (with case-insensitive comparison).
   *
   * @param array The array
   * @param value The value to search
   * @return true if the array contains the value
   */
  public static boolean containsIgnoreCase(String[] array, String value) {
    for (String str : array) {
      if (value == null && str == null) return true;
      if (value != null && value.equalsIgnoreCase(str)) return true;
    }
    return false;
  }

  /**
   * Join an array of strings with the given separator.
   * <p>
   * Note: This might be replaced by utility method from commons-lang or guava someday
   * if one of those libraries is added as dependency.
   * </p>
   *
   * @param array     The array of strings
   * @param separator The separator
   * @return the resulting string
   */
  public static String join(String[] array, String separator) {
    int len = array.length;
    if (len == 0) return "";

    StringBuilder out = new StringBuilder();
    out.append(array[0]);
    for (int i = 1; i < len; i++) {
      out.append(separator).append(array[i]);
    }
    return out.toString();
  }
}
