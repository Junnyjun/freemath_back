package com.math.weakness.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class UserProblem {

    @EmbeddedId
    private UserProblemId userProblemId = new UserProblemId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("problemId")
    @JoinColumn(name = "PROBLEM_ID")
    private Problem problem;

    @Column(name = "STATUS")
    private Boolean status;

    @Builder
    public UserProblem(User user, Problem problem, Boolean status) {
        this.user = user;
        this.problem = problem;
        this.status = status;
    }
}
