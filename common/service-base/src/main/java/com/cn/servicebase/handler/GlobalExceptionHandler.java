package com.cn.servicebase.handler;

import com.cn.servicebase.exception.CustomException;
import com.cn.utils.basics.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常类处理器
 * @Slf4j 等价于 private final static Logger logger = LoggerFactory.getLogger(xxx.class);
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //全局异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.error().message("全局异常处理");
    }

    //特定异常
    /*@ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e){
        e.printStackTrace();
        return Result.error().message("ArithmeticException异常处理");
    }*/

    //自定义异常
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result error(CustomException e){
        e.printStackTrace();
        return Result.error().code(e.getCode()).message(e.getMsg());
    }
}
