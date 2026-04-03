package com.study.Board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.study.Board.domain.board.BoardMapper;
import com.study.Board.domain.board.BoardRequest;
import com.study.Board.domain.board.BoardResponse;

@SpringBootTest
public class BoardMapperTest {
	
	 	@Autowired
	    BoardMapper boardMapper;

//	    @Test
//	    void save() {
//	    	BoardRequest params = new BoardRequest();
//	        params.setTitle("サンプル投稿_01");
//	        params.setMemberId(1L);
//	        params.setContent("サンプル投稿_内容_01");
//	        params.setWriter("tester1");
//	        boardMapper.save(params);
//
//	        List<BoardResponse> boards = boardMapper.findAll();
//	        System.out.println("boards size : " + boards.size());
//	    }
//	    
	    
//	    @Test
//	    void findById() {
//	        BoardResponse Board = boardMapper.findById(2L);
//	        try {
//	            String BoardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(Board);
//	            System.out.println(BoardJson);
//
//	        } catch (JsonProcessingException e) {
//	            throw new RuntimeException(e);
//	        }
//	    }
	 	
	 	
//	    @Test
//	    void update() {
//	        // 1. 게시글 수정
//	        BoardRequest params = new BoardRequest();
//	        params.setId(2L);
//	        params.setTitle("modified title");
//	        params.setContent("modified content");
//	        params.setWriter("mo_writer");
//	        boardMapper.update(params);
//
//	        // 2. 게시글 상세정보 조회
//	        BoardResponse Board = boardMapper.findById(2L);
//	        try {
//	            String BoardJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(Board);
//	            System.out.println(BoardJson);
//
//	        } catch (JsonProcessingException e) {
//	            throw new RuntimeException(e);
//	        }
//	    }
	 	
	 	
//	 	@Test
//	    void delete() {
//	        System.out.println("before delete : " + boardMapper.findAll().size());
//	        boardMapper.deleteById(2L);
//	        System.out.println("after delete: " + boardMapper.findAll().size());
//	    }
	 	

}
