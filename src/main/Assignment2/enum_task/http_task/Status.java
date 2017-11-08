package enum_task.http_task;

import java.time.temporal.ValueRange;

import enum_task.http_task.handlers.Handler;
import enum_task.http_task.handlers.InfoHandler;
import enum_task.http_task.handlers.SuccessHandler;
import enum_task.http_task.handlers.RedirectHandler;
import enum_task.http_task.handlers.ClientErrorHandler;
import enum_task.http_task.handlers.ServerErrorHandler;


public enum Status {
    INFORMATIONAL(ValueRange.of(100, 199), new InfoHandler()),
    SUCCESS(ValueRange.of(200, 299), new SuccessHandler()),
    REDIRECTION(ValueRange.of(300, 399), new RedirectHandler()),
    CLIENT_ERROR(ValueRange.of(400, 499), new ClientErrorHandler()),
    SERVER_ERROR(ValueRange.of(500, 599), new ServerErrorHandler());

    private ValueRange range;

    private Handler handler;

    Status(ValueRange range, Handler handler) {
        this.range = range;
        this.handler = handler;
    }

    public static Status findByCode(int code){
        for (Status v : values()) {
            if (v.range.isValidIntValue(code)){
                return v;
            }
        }
        return SERVER_ERROR;
    }

    public Handler getHandler() {
        return handler;
    }
}