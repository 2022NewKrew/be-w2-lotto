package lotto.util.input;

import java.util.Scanner;

public interface ConsoleInputInterface<T> {
    Scanner sc = new Scanner(System.in);

    String getMessage();

    T convert(String inputString);

    //TODO - 입력 실패시 try-catch
    default T read(boolean viewMessage){
        if(viewMessage)
            System.out.println(getMessage());

        final String inputStr = sc.nextLine();

        return convert(inputStr);
    }

}
