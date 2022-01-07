package view.web.dto;


public class LottoTicketShowDto {

    private final String numbers;

    public LottoTicketShowDto(String numbers) {
        this.numbers = numbers;
    }

    public String getNumbers() {
        return numbers;
    }
}
