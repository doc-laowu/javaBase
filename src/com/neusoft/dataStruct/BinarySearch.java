package com.neusoft.dataStruct;

public class BinarySearch {

    //二分查找不使用递归
    public int RunByLoop(int[] array, int value){

        int beginIndex = 0;// 低位下标

        int endIndex = array.length - 1;// 高位下标

        int midIndex = -1;

        while (beginIndex <= endIndex) {

            midIndex = beginIndex + (endIndex - beginIndex) / 2;//防止溢出

            if (value == array[midIndex]) {

                return midIndex;
            } else if (value < array[midIndex]) {

                endIndex = midIndex - 1;

            } else {

                beginIndex = midIndex + 1;

            }
        }

        return -1;

         //找到了，返回找到的数值的下标，没找到，返回-1
    }


    //二分查找使用递归
    public int RunByRever(int[] arr, int key, int low, int high){

        int mid = low + (high - low)/2;

            if(low > high)
            return -1;

        if(arr[mid] == key)
            return mid;
        else if(arr[mid] < key){
            return RunByRever(arr, key, low, mid-1);
        }else{
            return RunByRever(arr, key, mid+1, high);
        }
    }

}
