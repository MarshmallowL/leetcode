package com.liugs.algorithm.pedigree;

import java.util.List;
import java.util.UUID;

/**
 * @author liugs
 * @createTime 2022/2/10 15:26
 */
public class PedigreeVo {
    private String familyId = UUID.randomUUID().toString().replace("_","");
    private Point father;
    private Point mother;
    private Point mateNode;
    private Point childNode;
    private List<Point> children;

    public PedigreeVo(Point father, Point mother, Point mateNode, Point childNode, List<Point> children) {
        this.father = father;
        this.mother = mother;
        this.mateNode = mateNode;
        this.childNode = childNode;
        this.children = children;
    }

    public void executeOffset(int xOffset,int yOffset){
        father.offset(xOffset,yOffset);
        mother.offset(xOffset,yOffset);
        mateNode.offset(xOffset,yOffset);
        childNode.offset(xOffset,yOffset);
        for (Point point : children){
            point.offset(xOffset,yOffset);
        }
    }

    public Point getFather() {
        return father;
    }

    public void setFather(Point father) {
        this.father = father;
    }

    public Point getMother() {
        return mother;
    }

    public void setMother(Point mother) {
        this.mother = mother;
    }

    public Point getMateNode() {
        return mateNode;
    }

    public void setMateNode(Point mateNode) {
        this.mateNode = mateNode;
    }

    public Point getChildNode() {
        return childNode;
    }

    public void setChildNode(Point childNode) {
        this.childNode = childNode;
    }

    public List<Point> getChildren() {
        return children;
    }

    public void setChildren(List<Point> children) {
        this.children = children;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    @Override
    public String toString() {

        return "PedigreeVo{" +
                "father=" + father +
                ", mother=" + mother +
                ", mateNode=" + mateNode +
                ", childNode=" + childNode +
                ", children=" + children +
                '}';
    }
}
