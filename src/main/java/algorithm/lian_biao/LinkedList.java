package algorithm.lian_biao;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-06-15 16:10
 */
public class LinkedList {

    public static Node first;
    public static Node tail;

    /**
     * 正向输出
     */
    static void OutLinkZheng(Node ll){

        Node current;
        for (current = ll; current!=null; current = current.next){
            System.out.print(current.date + "t");
        }
    }
    static void OutLinkZheng1(Node ll){
        if (ll == null){
            return;
        } else {
            System.out.println(ll.date);
            OutLinkZheng1(ll.next);
        }
    }

    /**
     * 逆向输出
     * @param
     */
    static void OutLink(Node ll){
        Node current,Pend = null;
        while (Pend != ll){
            for (current = ll;current.next != Pend;current = current.next);
            System.out.println(current.date);
            Pend = current;
        }
    }
    static void OutLink1(Node ll){
        if (ll == null){
            return;
        } else {
            OutLink1(ll.next);
            System.out.println(ll.date);
        }
    }

    /**
     * 返回链表节点的个数
     */
    static int sum(Node ll){
        if (ll == null){
            return 0;
        } else {
            return sum(ll.next) + 1;
        }
    }
    static int sum1(Node ll){
        int i = 0;
        Node current;
        for (current = first;current!=null;i++,current = current.next);
        return i;
    }


    /**
     * 返回奇数节点的个数
     */
    static int sum_jishu(Node ll){
        if (ll == null){
            return 0;
        } else {
            return sum_jishu(ll.next) + ll.date%2;
        }
    }
    static int sum_jishu1(Node ll){
        int i = 0;
        Node current;
        for(current = first;current!=null;current = current.next){
            i += current.date%2;
        }
        return i;
    }

    /**
     * 链表最大值
     */
    static int Max(Node ll){
        int max;
        if (ll.next == null){
            return ll.date;
        } else {
            max = Max(ll.next);
            if (max < ll.date){
                max = ll.date;
            }
            return max;
        }
    }
    static int Max1(Node ll){
        if (ll.next == null){
            return ll.date;
        } else {
            return ll.date > Max1(ll.next) ? ll.date : Max1(ll.next);
        }
    }

    /**
     * 删除节点
     */
    static void delValue(long value){
        Node current,previous = first;
        for (current = first;current!= null && current.date!= value;previous = current,current = current.next);
        if (current == null){
            return;
        } else if (current == first){
            first = first.next;
        } else {
            previous.next = current.next;
        }
    }

    /**
     * 删除链表中奇数节点
     */
    static void delValue_jishu(){
        Node prevoius = null,current = first;
        while (current != null){
            if (current.date % 2 == 1){
                if (current == first){
                    first = first.next;
                    current = first;
                } else {
                    prevoius.next = current.next;
                    current = prevoius.next;
                }
            } else {
                prevoius = current;
                current = current.next;
            }
        }
    }

    /**
     * 创建链表，升序有序
     */
        static void GreateLink(int[] arr){

        Node node = new Node(arr[0]);
        node.next = null;
        first = node;
        Node current,previous = first;
        for (int i = 1;i<arr.length;i++){
            node = new Node(arr[i]);
            node.next = null;
            for (current = first;current != null && current.date<arr[i];previous = current,current = current.next);
            if (current == first){
                node.next = first;
                first = node;
            } else if (current == null){
                previous.next = node;
            } else {
                node.next = current;
                previous.next = node;
            }
        }
    }

    /**
     * 删除链表中指定节点
     */
    public void deleteNode(int value){

        for (Node i = first;i.next != null;i = i.next){
            Node current;
            Node previous = first;
            for (current = first;current != null && current.date != value;previous = current,current = current.next);
            if (current == first){
                return;
            } else if (current == null){
                previous.next = null;
            } else {
                previous.next = current.next;
            }
        }
    }

    /**
     * 删除一个链表中的最大值
     */
    public void deleteMax (){
        Node pre = null,current;
        Node preMax = null,max;
        max = pre = first;
        for (current = first.next;current!=null;pre = current,current = current.next){
            if (current.date > max.date){
                max = current;
                preMax = pre;
            }
        }
        if (max == first){
            first = first.next;
        } else {
            preMax.next = max.next;
        }
    }

