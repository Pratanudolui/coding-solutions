import java.util.Scanner;

class TestClass {

public static void main(String args[] ) throws Exception {

Scanner sc = new Scanner(System.in);

int n = sc.nextInt();

int time[] = new int[1440];

int max=0;

for(int i=0;i<n;i++){

int starth = sc.nextInt();

int startm = sc.nextInt();

int endh = sc.nextInt();

int endm = sc.nextInt();

int from = starth*60 + startm;

int to = endh*60 + endm;

for(int j=from;j<=to;j++){

time[j]++;

if(max < time[j])

max = time[j];

}

}

System.out.println(max);

}

}
