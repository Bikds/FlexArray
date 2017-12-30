/*
 * @author BikDS
 * The purpose of this class is to contain useful methods for working 
 * with an integer array
 * November 8, 2017
 */
public class FlexArrayPrimitive implements Comparable<FlexArrayPrimitive> {
	// mySize holds the logical size of the array
	private int mySize;
	// an array
	private int[] myArray;

	/*
	 * default constructor for FlexArrayPrimitive method It creates an array with 20
	 * elements
	 */
	public FlexArrayPrimitive() {
		myArray = new int[20];
		mySize = 0;
	}

	/*
	 * This constructor takes a number and creates an array of that many elements
	 */
	public FlexArrayPrimitive(int num) {
		myArray = new int[num];
		mySize = 0;
	}

	/*
	 * this method returns the number of "active" elements in the array Won't always
	 * be the length of the array
	 */
	public int getLength() {
		return mySize;
	}

	/*
	 * This method checks if the array is empty if it is empty it will return false,
	 * or else it will return true
	 */
	public boolean isEmpty() {
		if (mySize == 0) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * this method adds inputed data at the end of the array
	 */
	public void append(int data) {
		if (mySize >= myArray.length) {
			resize();
		}
		myArray[mySize] = data;
		mySize++;
	}

	/*
	 * this method inserts data at a specific index. The data and the index is
	 * inputed by the user Precondition: index >= 0
	 */
	public void insert(int index, int data) {
		if (index < mySize) {
			if (mySize >= myArray.length) {
				resize();
			}
			for (int i = mySize; i > index; i--) {
				myArray[i] = myArray[i - 1];
			}
			myArray[index] = data;
		} else {
			if (mySize < myArray.length) {
				myArray[mySize] = data;
			} else {
				resize();
				myArray[mySize] = data;
			}
		}
		mySize++;

	}

	/*
	 * discards the data at inputed index
	 */
	public int discard(int index) {
		int returnMe;
		if (index < mySize) {
			returnMe = myArray[index];
			for (int i = index; i < mySize - 1; i++) {
				myArray[i] = myArray[i + 1];
			}
			mySize--;
		} else {
			returnMe = -999;
		}
		return returnMe;
	}

	// returns the sum of the active elements
	private int getSumOfActiveElements() {
		int sum = 0;
		for (int i = 0; i < mySize; i++) {
			sum += myArray[i];
		}
		return sum;
	}

	// compares the sum of the active elements
	public int compareTo(FlexArrayPrimitive f) {
		return getSumOfActiveElements() - f.getSumOfActiveElements();
	}

	// compares the number of active elements, and returns true if they are equal
	public boolean equals(FlexArrayPrimitive f) {
		return (mySize == f.mySize);
	}

	// fix the sort method it changes everything to a zero

	// orders the array from low to high
	public void sort() {
		selectionSort(myArray);
	}

	// sorts the method from least to greatest
	public void selectionSort(int[] a) {
		for (int i = 0; i < mySize - 1; i++) {
			int minIndex = findMinimum(a, i);
			if (minIndex != i) {
				swap(a, i, minIndex);
			}
		}
	}

	// finds the smallest value in the array from a specific index
	private int findMinimum(int[] a, int first) {
		int minIndex = first;
		for (int i = first + 1; i < mySize; i++) {
			if (a[i] < a[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}

	// swaps two elements of an array
	public static void swap(int[] a, int i, int minIndex) {
		int temp = a[i];
		a[i] = a[minIndex];
		a[minIndex] = temp;
	}

	// returns value at inputed index or returns -999 if that value is non-existent
	public int getValue(int loc) {
		if (loc < 0 || loc > mySize - 1) {
			return -999;
		}
		return myArray[loc];
	}

	// returns the index of the first occurrence of target or -1 if there is none
	public int searchFor(int target) {
		for (int i = 0; i < mySize; i++) {
			if (myArray[i] == target) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * toString method returns all the numbers in the array
	 */
	public String toString() {
		String str = new String("[");
		for (int i = 0; i < mySize; i++) {
			str += myArray[i];
			if (i < mySize - 1) {
				str += ", ";
			}
		}
		str += "]";
		return str;
	}

	/*
	 * This method changes the size of the array when necessary it copies the
	 * original array's data onto another array, makes the original array bigger,
	 * then reassigns the values from the copy array to the original array
	 */
	private void resize() {
		int temp = myArray.length;
		int[] copyArray = new int[temp + 5];
		for (int i = 0; i < myArray.length; i++) {
			copyArray[i] = myArray[i];
		}
		myArray = new int[temp + 5];
		for (int i = 0; i < copyArray.length; i++) {
			myArray[i] = copyArray[i];
		}
	}
}
