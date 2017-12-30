/*
 * @author BikDS
 * The purpose of this class is to contain useful methods for working with a 
 * Rectangle object array
 * November 8, 2017
 */
public class FlexArrayRectangle implements Comparable<FlexArrayRectangle> {

	// mySize holds the logical size of the array
	private int mySize;
	// an array
	private Rectangle[] myArray;

	/*
	 * default createArray() method that creates an array with 20 elements
	 */
	public FlexArrayRectangle() {
		myArray = new Rectangle[20];
		mySize = 0;
	}

	/*
	 * This constructor takes a number and creates an array with that many number of
	 * elements
	 */
	public FlexArrayRectangle(int num) {
		myArray = new Rectangle[num];
		mySize = 0;
	}

	/*
	 * this method returns the number of active elements in the array Won't always
	 * be the length of the array
	 */
	public int getLength() {
		return mySize;
	}

	/*
	 * This method checks if the array is empty. Returns true if it is or else false
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
	public void append(Rectangle data) {
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
	public void insert(int index, Rectangle data) {
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
	public Rectangle discard(int index) {
		Rectangle returnMe;
		if (index < mySize) {
			mySize--;
			returnMe = myArray[index];
			for (int i = index; i < mySize - 1; i++) {
				myArray[i] = myArray[i + 1];
			}

		} else {
			returnMe = null;
		}
		return returnMe;
	}

	// returns the sum of the lengths of each active element
	private int getSumOfLengthsOfActiveElements() {
		int sum = 0;
		for (int i = 0; i < mySize; i++) {
			sum += myArray[i].myLength;
		}
		return sum;
	}

	// compares the sum of the active elements and returns an integer
	public int compareTo(FlexArrayRectangle f) {
		return getSumOfLengthsOfActiveElements() - f.getSumOfLengthsOfActiveElements();
	}

	// compares the number of active elements and checks if they are equal
	public boolean equals(FlexArrayRectangle f) {
		return (mySize == f.mySize);
	}

	// orders the array from low to high
	public void sort() {
		selectionSort(myArray);
	}

	// sorts the method from least to greatest
	public void selectionSort(Rectangle[] myArray) {
		for (int i = 0; i < mySize - 1; i++) {
			int minIndex = findMinimum(myArray, i);
			if (minIndex != i) {
				swap(myArray, i, minIndex);
			}
		}
	}

	// finds the smallest value in the array from a specific index
	private int findMinimum(Rectangle[] myArray, int first) {
		int minIndex = first;
		for (int i = first + 1; i < mySize; i++) {
			if (myArray[i].compareTo(myArray[minIndex]) < 0) {
				minIndex = i;
			}
		}
		return minIndex;
	}

	// swaps two elements of an array
	public static void swap(Rectangle[] myArray, int index, int otherIndex) {
		Rectangle temp = myArray[index];
		myArray[index] = myArray[otherIndex];
		myArray[otherIndex] = temp;
	}

	/*
	 * this method returns the value at the inputed index
	 */
	public Rectangle getValue(int loc) {
		if (loc < 0 || loc > mySize - 1) {
			return null;
		}
		return myArray[loc];
	}

	/*
	 * this method returns the first instance of target in the Rectangle array
	 */
	public int searchFor(Rectangle target) {
		for (int i = 0; i < mySize; i++) {
			if (myArray[i].equals(target)) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * toString method returns the width and height of every rectangle in the
	 * rectangle array
	 */
	public String toString() {
		String str = "[";
		for (int i = 0; i < mySize - 1; i++) {
			str += "Rectangle, width = " + myArray[i].getWidth() + " length = " + myArray[i].getLength() + " area = "
					+ myArray[i].getWidth() * myArray[i].getLength() + "\n";
		}
		if (mySize > 0) {
			str += "Rectangle, width = " + myArray[mySize - 1].getWidth() + " length = "
					+ myArray[mySize - 1].getLength() + " area = "
					+ myArray[mySize - 1].getWidth() * myArray[mySize - 1].getLength();
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
		Rectangle[] copyArray = new Rectangle[temp + 5];
		for (int i = 0; i < myArray.length; i++) {
			copyArray[i] = myArray[i];
		}
		myArray = new Rectangle[temp + 5];
		for (int i = 0; i < copyArray.length; i++) {
			myArray[i] = copyArray[i];
		}
	}

}
