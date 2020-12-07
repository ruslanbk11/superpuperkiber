import java.util.LinkedList;
import java.util.List;

public class ProbableWordHacker {

    public static void main(String[] args) {
        String input = "you will NEVER hack my string and read this, but if you do don't read this";

        System.out.println("Caesar Hack".toUpperCase());
        System.out.println(
                hackEncryptedByType(
                        CaesarEncryption.encrypt(input, 5),
                        "and",
                        10,
                        "caesar"
                )
        );

        System.out.println("Shuffle Hack".toUpperCase());
        System.out.println(
                hackEncryptedByType(
                        ShuffleEncryption.encrypt(input, 5),
                        "but",
                        10,
                        "shuffle"
                )
        );

        System.out.println("Vigener Hack".toUpperCase());
        System.out.println(
                hackEncryptedByType(
                        VigenerEncryption.encrypt(input, "key"),
                        "string",
                        3,
                        "vigener"
                )
        );
    }

    public static String hackEncryptedByType(String input, String probableWord, int maxKey, String type) {
        switch (type) {
            case "caesar":
                return hackCaesarEncryption(input, probableWord, maxKey);
            case "shuffle":
                return hackShuffleEncryption(input, probableWord, maxKey);
            case "vigener":
                return hackVigenerEncryption(input, probableWord, maxKey);
            default:
                return "choose type !!!";
        }
    }

    public static String hackCaesarEncryption(String input, String probableWord, int maxKey) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i <= maxKey; i++) {
            if (CaesarEncryption.decrypt(input, i).contains(probableWord)) {
                if (answer.length() == 0) {
                    answer.append(i);
                } else {
                    answer.append(", ").append(i);
                }
            }
        }
        String key = answer.toString();
        return key.length() == 0
                ? "¯\\_(ツ)_/¯"
                : "Key: " + key + "\n" +
                    "Result: " + CaesarEncryption.decrypt(input, Integer.parseInt(key));
    }

    public static String hackShuffleEncryption(String input, String probableWord, int maxKey) {
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= maxKey; i++) {
            if (ShuffleEncryption.decrypt(input, i).contains(probableWord)) {
                if (answer.length() == 0) {
                    answer.append(i);
                } else {
                    answer.append(", ").append(i);
                }
            }
        }
        String key = answer.toString();
        return key.length() == 0
                ? "¯\\_(ツ)_/¯"
                : "Key: " + key + "\n" +
                    "Result: " + ShuffleEncryption.decrypt(input, Integer.parseInt(key));
    }

    public static String hackVigenerEncryption(String input, String probableWord, int maxKeyLength) {
        StringBuilder answer = new StringBuilder();
        List<String> linkedList = new LinkedList<>();
        char[] chars = new char[maxKeyLength];
        for (int i = 0; i < maxKeyLength; i++) {
            chars[i] = 'A';
        }
        combinate(chars, linkedList, maxKeyLength);

        for (String maybeKey : linkedList) {
            if (VigenerEncryption.decrypt(input, maybeKey).contains(probableWord)) {
                if (answer.length() == 0) {
                    answer.append(maybeKey);
                } else {
                    answer.append(", ").append(maybeKey);
                }
            }
        }

        String key = answer.toString();
        StringBuilder finalAnswer = new StringBuilder();
        finalAnswer.append("Probable keys: " + key + "\n");

        for (String s : key.split(", ")) {
            finalAnswer.append("Key: " + s + "\n" + "Result: " + VigenerEncryption.decrypt(input, s) + "\n");
        }
        String finalFinalAnswer = finalAnswer.toString();
        return finalFinalAnswer.length() == 0
                ? "¯\\_(ツ)_/¯"
                : finalFinalAnswer;
    }

    private static void combinate(char[] chars, List<String> list, int maxKeyLength) {
        if (maxKeyLength == 1) {
            for (int i = 0; i < 58; i++) {
                list.add(new String(chars));
                chars[chars.length - maxKeyLength]++;
            }
            chars[chars.length - maxKeyLength] = 'A';
        } else {
            for (int i = 0; i < 58; i++) {
                combinate(chars, list, maxKeyLength - 1);
                chars[chars.length - maxKeyLength]++;
            }
            chars[chars.length - maxKeyLength] = 'A';
        }
    }

}