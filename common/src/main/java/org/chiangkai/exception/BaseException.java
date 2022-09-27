package org.chiangkai.exception;

import org.chiangkai.domain.result.Api;
import org.chiangkai.domain.result.ApiCode;

import java.util.Date;

/**
 * @author ChiangKai
 * @date 2022/9/27
 */
public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getTraceLogId() {
        return traceLogId;
    }

    public void setTraceLogId(String traceLogId) {
        this.traceLogId = traceLogId;
    }

    public Date getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(Date errorTime) {
        this.errorTime = errorTime;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    private Integer code;

    private String ip;

    private String machineName;

    private String traceLogId;

    private Date errorTime;

    private String message;

    private String serverName;
}
