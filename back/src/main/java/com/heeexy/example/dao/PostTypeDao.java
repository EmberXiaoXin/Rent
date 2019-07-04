package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface PostTypeDao {

    /**
     *@description:获取帖子类型列表
     */
    List<JSONObject> getPostTypeList(JSONObject jsonObject);

    /**
     *@description:添加帖子类型信息
     */
    int insertPostType(JSONObject jsonObject);

    /**
     *@description:根据帖子类型id修改相应信息
     */
    void updatePostTypeById(JSONObject jsonObject);

    /**
     *@description:根据帖子类型id逻辑删除相应信息
     */
    void deletePostTypeById(JSONObject jsonObject);

    /**
     *@description:计算列表条数
     */
    int countPostType(JSONObject jsonObject);
}
