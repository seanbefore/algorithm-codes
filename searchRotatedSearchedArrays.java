class Solution {
    public int search(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        int mid;
        int index=-1;
        while(i<=j){
            if(j-i==1 || j==i){
                if(nums[i]==target) index=i;
                else if(nums[j]==target) index=j;
                break;
            }
            else{
                mid=(i+j)/2;
                if(nums[mid]==target){
                    index=mid;
                    break;
                }else if(nums[i]==target){
                    index=i;
                    break;
                }else if(nums[j]==target){
                    index=j;
                    break;
                }else{
                    if(nums[mid]<nums[j]){
                        if(target<nums[j] && target>nums[mid]){  
                            i=mid+1;
                            j=j-1;
                        }else{
                            i=i+1;
                            j=mid-1;
                        }
                    }else if(nums[mid]>nums[i]){
                        if(target<nums[mid] && target>nums[i]){  
                            i=i+1;
                            j=mid-1;
                        }else{
                            i=mid+1;
                            j=j-1;
                        }
                    }
                    else{
                        if(nums[mid]<target && target<nums[j]){
                            i=mid+1;
                            j=j-1;
                        }
                        else if(nums[mid]>target && target>nums[i]){
                            i=i+1;
                            j=mid-1;
                        }else{
                            break;
                        }
                    }
                }
                
            }
        }
        return index;
    }
}