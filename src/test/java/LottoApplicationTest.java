import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoApplicationTest {
    @Test
    @DisplayName("yaml 설정파일 읽기테스트")
    void readYaml() throws Exception {
        // given
        Yaml y = new Yaml();
        File file = new File("src/main/java/conf.yaml");
        Reader yamlFileReader = new FileReader(file);
        Map<String, Object> yamlMaps = y.load(yamlFileReader);
        System.out.println("yamlMaps.get(\"lottoConfig\") = " + yamlMaps.get("lottoConfig"));
        System.out.println("yamlMaps.get(\"lottoConfig\") = " + yamlMaps.get("lottoMarket"));







        // when

        // then

    }

}