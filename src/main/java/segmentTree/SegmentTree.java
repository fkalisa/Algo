package segmentTree;

import java.util.Arrays;

public class SegmentTree {

    private int arr[];
    private int seg[];
    public SegmentTree(int arr[]){
        this.arr = arr;
        int n = arr.length;
        seg = new int[n*4 +5];
    }


    void build(int ind, int low, int high){
        if (low == high){
            seg[ind] = arr[low];
            return;
        }

        int mid = (low+high)/2;

        build( ind* 2+1,  low,  mid);
        build( ind* 2+2,  mid+1,  high);

        seg[ind] = Math.min(seg[ind*2 +1], seg[ind*2 +2]);

    }
    /*
        partially overlap of node (init): left, right
        completely overlap :  node
        no overlap : return max value as we are searching for min (to discard the value)
    */
    public int query(int ind, int low, int high, int l, int r){

        // complete overlap
        if(l <= low && high<= r)
        {
            return seg[ind];
        }

        // no verlap

        if(r < low  || high< l ){
            return Integer.MAX_VALUE;
        }

        // partially

        int mid = (low+high)/2;

        int left = query( ind*2 +1,  low,  mid,  l,  r);
        int right = query( ind*2 +2,  mid+1,  high,  l,  r);

        return Math.min(left, right);
    }

    public void update(int ind, int low, int high, int i, int val){
        if(low == high){
            seg[ind] = val;
            arr[i] = val;
            return;
        }

        int mid = (low+high)/2;

        if(i <= mid){
            update( ind*2 +1,  low,  mid,  i,  val);
        }else{
            update( ind*2 +2,  mid+1, high,  i,  val);
        }

        seg[ind] = Math.min(seg[ind*2+1],seg[ind*2+2]);

    }





    public static void main(String[] args) {

        int arr[] = {2, 1, 3, 2, 5, 0, 6};
        int n = arr.length;
        SegmentTree segmentTree = new SegmentTree(arr);
        segmentTree.build(0, 0, n-1);

        System.out.println(Arrays.toString(segmentTree.seg));


        System.out.println(" query range 0-2 : "  +segmentTree.query(0,0,n-1, 0, 2));

        System.out.println(" query range 4-6 : "  +segmentTree.query(0,0,n-1, 4, 6));

        segmentTree.update(0, 0, n-1, 1, -5);

        System.out.println(" query range 0-2 : "  +segmentTree.query(0,0,n-1, 0, 2));


    }




}
