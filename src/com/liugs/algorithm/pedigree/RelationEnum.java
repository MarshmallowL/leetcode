package com.liugs.algorithm.pedigree;

public enum RelationEnum {
    FATHER("FATHER"),
    MOTHER("MOTHER"),
    DAUGHTER("DAUGHTER"),
    SON("SON"),
    WIFE("WIFE"),
    HUSBAND("HUSBAND")
    ;


    private String relation;

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    RelationEnum(String relation) {
        this.relation = relation;
    }
}
