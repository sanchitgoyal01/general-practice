package datastructures;

public class Heap {
	public static int[] maxHeapify(int[] input, int i) {
		int l = left(i);
		int r = right(i);
		int largest = i;
		
		if(l<input.length && input[l]>input[i]) largest = l;
		if(r<input.length && input[r]>input[largest]) largest = r;
		if(largest!=i) {
			int temp = input[largest];
			input[largest] = input[i];
			input[i] = temp;
		}
		else return input;
		
		return maxHeapify(input, largest);
	}
	
	public static int[] buildMaxHeap(int[] input){
		for(int i=parent(input.length-1); i>=0; i--){
			maxHeapify(input, i);
		}
		return input;
	}
	
	public static void main(String[] args){
		int[] input = {1,2,3,4,5,6,7};
		int[] output = buildMaxHeap(input);
		for(int i=0;i<output.length;i++){
			System.out.println(output[i]);
		}
	}
	
	private static int parent(int i){
		return (int) Math.floor((i+1)/2)-1;
	}
	
	private static int left(int i){
		return (i+1)*2-1;
	}
	
	private static int right(int i){
		return (i+1)*2;
	}

}
