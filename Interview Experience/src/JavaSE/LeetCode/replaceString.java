package JavaSE.LeetCode;

public class replaceString {
    public static void main(String[] args) {
        String s = " We are happy.  ";
        String s1 = s.replaceAll(" ", "%20");
        System.out.println(s1);
        replaceString replaceString = new replaceString();
        StringBuffer stringBuffer = replaceString.replaceSpace(s);
        System.out.println(stringBuffer);
    }

    /*请实现一个函数，把字符串 s 中的每个空格替换成"%20"。



    示例 1：

    输入：s = "We are happy."
    输出："We%20are%20happy."*/

    public StringBuffer replaceSpace(String s) {
        StringBuffer stringBuffer = new StringBuffer(s);
        int j = 0;
        int count = 0;
        while (j < s.length()) {
            int i = s.indexOf(" ", j);
            if (i >= 0) {
                stringBuffer.replace(i+2*count, i+2*count + 1, "%20");
                count++;
                j = i + 1;
            }
            else break;
        }


        return stringBuffer;
    }




}
