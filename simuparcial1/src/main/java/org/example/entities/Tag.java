package org.example.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Repository> repositories;

    public Set<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(Set<Repository> repositories) {
        this.repositories = repositories;
    }

    public Tag(String name) {
        this.name = name;
    }
    public Tag(){}

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void addRepository(Repository repository){
        this.repositories.add(repository);
    }
}
