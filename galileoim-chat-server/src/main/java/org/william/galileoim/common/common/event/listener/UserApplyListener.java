package org.william.galileoim.common.common.event.listener;

import org.william.galileoim.common.common.event.UserApplyEvent;
import org.william.galileoim.common.user.dao.UserApplyDao;
import org.william.galileoim.common.user.domain.entity.UserApply;
import org.william.galileoim.common.user.domain.vo.response.ws.WSFriendApply;
import org.william.galileoim.common.user.service.WebSocketService;
import org.william.galileoim.common.user.service.adapter.WSAdapter;
import org.william.galileoim.common.user.service.impl.PushService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * 好友申请监听器
 *
 * @author zhongzb create on 2022/08/26
 */
@Slf4j
@Component
public class UserApplyListener {
    @Autowired
    private UserApplyDao userApplyDao;
    @Autowired
    private WebSocketService webSocketService;

    @Autowired
    private PushService pushService;

    @Async
    @TransactionalEventListener(classes = UserApplyEvent.class, fallbackExecution = true)
    public void notifyFriend(UserApplyEvent event) {
        UserApply userApply = event.getUserApply();
        Integer unReadCount = userApplyDao.getUnReadCount(userApply.getTargetId());
        pushService.sendPushMsg(WSAdapter.buildApplySend(new WSFriendApply(userApply.getUid(), unReadCount)), userApply.getTargetId());
    }

}
