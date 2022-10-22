package stack.concept;

import java.util.Map;
import java.util.Stack;

public class BalancedParetheses {

    public static void main(String[] args) {
        String s = "{}[]((()))";
        compute(s);
    }

    static public void compute(String s){

        Map<Character, Character> map = Map.of('{', '}', '[', ']', '(', ')');

        Stack<Character> stack = new Stack<>();
        Boolean result = null;
        for (char c : s.toCharArray()){
            if(map.keySet().contains(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    result = false;
                    break;
                }if(map.get(stack.peek()) == c){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }
        result = false;
        if (stack.isEmpty()){
            result = true;
        }

        System.out.println(result);
    }
}
