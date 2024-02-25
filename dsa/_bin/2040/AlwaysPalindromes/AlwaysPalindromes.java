/**
 * Name :
 * Matric. No :
 */

public class AlwaysPalindromes {
    public static void main(String args[]) {
        Kattio io = new Kattio(System.in);
        String token = io.getWord();
        int tokenLength = token.length();

        int verifiedPalindromeChars = 0;
        String reversedToken = "";

        for (int i = 0; i < tokenLength; i++) {

            reversedToken += token.charAt(tokenLength - (i + 1));

            if (token.charAt(i) == token.charAt(tokenLength - (i + 1))) {
                verifiedPalindromeChars += 1;
            }

            if ((i + 1) == tokenLength / 2 & verifiedPalindromeChars == tokenLength / 2) {
                System.out.println(token);
                break;
            }

        }

        if (verifiedPalindromeChars != tokenLength / 2) {
            System.out.println(token + reversedToken);
        }

    }
}
