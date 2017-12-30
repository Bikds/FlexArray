
/**
 * @author BikDS
 * The purpose of this class is to test FlexArrayPrimitive.java and
 * FlexArrayRectangle.java
 */
public class FlexArrayDriver {

	public static void main(String[] args) {

		// version 2.0
		FlexArrayPrimitive p1 = new FlexArrayPrimitive();
		FlexArrayPrimitive p2 = new FlexArrayPrimitive();
		FlexArrayPrimitive p3 = new FlexArrayPrimitive();

		FlexArrayRectangle r1 = new FlexArrayRectangle();
		FlexArrayRectangle r2 = new FlexArrayRectangle();
		FlexArrayRectangle r3 = new FlexArrayRectangle();

		int[] list1 = { 3, 65, 45, 2, 86 };
		int[] list2 = { 65, 45, 2, 86, 3 };
		int[] list3 = { 4, 1, 0 };
		Rectangle[] list4 = { new Rectangle(9, 8), new Rectangle(8, 8), new Rectangle(7, 9) };
		Rectangle[] list5 = { new Rectangle(8, 6), new Rectangle(9, 8), new Rectangle(7, 6) };
		Rectangle[] list6 = { new Rectangle(4, 5) };

		for (int i = 0; i < list1.length; i++) {
			p1.append(list1[i]);
		}
		for (int i = 0; i < list2.length; i++) {
			p2.append(list2[i]);
		}
		for (int i = 0; i < list3.length; i++) {
			p3.append(list3[i]);
		}
		for (int i = 0; i < list4.length; i++) {
			r1.append(list4[i]);
		}
		for (int i = 0; i < list5.length; i++) {
			r2.append(list5[i]);
		}
		for (int i = 0; i < list6.length; i++) {
			r3.append(list6[i]);
		}
		/*
		 * Test compareTo()
		 */
		System.out.println("\nThis is the test for compareTo()");
		System.out.println(p1.compareTo(p2));
		System.out.println(p2.compareTo(p3));
		System.out.println(p3.compareTo(p1));
		System.out.print("\n");
		System.out.println(r1.compareTo(r2));
		System.out.println(r2.compareTo(r3));
		System.out.println(r3.compareTo(r1));

		/*
		 * Test equals()
		 */
		System.out.println("\nThis is the test for equals()");
		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p3));
		System.out.println(p3.equals(p1));
		System.out.print("\n");
		System.out.println(r1.equals(r2));
		System.out.println(r2.equals(r3));
		System.out.println(r3.equals(r1));

		/*
		 * Test sort() method
		 */
		System.out.println("\nThis is the test for sort()");
		p1.sort();
		System.out.println(p1);
		r1.sort();
		System.out.println(r1);

		/*
		 * Test for getValue()
		 */
		System.out.println("\nThis is the test for getValue()");
		System.out.println(p1);
		System.out.println(p1.getValue(2));
		System.out.println(p1.getValue(0));
		System.out.println(p1.getValue(4));
		System.out.println(p1.getValue(5));
		System.out.println(r1);
		System.out.println(r1.getValue(1));
		System.out.println(r1.getValue(0));
		System.out.println(r1.getValue(2));
		System.out.println(r1.getValue(3));

		/*
		 * Test for searchFor()
		 */
		System.out.println("\nThis is the test for searchFor()");
		System.out.println(p1);
		System.out.println(p1.searchFor(65));
		System.out.println(p1.searchFor(1));
		System.out.println(r1);
		Rectangle rTest = new Rectangle(7, 9);
		Rectangle rFailTest = new Rectangle(1, 1);
		System.out.println(r1.searchFor(rTest));
		System.out.println(r1.searchFor(rFailTest));

		System.out.println(r1);

		/*
		 * Print out the final values
		 * 
		 * System.out.println("\n" + p1 + "\n"); System.out.println(p2 + "\n");
		 * System.out.println(p3 + "\n"); System.out.println(r1 + "\n");
		 * System.out.println(r2 + "\n"); System.out.println(r3);
		 */
		/*
		 * version 1.0 FlexArrayPrimitive x = new FlexArrayPrimitive(1); x.append(1);
		 * x.append(2); System.out.println(x); x.insert(1, 5); System.out.println(x);
		 * x.discard(0); System.out.println(x); x.append(69); System.out.println(x);
		 * System.out.println(x.getLength()); x.discard(0); System.out.println(x);
		 * x.discard(1); System.out.println(x); x.discard(0); System.out.println(x);
		 * System.out.println(x.isEmpty()); FlexArrayRectangle y = new
		 * FlexArrayRectangle(); System.out.println(y); y.append(new Rectangle(10,10));
		 * y.append(new Rectangle(10,10)); System.out.println(y); y.insert(1, new
		 * Rectangle(13, 44)); System.out.println(y); System.out.println(y.discard(1));
		 * System.out.println(y);
		 */

		/*
		 * FlexArrayPrimitive prim = new FlexArrayPrimitive(); FlexArrayRectangle rect =
		 * new FlexArrayRectangle(); int[] array = { 4, 6, -8, 2, 6 }; for (int i = 0; i
		 * < array.length; i++) { prim.append(array[i]); } System.out.println(prim);
		 * prim.insert(3, 3); System.out.println(prim); int x = prim.discard(0);
		 * System.out.println("Item discarded: " + x); System.out.println(prim);
		 * 
		 * rect.append(new Rectangle(2, 3)); rect.append(new Rectangle(4, 5));
		 * rect.append(new Rectangle(1, 3)); rect.append(new Rectangle(4, 3));
		 * rect.append(new Rectangle(5, 3)); rect.append(new Rectangle(3, 4));
		 * System.out.println(rect.toString()); rect.insert(10, new Rectangle(7, 6));
		 * System.out.println(rect.toString()); System.out.println(rect.discard(2));
		 * System.out.println(rect.toString()); System.out.println(rect.getLength());
		 * System.out.println(rect.isEmpty());
		 */
	}

}
