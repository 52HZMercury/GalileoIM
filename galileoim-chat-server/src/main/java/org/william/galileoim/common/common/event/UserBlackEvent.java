package org.william.galileoim.common.common.event;

import org.william.galileoim.common.user.domain.entity.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UserBlackEvent extends ApplicationEvent {
    private final User user;

    public UserBlackEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
