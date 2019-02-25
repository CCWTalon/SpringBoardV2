package ccw.spring.springboardv2.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ccw.spring.springboardv2.service.BoardService;
import ccw.spring.springboardv2.vo.Board;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping("index")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("Stop")
	public String stop() {
		
		return "Stop";
	}
	
	@GetMapping("boardList")
	public String boardList(Model model,
			 @RequestParam (value="currentPage",
							required=false,
							defaultValue="1") int currentPage) {
		
		Map<String, Object> map = boardService.selectBoardList(currentPage);
		model.addAttribute("map", map);
		model.addAttribute("currentPage", currentPage);
		System.out.println("Request:/BoardList");
		
		return "boardList";
	}
	
	@GetMapping("addBoard")
	public String addBoard() {
		
		return "addBoard";
	}
	
	@PostMapping("addBoard")
	public String addBoard(Board board) {
		System.out.println("addBoard Action");
		
		boardService.addBoard(board);
		
		return "redirect:/boardList";
	}
}
