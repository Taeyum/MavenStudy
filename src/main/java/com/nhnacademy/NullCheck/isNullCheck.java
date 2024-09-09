package com.nhnacademy.NullCheck;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class isNullCheck {

    public static boolean nullCheck1(Object object){
        return Objects.isNull(object);
    }

    public static boolean nullCheck2(String object){
        return StringUtils.isEmpty(object);
    }
}
