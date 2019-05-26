package in.hocg.zhifou.util.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

/**
 * @author hocgin
 * @date 2017/10/14
 * email: hocgin@gmail.com
 * 响应结果对象
 */
@ApiModel("响应")
public class Result<T> implements Serializable {
    @ApiModelProperty(value = "状态码", required = true, example = "200")
    private int code;
    @ApiModelProperty(value = "消息", required = true, example = "ok")
    private String message;
    @ApiModelProperty(value = "响应", required = true)
    private T data;
    
    private Result() {
    }
    
    public static Result newInstance() {
        return new Result();
    }
    
    public static Result result(boolean result) {
        return result ? success() : error();
    }
    
    public int getCode() {
        return code;
    }
    
    public Result setCode(int code) {
        this.code = code;
        return this;
    }
    
    public String getMessage() {
        return message;
    }
    
    public Result setMessage(String message) {
        this.message = message;
        return this;
    }
    
    public T getData() {
        return data;
    }
    
    public Result setData(T data) {
        this.data = data;
        return this;
    }
    
    
    public static <T> Result<T> success(T data) {
        return Result.result(Code.SUCCESS.code, Code.SUCCESS.message, data);
    }
    
    public static <T> Result<T> success() {
        return Result.success(null);
    }
    
    public static <T> Result<T> result(Integer code, String message) {
        return Result.result(code, message, null);
    }
    
    public static <T> Result<T> error(String message) {
        return Result.result(Code.ERROR.code, message, null);
    }
    
    public static <T> Result<T> error() {
        return Result.result(Code.ERROR.code, Code.ERROR.message, null);
    }
    
    public static <T> Result<T> result(Integer code, String message, T data) {
        Result<T> result = new Result<>();
        return result.setCode(code)
                .setMessage(message)
                .setData(data);
    }
    
    public ResponseEntity<Result<T>> asResponseEntity() {
        return ResponseEntity.ok(this);
    }
    
    public String toJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "{}";
    }
}
