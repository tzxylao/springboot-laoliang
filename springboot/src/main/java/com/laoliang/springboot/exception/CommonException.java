package com.laoliang.springboot.exception;

import com.laoliang.springboot.common.ResultInfo;
import lombok.Data;

/**
 * @author laoliangliang
 * @date 2019/10/29 17:25
 */
@Data
public class CommonException extends RuntimeException {
    private ResultInfo resultInfo;

    public CommonException(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

}
