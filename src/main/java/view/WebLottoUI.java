package view;

import controller.LottoController;
import domain.lotto.LottoNumberContainerDTO;
import domain.lotto.LottoNumberDTO;
import domain.match.LottoMatchStateDTO;
import domain.match.WinningLottoNumberDTO;
import domain.user.NormalUser;
import domain.user.User;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.TemplateEngine;
import spark.ModelAndView;
import spark.Route;

import java.util.*;
import java.util.stream.Collectors;

public class WebLottoUI implements LottoUI{
    private final TemplateEngine templateEngine = new HandlebarsTemplateEngine();
    private final LottoController lottoController;
    private final User user = new NormalUser(1L);

    public WebLottoUI(LottoController lottoController) {
        this.lottoController = lottoController;
    }

    public Route buyLottosWebResponse() {
        return ((request, response)->{
            // 세션 확인 흉내
            User user = this.user;

            // 유저의 자료를 받고
            int inputMoney = safeParseInt(request.queryParams("inputMoney"));
            LottoNumberContainerDTO lottoNumberContainerDTO = safeParseLottoNumberContainerDTO(request.queryParams("manualNumber"));

            // Controller 에서 처리한 뒤
            lottoController.saveUserBudget(user, inputMoney);
            int buyNum = lottoController.getBuyLottoNumber(user);
            int buyManualLottoNumber = lottoNumberContainerDTO.getLottoNumbers().size();
            lottoController.addManualLottosToUser(user, lottoNumberContainerDTO);

            lottoController.buyRandomLottos(user, buyNum - buyManualLottoNumber);
            LottoNumberContainerDTO userLottos = lottoController.getUserLottos(user);

            Map model = new HashMap<>();
            model.put("lottosSize", buyNum);
            if (buyNum>0){
                model.put("lottos", userLottos.getLottoNumbers().stream().map(value-> Map.of("numbers", value.getArrayListInteger().toString())).collect(Collectors.toList()));
            }
            return templateEngine.render(new ModelAndView(model,"/show.html"));
        });
    }


    public Route matchLottoWebResponse() {
        return ((request, response)->{
            // 세션 확인 흉내
            User user = this.user;

            WinningLottoNumberDTO winningLottoNumberDTO = safeParseWinningLottoNumbers(request.queryParams("winningNumber"), request.queryParams("bonusNumber"));
            lottoController.setWinningLottoNumber(winningLottoNumberDTO);
            LottoMatchStateDTO lottoMatchStateDTO = lottoController.result(user);

            Map model = new HashMap<>();
            model.put("lottosResult", true);
            model.put("totalRateOfReturn", String.format("%.2f", ((float)lottoMatchStateDTO.getMoneyTotalWin())/lottoMatchStateDTO.getMoneyTotalCost()*100));

            return templateEngine.render(new ModelAndView(model,"/result.html"));
        });

    }
    private WinningLottoNumberDTO safeParseWinningLottoNumbers(String basic, String extra) {
        ArrayList<Integer> basicNumbers = Arrays.stream(basic.split(",")).map(Integer::parseInt).collect(ArrayList::new, List::add, List::addAll);
        ArrayList<Integer> extraNumbers = Arrays.stream(extra.split(",")).map(Integer::parseInt).collect(ArrayList::new, List::add, List::addAll);

        return new WinningLottoNumberDTO(basicNumbers, extraNumbers);
    }

    private LottoNumberContainerDTO safeParseLottoNumberContainerDTO(String lines) {
        LottoNumberContainerDTO dto = new LottoNumberContainerDTO();
        List<LottoNumberDTO> collect = Arrays.stream(lines.split("\\r?\\n")).map(line -> new LottoNumberDTO(Arrays.stream(line.split(",")).map(Integer::parseInt).collect(ArrayList::new, List::add, List::addAll))).collect(Collectors.toList());
        for (LottoNumberDTO lottoNumberDTO : collect) {
            dto.addLottoNumber(lottoNumberDTO);
        }
        return dto;
    }
    private int safeParseInt(String str){
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int askUserBudget() {
        return 0;
    }

    @Override
    public int askUserHowManyManualNumberLotto(int buyLimitNum) {
        return 0;
    }

    @Override
    public LottoNumberContainerDTO askUserManualLottoNumbers(int num) {
        return null;
    }

    @Override
    public void showBoughtLottos(int manualLottosNum, int randomLottosNum, LottoNumberContainerDTO lottoNumberContainerDTO) {
    }


    @Override
    public WinningLottoNumberDTO askUserWinningNumbers() {
        return null;
    }

    @Override
    public void showResult(LottoMatchStateDTO lottoMatchStateDTO) {

    }
}
