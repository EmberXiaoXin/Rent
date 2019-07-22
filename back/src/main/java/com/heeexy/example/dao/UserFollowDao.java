package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface UserFollowDao {
    /**
     * 根据userId查询用户关注列表
     */
    List<JSONObject> getUserFollowList(JSONObject jsonObject);
    /**
     * 根据userId查询用户粉丝列表
     */
    List<JSONObject> getUserFansList(JSONObject jsonObject);

    /**
     *@description:计算用户关注列表条数
     */
    int countUserFollow(JSONObject jsonObject);

    /**
     *@description:计算用户粉丝列表条数
     */
    int countUserFans(JSONObject jsonObject);
    /**
     * @description 添加用户关注信息
     **/
    int insertUserFollow(JSONObject jsonObject);
    /**
     * @description 更新用户关注信息
     **/
    int updateDelFollow(JSONObject jsonObject);
    /**
     * @description 判断是否关注过
     **/
    JSONObject getIfFollow(JSONObject jsonObject);
}
