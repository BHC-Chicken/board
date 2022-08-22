package com.deploykube.board.controller;

import com.deploykube.board.dto.UserAccountDto;
import com.deploykube.board.dto.request.ArticleCommentRequest;
import com.deploykube.board.service.ArticleCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/comments")
@Controller
public class ArticleCommentController {

    private final ArticleCommentService articleCommentService;

    @PostMapping("/new")
    public String postNewArticleComment(ArticleCommentRequest articleCommentRequest, Long articleId) {

        articleCommentService.saveArticleComment(articleCommentRequest.toDto(UserAccountDto.of(
                "park", "pw", "test1234@sample.com", null,null
        )));

        return "redirect:/articles/" + articleCommentRequest.articleId();
    }

    @PostMapping("/{commentId}/delete")
    public String deleteArticle(@PathVariable Long commentId, Long articleId) {

        articleCommentService.deleteArticleComment(commentId);

        return "redirect:/articles" + articleId;
    }
}
