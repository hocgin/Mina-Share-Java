package in.hocg.zhifou.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import in.hocg.zhifou.support.mybatis.SuperModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Created by hocgin on 2019/6/1.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Data
@TableName("t_website")
@ApiModel("文章关联网址表")
public class Website extends SuperModel<Website> {
    
    @TableField("post_id")
    @ApiModelProperty(value = "关联文章 ID", required = true)
    private Long postId;
    
    @TableField("website")
    @ApiModelProperty(value = "网址", required = true)
    private String website;
    
    @TableField("created_at")
    @ApiModelProperty(value = "创建时间", required = true)
    private LocalDateTime createdAt = LocalDateTime.now();
}
