package com.study.Board.domain.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.Board.domain.member.MemberResponse;
import com.study.Board.dto.PagingResponse;
import com.study.Board.dto.SearchDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	 private final BoardService boardService;
	 
	 
	// 掲示物リストページ
	    @GetMapping("/board/list.do")
	    public String openBoardList(@ModelAttribute("params") SearchDto params, Model model) {
	        PagingResponse<BoardResponse> response = boardService.findAllBoard(params);
	        
	        // 1. 掲示物リストを boards として追加
	        model.addAttribute("boards", response.getList());
	        
	        // 2. ページング情報を追加
	        model.addAttribute("pagination", response.getPagination());
	        
	        return "board/list";
	    }

	    // 掲示物作成ページ
	    @GetMapping("/board/write.do")
	    public String openBoardWrite(@RequestParam(value = "id", required = false) Long id, Model model) {
	        if (id != null) {
	            BoardResponse board = boardService.findBoardById(id);
	            model.addAttribute("board", board);
	        }
	        return "board/write";
	    }

	    // 掲示物詳細ページ
	    @GetMapping("/board/view.do")
	    public String openPostView(@RequestParam(value = "id", required = false) Long id, Model model) {
	        BoardResponse board = boardService.findBoardById(id);
	        model.addAttribute("board", board);
	        return "board/view";
	    }

	    // 掲示物修正ページ
	    @GetMapping("/board/modify.do")
	    public String openBoardModify(@RequestParam(value = "id", required = false) Long id, Model model) {
	        if (id != null) {
	            BoardResponse board = boardService.findBoardById(id);
	            model.addAttribute("board", board);
	        }
	        return "board/modify";
	    }

	    // 新規掲示物作成
	    @PostMapping("/board/save")
	    public String saveBoard(HttpServletRequest request, BoardRequest params) {
	        
	        // セッションからログイン時に保存した loginMember オブジェクトを取得
	        HttpSession session = request.getSession();
	        MemberResponse loginMember = (MemberResponse) session.getAttribute("loginMember");
	        
	        // 掲示物の memberId をログインセッションから取得して設定
	        params.setMemberId(loginMember.getId());
	        
	        boardService.saveBoard(params);
	        return "redirect:/board/list.do";
	    }

	    // 既存掲示物の修正
	    @PostMapping("/board/update")
	    public String updatePost(BoardRequest params) {
	        boardService.updateBoard(params);
	        return "redirect:/board/list.do";
	    }

	    // 掲示物の削除
	    @PostMapping("/board/delete.do")
	    public String deleteBoard(@RequestParam(value = "id", required = false) Long id) {
	        boardService.deleteBoard(id);
	        return "redirect:/board/list.do";
	    }
}
