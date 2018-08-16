package com.hikvision.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hikvision.service.page.Page;
import com.hikvision.web.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by xiongyou on 2018/8/14.
 */
public class SuperController {
    /** session */
    protected HttpSession session;

    @Autowired
    protected HttpServletRequest request;

    /**
     * 重定向至地址 url
     *
     * @param url
     *            请求地址
     * @return
     */
    protected String redirectTo(String url) {

        StringBuffer rto = new StringBuffer("redirect:");
        rto.append(url);
        return rto.toString();
    }

    /**
     * 是否为 post 请求
     */
    protected boolean isPost(HttpServletRequest request) {

        session = request.getSession();
        return HttpUtil.isPost(request);
    }

    /**
     * 是否为 get 请求
     */
    protected boolean isGet(HttpServletRequest request) {

        session = request.getSession();
        return HttpUtil.isGet(request);
    }

    /**
     * <p>
     * 获取分页对象
     * </p>
     */
    protected <T> Page<T> getPage() {

        return getPage(request , 10);
    }

    /**
     * <p>
     * 获取分页对象
     * </p>
     *
     * @param size
     *            每页显示数量
     * @return
     */
    protected <T> Page<T> getPage(HttpServletRequest request, int size) {

        int _size = size, _index = 0;
        if (request.getParameter("_size") != null) {
            _size = Integer.parseInt(request.getParameter("_size"));
        }
        if (request.getParameter("_index") != null) {
            _index = Integer.parseInt(request.getParameter("_index"));
            _index = (_index / _size)+1;
        }
        return new Page<T>(_index , _size);
    }

    /**
     *
     * 返回 JSON 格式对象
     *
     * @param object
     *            转换对象
     * @return
     */
    protected String toJson(Object object) {

        return JSON.toJSONString(object , SerializerFeature.BrowserCompatible);
    }

    /**
     * <p>
     * 转换为 bootstrap-table 需要的分页格式 JSON
     * </p>
     *
     * @param page
     *            分页对象
     * @return
     */
    protected String jsonPage(Page<?> page) {

        JSONObject jo = new JSONObject();
        jo.put("total" , page.getTotal());
        jo.put("rows" , page.getRecords());
        return toJson(jo);
    }

    /**
     * <p>
     * 转换对象列表为JSONObject
     * </p>
     *
     * @param objects
     * @return
     */
    protected JSONObject jsonList(List<?> objects) {

        JSONObject jo = new JSONObject();
        jo.put("total" , objects.size());
        jo.put("data" , objects);

        return jo;
    }
}
