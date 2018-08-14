package other;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/3/2.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String result = trans(input);
            System.out.println(result);
        }
        sc.close();
    }

    private static String[] myDictionary = new String[]{"F", "G", "R", "S", "T", "L", "M", "N", "O", "P", "Q",
            "W", "X", "Y", "Z", "U", "A", "G", "H", "I", "J", "K",
            "B", "C", "D", "E", "l", "m", "n", "o", "p", "i", "j", "k", "f", "g", "h",
            "a", "b", "c", "d", "e", "q", "r", "w", "x", "y", "z", "s", "t", "u", "v"};

    private static String trans(String input) {
        if (input == null || input.length() == 0)
            return "ERROR";

        char[] charArray = input.toCharArray();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '#')
                count++;
            if (charArray[i] != '#' && charArray[i] != '.' && charArray[i] != '-')
                return "ERROR";
        }
        String nothing = "";
        if (count == charArray.length)
            return nothing;

        StringBuilder sb = new StringBuilder();
        String[] split = input.split("#");
        for (int i = 0; i < split.length; i++) {
            if (!split[i].equals("") && !split[i].equals(" ")) {
                String back = binaryTrans(split[i]);
                if (back.equals("ERROR"))
                    return back;
                sb.append(back);
            }
        }
        return sb.toString();
    }

    private static String binaryTrans(String str) {
        StringBuilder sb = new StringBuilder();
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            sb.append(cs[i] == '.' ? "1" : "0");
        }
        int num = Integer.valueOf(sb.toString(), 2);
        if (num >= 0 && num <= 51)
            return myDictionary[num];
        return "ERROR";
    }

}