package org.william.galileoim.common.chat.service.cache;

import org.william.galileoim.common.chat.dao.RoomDao;
import org.william.galileoim.common.chat.dao.RoomFriendDao;
import org.william.galileoim.common.chat.domain.entity.Room;
import org.william.galileoim.common.common.constant.RedisKey;
import org.william.galileoim.common.common.service.cache.AbstractRedisStringCache;
import org.william.galileoim.common.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description: 房间基本信息的缓存
 */
@Component
public class RoomCache extends AbstractRedisStringCache<Long, Room> {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private RoomFriendDao roomFriendDao;

    @Override
    protected String getKey(Long roomId) {
        return RedisKey.getKey(RedisKey.ROOM_INFO_STRING, roomId);
    }

    @Override
    protected Long getExpireSeconds() {
        return 5 * 60L;
    }

    @Override
    protected Map<Long, Room> load(List<Long> roomIds) {
        List<Room> rooms = roomDao.listByIds(roomIds);
        return rooms.stream().collect(Collectors.toMap(Room::getId, Function.identity()));
    }
}
