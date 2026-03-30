class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i =0;
        int j =0;
        int k =0;
        int [] temp = new int [m+n];
        while(i < n && j < m){
            if(nums1[i]<nums2[j]){
                 temp[k++] = nums1[i++];
                 
            }else{
                temp[k++] = nums2[j++];
                
            }    
        }
        while(i < n){
            temp[k++] = nums1[i++];
        }
        while(j<m){
            temp[k++] = nums2[j++];
        }
        if(temp.length % 2 != 0){
            return temp[temp.length/2];
        }else{
            int mid1 = temp.length/2-1;
            int mid2 = temp.length/2;
            return (temp[mid1]+temp[mid2])/2.0;
        }
        

    }
}
