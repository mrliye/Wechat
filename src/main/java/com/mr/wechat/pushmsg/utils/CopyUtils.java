package com.mr.wechat.pushmsg.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class CopyUtils {
	/**
	 * 用于将一个集合拷贝到另一个集合
	 * @param tlist 原jihe
	 * @param clz 新集合中的元素类型
	 * @return 新集合
	 */
	public static <T, E> List<E> copyPropreties(List<T> tlist, Class<E> clz) {
		List<E> list = new ArrayList<>();
		if(tlist!=null && !tlist.isEmpty()){
			try {
				for (T t : tlist) {
					E e = clz.newInstance();
					BeanUtils.copyProperties(t, e);
					list.add(e);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
