package com.Train.TrainMicroservice.Controller;

import com.Train.TrainMicroservice.Entity.Post;
import com.Train.TrainMicroservice.Service.PostService;
import com.Train.TrainMicroservice.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/createPost")
    public PostDto createPost(@RequestBody Post post,@RequestParam int userId){

        return postService.createPost(post,userId);

    }
    @GetMapping("/getAllPosts")
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }
     @GetMapping("/getSinglePost")
     public PostDto findSinglePost(@RequestParam String postTitle){
       return postService.findBySinglePost(postTitle);
     }

     @PatchMapping("updatePost")
    public PostDto updatePost(@RequestParam String postTitle){
        return postService.updatePost(postTitle);
     }


     @GetMapping("/getPosts/{userId}")
    public List<Post> getPosts(@PathVariable Integer userId){
      return   postService.getAllPostsWithUser(userId);
     }
}
