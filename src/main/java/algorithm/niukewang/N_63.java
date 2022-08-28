package algorithm.niukewang;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class N_63 {


    //存储大数据的小根堆（堆A）
    List<Integer> Max_heap = new ArrayList<>();
    //存储小数据的小根堆（堆B）
    List<Integer> Min_heap = new ArrayList<>();

    public int MaxHeap_min; //A堆的最小值
    public int MinHeap_Max; //B堆的最大值
    public static final int Max_Value = Integer.MAX_VALUE;

    public void Insert(Integer num) {

        //第一个数据进来存储在A堆，并且将A堆的最小值设置为第一个进来的数据
        if (Max_heap == null) {
            Max_heap.add(num);
            MaxHeap_min = num;
        } else {
            balanceTwoHeaps(num);
        }


    }

    /**
     * 新加入一个数之后，使得两个堆的长度之差不超过1
     * @param data
     */

    private void balanceTwoHeaps(int data) {
        //如果后来进入的数据大于A堆的最小值，则将这个数放在A堆
        if (data > MaxHeap_min) {
            Max_heap.add(data);
            //调整两个堆中数据的数目，使两个堆中数据的数目的绝对值小于等于1
            if (Math.abs(Max_heap.size() - Min_heap.size()) > 1) {
                //将大根堆的最小值取出来
                int x = MaxHeap_min;
                //移除大根堆的最小值
                Max_heap.remove(1);
                //将这个最小值加入到小根堆里面
                Min_heap.add(x);
                //同步大根堆的最小值
                MaxHeap_min = x;
            }
            //调整A堆为小根堆
            HeapSort(Max_heap);
            //如果后来进入的数据小于A堆的最小值，则将这个数放在B堆
        } else {
            Min_heap.add(data);
            //调整两个堆中数据的数目，直到两个堆中数据的数目的绝对值小于等于1
            if (Math.abs(Max_heap.size() - Min_heap.size()) > 1) {
                //将小根堆的最大值取出来
                int x = MinHeap_Max;
                //并将它移除
                Min_heap.remove(Min_heap.size() - 1);
                //将这个数添加到A堆
                Max_heap.add(x);
                //同步A堆的最小值
                MaxHeap_min = x;
                HeapSort(Max_heap);
            }
            //调整完之后，将B堆调整为小根堆
            HeapSort(Min_heap);
            //并且同步B堆的最大值
            MinHeap_Max = Min_heap.get(Min_heap.size() - 1);
        }
    }


    /**
     * 堆排序方法采用大根堆排序
     * 首先构建大根堆，使得根元素为最大的，
     * 堆排序时，将根元素与最后一个元素进行交换，再对前n-1个元素进行堆排序
     *
     * @param list
     * @return
     */
    private static List<Integer> buildMaxHeap(List<Integer> list) {
        if (list.size() <= 1)
            return list;
        for (int i = (list.size() - 2) / 2; i >= 0; i--)

        {
            adjust(list, i, list.size());
        }
        return list;
    }


    private static void adjust(List<Integer> list, int k, int length) {
        int tmp = list.get(k);
        for (int i = 2 * k + 1; i < length; i = 2 * i + 1) {
            if (i + 1 < length && list.get(i) < list.get(i + 1))
                i++;
            if (tmp > list.get(i)) {
                break;
            } else {
                list.set(k, list.get(i));
                k = i;
            }
        }
        list.set(k, tmp);
    }

    private static void HeapSort(List<Integer> list) {
        List<Integer> a = buildMaxHeap(list);
        for (int i = a.size() - 1; i >= 0; i--) {
            int tmp = a.get(0);
            a.set(0, a.get(i));
            a.set(i, tmp);
            adjust(a, 0, i);
        }
    }
    public int  GetMedian() {

        //如果两个堆中的数据数目相等，那么中位数就是A堆的最小值与B堆的最大值除以2
        if (Max_heap.size() == Min_heap.size()) {
            return (MaxHeap_min + MinHeap_Max) / 2;
            //如果A堆比B堆中数据的数目多，那么中位数就是A堆中的最小值
        } else if (Max_heap.size() > Min_heap.size()) {
            return MaxHeap_min;
            //如果B堆比A堆中数据的数目多，那么中位数就是B堆中的最大值
        } else
            return MinHeap_Max;

    }
}
