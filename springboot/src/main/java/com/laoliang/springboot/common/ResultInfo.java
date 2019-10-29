package com.laoliang.springboot.common;

import com.laoliang.springboot.exception.CommonException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

/**
 * @author laoliangliang
 * @date 2019/5/9 17:32
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class ResultInfo {
    private boolean flag;

    private int code;

    private String msg;

    private Object data;


    public ResultInfo(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public static ResultInfo ok() {
        return ok(null, "成功");
    }

    /**
     * 用来表示业务逻辑通顺，但数据不存在直接结束接下去的步骤
     * 比如查询对比交易配置，默认配置不存在，需要添加一次后才会存在，但第一次查到规则数据不存在就可以正常结束了，
     * 此时可以直接用{@link ResultInfo#ok()}返回默认的消息，也可以用此方法来自定义消息
     *
     * @param msg 消息
     */
    public static ResultInfo end(String msg) {
        return ok(null, msg);
    }

    public static ResultInfo ok(Object data) {
        return ok(data, null);
    }

    public static ResultInfo ok(Object data, String msg) {
        return new ResultInfo(true, HttpStatus.OK.value(), msg, data);
    }

    public static ResultInfo error(String msg, Object data) {
        throw new CommonException(new ResultInfo(false, HttpStatus.BAD_REQUEST.value(), msg, data));
    }

    public static ResultInfo error(String msg) {
        throw new CommonException(new ResultInfo(false, HttpStatus.BAD_REQUEST.value(), msg, null));
    }

    public static ResultInfo error() {
        throw new CommonException(new ResultInfo(false, HttpStatus.BAD_REQUEST.value(), "发生错误", null));
    }


    public ResultInfo msg(String msg) {
        return setMsg(msg);
    }
}
