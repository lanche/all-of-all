package spock

import io.CsvUtils
import io.model.Flow
import spock.lang.Specification
import sun.nio.cs.ext.GBK

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 * @Author hezhensheng* @Date 2021/4/12
 * @Description
 */
class CsvUtilsTest extends Specification {

    void setup() {
    }

    def "length of Spock's and his friends' names"() {
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }

    def "parseAdnHandle"() {
        setup:
        String fileName = "src/test/resources/账单字段样例.csv"
        when:
/*        Path myPath = Paths.get(fileName);

        BufferedReader br = Files.newBufferedReader(myPath,
                new GBK())
        CsvUtils.parse(br, Flow.class, { e ->
            System.out.println(e.toString());
        });*/
        CsvUtils.handle(fileName)

        then:
        noExceptionThrown()
    }

}
