package com.liugs.algorithm.pedigree;

import java.util.*;
import java.util.stream.Collectors;

import static com.liugs.algorithm.pedigree.RelationEnum.*;

/**
 * @author liugs
 * @createTime 2022/2/10 15:26
 * TODO 独立计算每颗家庭树，然后根据familyId合并，目前只考虑最多有两个子节点的情况
 */
public class PedigreeAlgorithm {
    public List<PedigreeVo> calPedigree(List<FamilyRelationVo> familyRelationList) {
        //先计算单个家庭关系的树
        List<PedigreeVo> pedigreeVoList = getSingleFamily(familyRelationList);
        //关联相同成员不同层级的家庭关系，对位置做偏移调整
        balance(pedigreeVoList,"II-3");
        return pedigreeVoList;
    }

    private List<PedigreeVo> getSingleFamily(List<FamilyRelationVo> list) {
        //按本端证件分组
        Collection<List<FamilyRelationVo>> groupFamily = list.stream().collect(Collectors.groupingBy(FamilyRelationVo::getIdCard)).values();
        Set<String> usedIdSet = new HashSet<>();
        List<PedigreeVo> resultList = new ArrayList<>();
        for (List<FamilyRelationVo> groupList : groupFamily) {
            FamilyRelationVo familyRelationVo = groupList.get(0);
            if (usedIdSet.contains(familyRelationVo.getIdCard())) {
                continue;
            }
            //过滤出当前节点的夫妻节点
            FamilyRelationVo mateVo = groupList.stream().filter(vo -> WIFE == vo.getRelation() || HUSBAND == vo.getRelation()).findAny().orElse(null);
            if (mateVo == null) {
                continue;
            }
            //计算当前节点的位置
            Point father;
            Point mother;
            usedIdSet.add(mateVo.getRelateIdCard());
            if (mateVo.getRelation() == WIFE) {
                father = new Point(mateVo.getIdCard(), 0, 0);
                mother = new Point(mateVo.getRelateIdCard(), 6, 0);
            } else {
                father = new Point(mateVo.getRelateIdCard(), 0, 0);
                mother = new Point(mateVo.getIdCard(), 6, 0);
            }
            Point mateNode = new Point(null, 3, 0);
            Point childNode = new Point(null, 3, 1);
            List<FamilyRelationVo> childrenList = groupList.stream().filter(vo -> SON == vo.getRelation() || DAUGHTER == vo.getRelation())
                    .collect(Collectors.toList());
            List<Point> children = new ArrayList<>();
            if (!childrenList.isEmpty()) {
                int childrenSize = childrenList.size();
                int initX = 6 - 3 * childrenSize;
                for (FamilyRelationVo relationVo : childrenList) {
                    children.add(new Point(relationVo.getRelateIdCard(), initX, 2));
                    initX += 6;
                }
            }
            PedigreeVo pedigreeVo = new PedigreeVo(father, mother, mateNode, childNode, children);
            resultList.add(pedigreeVo);
        }
        return resultList;
    }

    private void balance(List<PedigreeVo> list,String id) {
        Set<String> usedFamilyIdSet = new HashSet<>();
        //先找到查询id所属的家庭
        PedigreeVo mainFamily = list.stream().filter(vo -> vo.getChildren().stream().map(Point::getId).anyMatch(id::equals))
                .findFirst().orElse(null);
        if (mainFamily == null){
            return;
        }
        //找父亲节点所属家庭
        Point father = mainFamily.getFather();
        PedigreeVo fatherFamily = list.stream().filter(vo -> vo.getChildren().stream().map(Point::getId).anyMatch(father.getId()::equals))
                .findFirst().orElse(null);
        if (fatherFamily != null){
            Point fatherAsChild = fatherFamily.getChildren().stream().filter(vo -> vo.getId().equals(father.getId())).findAny().get();
            int xOffset = father.getX() - fatherAsChild.getX();
            int yOffset = father.getY() - fatherAsChild.getY();
            fatherFamily.executeOffset(xOffset,yOffset);
            List<Point> brotherPointList = fatherFamily.getChildren().stream().filter(vo -> !vo.getId().equals(father.getId()))
                    .collect(Collectors.toList());
            for (Point point:brotherPointList){

            }
        }
    }

