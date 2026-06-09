import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.*;


 

class xor {

public static void main(String args[])throws IOException {

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

long n=Long.parseLong(br.readLine());

StringTokenizer st=new StringTokenizer(br.readLine());

HashMap<Long,Long> hs=new HashMap<>();

long l=0;

while (st.hasMoreTokens())

{

long k=Long.parseLong(st.nextToken());

hs.put(k,hs.getOrDefault(k,l)+1);

}

long count=0;

for(Map.Entry<Long,Long> e:hs.entrySet()){

long c=e.getValue();

count+=c*(c-1)/2;

}

System.out.println(count);

}

}
