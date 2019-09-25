package com.hjy.LearnStudy.JavaStudy.SomeInterviewProblem;

/**
 * @author huangjunyan
 * @date 2019-07-10 17:29
 */
public class TransferNumberToChinese {
    public static void main(String[] args) {
        System.out.println(transferNumberToChinese(-101));
    }
    public static String transferNumberToChinese(int number) {
        String[] numArr = new String[]{"零","一","二","三","四","五","六","七","八","九"};
        String[] digArr = new String[]{"","十","百","千","万"};
        char[] numCharArr;
        if(number<0) {
            numCharArr = String.valueOf(number).substring(1).toCharArray();
        }
        else numCharArr = String.valueOf(number).toCharArray();
        System.out.println(numCharArr);
        StringBuilder res = new StringBuilder();
        int length = numCharArr.length;
        for(int i = 0;i < length;i++) {
            int temp = Integer.parseInt(String.valueOf(numCharArr[i]));
            boolean isZero = temp == 0 ? true : false;
            if(isZero) {
                while(i < length - 1 && numCharArr[i+1]=='0') {
                    i++;
                }
                if(i != length - 1) {
                    res.append(numArr[0]);
                }
            }else {
                res.append(numArr[temp]);
                res.append(digArr[length - i - 1]);
            }
        }
        if(number < 0) return "负"+res.toString();
        return res.toString();
    }
}
