import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Java Source file:");
        String filename = input.nextLine();
        File file = new File(filename);
        if (file.exists()) {
            System.out.println(countKeywords(file));
        } else {
            System.out.println("File " + filename + " not exists");
        }
    }

    private static int countKeywords(File file) throws Exception {
        String[] keywords = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum", "extends", "for", "final", "finally", "float", "goto", "if",
                "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected",
                "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws",
                "transient", "try", "void", "volatile", "while", "true", "false", "null"};
        System.out.println(keywords.length);
        Set<String> keywordset = new HashSet<>(Arrays.asList(keywords));
        int count = 0;
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String word = input.next();
            if (keywordset.contains(word)) {
                System.out.print("  " + word);
                count++;
            }
        }
        System.out.println();
        return count;
    }
}
