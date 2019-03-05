package com.lgh.aio.entity;

/**
 * @description:封装json对象，所有返回结果都使用它
 **/
public class Result<T> {

    private int code;// 业务自定义状态码

    private String msg;// 请求状态描述，调试用

    private T data;// 请求数据，对象或数组均可

    public Result() {
    }

    /**
     * 成功时候的调用
     *
     * @param data data
     * @param <T>  t
     * @return Result
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    /**
     * 失败时候的调用
     *
     * @param codeMsg codeMsg
     * @param <T>     t
     * @return Result
     */
    public static <T> Result<T> error(CodeMsg codeMsg) {
        return new Result<T>(codeMsg);
    }

    /**
     * 成功的构造函数
     *
     * @param data data
     */
    private Result(T data) {
        this.code = 200;//默认200是成功
        this.msg = "ok";
        this.data = data;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 失败的构造函数
     *
     * @param codeMsg codeMsg
     */
    private Result(CodeMsg codeMsg) {
        if (codeMsg != null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
