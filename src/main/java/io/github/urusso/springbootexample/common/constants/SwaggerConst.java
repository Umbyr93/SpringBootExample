package io.github.urusso.springbootexample.common.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SwaggerConst {
    public static final String USER_TAG_NAME = "USER API";
    public static final String USER_TAG_DESC = "Users management";

    public static final String ORDER_TAG_NAME = "ORDER API";
    public static final String ORDER_TAG_DESC = "Orders management";
}
