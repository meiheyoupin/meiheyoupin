package com.meiheyoupin.dao;

import com.meiheyoupin.entity.Comments;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsMapper {

    int insertComments(Comments comments);

    List<Comments> selectCommentsByGoodId(String goodId);

    int deleteCommentById(@Param("id") Integer id, @Param("state") Integer state);

    int updateCommentById(@Param("id") Integer id,
                          @Param("comment") String comment,
                          @Param("picturesUrl") String picturesUrl);

    Integer selectSumForStarsByGoodsId(String goodsId);

    Integer selectCountByGoodsId(String goodsId);

    int updateComment(Comments comments);

    List<String> selectListGoodsIdForLastMonths();

}