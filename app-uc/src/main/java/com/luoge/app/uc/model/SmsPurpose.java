package com.luoge.app.uc.model;

public enum SmsPurpose {
    LOGIN_VERIFY(1, "4ad26afe0df34778ab91a1e36aa1a65a", "8824011608176");

    public final int code;
    public final String templateId;
    public final String channelNo;

    SmsPurpose(int code, String templateId, String channelNo) {
        this.code = code;
        this.templateId = templateId;
        this.channelNo = channelNo;
    }

}
