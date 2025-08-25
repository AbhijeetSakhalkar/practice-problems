package tmp.practice;

public class Test {

    private static final String[] units = {
            "", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen"
    };

    private static final String[] tens = {
            "", "", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"
    };

    public static void main(String[] args) {
        int[] testCases = {0, 5, 19, 55, 5550, 55087, 150800, 193699, 10000000, 99999999};
        for (int num : testCases) {
            System.out.println(num + " => " + convertToIndianWords(num));
        }
    }

    public static String convertToIndianWords(int number) {
        if (number == 0) return "zero";
        StringBuilder result = new StringBuilder();
        if (number >= 10000000) {
            result.append(convertToIndianWords(number / 10000000)).append(" crore ");
            number %= 10000000;
        }
        if (number >= 100000) {
            result.append(convertToIndianWords(number / 100000)).append(" lakh ");
            number %= 100000;
        }
        if (number >= 1000) {
            result.append(convertToIndianWords(number / 1000)).append(" thousand ");
            number %= 1000;
        }
        if (number >= 100) {
            result.append(convertToIndianWords(number / 100)).append(" hundred ");
            number %= 100;
            if (number > 0) result.append("and ");
        }
        if (number > 0) {
            if (number < 20) {
                result.append(units[number]);
            } else {
                result.append(tens[number / 10]);
                if (number % 10 > 0) {
                    result.append(" ").append(units[number % 10]);
                }
            }
        }
        return result.toString().trim().replaceAll("\\s+", " ");
    }

}
