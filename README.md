# algorithm
算法

[TOC]

## 排序

### 冒泡排序

	public int[] sort(int[] array) {
		for(int i = 1; i < array.length; i++) {
			boolean flag = true;
			
			for(int j = 0; j < array.length - i; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = false;
				}
			}
			if(flag) {
				break;
			}
		}
		
		return array;
	}
	

### 选择排序

	public int[] sort(int[] array) {
		int length = array.length;
		//N-1轮
		for(int i = 0; i < length-1; i++) {
			int min = i;
			//N-i轮
			for(int j = i + 1; j < length; j++) {
				//使用下标来记录数组的数据
				if(array[min] > array[j]) {
					min = j;
				}
			}
			
			if(min != i) {
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		return array;
	}
  
  
