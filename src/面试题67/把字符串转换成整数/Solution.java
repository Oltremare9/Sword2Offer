package 面试题67.把字符串转换成整数;

class Solution {
    public int strToInt(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        char chars[] = str.toCharArray();
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == ' ') {
                i++;
                continue;
            }
            if ((chars[i] >= '0' && chars[i] <= '9') || chars[i] == '-' || chars[i] == '+') {
                //负号
                if (chars[i] == '-' || chars[i] == '+') {
                    //已经到了最后一个
                    if (i == chars.length - 1)
                        break;
                        //若后面不是有效数字
                    else if (chars[i + 1] < '0' || chars[i + 1] > '9') {
                        break;
                    }
                }
                //负号 或后面有有效数字 尽可能多的囊括进来
                stringBuffer.append(chars[i++]);
                while (i < chars.length && (chars[i] >= '0' && chars[i] <= '9')) {
                    stringBuffer.append(chars[i++]);
                }
                //已经获取到尽可能多的数据了
                boolean isNegative = false;
                char temp[] = stringBuffer.toString().toCharArray();
                int begin = 0;
                if (temp[0] == '-') {
                    isNegative = true;
                    begin++;
                }
                if (temp[0] == '+') {
                    isNegative = false;
                    begin++;
                }
                int index = temp.length - 1;
                long res = 0;
                int times = 0;
                while (index >= begin) {
                    res += Math.pow(10, times++) * (temp[index] - 48);
                    if (isNegative && res > ((long) Integer.MAX_VALUE + 1))
                        return Integer.MIN_VALUE;
                    else if (!isNegative && res > Integer.MAX_VALUE)
                        return Integer.MAX_VALUE;
                    index--;
                }
                if (isNegative)
                    return (int) -res;
                else return (int) res;

            } else
                return 0;
        }
        return 0;
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.strToInt("9223372036854775808"));
    }
}