package com.example.flashcardsserver.response;


import com.example.flashcardsserver.dto.TopicDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class PaginatedResponse<T>  {
    private List<TopicDto> content;
    private int totalPages;
    private long totalElements;
    private int currentPage;
    private int pageSize;
}