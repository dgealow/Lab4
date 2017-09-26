/*
 * The following code needs a lot of TLC. So give it some!
 *
 * 1. Fix all checkstyle errors
 * 2. Determine what it does (it's going to be tough before you finish #1)
 * 3. Improve the name of the methods and variables
 * 4. Add comments and Javadoc comments where needed
 * 5. Remove unnecessary comments as appropriate
 */
/**
 * Contains a substring finder.
 */
public class ReclamationProject {
    /**
     * Finds the longest substring shared by two strings.
     * @param a first input string
     * @param b second input string
     * @return longest shared substring of a and b or "" if there is none
     */
    static String sharedSubstring(final String a, final String b) {
        String longer, shorter;
        if (a.length() > b.length()) {
            longer = a;
            shorter = b;
        } else {
            longer = b;
            shorter = a;
        }

        String retString = "";
        if (longer.equals(shorter)) {
            retString = a;
        }

        for (int lIndex = 0; lIndex < longer.length(); lIndex++) {
            for (int length = longer.length() - lIndex; length > retString.length(); length--) {
                for (int sIndex = 0; sIndex <= shorter.length() - length; sIndex++) {
                    if (longer.regionMatches(lIndex, shorter, sIndex, length)) {
                        retString = longer.substring(lIndex, lIndex + length);
                    }
                }
            }
        }
        return retString;
    }

    /**
     * Tests the sharedSubstring method.
     * @param args unused
     */
    public static void main(final String[] args) {
        System.out.println(sharedSubstring("The quick brown fox", "jumps over the lazy dog."));
    }
}
