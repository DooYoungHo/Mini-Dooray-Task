package com.nhnacademy.taskapi.error.tag;

public class TagNotFoundException extends RuntimeException {

    public TagNotFoundException() {
      super("지정된 태그를 찾을 수 없습니다.");
    }

    public TagNotFoundException(Long tagId) {
        super("선택한 태그 아이디 : " + tagId + " 의 태그를 찾을 수 없습니다.");
    }

    public TagNotFoundException(String message) {
        super(message);
    }
}
