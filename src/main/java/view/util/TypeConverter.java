package view.util;

public class TypeConverter {
    public static int strToInteger(String str){
        try{
            final int result = Integer.parseInt(str);
            Validator.isPositive(result);
            return result;
        }catch (NumberFormatException ex){
            throw new RuntimeException("잘못된 타입입니다. 양의 정수를 입력해주세요.");
        }
    }
}
