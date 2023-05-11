package com.jscode.minseok.mapper;

import com.jscode.minseok.domain.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // Mapper는 XML Mapper에 선언된 SQL 중에서 메서드명과 동일한 id를 가진 SQL 쿼리를 찾아 실행
public interface PostMapper {

    // 게시글 저장
    int insertPost(Post post);

    Post selectPost(Long id);

    List<Post> selectPostList();

    void updatePost(Post post);

    void deletePost(Long id);
}