    /**
     * 数据域的值重复并且升序有序，删除链表中重复值节点
     */
    public void deleteNode(){
        Node i = first;
        Node j;
        while (i != null){
            for (j = i.next;j.next != null && j.date == i.date;j = j.next);
            if (j.next == null){
                return;
            } else if (i.next == j){
                i = j;
            } else {
                i.next = j;
                i = i.next;
            }
        }
    }

    /**
     * 将一个非空单向链表i拟置
     * 原链表改变方向就是产生一个新的链表
     */
    public void preLink(){
        Node p = first,h = first,hn = null;
        while (h != null){
            /**
             * 头删
             */
            h = h.next;
            /**
             * 头插
             */
            p.next = hn;
            hn = p;

            p = h;
        }
    }

    /**
     * 将一个链表中的所有奇数节点 移动 到偶数节点之后
     */
    public void moveOdd (){
        Node hn = null,h = first;
        Node current = first,previous = null,t;
        while (current != null){
            if (current.date % 2 == 1){
                if (current == first){
                    h = h.next;
                    current.next = hn;
                    hn = current;
                    current = h;
                } else {
                    previous.next = current.next;
                    current.next = hn;
                    hn = current;
                    current = previous.next;
                }
            } else {
                previous = current;
                current = previous.next;
            }
        }
        for (t = hn;t != null && t.next != null;t = t.next);
        if (t == null){
            first = h;
        } else {
            t.next = h;
            first = hn;
        }
    }

    /**
     *  求链表中的交点
     */
    public static Node A1(LianBiao lianBiao1, LianBiao lianBiao2){
        Node p1,p2,p;
        int cnt = 0,a;
        for (p1 = lianBiao1.first;p1 != null;cnt++,p1 = p1.next);
        for (p2 = lianBiao2.first;p2 != null;cnt--,p2 = p2.next);
        p1 = lianBiao1.first;
        p2 = lianBiao2.first;
        a = cnt;
        if (a > 0){
            p = lianBiao1.first;
        } else {
            cnt = -cnt;
            p = lianBiao2.first;
        }
        while (cnt != 0){
            p = p.next;
            cnt--;
        }
        if (a > 0){
            p1 = p;
        } else {
            p2 = p;
        }
        for (;p1 != p2;p1 = p1.next,p2 = p2.next);
        return p1;
    }
    public static Node A2(LianBiao lianBiao1, LianBiao lianBiao2){
        Node p1,p2;
        int cnt = 0;
        for (p1 = lianBiao1.first;p1 != null;cnt++,p1 = p1.next);
        for (p2 = lianBiao2.first;p2 != null;cnt--,p2 = p2.next);

        p1 = lianBiao1.first;
        p2 = lianBiao2.first;
        if (cnt < 0){
            p1 = lianBiao2.first;
            p2 = lianBiao1.first;
            cnt = -cnt;
        }
        while (cnt != 0){
            p1 = p1.next;
            cnt--;
        }
        for (;p1 != p2;p1 = p1.next,p2 = p2.next);
        return p1;
    }

    public static Node B1(LianBiao lianBiao1, LianBiao lianBiao2){
        Node Pend = null;
        Node p1 = lianBiao1.first,p2 = lianBiao2.first;
        while (p1 != p2){
            for (p1 = lianBiao1.first;p1.next != Pend;p1 = p1.next);
            for (p2 = lianBiao2.first;p2.next != Pend;p2 = p2.next);
            Pend = p1;
        }
        return p1.next;
    }

    public static Node B2(LianBiao lianBiao1, LianBiao lianBiao2){
        Node Pend = null;
        Node p1,p2;
        while (true){
            for (p1 = lianBiao1.first;p1.next != Pend;p1 = p1.next);
            for (p2 = lianBiao2.first;p2.next != Pend;p2 = p2.next);
            if (p1 != p2){
                break;
            }
            Pend = p1;
        }
        return p1.next;
    }



    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Node node = new Node(i);
            if (first == null){
                first = node;
                tail = first;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }
        System.out.println(tail.date);
//        OutLink1(first);
//        System.out.println(Max1(first));
    }
}
