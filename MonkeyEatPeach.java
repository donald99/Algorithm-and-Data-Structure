package com.algorithm;

public class MonkeyEatPeach {
	/**
     * 猴子吃桃问题
     * @param x 天数
     */
    public static int monkeyQue(int x) {

        if (x <= 0) {
            return 0;
        } else if (x == 1) {
            return 1;

        } else {
            return 2 * monkeyQue(x - 1) + 2;
        }
    }
}
