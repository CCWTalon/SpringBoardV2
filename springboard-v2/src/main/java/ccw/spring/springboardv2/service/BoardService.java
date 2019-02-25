package ccw.spring.springboardv2.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ccw.spring.springboardv2.mapper.BoardMapper;
import ccw.spring.springboardv2.vo.Board;

@Service
@Transactional
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;

	public Map<String, Object> selectBoardList(int currentPage) {
		final int ROW_PER_PAGE = 10;
		int startPage = (currentPage-1)*ROW_PER_PAGE;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("currentPage", currentPage);
		map.put("rowPerPage", ROW_PER_PAGE);
		map.put("startPage", startPage);
		
		int boardCount = boardMapper.selectBoardCount();
		int lastPage = (int)(Math.ceil(boardCount / ROW_PER_PAGE));
		System.out.println(boardCount + " <- boardCount");
		System.out.println(lastPage + " <- lastPage");
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", boardMapper.selectBoardList(map));
		returnMap.put("boardCount", boardCount);
		returnMap.put("lastPage", lastPage);
		
		return returnMap;
	}
	
	public int getBoardCount() {
		
		return boardMapper.selectBoardCount();
	}
	
	public int addBoard(Board board) {
		
		return boardMapper.insertBoard(board);
	}
}
