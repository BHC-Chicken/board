package com.deploykube.board.dto.response;

import com.deploykube.board.dto.ArticleCommentDto;

import java.time.LocalDateTime;

public record ArticleCommentResponse(
        Long id,
        String content,
        LocalDateTime createdAt,
        String email,

        String userId,
        String nickname
) {

    public static ArticleCommentResponse of(Long id, String content, LocalDateTime createdAt, String email, String userId, String nickname) {
        return new ArticleCommentResponse(id, content, createdAt, email, userId, nickname);
    }

    public static ArticleCommentResponse from(ArticleCommentDto dto) {
        String nickname = dto.userAccountDto().nickname();
        if (nickname == null || nickname.isBlank()) {
            nickname = dto.userAccountDto().userId();
        }

        return new ArticleCommentResponse(
                dto.id(),
                dto.content(),
                dto.createdAt(),
                dto.userAccountDto().email(),
                dto.userAccountDto().userId(),
                nickname
        );
    }

}
