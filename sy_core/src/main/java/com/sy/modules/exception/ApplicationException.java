package com.sy.modules.exception;

/**
 * Created by sss on 2015/6/10.
 */
public class ApplicationException extends Exception {

	private static final long serialVersionUID = -5751599522177178250L;
	private String code;

    public ApplicationException(ErrorCode e) {
        this(e, null, (Object[]) null);
    }

    public ApplicationException(ErrorCode e, Object... arguments) {
        this(e, null, arguments);
    }

    public ApplicationException(ErrorCode e, Exception err, Object... args) {
        super(e.parse(args), err);
        this.code = e.getCode();
    }

    public ApplicationException(String code, String description, Exception ex) {
        super(description, ex);
        this.code = code;
    }

    public ApplicationException(String code, String description) {
        super(description);
        this.code = code;
    }

    public ApplicationException(String description) {
        super(description);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
