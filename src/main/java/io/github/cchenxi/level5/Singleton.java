package io.github.cchenxi.level5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

/**
 * 单例，枚举
 * Date: 2021-10-04
 *
 * @author chenxi
 */
public enum Singleton {
    INSTANCE;

    public void method() {}
}
