/*
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (23.18%)
 * Total Accepted:    257.9K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * Example 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * 
 * Example 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int[] c = new int[A.length+B.length];
int i = 0;
int j = 0;
int k =  0;
if (A.length ==0)
{
    c=B;
}
else if(B.length ==0)
{
    c=A;
}
else
{
while (i< A.length &&j< B.length)
{

		if (A[i] <B[j])
		{
			c[k]=A[i];
			k++;
			i++;
		}
		else
		{
			c[k]=B[j];
			k++;
			j++;

	}

}
if(i!= A.length)
	while (i!=A.length)
	{
	c[k]=A[i];
	k++;
	i++;
	}
else if (j!=B.length)
	while (j!=B.length)
	{
	c[k]=B[j];
	k++;
	j++;
	}
}
double ans = 0;
if (c.length % 2 ==0)
{
	ans = (double)(c[c.length/2] + c[c.length/2-1])/2;
    return ans;
}
else
{
	ans = (double) c[c.length/2];
	return ans;
}
	
        

}
}
