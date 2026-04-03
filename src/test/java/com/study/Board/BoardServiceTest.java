package com.study.Board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.Board.domain.board.BoardRequest;
import com.study.Board.domain.board.BoardService;

@SpringBootTest
public class BoardServiceTest {

	@Autowired
    BoardService BoardService;

//    @Test
//    void save() {
//        BoardRequest params = new BoardRequest();
//        params.setTitle("Board Title");
//        params.setMemberId(1L);
//        params.setContent("Board Content");
//        params.setWriter("tester");
//        Long id = BoardService.saveBoard(params);
//        System.out.println("BoardId : " + id);
//    }
    
//    @Test
//    void saveByForeach() {
//        for (int i = 1; i <= 1000; i++) {
//            BoardRequest params = new BoardRequest();
//            params.setTitle(i + "번 게시글 제목");
//            params.setContent(i + "번 게시글 내용");
//            params.setMemberId(2L);
//            params.setWriter("테스터" + i);
//            BoardService.saveBoard(params);
//        }
//    }
	
	
}
