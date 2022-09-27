package org.chiangkai.util;

/**
 * @author ChiangKai
 * @date 2022/9/27
 */
public class ExcpUtil {
    /**
     * 打印异常堆栈信息
     *
     * @param ex 异常
     * @return {@link String}
     */
    public static String getStackTraceString(Throwable ex) {//(Exception ex) {
        StackTraceElement[] traceElements = ex.getStackTrace();

        StringBuilder traceBuilder = new StringBuilder();

        if (traceElements != null && traceElements.length > 0) {
            for (StackTraceElement traceElement : traceElements) {
                traceBuilder.append(traceElement.toString());
                traceBuilder.append("\n");
            }
        }

        return traceBuilder.toString();
    }

    /**
     * 构造异常堆栈信息
     *
     * @param ex 异常
     * @return {@link String}
     */
    public static String buildErrorMessage(Throwable ex) {

        String result;
        String stackTrace = getStackTraceString(ex);
        String exceptionMessage = ex.toString();
        result = String.format("exceptionMessage : %s \r\nstackTrace:\n%s", exceptionMessage, stackTrace);

        return result;
    }


}