package com.green.board.application;

import com.green.board.application.model.BoardGetOneRes;
import com.green.board.application.model.BoardGetRes;
import com.green.board.application.model.BoardPostReq;
import com.green.board.application.model.BoardPutReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/* @Service는 서버가 기동되는 순간 객체화가 된다
 서버가 기동되면 @Service 애노테이션 가지고 있는 클래스는
 싱글톤 객체화가 된다.
 애노테이션을 붙이는 행위는 빈(Bean)등록이라 한다.
 스프링 컨테이너는 객체의 주소값을 저장하고 있다.
 그리고 누군가 해당 객체의 주소값을 달라고 하면 DI해준다.

 DI : 외부에서 만든 객체 주소값을 생성자 or setter를 통해 주소값을 전달받아 저장하는것
 IoC :A객체가 사용할 B객체를 A객체가 직접 객체화하는 것이 아니라
      외부에서 A객체가 사용할 B객체를 객체화하여 A객체에게 전달하는 구조
 싱글톤 : 객체를 딱 하나만 생성해서 공유하고 싶을때.
        new를 막고, static으로 하나만 만들어 공유하는 패턴

 서비스의 역할은 로직처리 +DB담당자에게

 */

@Service
@RequiredArgsConstructor //아규먼트가 있는 생성자를 자동으로 만들어 준다.(실제로 보이진 않는다.)
public class BoardService {
    private final BoardMapper boardMapper;


    public int postBoard(BoardPostReq req){
        return boardMapper.save(req);
    }
    public List<BoardGetRes> getBoardList(){
        return boardMapper.findAll();
    }
    public BoardGetOneRes getBoardOne(int id){
        return boardMapper.findById(id);
    }
    public int putBoard(BoardPutReq req){
        return boardMapper.update(req);
    }
    public int delBoard(int id){
        return boardMapper.delete(id);
    }

}
