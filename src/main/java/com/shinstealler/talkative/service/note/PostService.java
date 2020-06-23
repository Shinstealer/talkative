package com.shinstealler.talkative.service.note;

import java.util.List;
import java.util.stream.Collectors;

import com.shinstealler.talkative.domain.note.PostRepository;
import com.shinstealler.talkative.model.PostResponseModel;
import com.shinstealler.talkative.model.PostSaveRequestModel;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostService {

    private PostRepository postRepository;

    @Transactional
    public long createPost(PostSaveRequestModel request) {
        return postRepository.save(request.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostResponseModel> findAllPostDesc() {
        return postRepository.findAllDesc().map(PostResponseModel::new).collect(Collectors.toList());
    }

    @Transactional
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
}