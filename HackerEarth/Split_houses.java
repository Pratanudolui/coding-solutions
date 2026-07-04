import java.util.*;
class TestClass {    
    public static void main(String args[])    {
                Scanner s = new Scanner (System.in);
                        int n = s.nextInt();        
                        s.nextLine();        
                        String str = s.nextLine();        
                        char[] array = str.toCharArray();        
                        int valid = 1;        
                        for(int i=0;i<n;i++)        
                        {            
                            if(array[i]=='.') 
                            array[i]='B';        
                        }        
                        for(int i=1;i<n;i++)        {            
                            if(array[i]=='H' && array[i-1]=='H')            
                            {
                                                valid=0;                
                                                break;            
                            }        
                        }        
                        if(valid == 1)        
                        {            
                            System.out.println("YES");            
                            System.out.println(array);        
                        }        
                        else        
                        {            
                            System.out.println("NO");        
                        }    
    }
}
