import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        Set<String> uniqueGroups = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!sc.hasNext()) break;
            String name = sc.next();

            char firstChar = name.charAt(0);
            char lastChar = name.charAt(name.length() - 1);

            // Sort characters to identify anagrams
            char[] chars = name.toCharArray();
            Arrays.sort(chars);
            String sortedName = new String(chars);

            // Canonical key: uniquely identifies anagram group with same start/end char
            String key = firstChar + "#" + sortedName + "#" + lastChar;
            uniqueGroups.add(key);
        }

        System.out.println(uniqueGroups.size());
    }
}
