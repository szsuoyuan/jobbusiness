package com.sy.modules.exception;
/**
 * Created by sss on 2015/6/10.
 */
public interface ErrorCode {
    String getCode();
    String getDesc();
    String parse(Object... args);
}
