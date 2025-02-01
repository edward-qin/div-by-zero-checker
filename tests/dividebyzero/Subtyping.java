import org.checkerframework.checker.dividebyzero.qual.Bottom;
import org.checkerframework.checker.dividebyzero.qual.NotZero;
import org.checkerframework.checker.dividebyzero.qual.Top;
import org.checkerframework.checker.dividebyzero.qual.Zero;

// Test subtyping relationships for the Divide By Zero Checker.
// The file contains "// ::" comments to indicate expected errors and warnings.

@SuppressWarnings(
 "anno.on.irrelevant" 
)
class SubtypeTest {
  // I have NO idea why these annotations are marked as irrelevant and Subtyping checking does not work
  // I followed the example here and in the Checker Framework manual exactly
  public static void topBottomRelationship(@Top int x, @Bottom int y) {
    @Top int a = x;
    @Bottom int b = y;
    // :: error: assignment
    @Bottom int c = x;
    @Bottom int d = y;
  }

  public static void topZeroRelationship(@Top int x, @Zero int y) {
    @Top int a = x;
    @Zero int b = y;
    // :: error: assignment
    @Zero int c = x;
    @Zero int d = y;
  }
  
  public static void topNotZeroRelationship(@Top int x, @NotZero int y) {
    @Top int a = x;
    @NotZero int b = y;
    // :: error: assignment
    @NotZero int c = x;
    @NotZero int d = y;
  }

  public static void ZeroBottomRelationship(@Zero int x, @Bottom int y) {
    @Zero int a = x;
    @Bottom int b = y;
    // :: error: assignment
    @Bottom int c = x;
    @Bottom int d = y;
  }

  public static void NotZeroBottomRelationship(@NotZero int x, @Bottom int y) {
    @NotZero int a = x;
    @Bottom int b = y;
    // :: error: assignment
    @Bottom int c = x;
    @Bottom int d = y;
  }

  public static void ZeroNotZeroRelationship(@Zero int x, @NotZero int y) {
    @Zero int a = x;
    @NotZero int b = y;
    // :: error: assignment
    @NotZero int c = x;
    // :: error: assignment
    @Zero int d = y;
  }
}
