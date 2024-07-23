package com.luoge.bos.common;

import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.luoge.ns.core.AppException;
import com.luoge.ns.core.Code;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;

public class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);


    private JsonUtil() {
    }

    public static String toJsonString(Object o) {
        try {
            return JSONObject.toJSONString(o);
        } catch (Exception e) {
            logger.error("object:{},serialize error ", o, e);
            throw new AppException(Code.ILLEGAL_PARAMETER, e);
        }
    }

    public static <T> T parse(String json, Class<T> clazz) {
        try {
            return JSONObject.parseObject(json, clazz);
        } catch (Exception e) {
            logger.error("json str:{}  ,parse error ", json, e);
            throw new AppException(Code.ILLEGAL_PARAMETER, e);
        }
    }

    public static <T> T parse(String json, TypeReference<T> reference) {
        try {
            return JSONObject.parseObject(json, (Type) reference);
        } catch (Exception e) {
            logger.error("json str:{}  ,parse error ", json, e);
            throw new AppException(Code.ILLEGAL_PARAMETER, e);
        }
    }


    public static <T> T safeParse(String json, Class<T> clazz) {
        try {
            return JSONObject.parseObject(json, clazz);
        } catch (Exception e) {
            logger.error("json str:{}  ,parse error ", json, e);
            return null;
        }
    }


}

