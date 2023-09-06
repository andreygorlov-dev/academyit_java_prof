package org.example.cars;

import javax.persistence.*;

@Entity
@Table(name = "MODELS")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title_model")
    private String titleModel;

    @ManyToOne
    private Mark mark;

    public Model() {
    }

    public Model(String titleModel, Mark mark) {
        this.titleModel = titleModel;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public Model setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitleModel() {
        return titleModel;
    }

    public Model setTitleModel(String titleModel) {
        this.titleModel = titleModel;
        return this;
    }

    public Mark getMark() {
        return mark;
    }

    public Model setMark(Mark mark) {
        this.mark = mark;
        return this;
    }
}
