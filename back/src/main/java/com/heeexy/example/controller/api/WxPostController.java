package com.heeexy.example.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.PostBaseService;
import com.heeexy.example.service.PostForMiniPrgService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.model.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName PostController
 * @Description 帖子信息接口（小程序专用）
 * @Author Lingling00
 * @DATE 7/18/2019 15:52
 * @VERSION 1.0
 **/
@RestController
@RequestMapping("/wxPost")
public class WxPostController {
    @Autowired
    private PostForMiniPrgService postForMiniPrgService;
    @Autowired
    private PostBaseService postBaseService;

    /**
     * @description 获取帖子列表
     * @param request （帖子id-postId，发帖人昵称-nickname（用于获取指定用户发布的帖子列表，非必须），关键词-keyword（用于进行模糊查询，包括地址及帖子内容））
     * @return
     *      发帖人-poster,
     *      发帖人头像-posterAvatar,
     *      发帖人性别-posterGender，
     *      是否关注发帖人-isFollow,
     *      帖子Id-postId,
     *      帖子创建时间-createTime,
     *      帖子类别名称-typeName,
     *      地址-address,
     *      帖子内容content,
     *      最低价-minPrice,
     *      最高价- maxPrice,
     *      联系方式-phone,
     *      帖子标签集合-postLabels，
     *      浏览量-browse，
     *      评论数量-comments,
     *      评论列表-commentList，
     *      图片集合-postImgs，
     *      点赞列表-likeList，
     *      点赞量-likes，
     *      帖子收藏量-collections，
     *      中介费-fee,
     *      活跃时间-activeTime
     **/
    @GetMapping("/getPostInfo")
    public List<PostDto> getPostList(HttpServletRequest request) {
        return postForMiniPrgService.getPostInfo(CommonUtil.request2Json(request));
    }
    /**
     * @description 用户发布帖子插入帖子信息
     * @param request postId-帖子Id,帖子类型id-typeId，昵称-nickName，关键词-keyword（以上参数均可选）
     * @return
     *             posterId-发帖人id（userid）,
     *             typeId -帖子类型id,
     *             content-帖子内容,
     *             minPrice-最低价,
     *             maxPrice-最高价,
     *             phone-联系方式,
     *             address-地址,
     *             labels-帖子标签集合,
     *             totalBrowse-浏览量,
     *             totalLike-点赞量,
     *             activeTime-活跃时间（默认与发布时间相同）,
     *             createTime-发布时间,
     *             fee-是否有中介费，
     *             postImgList-图片列表
     **/
    @PostMapping("/insertPost")
    public JSONObject insertPostBase(HttpServletRequest request){
        return postBaseService.insertPostBase(CommonUtil.request2Json(request));
    }


}