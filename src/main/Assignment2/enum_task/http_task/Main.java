package enum_task.http_task;
import org.fluttercode.datafactory.impl.DataFactory;

public class Main {

    public static void main(String[] args) {

        Service httpService = new Service();
        DataFactory dataFactory = new DataFactory();

        httpService.processCode(dataFactory.getNumberBetween(100, 599));
        httpService.processCode(dataFactory.getNumberBetween(100, 599));
        httpService.processCode(dataFactory.getNumberBetween(100, 599));
        httpService.processCode(dataFactory.getNumberBetween(100, 599));
        httpService.processCode(dataFactory.getNumberBetween(100, 599));

    }
}
