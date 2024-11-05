package org.william.galileoim.common.user.service;

import org.william.galileoim.common.user.domain.vo.request.oss.UploadUrlReq;
import org.william.galileoim.oss.domain.OssResp;

/**
 * <p>
 * oss 服务类
 * </p>
 *
 * @author <a href="https://github.com/zongzibinbin">abin</a>
 * @since 2023-03-19
 */
public interface OssService {

    /**
     * 获取临时的上传链接
     */
    OssResp getUploadUrl(Long uid, UploadUrlReq req);
}
