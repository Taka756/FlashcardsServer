package com.example.flashcardsserver.specifications;

import com.example.flashcardsserver.entity.TopicEntity;
import com.example.flashcardsserver.enums.NumberOfQuestionsEnum;
import com.example.flashcardsserver.enums.SubjectEnum;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.UUID;

public class TopicSpecifications {

    public static Specification<TopicEntity> hasTitle(String title) {
        return (root, query, cb) -> {
            if (title == null || title.isEmpty()) {
                return null;
            }
            return cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
        };
    }

    public static Specification<TopicEntity> hasAuthorId(UUID authorId) {
        return (root, query, cb) -> {
            if (authorId == null) {
                return null;
            }
            return cb.equal(root.get("authorId"), authorId);
        };
    }

//    public static Specification<TopicEntity> hasSubject(SubjectEnum subject) {
//        return (root, query, cb) -> {
//            if (subject == null) {
//                return null;
//            }
//            return cb.equal(root.get("subject"), subject);
//        };
//    }

    public static Specification<TopicEntity> hasSubjects(List<SubjectEnum> subjects) {
        return (root, query, cb) -> {
            if (subjects == null || subjects.isEmpty()) {
                return null;
            }
            CriteriaBuilder.In<SubjectEnum> inClause = cb.in(root.get("subject"));
            for (SubjectEnum subject : subjects) {
                inClause.value(subject);
            }
            return inClause;
        };
    }

    public static Specification<TopicEntity> hasNumberOfQuestionsInRange(NumberOfQuestionsEnum range) {
        return (root, query, criteriaBuilder) -> {
            if (range != null) {
                return criteriaBuilder.between(root.get("numberOfQuestions"), range.getMin(), range.getMax());
            }
            return criteriaBuilder.conjunction();  // No filter if range is null
        };
    }
}
