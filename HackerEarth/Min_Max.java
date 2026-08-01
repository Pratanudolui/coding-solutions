import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int no=s.nextInt();
        TreeSet <Integer>tr=new TreeSet<>();
        int min=9999, max=0,flag=0,m=0;
        for(int i=0;i<no;i++){
            tr.add(s.nextInt());
        }
        min=tr.first();
        max=tr.last();
        for(int i=min;i<max;i++){
            if(tr.contains(i)){

            }
            else{
                flag=1;  
                break; 
            }
        }
        if(flag==1 ){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
        }
    }
}
