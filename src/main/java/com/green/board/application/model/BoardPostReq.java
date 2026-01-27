package com.green.board.application.model;
// board 테이블에 post통신으로 들어오는 요청


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class BoardPostReq {
    private String title;
    private String contents;
}
