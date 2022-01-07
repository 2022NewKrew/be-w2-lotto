package step5.exceptions;

public class DifferentSizeException extends RuntimeException {
    public DifferentSizeException(int insertedSize, int neededSize) {
        super(String.format("입력하신 로또번호의 개수에 문제가 있습니다. (입력하신 로또 번호 개수 = %d, 필요한 로또 번호 개수 = %d)",
                insertedSize, neededSize));
    }
}