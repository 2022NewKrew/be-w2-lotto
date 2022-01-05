package dto.response;

public class LottoPurchaseAmount {
	private final int totalAmount;
	private final int customAmount;
	private final int autoAmount;

	public LottoPurchaseAmount(int totalAmount, int customAmount, int autoAmount) {
		this.totalAmount = totalAmount;
		this.customAmount = customAmount;
		this.autoAmount = autoAmount;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public int getCustomAmount() {
		return customAmount;
	}

	public int getAutoAmount() {
		return autoAmount;
	}
}
