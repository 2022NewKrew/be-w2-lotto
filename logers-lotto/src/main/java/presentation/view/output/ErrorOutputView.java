package presentation.view.output;

public class ErrorOutputView implements OutputView{
    private final RuntimeException runtimeException;

    public ErrorOutputView(RuntimeException runtimeException) {
        this.runtimeException = runtimeException;
    }

    @Override
    public void print() {
        System.out.println(runtimeException.getMessage());
        System.out.println("다시 프로그램을 실행하세요.");
    }
}
