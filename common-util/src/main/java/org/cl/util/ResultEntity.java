package org.cl.util;

import lombok.ToString;

import java.io.Serializable;

/**
 * @author chenlin
 * @create 2020-05-18 22:50
 * @description: 用于统一项目中所有 Ajax 请求的返回值类型
 *              未来也可以用于分布式架构各个模块间调用时返回统一类型
 * @version：1.0
 **/
@ToString
public class ResultEntity<T> implements Serializable {

    public static final String SUCCESS = "SUCCESS";

    public static final String FAILED = "FAILED";

    /**用来封装当前请求处理的结果是成功还是失败*/
    private String success;
    /**请求处理失败时返回的错误消息*/
    private String message;
    /***要返回的数据*/
    private T data;

    public ResultEntity(){

    }

    public ResultEntity(String success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    /**
     * 方法作用：请求处理成功且不需要返回数据时使用的工具方法
     * @param
     * @return: org.cl.util.ResultEntity<Type>
     * @createDate:  2020/5/18 23:04
     * @createAuthor: chenlin
     * @updateDate:  2020/5/18 23:04
     * @updateAuthor:  修改作者
     * @updateRemark:  修改内容
     **/
    public static <Type> ResultEntity<Type> successWithoutData(){
        return new ResultEntity<Type>(SUCCESS,null,null);
    }

    /**
     * 方法作用：请求处理成功且需要返回数据时使用的工具方法
     * @param data 返回的数据对象
     * @return: org.cl.util.ResultEntity<Type>
     * @createDate:  2020/5/18 23:05
     * @createAuthor: chenlin
     * @updateDate:  2020/5/18 23:05
     * @updateAuthor:  修改作者
     * @updateRemark:  修改内容
     **/
    public static <Type> ResultEntity<Type> successWithData(Type data){
        return new ResultEntity<Type>(SUCCESS,null,data);
    }

    /**
     * 方法作用：请求处理失败后使用的工具方法
     * @param message 失败的提示消息
     * @return: org.cl.util.ResultEntity<Type>
     * @createDate:  2020/5/18 23:05
     * @createAuthor: chenlin
     * @updateDate:  2020/5/18 23:05
     * @updateAuthor:  修改作者
     * @updateRemark:  修改内容
     **/
    public static <Type> ResultEntity<Type> failed(String message){
        return new ResultEntity<>(FAILED,message,null);
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
