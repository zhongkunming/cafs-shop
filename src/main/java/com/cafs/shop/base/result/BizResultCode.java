package com.cafs.shop.base.result;

public enum BizResultCode implements IResultCode {
    SUCCESS(0, "操作成功"),
    FAILURE(-1, "操作失败");

    final int code;
    final String message;

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    private BizResultCode(final int code, final String message) {
        this.code = code;
        this.message = message;
    }
}