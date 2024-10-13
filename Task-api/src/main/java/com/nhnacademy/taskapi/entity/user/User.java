
package com.nhnacademy.taskapi.entity.user;

import com.nhnacademy.taskapi.entity.projectmember.ProjectMember;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @Column(unique = true)
    private String userId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<ProjectMember> projectMembers;

    public User(String userId) {
        this.userId = userId;
    }
}
