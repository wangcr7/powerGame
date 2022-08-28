package algorithm.niukewang;

import java.util.Stack;

/**
 * @program: CristianoRonaldo
 * @description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 *
 *
 * 应用一个辅助栈，压的时候，如果压入的元素比B栈栈顶元素大，B栈不压。小于等于，AB栈同时压入，
 * 出栈，如果，AB栈顶元素不等，A出，B不出。如果相等，两个栈都出
 * @author: wang chi
 * @create: 2020-06-22 11:44
 */
public class N_020_1 {

    Stack<Integer> stack1 = new Stack();
    Stack<Integer> stack2 = new Stack();

    public void push(int node) {

        stack1.push(node);
        if (stack2.empty() ){
            stack2.push(node);
        } else if (node <= stack2.peek()) {
            stack2.push(node);
        }
    }

    public void pop() {
        if (stack1.peek() == stack2.peek()){
            stack2.pop();
        }
        stack1.pop();
    }

    public int top() {

        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }

}
