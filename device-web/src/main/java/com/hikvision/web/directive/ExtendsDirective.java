package com.hikvision.web.directive;

import org.apache.velocity.runtime.directive.Parse;

/**
 * Created by xiongyou on 2018/8/14.
 */
public class ExtendsDirective extends Parse {

    @Override
    public String getName() {

        return "extends";
    }

}