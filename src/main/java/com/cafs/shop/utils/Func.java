package com.cafs.shop.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.cafs.shop.base.DateFormatData;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @description 工具类
 */
public class Func {
    public Func(){}

    public static List<Long> toLongList(String str){
        return Arrays.asList(toLongArray(str));
    }

    public static Long[] toLongArray(String str){
        return toLongArray(",",str);
    }

    public static Long[] toLongArray(String split,String str){
        if (StringUtil.isEmpty(str)){
            return new Long[0];
        } else {
            String[] arr = str.split(split);
            Long[] longs = new Long[arr.length];

            for (int i = 0; i < arr.length; ++i) {
                Long v = toLong(arr[i], 0L);
                longs[i] = v;
            }
            return longs;
        }
    }

    public static long toLong(@Nullable final Object str, final long defaultValue) {
        if (str == null) {
            return defaultValue;
        } else {
            try {
                return Long.parseLong(String.valueOf(str));
            } catch (NumberFormatException var4) {
                return defaultValue;
            }
        }
    }

    public static boolean equals(Object obj1, Object obj2) {
        return Objects.equals(obj1, obj2);
    }

    public static String toStr(Object str) {
        return toStr(str, "");
    }

    public static String toStr(Object str, String defaultValue) {
        return null != str && !str.equals("null") ? String.valueOf(str) : defaultValue;
    }

    public static String[] toStrArray(String str) {
        return toStrArray(",", str);
    }

    public static String[] toStrArray(String split, String str) {
        return StringUtil.isBlank(str) ? new String[0] : str.split(split);
    }


    public static void formatSEDate(DateFormatData inData){
        if (ObjectUtil.isNotEmpty(inData.getStartDt())){
            inData.setStartDt(DateUtil.beginOfDay(DateUtil.parse(inData.getStartDt())).toString());
        }
        if (ObjectUtil.isNotEmpty(inData.getEndDt())){
            inData.setEndDt(DateUtil.endOfDay(DateUtil.parse(inData.getEndDt())).toString());
        }
    }

    public static boolean nullSafeEquals(@Nullable Object o1, @Nullable Object o2) {
        if (o1 == o2) {
            return true;
        } else if (o1 != null && o2 != null) {
            if (o1.equals(o2)) {
                return true;
            } else {
                return o1.getClass().isArray() && o2.getClass().isArray() ? arrayEquals(o1, o2) : false;
            }
        } else {
            return false;
        }
    }

    private static boolean arrayEquals(Object o1, Object o2) {
        if (o1 instanceof Object[] && o2 instanceof Object[]) {
            return Arrays.equals((Object[])((Object[])o1), (Object[])((Object[])o2));
        } else if (o1 instanceof boolean[] && o2 instanceof boolean[]) {
            return Arrays.equals((boolean[])((boolean[])o1), (boolean[])((boolean[])o2));
        } else if (o1 instanceof byte[] && o2 instanceof byte[]) {
            return Arrays.equals((byte[])((byte[])o1), (byte[])((byte[])o2));
        } else if (o1 instanceof char[] && o2 instanceof char[]) {
            return Arrays.equals((char[])((char[])o1), (char[])((char[])o2));
        } else if (o1 instanceof double[] && o2 instanceof double[]) {
            return Arrays.equals((double[])((double[])o1), (double[])((double[])o2));
        } else if (o1 instanceof float[] && o2 instanceof float[]) {
            return Arrays.equals((float[])((float[])o1), (float[])((float[])o2));
        } else if (o1 instanceof int[] && o2 instanceof int[]) {
            return Arrays.equals((int[])((int[])o1), (int[])((int[])o2));
        } else if (o1 instanceof long[] && o2 instanceof long[]) {
            return Arrays.equals((long[])((long[])o1), (long[])((long[])o2));
        } else {
            return o1 instanceof short[] && o2 instanceof short[] ? Arrays.equals((short[])((short[])o1), (short[])((short[])o2)) : false;
        }
    }
}
