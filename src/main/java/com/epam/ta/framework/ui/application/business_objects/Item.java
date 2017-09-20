package com.epam.ta.framework.ui.application.business_objects;


import com.epam.ta.framework.ui.application.enums.User;

public abstract class Item {
    private String summary;
    private String id;
    private User creator;
    private User actionPerfomer;
    private String currency;
    private String projectName;

    protected Item() {
    }

    protected Item(String summary, User actionPerfomer, String projectName) {
        this.summary = summary;
        this.actionPerfomer = actionPerfomer;
        this.projectName = projectName;
    }

    public String getSummary() {
        return summary;
    }

    public String getId() {
        return id;
    }

    public User getCreator() {
        return creator;
    }

    public User getActionPerfomer() {
        return actionPerfomer;
    }

    public String getCurrency() {
        return currency;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setActionPerfomer(User actionPerfomer) {
        this.actionPerfomer = actionPerfomer;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
