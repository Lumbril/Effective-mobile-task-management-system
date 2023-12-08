package com.example.server.services;

import com.example.server.dto.request.CommentCreateRequest;
import com.example.server.entities.Client;
import com.example.server.entities.Comment;

public interface CommentService {
    Comment createFromRequest(CommentCreateRequest commentCreateRequest, Client author, Long taskId);
}
