package client.web;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import com.google.gson.Gson;
import controller.LottoController;
import controller.dto.LottoListDTO;
import controller.dto.LottoResultDTO;
import controller.dto.PurchaseDTO;
import controller.dto.SimulateDTO;
import java.sql.Timestamp;
import java.util.HashMap;
import org.eclipse.jetty.http.HttpHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.LottoService;
import spark.ModelAndView;
import spark.Request;
import spark.template.mustache.MustacheTemplateEngine;

public class WebListener {

  private final Gson parser;
  private final LottoController controller;
  private final Logger logger = LoggerFactory.getLogger(WebListener.class);

  public WebListener() {
    this.parser = new Gson();
    this.controller = new LottoController(new LottoService());
  }


  public void listen(int port) {
    port(port);
    try{
      router();
    }catch(Exception e) {
      e.printStackTrace();
      logger.debug("ee : {}", e.getMessage());
    }

  }


  private void router() {

    post("/lotto/purchase", (req, res) -> {
      logRequest(req);
      LottoListDTO pdto = controller.buyLotto(new PurchaseDTO(req));
      return render(pdto, "/show.html");
    });

    post("/lotto/simulation", (req, res) -> {
      logRequest(req);
      LottoResultDTO result = controller.simulateLottery(new SimulateDTO(req));
      return render(result, "result.html");
    });

    get("/", (req, res) -> {
      return render(new HashMap<>(), "/index.html");
    });

  }


  private String render(Object model, String path) {
    return new MustacheTemplateEngine().render(new ModelAndView(model, path));
  }


  private void logRequest(Request req) {
    logger.info("START REQUEST ----------------------------------------------------------------");
    logger.info("url : {}", req.url());
    logger.info("time : {}", new Timestamp(System.currentTimeMillis()));
    logger.info("content-type : {}", req.headers(String.valueOf(HttpHeader.CONTENT_TYPE)));
    logger.info("query : {}", req.queryString());
    logger.info("queryParams: {}", req.queryParams());
    logger.info("body : {}", req.body());
    logger.info("END REQUEST-------------------------------------------------------------------");
  }

}
