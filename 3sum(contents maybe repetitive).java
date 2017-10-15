/*
this implemention is not good(very slow)


*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Map<Integer,Integer> mapP=new HashMap<Integer,Integer>();
        Map<Integer,Integer> mapN=new HashMap<Integer,Integer>();
        Set<Integer> set=new HashSet<Integer>();
        Set<Integer> setTemp=new HashSet<Integer>();
        
        List<List<Integer>> listList=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        
        int key,key2,value,sum2,num0=0,sum2Half;
        boolean flag0;
        
        for(int i=0;i<nums.length;i++){
            key=nums[i];
            if(key>0)
                mapP.put(key,mapP.getOrDefault(key,0)+1);
            else if(key<0)
                mapN.put(key,mapN.getOrDefault(key,0)+1);
            else num0++;
        }
        
        flag0=num0>0;
        
        for(int i=0;i<nums.length;i++){
            key=nums[i];
            if(key<=0 || set.contains(key)) continue;
            set.add(key);
            
            value=mapP.get(key);
            sum2=0-key;
            
            if(flag0)
                if(mapN.containsKey(sum2)){
                    list.add(sum2);
                    list.add(0);
                    list.add(key);
                    listList.add(list);
                    list=new ArrayList<Integer>();
                    setTemp.add(sum2);
                }
            if(value>=2){
                if(mapN.containsKey(sum2-key)){
                    list.add(sum2-key);
                    list.add(key);
                    list.add(key);
                    listList.add(list);
                    list=new ArrayList<Integer>();
                    setTemp.add(sum2-key);
                }
            }
            if(sum2%2==0){
                sum2Half=sum2/2;
                if(mapN.containsKey(sum2Half) && mapN.get(sum2Half)>=2){
                    list.add(sum2Half);
                    list.add(sum2Half);
                    list.add(key);
                    listList.add(list);
                    list=new ArrayList<Integer>();
                    setTemp.add(sum2Half);
                }
            }
            for(int j=0;j<nums.length;j++){
                key2=nums[j];
                if(key2>=0 || setTemp.contains(key2)) continue;
                if(mapN.containsKey(sum2-key2) && sum2-key2!=key2){
                    list.add(sum2-key2);
                    list.add(key2);
                    list.add(key);
                    listList.add(list);
                    
                    setTemp.add(sum2-key2);
                    setTemp.add(key2);
                    set.add(key);
                    list=new ArrayList<Integer>();
                }
            }   
            setTemp.clear();
            
        }
        
        for(int i=0;i<nums.length;i++){
            key=nums[i];
            if(key>=0 || set.contains(key)) continue;
            set.add(key);
            
            value=mapN.get(key);
            sum2=0-key;
            
            for(int j=0;j<nums.length;j++){
                key2=nums[j];
                if(key2<=0 || setTemp.contains(key2)) continue;
                
                if(mapP.containsKey(sum2-key2) && sum2-key2!=key2){
                    list.add(sum2-key2);
                    list.add(key2);
                    list.add(key);
                    listList.add(list);
                    
                    setTemp.add(sum2-key2);
                    setTemp.add(key2);
                    set.add(key);
                    list=new ArrayList<Integer>();
                }
            }   
            setTemp.clear();
        }
        if(num0>=3){
            list.add(0);
            list.add(0);
            list.add(0);
            listList.add(list);
        }
        
        return listList;
    }
    
}