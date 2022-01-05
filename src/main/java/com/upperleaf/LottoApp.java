package com.upperleaf;

import com.upperleaf.web.LottoWebApp;

public class LottoApp {
    public static void main(String[] args) {
        LottoWebApp webApp = new LottoWebApp();
        webApp.start(8080);
    }
}
