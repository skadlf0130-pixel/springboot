package com.green.board.application;

import com.green.board.application.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // 빈등록 + 요청/응답 담당자가 된다.
@RequiredArgsConstructor //아규먼트가 있는 생성자를 자동으로 만들어 준다.(실제로 보이진 않는다.)
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    // 파라미터(매개변수)는 FE부터 날라오는 데이터를 받는 용도로 사용.
    // JSON형태와 일치하는 클래스를 만들어 주면 된다(필드명과 key값이 같아야 한다.)
    // BoardService 객체 주소값을 받아서 멤버필드에 대입하는 생성자 생성

    // @RequestBody는 JSON형태로 BODY에 담겨져 있는 데이터를 받을 때 사용.
    @PostMapping
    public int postBoard(@RequestBody BoardPostReq req){
        System.out.println("req: " +req);
        int result = boardService.postBoard(req);
        return result;
    }

    @GetMapping
    public List<BoardGetRes> getBoardList(){
        return boardService.getBoardList();
    }

    @GetMapping("{id}")
    public BoardGetOneRes getBoardOne(@PathVariable int id){
        System.out.println("id: "+ id);
        return boardService.getBoardOne(id);
    }
    @PutMapping
    public int putBoard(@RequestBody BoardPutReq req) {
        System.out.println("req: " + req);
        return boardService.putBoard(req);
    }
    @DeleteMapping
    public int delBoard(@RequestParam int id){
        System.out.println("delete-id : " + id);
        return boardService.delBoard(id);
    }
}
