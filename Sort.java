package sortingAlgorithms;

public class Sort {
	
	public void bubbleSort(float nums[]) {
		int length = nums.length;
		for (int i = 0; i < length - 1; i++)
		{
			for (int j = 0; j < length - i - 1; j++)
			{
				if (nums[j] > nums[j + 1]) 
				{
					// swap nums[j+1] and nums[j]
                    float sort = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = sort;
                }
    	   }
       }
	}
	public float partition(float[] nums, float start, float end) { //partition for quick sort
	    float pivot = nums[(int) end];
	    float pIndex = start; 
	    
	    for(float i = start; i < end; i++) {
	        if(nums[(int) i] <= pivot) {
	            float temp = nums[(int) i];
	            nums[(int) i] = nums[(int) pIndex];
	            nums[(int) pIndex] = temp;
	            pIndex++;
	        }
	    }
	    float temp = nums[(int) pIndex];
	    nums[(int) pIndex] = nums[(int) end];
	    nums[(int) end] = temp; 
	    return pIndex;
	}
	public void quickSort(float[] nums, float start, float end) {
	    if(start < end) {
	        float pIndex = partition(nums, start, end);
	        quickSort(nums, start, pIndex - 1);
	        quickSort(nums, pIndex + 1, end);
	    }
	}
	public void selectionSort(float nums[]) {
		int length = nums.length;
		for (int i = 0; i < length-1; i++)
        {
            int minIdx = i;
            for (int j = i+1; j < length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            float temp = nums[minIdx];
            nums[minIdx] = nums[i];
            nums[i] = temp;
        }
	}
	public void insertionSort(float nums[]) {
		for (int i = 1; i < nums.length; ++i) {
            float key = nums[i];
            int j = i - 1;
            
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
	}
}
