package enum_task.http_task;

public class Service {
    public void processCode(int code) {
        Status status = Status.findByCode(code);
        // call handler
        status.getHandler().handle();
    }
}