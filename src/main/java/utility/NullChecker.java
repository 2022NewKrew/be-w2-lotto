package utility;

public class NullChecker {
    public static void checkNull(Object target) {
        if (target == null) {
            throw new IllegalArgumentException("값이 Null 입니다.");
        }
    }
}
