/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        System.out.println(subsetOf("pasd","space"));
        System.out.println(randomStringOfLetters(3));
        System.out.println(remove("abc","b"));
        System.out.println(insertRandomly('s',"cat"));
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int counter = 0;
        for (int i = 0; i<str.length(); i++) {
            if ( str.charAt(i) == ch) {
                counter ++;
            }
        }
        return counter;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
       for (int i = 0; i<str1.length(); i++) {
            
            // if the char in str1 isnt in str2 then false
            if (str2.indexOf(str1.charAt(i)) == -1) {
                return false;
            }
            
            // if the amount of each char isnt equal then false
            int freq1 = countChar(str1, str1.charAt(i));
            int freq2 = countChar(str2, str2.charAt(str2.indexOf(str1.charAt(i))));

            if ( freq1 != freq2) {
                return false;
            }
       }

       if (str1.length() == 0) {
        return true;
       
        }
    // if all conditions are true, then it is true :)
    return true;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        StringBuilder sb = new StringBuilder(str);
            for(int i = 0; i<(sb.length() -1); i+=2) {
                sb.insert(i+1, " ");
            }

            if (str.length()==0) {
                return "";
            }

        String newStr = sb.toString();
        return newStr;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String concat = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i<n; i++) {
            int index = (int)(Math.random() * 26);
            char letter = alphabet.charAt(index);
            concat = concat + letter;
        }
        
        
    return concat;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
      if (str2.length()==0) {
           return str1;
       }
        
        StringBuilder sbStr1 = new StringBuilder(str1);

       for (int i = 0; i<str2.length(); i++) {
            int index = String.valueOf(sbStr1).indexOf(str2.charAt(i));
           
           if ( index != -1) {
            sbStr1 = sbStr1.delete(index,(index + 1)); 

           }
        }
       
        String strReturn = String.valueOf(sbStr1);
       return strReturn;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
