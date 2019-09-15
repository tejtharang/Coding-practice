package DataStructuresGeneric.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        stack.push("Tej");
        stack.push("Tharang");
        System.out.println(stack.top());

    }
}
