package com.liugs.algorithm.pedigree;

/**
 * @author liugs
 * @createTime 2022/2/10 15:21
 */
public class FamilyRelationVo {
    private String idCard;
    private String relateIdCard;
    private RelationEnum relation;

    public FamilyRelationVo(String idCard, String relateIdCard, RelationEnum relation) {
        this.idCard = idCard;
        this.relateIdCard = relateIdCard;
        this.relation = relation;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getRelateIdCard() {
        return relateIdCard;
    }

    public void setRelateIdCard(String relateIdCard) {
        this.relateIdCard = relateIdCard;
    }

    public RelationEnum getRelation() {
        return relation;
    }

    public void setRelation(RelationEnum relation) {
        this.relation = relation;
    }
}
