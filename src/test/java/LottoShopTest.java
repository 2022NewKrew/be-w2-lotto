import domain.LottoShop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.LottoGenerator;

import static org.junit.jupiter.api.Assertions.*;

class LottoShopTest {

    LottoShop lottoShop;

    @BeforeEach
    void setUp() {
        lottoShop = new LottoShop(new LottoGenerator());
    }


}