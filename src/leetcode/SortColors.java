package leetcode;
/*Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?*/
public class SortColors {
	
	/*一开始想到的就是计数排序，但是计数排序需要两边扫描，第一遍统计红，白，蓝的数目，第二遍生成新数组。

	考虑到题目要求one pass。这就意味着类似于链表的双指针问题，这里也要track两个index，一个是red的index，一个是blue的index，两边往中间走。

	i从0到blue index扫描，
	遇到0，放在red index位置，red index后移；
	遇到2，放在blue index位置，blue index前移；
	遇到1，i后移。
	扫描一遍得到排好序的数组。时间O(n)，空间O(1)，*/
	public class Solution1 {
	    public void sortColors(int[] A) {
	        int red = 0;
	        int white = 0;
	        int blue = 0;
	        
	        for (int i=0; i<A.length; i++) {
	            if (A[i] == 0) {
	                red++;
	            }
	            else if (A[i] == 1) {
	                white ++;
	            }
	            
	            else {
	                blue++;
	            }
	        }
	        
	        for (int i=0; i<A.length; i++) {
	            if (i<red) {
	                A[i] = 0;
	            }
	            if (i<white+red && i>=red) {
	                A[i] = 1;
	            }
	            if (i>= white+red) {
	                A[i] = 2;
	            }
	        }
	        
	    }
	}
	
	//solution2
	public class Solution {
	    public void sortColors(int[] A) {
	        if (A.length == 0 || A == null) {
	            return;
	        }
	        
	        int red = 0;
	        int blue = A.length-1;
	        int i = 0;
	        
	        while (i<=blue) {
	            if (A[i] == 0) {
	                swap(A,i,red);
	                red++;
	                i++;
	                continue;
	            }
	            if (A[i] == 2) {
	                swap(A,i,blue);
	                blue--;
	                continue;
	            }
	            i++;
	        }
	        
	        
	    }
	    
	    private void swap(int[] A, int i, int j) {
	        int tmp = A[i];
	        A[i] = A[j];
	        A[j] = tmp;
	    }
	}
	//solution3:
	//就是搞两个指针，一个指在当前0的最后一个下标，另一个是指在当前1的最后一个下标（2不需要指针因为剩下的都是2了）。
	//进行一次扫描，如果遇到0就两个指针都前进一步并进行赋值，如果遇到1就后一个指针前进一步并赋值。代码如下： 
	public void sortColors(int[] A) {
	    if(A==null || A.length==0)
	        return;
	    int idx0 = 0;
	    int idx1 = 0;
	    for(int i=0;i<A.length;i++)
	    {
	        if(A[i]==0)
	        {
	            A[i] = 2;
	            A[idx1++] = 1;
	            A[idx0++] = 0;
	        }
	        else if(A[i]==1)
	        {
	            A[i] = 2;
	            A[idx1++] = 1;
	        }
	    }
	}

}
