package dto;

import java.util.ArrayList;
import java.util.List;

public class ResultDto {
    private List<String> messageList = new ArrayList<>();
    private float earningRate;

    public ResultDto(float earningRate) {
        this.earningRate = earningRate;
    }

    public ResultDto(List<String> messageList, float earningRate) {
        this.messageList = messageList;
        this.earningRate = earningRate;
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }

    public float getEarningRate() {
        return earningRate;
    }

    public void setEarningRate(float earningRate) {
        this.earningRate = earningRate;
    }
}
