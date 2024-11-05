package org.william.galileoim.common.chat.service;

import org.william.galileoim.common.chat.domain.vo.request.*;
import org.william.galileoim.common.chat.domain.vo.request.member.MemberAddReq;
import org.william.galileoim.common.chat.domain.vo.request.member.MemberDelReq;
import org.william.galileoim.common.chat.domain.vo.request.member.MemberReq;
import org.william.galileoim.common.chat.domain.vo.response.ChatMemberListResp;
import org.william.galileoim.common.chat.domain.vo.response.ChatRoomResp;
import org.william.galileoim.common.chat.domain.vo.response.MemberResp;
import org.william.galileoim.common.common.domain.vo.request.CursorPageBaseReq;
import org.william.galileoim.common.common.domain.vo.response.CursorPageBaseResp;
import org.william.galileoim.common.user.domain.vo.response.ws.ChatMemberResp;

import java.util.List;

/**
 * Description:
 * Author: <a href="https://github.com/zongzibinbin">abin</a>
 * Date: 2023-07-22
 */
public interface RoomAppService {
    /**
     * 获取会话列表--支持未登录态
     */
    CursorPageBaseResp<ChatRoomResp> getContactPage(CursorPageBaseReq request, Long uid);

    /**
     * 获取群组信息
     */
    MemberResp getGroupDetail(Long uid, long roomId);

    CursorPageBaseResp<ChatMemberResp> getMemberPage(MemberReq request);

    List<ChatMemberListResp> getMemberList(ChatMessageMemberReq request);

    void delMember(Long uid, MemberDelReq request);

    void addMember(Long uid, MemberAddReq request);

    Long addGroup(Long uid, GroupAddReq request);

    ChatRoomResp getContactDetail(Long uid, Long roomId);

    ChatRoomResp getContactDetailByFriend(Long uid, Long friendUid);
}
