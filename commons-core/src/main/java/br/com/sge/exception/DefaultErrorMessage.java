package br.com.sge.exception;

public record DefaultErrorMessage(
    String message,
    String path,
    String method,
    int status
) {

}
