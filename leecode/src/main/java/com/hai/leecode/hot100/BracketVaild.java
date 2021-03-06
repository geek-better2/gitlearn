package com.hai.leecode.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/** leecode 20 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 //
 // 有效字符串需满足：
 //
 //
 // 左括号必须用相同类型的右括号闭合。
 // 左括号必须以正确的顺序闭合。
 //
 //
 // 注意空字符串可被认为是有效字符串。
 //
 // 示例 1:
 //
 // 输入: "()"
 //输出: true
 //
 //
 // 示例 2:
 //
 // 输入: "()[]{}"
 //输出: true
 //
 //
 // 示例 3:
 //
 // 输入: "(]"
 //输出: false
 //
 //
 // 示例 4:
 //
 // 输入: "([)]"
 //输出: false
 //
 //
 // 示例 5:
 //
 // 输入: "{[]}"
 //输出: true
 // Related Topics 栈 字符串
 * @author hai
 * @date 2020-05-14 16:17
 */
public class BracketVaild {
    private Map<Character,Character> map;

    BracketVaild(){
        this.map = new HashMap<>();
        this.map.put('}','{');
        this.map.put(')','(');
        this.map.put(']','[');
    }

    public boolean isVaild(String s){
        if(s.length() % 2 == 1 )return false;
        Stack<Character> stack = new Stack<>();
        for (Character a : s.toCharArray()) {

            if(this.map.containsKey(a)) {
                Character c = stack.empty() ? '#' : stack.pop();
                if (c != this.map.get(a)) {
                    return false;
                }
            }else {
                stack.push(a);
            }
        }
        return stack.empty();
    }


    public static void main(String[] args) {
        String s = "{}}[]()";
        BracketVaild instance = new BracketVaild();
        boolean res = instance.isVaild(s);
        System.out.println(res);
    }
}
