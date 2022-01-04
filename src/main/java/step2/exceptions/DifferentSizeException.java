package step2.exceptions;

public class DifferentSizeException extends RuntimeException {
    public DifferentSizeException(int insertedSize, int neededSize) {
        super(String.format("입력하신 결과와 필요한 개수가 다릅니다. (압력하신 결과 개수 = %d, 필요한 결과 개수 = %d)",
                insertedSize, neededSize));
    }
}