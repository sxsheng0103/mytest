package com.jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UserN {
	public static void main(String[] args) {
		Integer[] array = new Integer[]{3,5,7,2,5,4,89};
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1 = Arrays.asList(array);
		
		
		
		List<Integer> list = new ArrayList<Integer>();
		//第二种
		list.clear();
		list.add(434);
		list.add(5564);
		list.add(4);
		for(int i = list.size()-1;i>=0;i--) {
			if(list.get(i).intValue()>10) {
				list.remove(i);
			}
		}
		System.out.println(list);
		//第一种
		list.clear();
		list.add(434);
		list.add(5564);
		list.add(4);
		Iterator<Integer> itor = list.iterator();
		int temp =0;
		while(itor.hasNext()) {
			temp = itor.next();
			if(temp>6)
			itor.remove();
		}
		System.out.println(list);
		
		
		
		
		
		list.clear();
		list.add(1);
		list.add(5);
		list.add(5);
		list.add(-7);
		list.add(8);
		list.add(2);
		list.add(6);
		Set<Integer> set = new HashSet<Integer>();
		set.addAll(list);
		List list2 = new ArrayList(set);
		Collections.sort(list2);
		System.out.println(list2);
		
	}
	
	
	
}
