/**

* <p>Title: SortAlgorithm.java</p>

* <p>Description: </p>

* <p>Copyright: Copyright (c) 2017</p>

* <p>Company: zyx@taeyeon.cn</p>

* @author KEN

* @date 2018年2月25日

* @version 1.0

*/

package com.grgbanking.test;

/**
 * @author KEN
 *
 */
public class SortAlgorithm {

    public void QuickSort(int[] list){
        if(null==list||list.length<=1) {
            return;
        }
        System.out.println("+++++++++++++++++++++开始快排++++++++++++++++++++++++");
        int len=list.length;

        QuickSort(list,0,len-1);
    }

    public void QuickSort(int[] list,int low,int high){
        if(low<high){
            int index=Partition2(list,low,high);
            QuickSort(list,low,index-1);
            QuickSort(list,index+1,high);
        }
    }

    //升序
    public int Partition(int[] list,int low,int high){
        int temp=list[low];
        while(low<high){
            while(low<high&&list[high]>temp){
                high--;
            }
            if(low<high){
                list[low++]=list[high];
            }

            while(low<high&&list[low]<temp){
                low++;
            }
            if(low<high){
                list[high--]=list[low];
            }
        }
        list[high]=temp;
        return temp;
    }

    //降序
    public int Partition2(int[] list,int low,int high){
        int temp=list[high];
        while(low<high){
            while(low<high&&list[low]>temp){
                low++;
            }
            if(low<high){
                list[high--]=list[low];
            }
            while(low<high&&list[high]<temp){
                high--;
            }
            if(low<high){
                list[low++]=list[high];
            }
        }
        list[low]=temp;
        return low;

    }

    public void HeapSort(int[] list){
        if(list.length<=1) {
            return;
        }
        int len=list.length;
        System.out.println("+++++++++++初始建堆+++++++++++++++++");
        for(int i=(len-1)/2;i>=0;i--){
            HeapAdjust(list,i,len-1);
        }

        System.out.println("++++++++++++开始排序+++++++++++++++");
        int temp;
        for(int j=len-1;j>0;j--){
            temp=list[0];
            list[0]=list[j];
            list[j]=temp;
            HeapAdjust(list,0,j-1);
        }
    }

    public void HeapAdjust(int[] list,int i,int len){
        int left=2*i+1;
        int right=2*i+2;
        int largest=i;

        if(left<=len&&list[left]>list[largest]){
            largest=left;
        }
        if(right<=len&&list[right]>list[largest]){
            largest=right;
        }
        int temp;
        if(largest!=i){
            temp=list[i];
            list[i]=list[largest];
            list[largest]=temp;

            HeapAdjust(list,largest,len);
        }
    }

    public void PrintList(int[] list){
        if(list.length<=0){
            throw new IndexOutOfBoundsException("Index 越界了！！！");
        }

        for(int i=0;i<list.length;i++){
            System.out.print(list[i]+"\t");
        }
    }

    public static void main(String[] args) {
       int[] list={4,7,3,8,2,9,0,1,5,6};
       SortAlgorithm sa=new SortAlgorithm();

       System.out.println("+++++++++++++++原始序列为：");
       sa.PrintList(list);
       System.out.println();
       //sa.QuickSort(list);
       sa.HeapSort(list);
       sa.PrintList(list);

    }

}
