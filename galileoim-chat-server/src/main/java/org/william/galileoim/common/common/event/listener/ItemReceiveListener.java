package org.william.galileoim.common.common.event.listener;

import org.william.galileoim.common.common.event.ItemReceiveEvent;
import org.william.galileoim.common.user.dao.UserDao;
import org.william.galileoim.common.user.domain.entity.ItemConfig;
import org.william.galileoim.common.user.domain.entity.User;
import org.william.galileoim.common.user.domain.entity.UserBackpack;
import org.william.galileoim.common.user.domain.enums.ItemTypeEnum;
import org.william.galileoim.common.user.service.cache.ItemCache;
import org.william.galileoim.common.user.service.cache.UserCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 用户收到物品监听器
 *
 * @author zhongzb create on 2022/08/26
 */
@Slf4j
@Component
public class ItemReceiveListener {
    @Autowired
    private UserDao userDao;
    @Autowired
    private ItemCache itemCache;
    @Autowired
    private UserCache userCache;

    /**
     * 徽章类型，帮忙默认佩戴
     *
     * @param event
     */
    @Async
    @EventListener(classes = ItemReceiveEvent.class)
    public void wear(ItemReceiveEvent event) {
        UserBackpack userBackpack = event.getUserBackpack();
        ItemConfig itemConfig = itemCache.getById(userBackpack.getItemId());
        if (ItemTypeEnum.BADGE.getType().equals(itemConfig.getType())) {
            User user = userDao.getById(userBackpack.getUid());
            if (Objects.isNull(user.getItemId())) {
                userDao.wearingBadge(userBackpack.getUid(), userBackpack.getItemId());
                userCache.userInfoChange(userBackpack.getUid());
            }
        }
    }

}
