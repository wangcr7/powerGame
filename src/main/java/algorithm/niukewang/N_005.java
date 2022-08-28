package algorithm.niukewang;

import java.util.Stack;

/**
 * @program: CristianoRonaldo
 * @description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author: wang chi
 * @create: 2020-06-17 18:53
 */
public class N_005 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        if (stack2.size() <= 0){
            while (stack1.size() != 0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {

        N_005 n_005 = new N_005();
        n_005.push(1);
        n_005.push(2);
        n_005.push(3);
        System.out.println(n_005.pop());
        System.out.println(n_005.pop());
        n_005.push(4);
        System.out.println(n_005.pop());
        n_005.push(5);
        System.out.println(n_005.pop());
        System.out.println(n_005.pop());
    }
}
