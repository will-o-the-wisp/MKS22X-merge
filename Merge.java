import java.util.*;
public class Merge{

  public static void main(String[]args){
    /*
    System.out.println("Size\t\tMax Value\tmerge/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          mergesort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
    */
    Random r = new Random();
    int[] a = new int[10];
    for(int i=0;i<a.length;i++){
      a[i] = r.nextInt(50);
    }
    System.out.println(ats(a));
    insertionsort(a,2,7);
    System.out.println(ats(a));
  }
  private static String ats(int[] data){
    String s="";
    for(int i=0;i<data.length;i++){
      s+=data[i];
      s+=" ";
    }
    return s;
  }
  private static void insertionsort(int[] data, int lo, int hi){
    int index=lo+1;
    for(int i=index;i<hi+1;i++){
      if(data[i-1]>data[i]){
        int temp=data[i];
        int j=i-1;
        while(j>=lo&&temp<data[j]){
            data[j+1]=data[j];
            j--;
        }
        data[j+1]=temp;
      }
    }
  }
  public static void mergesort(int[] data){
    int[] temp = new int[data.length];
    for(int i=0;i<temp.length;i++){
      temp[i]=data[i];
    }
    mergesortH2(data,temp,0,data.length-1);
  }
  private static void mergesortH2(int[] data, int[] temp, int lo, int hi){
    if(hi-lo+1<50){
      insertionsort(data,lo,hi);
      return;
    }
    mergesortH2(temp, data, lo, (hi+lo)/2);
    mergesortH2(temp, data, (hi+lo)/2+1, hi);
    int i=0;
    int l=lo;
    int r=(hi+lo)/2+1;
    while(i<hi-lo+1){
      if(r>=hi+1||(l<(hi+lo)/2+1&&temp[l]<=temp[r])){
        data[i+lo]=temp[l];
        l++;
      }
      else{
        data[i+lo]=temp[r];
        r++;
      }
      i++;
    }

  }
  private static void mergesortH(int[] data){
  //  if(lo>=hi){
  //    return;
  //  }
    if(data.length<2){
      return;
    }
    int[] left = new int[(data.length-1)/2+1];
    int[] right = new int[data.length-left.length];
    for(int i=0;i<left.length;i++){
      left[i]=data[i];
    }
    for(int i=0;i<right.length;i++){
      right[i]=data[i+left.length];
    }
    mergesortH(left);
    mergesortH(right);
    int i=0;
    int l=0;
    int r=0;
    while(i<data.length){
      if(r>=right.length||(l<left.length&&left[l]<=right[r])){
        data[i]=left[l];
        l++;
      }
      else{
        data[i]=right[r];
        r++;
      }
      i++;
    }
    /*
    for(int i=0;i<left.length;i++){
      data[i]=left[i];
    }
    for(int i=0;i<right.length;i++){
      data[i+left.length]=right[i];
    }
    */
  }
}
