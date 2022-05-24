import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("Введите строку букв для первого задания");
        String countChar = new Scanner(System.in).next();
        System.out.println("Введите строку со скобками для второго задания");
        String validate = new Scanner(System.in).next();
        countChar(countChar);
        isValidValue(validate);
    }

    public static void countChar(String text) {
        if (text == null || text == "") {
            System.out.println("Пришла пустая строка");
            return;
        }
        int count = 1;
        String result = "";
        char[] charMass = text.toCharArray();
        char startChar;
        char endChar = charMass[charMass.length - 1];
        for (int i = 0; i <= charMass.length - 1; i++) {
            if (i == charMass.length - 1) {
                if (endChar == charMass[i]) {
                    result = result + count + endChar;
                    break;
                }
            }
            startChar = charMass[i];
            if (startChar == charMass[i + 1]) {
                count++;
            } else {
                result = result + count + startChar;
                count = 1;
            }
        }
        System.out.println(result.replace("1", ""));
    }

    public static void isValidValue(String text) {
        if (text == null || text == "") {
            System.out.println("Пришла пустая строка");
            return;
        }

        Map<Character, Character> template = new HashMap<>();
        template.put(')', '(');
        template.put('}', '{');
        template.put(']', '[');
        template.put('>', '<');

        Deque<Character> stack = new LinkedList<>();
        for (char c : text.toCharArray()) {
            if (template.containsValue(c)) {
                stack.push(c);
            } else if (template.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != template.get(c)) {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(stack.isEmpty());
    }
}
