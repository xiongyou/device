package com.hikvision.service.vo;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Created by xiongyou on 2018/8/14.
 */
public class ToString implements Serializable {
    /** serialVersionUID */
    private static final long	serialVersionUID	= -8430158114125721933L;

    /**
     * toString方法
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this ,
                ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
