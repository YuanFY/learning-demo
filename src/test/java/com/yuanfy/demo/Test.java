package com.yuanfy.demo;

/**
 * @author maple.yuan
 * @date 2020-07-25 11:29
 */
public class Test {

    public static void main(String[] args) {

        String firstNumStr = "1234";
        String secondNumStr = "1234";

        System.out.println(multi(firstNumStr, secondNumStr));

    }

    /**
     * 计算乘积， 思路：
     * 1、从后往前遍历，第一个字符串的每一位都与第二个字符串的每一个字符相乘；
     * 2、然后累加第一步的结果。
     * @param firstNumStr
     * @param secondNumStr
     * @return
     */
    private static String multi(String firstNumStr, String secondNumStr) {
        String rstStr = "0";
        for (int i = firstNumStr.length()-1; i >= 0; i --) {
            // 初始化每一位数值
            String subRstStr = "0";
            for (int j = secondNumStr.length()-1; j >= 0; j --) {
                // 简单相乘
                int multiRst = multi(secondNumStr.charAt(j), firstNumStr.charAt(i));
                // 将上一步结果需要进行补位0
                subRstStr = add(subRstStr, String.valueOf(multiRst), secondNumStr.length()-1-j);
            }
            // 累加每一位的乘积
            rstStr = add(rstStr, subRstStr, firstNumStr.length()-1-i);
        }
        return rstStr;
    }

    /**
     * 两个字符串相加
     * @param firstNumStr
     * @param secondNumStr
     * @param index 表示第二个字符串需要往后面补位多少个0
     * @return
     */
    private static String add(String firstNumStr, String secondNumStr, int index) {

        // 补0操作
        secondNumStr = append(secondNumStr, index);
        StringBuilder rstBuilder = new StringBuilder(secondNumStr.length());

        int firstLen = firstNumStr.length() - 1;
        int secondLen = secondNumStr.length() - 1;
        // 两者累加结果与10的商
        int prefix = 0;
        while (firstLen > -1 && secondLen > -1) {
            int addRst = add(firstNumStr.charAt(firstLen), secondNumStr.charAt(secondLen), prefix);
            // 取余数存储
            rstBuilder.append(addRst % 10);
            // 取商
            prefix = addRst / 10;

            firstLen = firstLen - 1;
            secondLen = secondLen - 1;
        }

        // 将商与剩下的继续相加
        prefix = add(firstNumStr, rstBuilder, firstLen, prefix);

        // 将商与剩下的继续相加
        prefix = add(secondNumStr, rstBuilder, secondLen, prefix);

        if (prefix > 0) {
            rstBuilder.append(prefix);
        }

        // 去掉前面的0操作
        return filterPrefixZero(rstBuilder);
    }

    private static String filterPrefixZero(StringBuilder rstBuilder) {
        StringBuilder finalRstBuilder = new StringBuilder(rstBuilder.length());
        String rstStr = rstBuilder.reverse().toString();
        boolean isZeroFlag = true;
        for (int i = 0; i < rstStr.length(); i ++) {
            if (rstStr.charAt(i) == '0' && isZeroFlag) {
                continue;
            }
            isZeroFlag = false;
            finalRstBuilder.append(rstStr.charAt(i));
        }
        if (finalRstBuilder.length() == 0) {
            return "0";
        }
        return finalRstBuilder.toString();
    }

    private static int add(String numStr, StringBuilder rstBuilder, int len, int prefix) {
        for (int i = len; i > -1; i--) {
            int addRst = add(numStr.charAt(i), prefix);
            prefix = addRst / 10;
            rstBuilder.append(addRst % 10);
        }
        return prefix;
    }

    /**
     * 补0操作
     */
    private static String append(String numStr, int index) {
        StringBuilder rstBuilder = new StringBuilder(numStr.length() + index);
        rstBuilder.append(numStr);
        for (int i = 0; i < index; i ++) {
            rstBuilder.append("0");
        }
        return rstBuilder.toString();
    }

    private static int multi(char firstNum, char secondNum) {
        return Integer.parseInt(String.valueOf(firstNum)) * Integer.parseInt(String.valueOf(secondNum));
    }

    private static int add(char firstNum, char secondNum, int prefix) {
        return Integer.parseInt(String.valueOf(firstNum)) + Integer.parseInt(String.valueOf(secondNum)) + prefix;
    }

    private static int add(char num, int prefix) {
        return Integer.parseInt(String.valueOf(num)) + prefix;
    }

    @org.junit.Test
    public void test1() {
        System.out.println(multiply("1234", "0"));
    }
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }
}
