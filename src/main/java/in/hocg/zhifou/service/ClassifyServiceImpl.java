package in.hocg.zhifou.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import in.hocg.zhifou.domain.Classify;
import in.hocg.zhifou.mapper.ClassifyMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by hocgin on 2019/5/22.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
@Service
@AllArgsConstructor
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify>
        implements ClassifyService {
}
