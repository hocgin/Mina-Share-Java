package in.hocg.zhifou.pojo.vo;

import in.hocg.zhifou.domain.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Data
public class UserVo {
    @ApiModelProperty(value = "ID", required = true)
    private Long id;
    
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    
    @ApiModelProperty(value = "头像", required = true)
    private String avatar = "https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png";
    
    
    public UserVo(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }
    
}