    public static void main(String[] args) {
        //构造测试数据
        List<FamilyRelationVo> list = new LinkedList<>();
        list.add(new FamilyRelationVo("I-1", "I-2", WIFE));
        list.add(new FamilyRelationVo("I-1", "II-1", SON));
        list.add(new FamilyRelationVo("I-2", "I-1", HUSBAND));
        list.add(new FamilyRelationVo("I-2", "II-1", SON));
        list.add(new FamilyRelationVo("II-1", "I-1", FATHER));
        list.add(new FamilyRelationVo("II-1", "I-2", MOTHER));
        list.add(new FamilyRelationVo("II-1", "II-2", WIFE));
        list.add(new FamilyRelationVo("II-1", "III-1", SON));
        list.add(new FamilyRelationVo("III-1", "II-1", FATHER));
        list.add(new FamilyRelationVo("III-1", "II-2", MOTHER));
        list.add(new FamilyRelationVo("II-2", "II-1", HUSBAND));
        list.add(new FamilyRelationVo("II-2", "III-1", SON));
        list.add(new FamilyRelationVo("II-2", "I-3", FATHER));
        list.add(new FamilyRelationVo("II-2", "I-4", MOTHER));
        list.add(new FamilyRelationVo("I-3", "I-4", WIFE));
        list.add(new FamilyRelationVo("I-3", "II-2", DAUGHTER));
        list.add(new FamilyRelationVo("I-3", "II-3", SON));
        list.add(new FamilyRelationVo("I-4", "I-3", HUSBAND));
        list.add(new FamilyRelationVo("I-4", "II-2", DAUGHTER));
        list.add(new FamilyRelationVo("I-4", "II-3", SON));
        list.add(new FamilyRelationVo("II-3", "I-3", FATHER));
        list.add(new FamilyRelationVo("II-3", "I-4", MOTHER));
        list.add(new FamilyRelationVo("II-3", "II-4", WIFE));
        list.add(new FamilyRelationVo("II-3", "III-2", SON));
        list.add(new FamilyRelationVo("III-2", "II-3", FATHER));
        list.add(new FamilyRelationVo("III-2", "II-4", MOTHER));
        list.add(new FamilyRelationVo("II-4", "I-5", FATHER));
        list.add(new FamilyRelationVo("II-4", "I-6", MOTHER));
        list.add(new FamilyRelationVo("II-4", "II-3", HUSBAND));
        list.add(new FamilyRelationVo("II-4", "III-2", SON));
        list.add(new FamilyRelationVo("I-5", "I-6", WIFE));
        list.add(new FamilyRelationVo("I-5", "II-4", SON));
        list.add(new FamilyRelationVo("I-5", "II-5", DAUGHTER));
        list.add(new FamilyRelationVo("I-6", "I-5", HUSBAND));
        list.add(new FamilyRelationVo("I-6", "II-4", SON));
        list.add(new FamilyRelationVo("I-6", "II-5", DAUGHTER));
        list.add(new FamilyRelationVo("II-5", "I-5", FATHER));
        list.add(new FamilyRelationVo("II-5", "I-6", MOTHER));
        list.add(new FamilyRelationVo("II-5", "II-6", HUSBAND));
        list.add(new FamilyRelationVo("II-5", "III-3", DAUGHTER));
        list.add(new FamilyRelationVo("II-6", "II-5", WIFE));
        list.add(new FamilyRelationVo("II-6", "III-3", DAUGHTER));
        list.add(new FamilyRelationVo("III-3", "II-5", MOTHER));
        list.add(new FamilyRelationVo("III-3", "II-6", FATHER));
        PedigreeAlgorithm pedigreeAlgorithm = new PedigreeAlgorithm();
        List<PedigreeVo> resultList = pedigreeAlgorithm.calPedigree(list);
        System.out.println(resultList.size());
    }
}
