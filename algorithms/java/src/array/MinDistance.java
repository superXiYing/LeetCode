package array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//Given a 2 dimensional matrix where some of the elements are filled with 1 and rest of the elements are filled. Here X means you cannot traverse to that particular points. From a cell you can either traverse to left, right, up or down. Given two points in the matrix find the shortest path between these points. Here S is the starting point and E is the Ending point.
public class MinDistance {
	public static void main(String[] args) {
		char[][] matrix = { { '1', '1', '1', '1' }, { '1', 'S', '1', '1' },
				{ '1', '1', 'X', '1' }, { '1', '1', '1', 'E' } };
	}

	public static int minDistance(char[][] matrix){
		//1. find the start element 'S'
		int s_row =0, s_col = 0;
		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[i].length; j++){
				if(matrix[i][j] == 'S'){
					s_row = i;
					s_col = j;
				}
			}
		
		//2. find the shortest distance from 'S' to 'E'
		int count = 0;
		//record the elements which are visited
		Set<int[]> visited = new HashSet<int[]>();
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[]{s_row, s_col});
		while(!queue.isEmpty()){
			int[] point = queue.poll();
			int row = point[0];
			int col = point[1];
			
			//check for current element
			if(matrix[row][col] == 'E')
				return count;
			
			boolean goAhead = false;
			
			//Check for the up element
			if(row>0 && matrix[row-1][col] != 'X'){
				int[] upPoint = new int[]{row-1, col}; 
				if(!visited.contains(upPoint)){
					queue.add(upPoint);
					goAhead = true;
				}
					
			}
				
		    //Check for the down element
			if(row<matrix.length && matrix[row+1][col]!='X'){
				int[] downPoint = new int[]{row+1, col}; 
				if(!visited.contains(downPoint)){
					queue.add(downPoint);
					goAhead = true;
				}
				 
			}
               
			//Check for the left element
			if(col>0 &&matrix[row][col-1] != 'X' ){
				int[] leftPoint = new int[]{row, col-1}; 
				if(!visited.contains(leftPoint)){
					queue.add(leftPoint);
					goAhead = true;
				}
				
			}
				
			//Check for the right element
			if(col<matrix[0].length &&matrix[row][col+1] != 'X'){
				int[] rightPoint = new int[]{row, col+1}; 
				if(!visited.contains(rightPoint)){
					queue.add(rightPoint);
					goAhead = true;
				}
				
			}
				
			if(goAhead)
			   count ++;
			visited.add(point);
			
		}
		
		//Did not find the 'E'
		return -1;
		
	}
}
