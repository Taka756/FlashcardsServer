package com.example.flashcardsserver.controllers;

import com.example.flashcardsserver.dto.SaveTopicDto;
import com.example.flashcardsserver.dto.TopicDto;
import com.example.flashcardsserver.enums.NumberOfQuestionsEnum;
import com.example.flashcardsserver.enums.SubjectEnum;
import com.example.flashcardsserver.response.PaginatedResponse;
import com.example.flashcardsserver.services.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/topics")
public class TopicController {
    private final TopicService topicService;

//    @GetMapping("/all")
//    public List<TopicDto> list(){
//        return topicService.list();
//    }

//    @GetMapping("/all")
//    public Page<TopicDto> searchTopics(
//            @RequestParam(required = false) String title,
//            @RequestParam(required = false) UUID authorId,
//            @RequestParam(required = false) List<SubjectEnum> subject,
//            @PageableDefault(size = 1) Pageable pageable) {
//
//
//        return topicService.list(title, authorId, subject, pageable);
//    }

    @GetMapping("/all")
    public Page<TopicDto> searchTopics(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) UUID authorId,
            @RequestParam(required = false) List<SubjectEnum> subject,
            @RequestParam(required = false) NumberOfQuestionsEnum flashcardsCount,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "true") boolean asc
    ) {

        Sort sort = asc? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        return topicService.list(title, authorId, subject, flashcardsCount, pageable);
//
//        return ResponseEntity.ok(
//                PaginatedResponse.builder()
//                        .content(page.getContent())
//                        .currentPage(page.getNumber())
//                        .pageSize(page.getSize())
//                        .totalPages(page.getTotalPages())
//                        .totalElements(page.getTotalElements())
//                        .build()
//        );
    }

    @GetMapping("/{topicId}")
    public TopicDto get(@PathVariable UUID topicId){
        return topicService.get(topicId);
    }

    @PostMapping("/save")
    public TopicDto save(@RequestBody SaveTopicDto dto){
        return topicService.save(dto);
    }

    @PutMapping("/edit/{topicId}")
    public TopicDto edit(@PathVariable UUID topicId, @RequestBody SaveTopicDto dto){
        return topicService.edit(topicId, dto);
    }

    @DeleteMapping("/delete/{topicId}")
    public String delete(@PathVariable UUID topicId){
        topicService.delete(topicId);
        return "Topic was successfully deleted";
    }
}
