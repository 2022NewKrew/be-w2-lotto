package domain;

import java.util.ArrayList;
import java.util.List;

//금액, 로또 리스트, 당첨번호
public interface IUser {

    default List<Integer> stringToList(String lottoStr){
        List<Integer> retVal = new ArrayList<Integer>();
        for(String lotto : lottoStr.split(",")){
            retVal.add(Integer.parseInt(lotto));
        }
        return retVal;
    }
}