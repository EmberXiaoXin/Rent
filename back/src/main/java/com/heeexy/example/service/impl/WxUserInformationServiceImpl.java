package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.WxUserDao;
import com.heeexy.example.dao.WxUserInformationDao;
import com.heeexy.example.service.WxUserInformationService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chens
 * @description: 微信用户消息业务逻辑实现
 * @date: 2019-07-30 14:00
 */
@Service
public class WxUserInformationServiceImpl implements WxUserInformationService {


    @Autowired
    private WxUserDao wxUserDao;

    @Autowired
    private WxUserInformationDao wxUserInformationDao;

    /**
     * 获取用户最新未读消息
     * userId   用户ID
     * flagTime 参考时间
     * @param jsonObject
     * @return
     */
    @Override
    public JSONObject getNewInfomation(JSONObject jsonObject) {

        //获取到最新的消息数据
        List<JSONObject> joList = wxUserInformationDao.getNewInformationByUserIdFlagTime(jsonObject);
        return CommonUtil.successPage(joList);
    }
}