import java.util.*;
class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long d = sc.nextInt();
        long oc = sc.nextInt();
        long of = sc.nextInt();
        long od = sc.nextInt();
        long cs = sc.nextInt();
        long cb = sc.nextInt();
        long cm = sc.nextInt();
        long cd = sc.nextInt();
 


        long onl = oc+((d-of)*od);
 


        long time = d/cs;
        long clc = cb+(time*cm)+(d*cd);
 
        if(onl<clc){
            System.out.println("Online Taxi");
        }
        else if(onl==clc){
            System.out.println("Online Taxi");
        }
        else{
            System.out.println("Classic Taxi");
        }
        sc.close();
    }
}
