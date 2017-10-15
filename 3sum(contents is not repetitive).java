/*
	Given an array S of n integers(not repetitive), are there elements a, b, c in S such that a + b + c = 0? Find all 
		unique triplets in the array which gives the sum of zero.
*/



class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList=new ArrayList<List<Integer>>();
        List<List<Integer>> listTemp=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        Iterator<List<Integer>> iList;
        Integer[] three=new Integer[3];
        Integer p,sum2,sum;
        Set positive=new HashSet<Integer>(),negtive=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                positive.add(nums[i]);
            else
                negtive.add(nums[i]);
        }
        
        Iterator<Integer> ip=positive.iterator();
        while(ip.hasNext()){
            p=ip.next();
            listTemp=twoSum(negtive,0-p);
            if(!listTemp.isEmpty()){
                iList = listTemp.iterator();
                while(iList.hasNext()){
                    iList.next().add(p);
                }
                listList.addAll(listTemp);
            }            
        }
        return listList;
        
    }
    
    public List<List<Integer>> twoSum(Set<Integer> negtive,Integer sum){
        List<List<Integer>> listList=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        
        Set<Integer> hased=new HashSet<Integer>(); 
        
        Iterator<Integer> in=negtive.iterator();
        Integer n,mi;
        while(in.hasNext()){
            n=in.next();
            mi=sum-n;
            if(!hased.contains(n) && mi!=n && negtive.contains(mi)){
                list.add(n);
                list.add(mi);
                
                hased.add(n);
                hased.add(mi);
                
                listList.add(list);
                list=new ArrayList<Integer>();
            }  
        }
        
        return listList;
    }
}