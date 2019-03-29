package com.ligz.offer;



/**
 * 字符流中第一个不重复的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * author:ligz
 */
public class FindFirstNoRepeat {
    String s = "";//必须为""，如果不设置空值，竟然为 null
    int[] str = new int[256];

    //Insert one char from stringstream
    public void Insert(char ch) {//用256个空间存储
        s += ch;
        str[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (int i = 0; i < s.length(); i++) {
            if (str[s.charAt(i)] == 1) return s.charAt(i);
        }
        return '#';
    }



/*    Map<Character, Integer> map = new LinkedHashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
        else map.put(ch, 1);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return '#';
    }*/
}
