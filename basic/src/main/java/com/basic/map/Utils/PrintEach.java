package com.basic.map.Utils;

import java.util.*;

/**
 * ClassName: PrintEach <br/>
 * Description: 打印Map工具类,自用<br/>
 * date: 2020/7/8 14:24<br/>
 *
 * @author zwk<br />
 */
public class PrintEach {

    private static final int DEFAULT_CAP = 0;

    /**
     * 检查参数
     * @param map
     * @throws Exception
     */
    private static void checkParam(Map<Object,Object> map) throws Exception{
        if (map == null || map.size() <= 0) {
            throw new RuntimeException("入参Map数组不可以为空");
        }
    }
    /**
     * lamda表达式循环
     * @param map
     */
    public static void print(Map<Object,Object> map) {

        try {
            checkParam(map);
            map.entrySet().stream().forEach( x-> {
                System.out.println("key is :" + x.getKey() + ",value is :" + x.getValue());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * foreach循环遍历Map
     */
    public static void printEach(Map<Object,Object> map) {

        try {
            checkParam(map);
            for (Map.Entry<Object, Object> next : map.entrySet()) {
                System.out.println("key is :" + next.getKey() + ",value is :" + next.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Iterator遍历map
     * @param map
     */
    public static void printIteator(Map<Object,Object> map) {

        try {
            checkParam(map);
            Iterator<Map.Entry<Object, Object>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Object, Object> next = iterator.next();
                System.out.println("key is :" + next.getKey() + ",value is :" + next.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *打印map的第一个
     */
    public static void printFirst (Map<Object,Object> map) {
        try {
            checkParam(map);
            Map.Entry<Object, Object> next = map.entrySet().stream().findFirst().get();
            System.out.println("key is :" + next.getKey() + ",value is :" + next.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 间隔打印
     * @param cap 间隔数
     */
    public static void printByArr (Map<Object,Object> map,int cap) {
        if (cap < 0 || cap > map.size()) throw new RuntimeException("间隔参数错误");
        try {
            checkParam(map);
            int count = 0;
            List<Object> temp = new ArrayList<Object>();

            for (Map.Entry<Object, Object> next : map.entrySet()) {
                temp.add("{key:" + next.getKey() + ",value:" + next.getValue() + "}");
                count++;
                if (cap == count) {
                    temp.stream().forEach(x -> {
                        System.out.print(x);
                    });
                    count = 0;
                    temp.clear();
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("1","aaa");
        map.put("2","bbb");
        map.put("3","ccc");
        map.put("4","aaa");
        map.put("5","bbb");
        map.put("6","ccc");
        map.put("7","aaa");
        map.put("8","bbb");
        map.put("9","ccc");

        PrintEach.printByArr(map,3);

    }

}
