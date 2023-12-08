package com.example.server.services.impl;

import com.example.server.dto.request.CommentCreateRequest;
import com.example.server.entities.Client;
import com.example.server.entities.Comment;
import com.example.server.entities.Task;
import com.example.server.repositories.CommentRepository;
import com.example.server.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final TaskServiceImpl taskService;

    @Override
    @Transactional
    public Comment createFromRequest(CommentCreateRequest commentCreateRequest, Client author, Long taskId) {
        Task task = taskService.get(taskId);

        Comment comment = Comment.builder()
                .text(commentCreateRequest.getText())
                .author(author)
                .task(task)
                .build();

        return commentRepository.save(comment);
    }
}
