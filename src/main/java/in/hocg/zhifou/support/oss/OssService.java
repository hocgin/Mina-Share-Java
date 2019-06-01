package in.hocg.zhifou.support.oss;

import com.google.common.hash.HashCode;
import com.google.common.io.Files;
import in.hocg.zhifou.util.LangKit;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

/**
 * Created by hocgin on 2019/6/1.
 * email: hocgin@gmail.com
 *
 * @author hocgin
 */
public interface OssService {
    
    /**
     * 获取文件名
     *
     * @param file
     * @return
     */
    @SneakyThrows
    default String filename(File file) {
        String prefix = Files.getFileExtension(file.getName());
        HashCode hashCode = LangKit.md5(Files.toByteArray(file));
        return String.format("%s.%s", hashCode.toString(), prefix);
    }
    
    /**
     * 上传文件
     *
     * @param file 文件
     * @return 保存的文件名
     * @throws IOException
     */
    String upload(File file) throws IOException;
    
    
    /**
     * 是否已经存在
     *
     * @param filename 保存的文件名
     * @return 是否存在
     */
    boolean isExist(String filename);
    
    
    /**
     * 删除文件
     *
     * @param filename 保存的文件名
     * @return 是否删除成功
     */
    void delete(String filename);
    
    
    
    /**
     * 查找文件
     *
     * @param filename 保存的文件名
     * @return 查找结果
     */
    Optional<InputStream> get(String filename);
}
