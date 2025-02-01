public class StudentProvidedTests {
  public static void bottomNoError() {
    int one = 1;
    int zero = 0;
    // :: error: divide.by.zero
    int x = one / zero; // x is Bottom
    int y = zero / one; // y is Zero
    int z = one / x;    // z is Bottom

    x = x * zero;       // x is Bottom
    x = x + one;        // x is Bottom
    z = one / x;        // z is Bottom
    String s = "hello";
  }

  public static void fourPoints() {
    int zero = 0;
    int one = 1;
    int two = 2;
    int top = one + two;
    // :: error: divide.by.zero
    int bottom = one / top;
    top = two / one;

    int notZero = zero - two;
    zero = zero % one;
    // :: error: divide.by.zero
    bottom = zero % zero;
    // :: error: divide.by.zero
    bottom = one % zero;
  }

  public static void refinement() {
    int zero = 0;
    int one = 1;
    int two = 2;
    int top = one + two;
    if (zero == 0) {
      // :: error: divide.by.zero
      int x = two / zero;    // zero is Zero
    } else {
      int y = two / zero;    // zero is Bottom
    }
    if (one == 0) {
      int x = two / one;    // one is Bottom
    } else {
      int y = two / one;    // one is NotZero
    }
    if (top == 0) {
      // :: error: divide.by.zero
      int x = two / top;    // top is Zero
    } else {
      int y = two / top;    // top is NotZero
    }
    if (top <= 1) {
      // :: error: divide.by.zero
      int x = two / top;    // top is Top
    } else {
      // :: error: divide.by.zero
      int y = two / top;    // top is Top
    }
  }
}
