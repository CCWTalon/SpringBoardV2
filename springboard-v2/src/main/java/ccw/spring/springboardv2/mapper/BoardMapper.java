package ccw.spring.springboardv2.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ccw.spring.springboardv2.vo.Board;

@Mapper
public interface BoardMapper {

	List<Board> selectBoardList(Map<String, Integer> map);
	int selectBoardCount();
	int insertBoard(Board board);
}
