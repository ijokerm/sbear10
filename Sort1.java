import java.util.Arrays;
import java.util.Random;

public class Sort1 {
    //1、插排
    public static void inserSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            /**
             * 有序区间[0,i]
             * 无序区间[i+1,length-1]
             * 待插入的数据为array[i+1]
             * 插入过程在有序区间内查找
             */
               int key=array[i+1];
               int j;
               //查找
               for(j=i;j>=0;j--){
                  //加=保证稳定性
                   if(key>=array[j]){
                       break;
                   }
               }
               //j+1放到key位置
            for(int k=i;k>j;k--){
                array[k+1]=array[k];
            }
            array[j+1]=key;
        }
    }
    /**
     * key<array[j]
     * for(j=i;j>=0&&key<array[j];j--){
     *     array[j+1]=array[j];
     * }
     * array[j+1]=key;
     */
    //2、希尔
    public static void inserSortGap(int[] array,int gap) {
        for (int i = 0; i < array.length - gap; i++) {
            int key = array[i + gap];
            int j;

            for (j = i; j >= 0 && key < array[j]; j -= gap) {
                if (key < array[j]) {
                    array[j + gap] = array[j];
                }
                array[j + gap] = key;
            }
        }
    }
    public static void shellSort(int[]array){
        int gap=array.length;
        while(true) {
            gap =gap/3+1;
            inserSortGap(array, gap);
            if(gap==1){
                return ;
            }
        }
    }

    //选择排序
    public static void selectSort(int[] array){
        //每次选最大的数
        for(int i=0;i<array.length;i++){
            //无序区间[0,array.length-i)
            //有序区间
            int max=0;
            int j;
            for(j=1;j<array.length-i;i++){
                if(array[j]>array[max]){
                    max=j;
                }
            }
            swap(array,max,j);
        }
    }
    //堆排序
    public static void heapSort(int[] array){
         createHeap(array,array.length);
         for(int i=0;i<array.length-1;i++){
         //无序[0,array.length-i)
             swap(array,0,array.length-i);
         Heapify(array,array.length-i,0);

         }
    }
    //建堆
    public static void createHeap(int[]array,int size){
        for(int i=(size-2)/2;i>=0;i--){
            Heapify(array,size,i);
        }
    }
    //向下调整
    public static void Heapify(int[]array,int size,int index){
       while(true){
           int left=2*index-1;
           if(left>size){
               return;
           }
           int max=left;
           if(left+1<size&&array[left]<array[left+1]){
                 max=left+1;
           }
           if(array[max]>array[index]){return;}
           swap(array,index,max);
       }
    }


    public static void swap(int[]arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    //选择排序进阶版
    public static void selectSort2(int[] arr2){
        int low=0;
        int high=arr2.length-1;
        //无序区间【low,high】
        while(low<high){
            int min=low;
            int max=high;
        }

    }
    //冒泡排序-减治排序
    //无序区间[0,array.length-i）
    public static int[]  test1(int n){
       int[]arr=new int[n];
        for(int i=0;i<n;i++){
           arr[i]=i;
        }
       return arr;
    }
    //快排
    public static void quickSort(int[] arr){}
    public static void quickSortInternal(int[]array,int left,int right){}

    public static int partition2(int[]array,int left,int right){
        int privot=array[right];
        int less=left;
        int great=right;
      while (less<great) {
          if (less < great && array[less] <= privot) {
              less++;
          }
          array[great] = array[less];

          if (less < great && array[great] >= privot) {
              great--;
          }
          array[less] = array[great];
      }
       array[less]=privot;
      return less;
    }

    public static int partition(int[]array,int left,int right){
        int privot=array[right];
        int less=left;
        for(int i=left;i<right;i++){
            if(array[i]<privot){
               //蓝色箭头--less
                swap(array,less,i);
                less++;
            }
            swap(array,less,right);
        }
        return less;

    }

    //随机数
    public static int[] test2(int n){
        Random random=new Random(20198870);
        int[]array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=random.nextInt(n);
        }
        return array;
    }


    public static void main(String[] args) {
        /**int[]arr=test1(10);
        inserSort(arr);
        System.out.println(Arrays.toString(arr));
        long begin=System.nanoTime();//记录时间
        long end=System.nanoTime();
        System.out.println(end-begin);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
        long begin1=System.nanoTime();//记录时间
        long end1=System.nanoTime();
        System.out.println(end-begin);
        */
        int[]arr1=test2(10000);

        //System.out.println(Arrays.toString(arr1));
        long begin=System.nanoTime();//记录时间
        inserSort(arr1);
        long end=System.nanoTime();
        System.out.println(end-begin);
    }

}
