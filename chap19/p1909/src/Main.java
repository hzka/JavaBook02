public class Main {

    public static void main(String[] args) {
        GenriStack <String> stack1 = new GenriStack<>();
        GenriStack<Object> stack2 = new GenriStack<>();
        stack2.push("Java");
        stack2.push(2);
        stack1.push("Sun");
        add(stack1,stack2);
    }

    private static <T> void add(GenriStack<T> stack1, GenriStack<? super T> stack2) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
