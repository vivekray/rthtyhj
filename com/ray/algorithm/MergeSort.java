package com.ray.algorithm;

public class MergeSort {
	static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	static int[] mergeSort(int arr[],int l,int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second half
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			// Merge the sorted half
			merge(arr, l, m, r);
		}
		return arr;
	}
	 static int[] merge(int[] arr) {
		 
		return (mergeSort(arr,0,arr.length-1));
		 
	 }
	 
	 static void printArrayInt(int[] arr) {
			int n = arr.length;
			for (int i = 0; i < n; ++i)
				System.out.print(arr[i] + " ");

			System.out.println();
		}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3,2,4,78,87,85,9};
		
		merge(arr);
		printArrayInt(merge(arr));

	}

}
