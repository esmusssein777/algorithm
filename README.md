# algorithm
算法

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
  
  
