package main.util;

import java.util.ArrayList;


/*
 * created by :Ankit Goenka
 */
public class Heap<D extends Comparable<D>> {

	
	private ArrayList<D> arr;
	private boolean isMAx=true;
	
	/*
	 * Will create a maxHeap
	 */
	public Heap() {
		arr=new ArrayList<>();
	}
	
	/*
	 *  @param minMaxFlag :"MIN" for minHeap else maxHeap
	 */
	public Heap(String minMaxFlag) {
		arr=new ArrayList<>();
		if("MIN".equals(minMaxFlag)){
			setMAx(false);
		}else{
			setMAx(true);
		}
	}
	

	/*
	 *"MIN" for minHeap, else maxHeap
	 * @param size: intial size if heap array
	 */
	public Heap(String minMaxFlag,int size) {
		arr=new ArrayList<>(size);
		if("MIN".equals(minMaxFlag)){
			setMAx(false);
			System.out.println("sd");
		}else{
			setMAx(true);
		}
	}
	
	private void swap(int first,int second){
		
		if(first>=arr.size() || second>=arr.size()){
			return;
		}
		
		D temp=arr.get(first);
		arr.set(first, arr.get(second));
		arr.set(second, temp);
		return;
	}

	
	
	public void add(D a){
	
		
		arr.add(a);
		int current=getSize()-1;
		
		while(current!=0 && !(arr.get(current).compareTo(getParent(current))>0^getIsMAx())){
			
			swap(current, (current-1)/2);
			current=(current-1)/2;
		}
		
		
	}
	
	
	public D getTop(){
		if(arr.size()==0){
			return null;
		}else{
			return arr.get(0);
		}
	}
	
	public D removeTop(){
		if(arr.size()==0){
			return null;
		}else{
			D top= arr.get(0);
			arr.set(0, arr.get(getSize()-1));
			arr.remove(getSize()-1);
			heapify();
			return top;
		}
	}
	
	public int getSize(){
		return arr.size();
	}
	
	public void heapify(){
	
		heapify(0);
		
	}
		
	public void heapify(int i){
		
		if(i<arr.size()){
			
			if(   (getLeft(i) ==null || !(getLeft(i).compareTo(arr.get(i))<0 ^getIsMAx())  )  &&
					 (getRight(i) ==null || !(getRight(i).compareTo(arr.get(i))<0 ^getIsMAx())  )){
				
				return;
			}

			
			int heapifyIndex;
			
			if(  getRight(i)==null ||(    getLeft(i)!=null && !(getLeft(i).compareTo(getRight(i))>0 ^getIsMAx()) ) ){
				
				heapifyIndex=2*i+1;
				
			}else{
				heapifyIndex=2*i+2;
			}
			
			swap(heapifyIndex, i);
			heapify(heapifyIndex);
			
		}
	}
	
	
	private D getRight(int i){
		
		if(i*2 +2>=arr.size()){
			return null;
		}else{
			return arr.get(2*i+2);
		}
		
	}
	
	private D getLeft(int i){
		
		if(i*2 +1>=arr.size()){
			return null;
		}else{
			return arr.get(2*i+1);
		}
		
	}
	
	
	

	
	private D getParent(int i){
		
		if(i>=arr.size()){
			return null;
		}else{
			return arr.get((i-1)/2);
		}
		
	}
	
	public ArrayList<D> getArr() {
		return arr;
	}


	public void setArr(ArrayList<D> arr) {
		this.arr = arr;
	}


	public boolean getIsMAx() {
		return isMAx;
	}


	public void setMAx(boolean isMAx) {
		this.isMAx = isMAx;
	}
	
	
	
}

