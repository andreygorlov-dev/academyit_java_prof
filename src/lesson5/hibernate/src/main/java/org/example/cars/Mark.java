package org.example.cars;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MARKS")
public class Mark {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title_mark")
    private String titleMark;

    @OneToMany
    @JoinColumn(name = "mark_id", referencedColumnName = "id")
    private List<Model> models;

    public Mark() {
    }

    public Mark(String titleMark) {
        this.titleMark = titleMark;
    }

    public int getId() {
        return id;
    }

    public Mark setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitleMark() {
        return titleMark;
    }

    public Mark setTitleMark(String titleMark) {
        this.titleMark = titleMark;
        return this;
    }

    public List<Model> getModels() {
        return models;
    }

    public Mark setModels(List<Model> models) {
        this.models = models;
        return this;
    }
}
