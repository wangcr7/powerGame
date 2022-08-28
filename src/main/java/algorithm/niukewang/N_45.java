package algorithm.niukewang;

/**
 *
 *
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 必须满足的条件：
 * 1、除 0 以外没有重复数字
 * 2、最大值 - 最小值 < 5
 */
public class N_45 {

    public boolean isContinuous(int [] numbers) {

        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;

        for (int num: numbers) {

            if (num == 0){
                continue;
            }
            max = Math.max(num, max);
            min = Math.min(num, min);

            if (repeat.contains(num)){
                return false;
            }
            repeat.add(num);
        }

        return max - min < 5;
    }

    public boolean isStraight(int[] nums) {

        int joker = 0;

        Arrays.sort(nums);

        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) joker++;
            else if (nums[i] == nums[i+1]) return false;
        }

        return nums[4]- joker < 5;
    }


}
