package com.upperleaf;

import com.upperleaf.web.LottoWebApp;

import java.sql.SQLException;

public class LottoApp {
    public static void main(String[] args) throws SQLException {
        LottoWebApp webApp = new LottoWebApp();
        webApp.start(8080);
    }
}
