/* 将一个字符串转换为Integer，考虑溢出和不合理字符*/
/* 可以使用String.trim（）对算法进行改进*/
class Solution {
    public int myAtoi(String str) {
        
        char c;
        
        boolean flag=false,sign=true;
        int flag2=1;
        
        int temp=0,num=0;
        
        for(int i=0;i<str.length();i++){
            c=str.charAt(i);
            if(c==' ') 
                if(sign) continue;
                else break;          
            
            if(c>='0' && c<='9'){
                temp=num*10+(c-'0')*flag2;
                if(temp/10 != num)
                    if(flag2==-1) return Integer.MIN_VALUE;
                    else return Integer.MAX_VALUE;
                num=temp;
                sign=false;
            }
            else{
                sign=false;
                if(flag) break;
                if(c=='-'){
                    flag=true;
                    flag2=-1;
                }   
                else if (c=='+') flag=true;
                else break;          
            }
        }
     
     return (int)num;
        
    }
}