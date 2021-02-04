package com.cn.edu.entity.extend;

import java.io.Serializable;
import java.util.List;

public class EduSubjectExt implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;

    private String id;

    private String parentId;

    private int sort;

    private List<EduSubjectExt> nodes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<EduSubjectExt> getNodes() {
        return nodes;
    }

    public void setNodes(List<EduSubjectExt> nodes) {
        this.nodes = nodes;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
