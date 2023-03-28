package com.example.SpringBoot_movie_admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.SpringBoot_movie_admin.entity.tool.ToolTree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: yang-sir
 * @date: 2023/3/27 14:16
 * @projectName: SpringBoot_movie_admin
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
    @TableId(value="id",type= IdType.AUTO)
    public Integer id;
    public String value;//地区的英文名
    public String label;//地区展示的名字
    public Integer level;
    public Integer parentId;



    public List<ToolTree> getTree(List<BaseEntity> itemList) {
        List<ToolTree> list=new ArrayList<>();
        for(BaseEntity item:itemList){
            ToolTree tree =new ToolTree();
            level=1;
            if(item.getParentId()==0){
                BeanUtils.copyProperties(item,tree);
                tree.setLevel(level);
                tree.setChildren(getChildTree(itemList,item.getId()));
                list.add(tree);
            }
        }

        return list;
    }

    public List<ToolTree> getChildTree(List<BaseEntity> itemList, Integer id) {
        List<ToolTree> childList=new ArrayList<>();
        level++;
        for(BaseEntity item:itemList){
            ToolTree childTree =new ToolTree();

            if(Objects.equals(item.getParentId(), id)){
                BeanUtils.copyProperties(item,childTree);
                childTree.setLevel(level);
                childTree.setChildren(getChildTree(itemList,item.getId()));

                childList.add(childTree);
                level--;
            }

        }
        return childList;
    }

    public  Object parentSubclass(Object parent,Object subclass){
        Field[] parents = parent.getClass().getDeclaredFields();//获取所有属性
        Field[] children = subclass.getClass().getSuperclass().getDeclaredFields();//获取父类所有属性
        try {
            for (Field fieldParent : parents){
                fieldParent.setAccessible(true);
                String nameParent = fieldParent.getName(); //获取属性的名字
                Object valueParent = fieldParent.get(parent);//获取属性值
                for (Field fieldChild : children){
                    fieldChild.setAccessible(true);
                    String nameChild = fieldChild.getName(); //获取属性的名字
                    Object valueChild= fieldChild.get(subclass);
                    if (nameChild.equals(nameParent)){
                        fieldChild.set(subclass,valueParent);
                    }

                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return subclass;
    }



}
