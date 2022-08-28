package Algorithm.niukewang;


import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class N_54 {

    Queue<Character> queue = new LinkedBlockingQueue<>();
    int [] chars = new int[128];

    //Insert one char from stringstream
    public  void Insert(char ch) {


        ++chars[ch - '\0'];

        if (chars[ch - '\0'] == 1){
            queue. offer(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {

        while(!queue.isEmpty() && chars[queue.peek() - '\0'] >= 2) {
            queue.poll();
        }

        if (queue.isEmpty()){
            return '#';
        }
        return queue.peek();
    }

    public static void main(String[] args) {

//        N_54 n_54 = new N_54();
//        n_54.Insert('a');

        System.out.println('A' - '\0');
    }
}
