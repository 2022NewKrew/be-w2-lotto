package input;

import input.dto.InputInfo;

import java.util.List;

public interface InputView {
    public InputInfo getBuyInfo();
    public void getTargetNum(InputInfo inputInfo);
}
