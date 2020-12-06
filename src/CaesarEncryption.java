public class CaesarEncryption {

    private static String encryptResult;

    public static void main(String[] args) {
        String input = "is it caesar or shuffle encryption???";
        encrypt(input,5);
        decrypt(encryptResult, 5);
    }

    public static void encrypt(String input, int key) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char symbol : input.toCharArray()) {
            if (symbol != ' ') {
                symbol = (char) (symbol - key);
            }
            stringBuilder.append(symbol);
        }
        encryptResult = stringBuilder.toString();
        System.out.println(encryptResult);
    }

    public static void decrypt(String input, int key) {
        encrypt(input, -key);
    }
}