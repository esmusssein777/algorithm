# algorithm
算法


## 排序

### 冒泡排序

	public int[] sort(int[] sourceArray) {
		int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
		
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

	public int[] sort(int[] sourceArray) {
		int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
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
	
	
### 插入排序

	public int[] sort(int[] sourceArray) {
		int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
		for(int i = 1; i < array.length; i++) {
			//用一个数来记录将要插入的数
			int temp= array[i];
			int j = i;
			//前面的数已经有序了，只要小于前面一个数即可
			while(j > 0 && temp < array[j - 1]) {
				array[j] = array[j - 1];
				j--;
			}
			if(j != i) {
				array[j] = temp;
			}
		}
		return array;
	}
  
  
  ### 希尔排序
  
  	public int[] sort(int[] sourceArray) {
		int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
		
        for(int gap = array.length / 2; gap > 0; gap /= 2) {
        	
        	for(int i = gap; i < array.length; i++) {
        		int temp = array[i];
        		int j = i - gap;
        		while(j >= 0 && temp < array[j]) {
        			array[j+gap] = array[j];
        			j -= gap;
        		}
        		array[j + gap] = temp;
        	}
        }

        return array;
    }
    
   
### 归并排序


	public int[] sort(int[] sourceArray) {
		int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
		if(array.length < 2) {
			return array;
		}
		int mid = (int)Math.floor(array.length / 2);
		
		int[] left = Arrays.copyOfRange(array, 0, mid);
		int[] right = Arrays.copyOfRange(array, mid, array.length);
		//递归，空间复杂度为O(n),而不是O(1)
		return merge(sort(left), sort(right));
	}
	
	private int[] merge(int[] left, int[] right) {
		int result[] = new int[left.length + right.length];
		int i = 0;
		while(left.length > 0 && right.length > 0) {
			if(left[0] <= right[0]) {
				result[i++] = left[0];
				//将已经加到上一层的left[0]从里面去除
				left = Arrays.copyOfRange(left, 1, left.length);
			}else {
				result[i++] = right[0];
				right = Arrays.copyOfRange(right, 1, right.length);
			}
		}
		//最后剩了一个left或者right的时候是最大值，加进去
		while(left.length > 0) {
			result[i++] = left[0];
			left = Arrays.copyOfRange(left, 1, left.length);
		}
		
		while(right.length > 0) {
			result[i++] = right[0];
			right = Arrays.copyOfRange(right, 1, right.length);
		}
		
		return result;
	}
  
  
  
  ### 快速排序
  ```
  public class Quick implements Sort {
	@Override
	public int[] sort(int[] sourceArray) {
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

		return quickSort(arr, 0, arr.length - 1);
	}

	private int[] quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int p = pIndex(arr, left, right);
			quickSort(arr, left, p - 1);
			quickSort(arr, p + 1, right);
		}
		return arr;
	}

	private int pIndex(int[] arr, int left, int right) {
		int p = left;
		int index = p + 1;
		for (int i = index; i <= right; i++) {
			if (arr[i] < arr[p]) {
				swap(arr, i, index);
				index++;
			}
		}
		swap(arr, p, index - 1);
		return index - 1;
	}

	private void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public static void main(String[] args) {
		int array[] = { 3, 5, 8, 1, 2, 9, 4, 7, 6 };
		Sort q = new Quick();
		
		System.out.println(Arrays.toString(q.sort(array)));
	}

}
  ```
