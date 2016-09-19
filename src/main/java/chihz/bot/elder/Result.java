package chihz.bot.elder;

/**
 * 描述接口的返回结果
 * Created by chihongze on 16/9/19.
 */
public class Result<T> {

    public static final int STATUS_OK = 200;

    public static final int STATUS_BAD_REQUEST = 400;

    public static final int STATUS_NOT_FOUND = 404;

    public static final int STATUS_SERVICE_ERROR = 500;

    public static <T> Result<T> ok() {
        return new Result(STATUS_OK, null, null, null);
    }

    public static <T> Result<T> ok(T data) {
        return new Result(STATUS_OK, null, null, data);
    }

    public static <T> Result<T> badRequest(String reason, String msg) {
        return new Result(STATUS_BAD_REQUEST, reason, msg, null);
    }

    private final int statusCode;

    private final String reason;

    private final String msg;

    private final T data;

    public Result(int statusCode, String reason, String msg, T data) {
        this.statusCode = statusCode;
        this.reason = reason;
        this.msg = msg;
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getReason() {
        return reason;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
