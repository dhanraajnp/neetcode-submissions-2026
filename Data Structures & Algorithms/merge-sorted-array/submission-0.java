class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0;
        int j = 0;
        int k =0;
        int[] res = new int[m+n];

        while(i < m && j<n ){
            if(nums2[j] > nums1[i])
                res[k++]=nums1[i++];
            else
                res[k++]=nums2[j++];
        }

        while(i<m){
            res[k++]=nums1[i++];
        }

        while(j<n){
            res[k++]=nums2[j++];
        }

        for(int i2=0; i2<m+n; i2++){
            nums1[i2] = res[i2];
        }
    }
}