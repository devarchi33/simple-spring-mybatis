package com.devarchi33.domain;

import lombok.Getter;

/**
 * Created by donghoon on 2016. 9. 26..
 */
public enum DevarchiAuthority {

    ADMIN(0, "슈퍼관리자"), MANAGER(1, "관리자"), MONITOR(2, "모니터");

    @Getter
    private int authorityNum;
    @Getter
    private String authorityName;

    DevarchiAuthority(int authorityNum, String authorityName) {
        this.authorityNum = authorityNum;
        this.authorityName = authorityName;
    }
}
