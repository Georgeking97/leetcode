public class leetcode {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        String[] strs = {"flow", "flow", "flow"};
        String romanNumeral = "III";

        twoSum(nums, target);
        isPalindrome(123);
        romanToInt(romanNumeral);
        longestCommonPrefix(strs);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] resultsArray = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j] == target)) {
                    resultsArray[0] = i;
                    resultsArray[1] = j;
                }
            }
        }
        return resultsArray;
    }

    public static boolean isPalindrome(int x) {
        String original = Integer.toString(x);
        String converted = "";
        char indexPosition;

        for (int i = 0; i < original.length(); i++) {
            indexPosition = original.charAt(i);
            converted = indexPosition + converted;
        }

        return original.compareTo(converted) == 0;
    }

    public static int romanToInt(String s) {
        int currentIndexValue = 0, finalValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I':
                    currentIndexValue = 1;
                    break;
                case 'V':
                    currentIndexValue = 5;
                    break;
                case 'X':
                    currentIndexValue = 10;
                    break;
                case 'L':
                    currentIndexValue = 50;
                    break;
                case 'C':
                    currentIndexValue = 100;
                    break;
                case 'D':
                    currentIndexValue = 500;
                    break;
                case 'M':
                    currentIndexValue = 1000;
                    break;
            }
            if (4 * currentIndexValue < finalValue) {
                finalValue -= currentIndexValue;
            } else {
                finalValue += currentIndexValue;
            }
        }
        return finalValue;
    }

    public static String longestCommonPrefix(String[] strs) {
        int currentLength, shortestLength = 201;
        StringBuilder longestCommonPrefix = new StringBuilder();

        if (strs == null || strs.length == 0) {
            return longestCommonPrefix.toString();
        }

        for (int i = 0; i < strs.length; i++) {
            currentLength = strs[i].length();
            if (currentLength < shortestLength) {
                shortestLength = currentLength;
            }
        }

        for (int i = 0; i < shortestLength; i++) {
            char currentChar = strs[0].charAt(i);
            for (String letter : strs) {
                if (letter.charAt(i) != currentChar) {
                    return longestCommonPrefix.toString();
                }
            }
            longestCommonPrefix.append(currentChar);
        }
        return longestCommonPrefix.toString();
    }
}
