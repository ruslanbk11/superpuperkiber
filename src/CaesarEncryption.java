public class CaesarEncryption {

    public static String encryptResult;

    public static void main(String[] args) {
        String input = "is it caesar or shuffle encryption???";

        System.out.println(encrypt(input,5));
        System.out.println(decrypt(encryptResult, 5));
    }

    public static String encrypt(String input, int key) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char symbol : input.toCharArray()) {
            if (symbol != ' ') {
                symbol = (char) (symbol - key);
            }
            stringBuilder.append(symbol);
        }
        encryptResult = stringBuilder.toString();
        return encryptResult;
    }

    public static String decrypt(String input, int key) {
        return encrypt(input, -key);
    }
}