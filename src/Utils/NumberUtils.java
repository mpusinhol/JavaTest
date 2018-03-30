package Utils;

public class NumberUtils {
    private static final Integer MAX_MIXED_NUMBER_VALUE = 1000000;
    private static final String  REGEX_ONLY_NUMBERS = "\\d+";

    /**
     * A function to verify if a passed string contains only numbers
     * @param number The number to be tested
     * @return true if contain only numbers, false otherwise
     */
    public static boolean isValidInteger(String number)
    {
        return number.matches(REGEX_ONLY_NUMBERS);
    }

    /**
     * A function to mix two numbers. It alternates characters from each number.
     * If one number if bigger than the other, the function fill the final number with the characters remaining.
     * If the mixed number is greater than 1000000, it returns -1.
     * Example 1: firstNumber = 12, secondNumber = 4567, return = 142567
     * Example 2: firstNumber = 10250, secondNumber = 512, return = -1
     * @param firstNumber The first number to be mixed
     * @param secondNumber The second number to be mixed
     * @return A mixed number from the parameters passed or -1 if the mixed number is greater than 1000000
     * @throws Exception if either of the numbers passed is null
     */
    public static Integer mixNumbers(Integer firstNumber, Integer secondNumber) throws Exception {
        if (firstNumber != null && secondNumber != null) {
            Integer resultNumber;
            String finalNumber = "",
                    strFirstNumber = firstNumber.toString(),
                    strSecondNumber = secondNumber.toString();

            do {
                finalNumber += strFirstNumber.substring(0, 1) + strSecondNumber.substring(0, 1);

                strFirstNumber = strFirstNumber.substring(1);
                strSecondNumber = strSecondNumber.substring(1);

            } while (strFirstNumber.length() > 0 && strSecondNumber.length() > 0);

            if (strFirstNumber.length() > 0) {
                finalNumber += strFirstNumber;
            } else if (strSecondNumber.length() > 0) {
                finalNumber += strSecondNumber;
            }

            resultNumber = Integer.valueOf(finalNumber);

            return resultNumber > MAX_MIXED_NUMBER_VALUE ? -1 : resultNumber;
        } else {
            throw new Exception("None of the numbers may be null");
        }
    }
}
