import java.util.ArrayList;

public class ShuffleEncryption {

    public static String encryptResult;

    public static void main(String[] args) {
        String input = "is it caesar or shuffle encryption???";
        encryptResult = encrypt(input,4);
        System.out.println(encryptResult);
        System.out.println(decrypt(encryptResult, 4));
    }

    public static String encrypt(String input, int key) {
        int length = input.length();
        int columns = length / key;

        ArrayList<StringBuilder> stringBuilders = new ArrayList<>();
        for (int j = 0; j < key; j++) {
            stringBuilders.add(new StringBuilder());
        }

        StringBuilder s;
        for (int j = 0; j < length; j++) {
            s = stringBuilders.get(j % stringBuilders.size());
            s.append(input.charAt(j));
        }

        for (StringBuilder stringBuilder : stringBuilders) {
            if (stringBuilder.length() < columns + 1) {
                stringBuilder.append('_');
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder builder : stringBuilders) {
            stringBuilder.append(builder);
        }

        return stringBuilder.toString();
    }

    public static String decrypt(String input, int key) {
        int length = input.length();
        int columns = length / key;

        ArrayList<ArrayList<String>> stringBuilders = new ArrayList<>();
        for (int j = 0; j < columns; j++) {
            stringBuilders.add(new ArrayList<>());
        }

        ArrayList<String> collector = new ArrayList<>();
        for (char c : input.toCharArray()) {
            collector.add(String.valueOf(c));
        }

        ArrayList s;
        for (int j = 0; j < length; j++) {
            s = stringBuilders.get(j % columns);
            if (!collector.get(j).equals("_")) {
                s.add(collector.get(j));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringBuilders.size(); i++) {
            for (int j = 0; j < stringBuilders.get(i).size(); j++) {
                stringBuilder.append(stringBuilders.get(i).get(j));
            }

        }
        return stringBuilder.toString();
    }
}