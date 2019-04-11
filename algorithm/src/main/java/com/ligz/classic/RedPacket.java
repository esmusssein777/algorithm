package com.ligz.classic;

import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.List;


/**
 * Function: 模拟微信红包生成，以分为单位
 * author:ligz
 */
public class RedPacket {
    private final static int MAX_MONEY = 200 * 100;//最大的红包是 200 元，单位是分

    private final static int MIN_MONEY = 1;//最小的红包是 1 分

    private final static int LESS = -1;//小于最小值

    private final static int MORE = -2;//大于最大值

    private final static int SUCCESS = 1;//正常红包值

    private final static double TIMES = 2.0f;//最大的红包不能大于平均值的 2 倍

    private int sum = 0;//重新计算的次数

    /**
     * 发红包
     * @param money 总金额
     * @param count 红包个数
     * @return
     */
    public List<Integer> splitRedPacket(int money, int count) {
        List<Integer> packet = new LinkedList<>();
        if (MAX_MONEY * count < money) {
            System.err.println("最大的红包值不能超过200");
            return packet;
        }

        //计算出最大的红包金额
        int max = (int) ((money / count) * TIMES);
        max = max > MAX_MONEY ? MAX_MONEY : max;

        //随机发红包
        for (int i = 0; i < count; i++) {
            int number = randomPacket(money, MIN_MONEY, max, count - i);
            money -= number;
            packet.add(number);
        }
        return packet;
    }

    /**
     * 随机生成红包数额
     * @param total 剩下的金额
     * @param min 最小值
     * @param max 最大值
     * @param count 剩下的红包个数
     * @return
     */
    private int randomPacket(int total, int min, int max, int count) {
        if (count == 1) return total;//剩下一个红包就全部返回
        if (min == max) return min;

        max = max > total ? total : max;//如果总金额数足够多，则最大的数是总的金额取随机数，如果不够多，那么取 max

        int number = (int) (Math.random() * (max - min) + min);//计算随机数作为红包

        int lastNumber = total - number;//剩下的钱

        int status = check(lastNumber, count);//计算剩下的钱平均值是否正常

        if (status == SUCCESS) return number;
        if (status == LESS) {
            sum++;
            System.out.println("sum == " + sum);
            return randomPacket(total, min, number, count);
        }
        if (status == MORE) {
            sum++;
            System.out.println("sum == " + sum);
            return randomPacket(total, number, max, count);
        }
        return number;
    }

    /**
     * 计算剩下的钱平均值是否正常
     * @param lastNumber
     * @param count
     * @return
     */
    private int check(int lastNumber, int count) {
        double avg = lastNumber / count;
        if (avg < MIN_MONEY) return LESS;
        if (avg > MAX_MONEY) return MORE;
        return SUCCESS;
    }

}
