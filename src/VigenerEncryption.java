public class VigenerEncryption {
    private static String string = "abcdefghijklmnopqrstuvwxyz";
    private static String alphabet = string + string.toUpperCase() + ' ';
    private static String encryptResult;

    public static void main() {
        encryptResult = encrypt("is it caesar or shuffle encryption???", "hey");
        System.out.println("Encrypted vigener: " + encryptResult);
        System.out.println("Decrypted vigener: " + decrypt(encryptResult, "hey") + "\n\n");
    }

    public static String encrypt(String input, String key) {
        return vigener(input, key, true );
    }

    public static String decrypt(String input, String key) {
        return vigener(input, key, false );
    }

    public static String vigener(String input, String key, boolean encrypt) {
        int alphabetLength = alphabet.length();
        StringBuilder encryptedText = new StringBuilder(input.length());

        for (int i = 0; i < input.length(); i++) {
            int alphabetPosition = alphabet.indexOf(input.charAt(i));

            if (alphabetPosition != -1) {
                int alphabetKeyPosition = alphabet.indexOf(key.charAt(i % key.length()));

                if (!encrypt) {
                    int shiftedPosition = alphabetPosition - alphabetKeyPosition;

                    if (shiftedPosition < 0) {
                        shiftedPosition += alphabetLength;
                    }

                    encryptedText.append(alphabet.charAt(shiftedPosition));
                } else {
                    encryptedText.append(alphabet.charAt((alphabetPosition + alphabetKeyPosition) % alphabetLength));
                }
            } else {
                encryptedText.append(input.charAt(i));
            }
        }
        return encryptedText.toString();
    }
}