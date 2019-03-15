import java.util.*;
public class Merge{

  public static void main(String[]args){
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
  }
  public static void mergesort(int[] data){
    mergesortH(data);
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
