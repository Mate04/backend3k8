package org.example.entities;

import java.util.HashSet;

public class Language {
    private String name;
    private HashSet<Repository> repositories;

    public HashSet<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(HashSet<Repository> repositories) {
        this.repositories = repositories;
    }

    public Language(){}

    public Language(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
