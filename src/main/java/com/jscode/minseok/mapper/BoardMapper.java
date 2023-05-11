package com.jscode.minseok.mapper;

import com.jscode.minseok.dto.BoardRequestDTO;
import com.jscode.minseok.dto.BoardResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // Mapper는 XML Mapper에 선언된 SQL 중에서 메서드명과 동일한 id를 가진 SQL 쿼리를 찾아 실행
public interface BoardMapper {

    // 게시글 저장
    void insertBoard(BoardRequestDTO boardRequestDTO);

    BoardResponseDTO selectBoard(Long id);

    List<BoardResponseDTO> selectBoardList();

    void updateBoard(BoardResponseDTO board);

    void deleteBoard(Long id);
}
