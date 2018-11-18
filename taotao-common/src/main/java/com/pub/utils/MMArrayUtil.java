package com.pub.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Array类型工具类
 * 
 * @since 6.3
 * @version 2012-8-31 上午08:42:53
 * @author lixdh
 */
public class MMArrayUtil {

    /**
     * 判断数组是否为空
     * 
     * @param objs
     * @return
     */
    public static boolean isEmpty(Object[] objs) {
        return null == objs || objs.length == 0;
    }

    /**
     * 判断数组是否为非空
     * 
     * @param objs
     * @return
     */
    public static boolean isNotEmpty(Object[] objs) {
        return null != objs && objs.length > 0;
    }

    /**
     * 判断数组是否包含空元素
     * 
     * @param objs
     * @return
     */
    public static boolean isContainNull(Object[] objs) {
        if (MMArrayUtil.isEmpty(objs)) {
            return true;
        }
        for (Object obj : objs) {
            if (null == obj) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断数组是否不包含空元素
     * 
     * @param objs
     * @return
     */
    public static boolean isNotContainNull(Object[] objs) {
        if (MMArrayUtil.isEmpty(objs)) {
            return false;
        }
        for (Object obj : objs) {
            if (null == obj) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断两个数组长度是否相等
     * 
     * @param objs1
     * @param objs2
     * @return
     */
    public static boolean isLengthEqual(Object[] objs1, Object[] objs2) {

        if (MMArrayUtil.isEmpty(objs1) && MMArrayUtil.isEmpty(objs2)) {
            return true;
        }
        else if (MMArrayUtil.isNotEmpty(objs1) && MMArrayUtil.isNotEmpty(objs2) && objs1.length == objs2.length) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 合并多个数组
     * 
     * @param <T>
     * @param objs
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] combineArray(T[]... objs) {
        if (null == objs) {
            return null;
        }
        int length = 0;
        int count = 0;
        T[] result = null;
        for (T[] array : objs) {
            if (MMArrayUtil.isEmpty(array)) {
                continue;
            }
            if (null == result) {
                result = array;
            }
            count++;
            length += array.length;
        }
        if (length == 0 || count == 1 || null == result) {
            return result;
        }
        result = (T[]) Array.newInstance(result[0].getClass(), length);
        int destPos = 0;
        for (Object[] array : objs) {
            if (MMArrayUtil.isEmpty(array)) {
                continue;
            }
            System.arraycopy(array, 0, result, destPos, array.length);
            destPos += array.length;
        }
        return result;
    }

    /**
     * 去掉数组中的空元素
     * 
     * @param <T>
     * @param objs
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] removeNull(T[] objs, Class<T> clazz) {
        if (MMArrayUtil.isEmpty(objs)) {
            return null;
        }
        List<T> tempList = new ArrayList<T>();
        for (T temp : tempList) {
            if (null == temp) {
                continue;
            }
            tempList.add(temp);
        }
        T[] result = (T[]) Array.newInstance(clazz, tempList.size());
        tempList.toArray(result);
        return result;
    }

    /**
     * Object转换成数组T[]
     * 
     * @param <T>
     * @param obj
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(T obj) {
        T[] array = null;
        if (obj.getClass().isArray()) {
            Object[] objs = (Object[]) obj;
            array = (T[]) Array.newInstance(objs[0].getClass(), objs.length);
            for (int i = 0; i < objs.length; i++) {
                array[i] = (T) objs[i];
            }
        }
        else {
            array = (T[]) Array.newInstance(obj.getClass(), 1);
            array[0] = obj;
        }
        return array;
    }

    /**
     * Object[]转换成数组T[]
     * 
     * @param <T>
     * @param objs
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(Object[] objs) {
        if (MMArrayUtil.isEmpty(objs)) {
            return null;
        }
        T[] result = (T[]) Array.newInstance(objs[0].getClass(), objs.length);
        if (result.getClass().isAssignableFrom(objs.getClass())) {
            return (T[]) objs;
        }
        System.arraycopy(objs, 0, result, 0, objs.length);
        return result;
    }

    /**
     * Collection转换成数组T[]
     * 
     * @param <T>
     * @param c
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(Collection<T> c) {
        if (MMCollectionUtil.isEmpty(c)) {
            return null;
        }
        Iterator<T> iter = c.iterator();
        if (!iter.hasNext()) {
            return null;
        }
        T t = iter.next();
        T[] result = (T[]) Array.newInstance(t.getClass(), c.size());
        return c.toArray(result);
    }

    /**
     * Collection转换成数组T[]
     * 
     * @param <T>
     * @param c
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(Collection<T> c, Class<T> clazz) {
        if (MMCollectionUtil.isEmpty(c)) {
            return null;
        }
        T[] result = (T[]) Array.newInstance(clazz, c.size());
        return c.toArray(result);
    }

    /**
     * 方法功能描述：单对象转换为数组，需传入目标对象类型，如果本身不是数组则返回size=1的数组
     * 
     * @param <T> 泛型参数决定返回数组的类型
     * @param dataClass 传入泛型T的类型参数，决定返回数组的类型
     * @param obj 待转换为数组的Object型对象参数
     * @return 转换后的泛型数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(Class<T> dataClass, Object obj) {
        T[] array = null;
        if (obj.getClass().isArray()) {
            Object[] objs = (Object[]) obj;
            array = (T[]) Array.newInstance(dataClass, objs.length);
            for (int i = 0; i < objs.length; i++) {
                array[i] = (T) objs[i];
            }
        }
        else {
            array = (T[]) Array.newInstance(obj.getClass(), 1);
            array[0] = (T) obj;
        }
        return array;
    }
    
    @SuppressWarnings("unchecked")
	public static <T> List<T> toList(Class<T> dataClass, Object obj) {
    	List<T> list = null;
        if (obj.getClass().isArray()) {
            Object[] objs = (Object[]) obj;
            list = new ArrayList<>();
            for (int i = 0; i < objs.length; i++) {
                list.add((T) objs[i]);
            }
        }
        else {
        	  list = new ArrayList<>();
                 list.add((T)obj);
        }
		return list;
        
    }
}
