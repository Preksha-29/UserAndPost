package com.Train.TrainMicroservice.Service;

import com.Train.TrainMicroservice.Entity.Post;
import com.Train.TrainMicroservice.Entity.User;
import com.Train.TrainMicroservice.Repository.PostRepo;
import com.Train.TrainMicroservice.Repository.UserRepo;
import com.Train.TrainMicroservice.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {


    @Autowired
    PostRepo postRepo;


    @Autowired
    UserRepo userRepo;

    public PostDto createPost(Post post, int userId) {
        Optional<User> user = userRepo.findById(userId);
        post.setUser(user.get());
        Post post1 = postRepo.save(post);
        PostDto postDto = new PostDto();
        postDto.setPostTitle(post1.getPostTitle());
        postDto.setPostCategory(post1.getPostCategory());
        return postDto;
    }

    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepo.findAll();
        Post post = posts.get(0);
        PostDto postDto1 = new PostDto();
        postDto1.setPostTitle(post.getPostTitle());
        postDto1.setPostCategory(post.getPostCategory());
        Post post1 = posts.get(1);
        PostDto postDto2 = new PostDto();
        postDto2.setPostCategory(post1.getPostCategory());
        postDto1.setPostTitle(post1.getPostTitle());
        List<PostDto> postDto = new ArrayList<>();
        postDto.add(postDto1);
        postDto.add(postDto2);
        return postDto;


    }


    public PostDto findBySinglePost(String postTitle) {
        Post post = postRepo.findByPostTitle(postTitle);
        PostDto postDto = new PostDto();
        postDto.setPostCategory(post.getPostCategory());
        postDto.setPostTitle(post.getPostTitle());
        return postDto;
    }


    public PostDto updatePost(String postTitle) {
        Post post1 = postRepo.findByPostTitle(postTitle);
        post1.setPostTitle("Tester");
        Post post2 = postRepo.save(post1);
        PostDto postDto = new PostDto();
        postDto.setPostTitle(post2.getPostTitle());
        return postDto;
    }


    public List<Post> getAllPostsWithUser(Integer userId) {
        Optional<User> user = userRepo.findById(userId);
        User user2=user.get();
        List<Post> foundPostByUser = postRepo.findByUser(user2);
        return foundPostByUser;
    }


}
