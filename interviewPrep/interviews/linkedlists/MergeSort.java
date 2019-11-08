public class MergeSort{

	static void sort(int[] array){
		int[] helper = new int[array.length];
		mergesort(array,helper,0,array.length-1);
	}

	static void mergesort(int[] array,int[] helper,int start, int end){
		if (start<end){
			int middle = (start+end)/2;
			mergesort(array,helper,start,middle);
			mergesort(array,helper,middle+1,end);
			merge(array,helper,start,middle,end);
		}
	}

	static void merge(int[] array,int[] helper,int start, int middle, int end){
		for (int i=start;i<=end;i++) {
			helper[i]=array[i];
		}

		int helperLeft = start;
		int helperRight = middle+1;
		int current = start;
	
		while(helperLeft<= middle && helperRight <= end){
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft++];
			}
			else {array[current]=helper[helperRight++];}
			current++;
		}

		int remaining = middle-helperLeft;
		for (int i=0;i<= remaining;i++){
			array[current+i]= helper[helperLeft+i];
		}

	}


	public static void main(String[] args) {
		int[] me =  {10,3,5,6,2};
		for (int i:me) System.out.print(i+", ");
		System.out.println();
		sort(me);
		for (int i:me) System.out.print(i+", ");
					System.out.println();


	}

}