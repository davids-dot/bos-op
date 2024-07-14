package com.luoge.bos.op.core.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

public class EncryptUtil {

    public static String crypt(String passwd) {
        Digester digester = new Digester(DigestAlgorithm.MD5);
        return digester.digestHex(passwd);
    }
}
