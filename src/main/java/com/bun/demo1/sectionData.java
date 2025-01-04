package com.bun.demo1;

public class sectionData {
    private String section, description, adviser;

    public sectionData(String section, String description, String adviser) {
        this.section = section;
        this.description = description;
        this.adviser = adviser;
    }

    public String getSection() { return section;}
    public String getDescription() { return description;}
    public String getAdviser() { return adviser;}

}
