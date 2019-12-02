package sort_search;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.
Given target = 20, return false.
*/
public class Search2DMatrix {
	public static boolean searchMatrix1(int[][] matrix, int target){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[i].length; j++){
				int currValue = matrix[i][j];
				if(currValue == target)
					return true;
				if(currValue > target)
					break;
			}
		}
	return false;
	
	}
	
	public static boolean searchMatrix2(int[][] matrix, int target){
		boolean result = false;
		for(int[] m: matrix){
		  	result = binarySearch(m, target);
		  	if(result)
		  		return result;
		}
		
		return result;
		
	}
	
	public static boolean binarySearch(int[] a, int target){
		int low = 0, high = a.length-1;
		while(high >= low){
			int mid = low + (high-low)/2;
			if(a[mid] == target)
				return true;
			else if(a[mid] > target){
			  high = mid -1;	
			}
			else
			{
			 low = mid + 1;
			}
		}
		return false;
	}
	
	   public static boolean searchMatrix3(int[][] matrix, int target) {
	        int n = matrix.length;
	        if(n == 0)
	            return false;
	        int j = matrix[0].length - 1;
	        int i = 0;
	        while(i<n && j>=0){
	            if(matrix[i][j] == target)
	                return true;
	            else if(matrix[i][j] > target)
	                j --;
	            else
	                i ++;
	        }
	        return false;
	        
	    }
	
	public static void main(String[] args){
		int[][] matrix = {
				{1,4,7,11,15},
				{2,5,8,12,19},
				{3,6,9,16,22},
				{10,13,14,17,24},
				{18,21,23,26,30}
		};
		
		int [][] matrix1 = {{-5}};
		int target = -10;
		
		System.out.println(searchMatrix3(matrix1, target));
	}
	
 
}
