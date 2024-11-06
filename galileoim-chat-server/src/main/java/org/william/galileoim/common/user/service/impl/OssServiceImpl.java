package org.william.galileoim.common.user.service.impl;

import org.william.galileoim.common.common.utils.AssertUtil;
import org.william.galileoim.common.user.domain.enums.OssSceneEnum;
import org.william.galileoim.common.user.domain.vo.request.oss.UploadUrlReq;
import org.william.galileoim.common.user.service.OssService;
import org.william.galileoim.oss.MinIOTemplate;
import org.william.galileoim.oss.domain.OssReq;
import org.william.galileoim.oss.domain.OssResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Author: <a href="https://github.com/zongzibinbin">abin</a>
 * Date: 2023-06-20
 */
//@Service
//public class OssServiceImpl implements OssService {
//    @Autowired
//    private MinIOTemplate minIOTemplate;
//
//    @Override
//    public OssResp getUploadUrl(Long uid, UploadUrlReq req) {
//        OssSceneEnum sceneEnum = OssSceneEnum.of(req.getScene());
//        AssertUtil.isNotEmpty(sceneEnum, "场景有误");
//        OssReq ossReq = OssReq.builder()
//                .fileName(req.getFileName())
//                .filePath(sceneEnum.getPath())
//                .uid(uid)
//                .build();
//        return minIOTemplate.getPreSignedObjectUrl(ossReq);
//    }
//}
