package spock


import spock.lang.Specification

/**
 * @Author hezhensheng* @Date 2021/4/12
 * @Description
 */
class CsvUtilsTest extends Specification {

    void setup() {
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
