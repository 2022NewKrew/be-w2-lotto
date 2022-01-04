import domain.controller.LottoManager;
import model.MemoryRepository;
import org.yaml.snakeyaml.Yaml;
import view.ConsoleLottoUI;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class LottoApplication {

    public static void main(String[] args) throws Exception {

        // 환경설정
        Map<String, Object> config = readConfig("conf.yaml");

        // Controller, Model, View 연결
        LottoManager lottoManager = new LottoManager(new MemoryRepository(), new ConsoleLottoUI(), 1L, config);
        lottoManager.run();
    }

    public static Map<String, Object> readConfig(String path) {
        Yaml y = new Yaml();
        Map<String, Object> yamlMap = null;
        try {
            yamlMap = y.load(new FileReader("src/main/resources/" + path));

        } catch (FileNotFoundException e) {
            System.out.println("설정파일인 conf.yaml 파일이 resources에 존재하지 않습니다.");
            System.exit(0);
        }
        return yamlMap;

    }
}
