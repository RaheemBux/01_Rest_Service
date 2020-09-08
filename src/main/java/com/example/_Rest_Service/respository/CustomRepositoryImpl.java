package com.example._Rest_Service.respository;

import com.example._Rest_Service.entity.ItemEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomRepositoryImpl implements CustomRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<ItemEntity> getAll(ItemEntity itemEntity) {
        String JPQL = "select name,gender,size,season,fit_group,brand,tags,year,collection,unq_Id,id,material,trans_mode,thickness_class,inc_Id from items ie where ";
        if(itemEntity.getSeason()!=null){
            if(itemEntity.getSeason().toUpperCase().contains("OR")){
                String [] seasons =itemEntity.getSeason().toUpperCase().split("OR");
                if(seasons.length==1){
                    JPQL+="ie.season=+'"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    JPQL+="ie.season='"+seasons[0].trim()+"' or ie.season='"+seasons[1].trim()+"'";
                }
            }
            else if(itemEntity.getSeason().toUpperCase().contains("AND")){
                String [] seasons =itemEntity.getSeason().toUpperCase().split("AND");
                if(seasons.length==1){
                    JPQL+="ie.season=+'"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    Query q=entityManager.createNativeQuery("select * from items where season='"+seasons[0].trim()+"'");
                    Query q2=entityManager.createNativeQuery("select * from items where season='"+seasons[1].trim()+"'");
                    boolean bool=false;
                    if(q.getResultList().isEmpty() || q2.getResultList().isEmpty()){
                        bool=true;
                    }
                    if(bool==false){
                        JPQL+="ie.season='"+seasons[0].trim()+"' and ie.season='"+seasons[1].trim()+"'";
                    }
                    else{
                        JPQL+="ie.season='"+seasons[0].trim()+"' and ie.season='"+seasons[1].trim()+"'";
                    }
                }
            }
            else {
                JPQL+="ie.season='"+itemEntity.getSeason().trim()+"'";
            }
        }
        if(itemEntity.getSeason()!=null && itemEntity.getCollection()!=null){
            JPQL+=" OR ";
        }
        if (itemEntity.getCollection()!=null){
            if(itemEntity.getCollection().toUpperCase().contains("OR")){
                String [] seasons =itemEntity.getCollection().toUpperCase().split("OR");
                if(seasons.length==1){
                    System.out.println("1");
                    JPQL+=" ie.collection=+'"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    JPQL+=" ie.collection='"+seasons[0].trim()+"' or ie.collection='"+seasons[1].trim()+"'";
                }
            }
            else if(itemEntity.getCollection().toUpperCase().contains("AND")){
                String [] seasons =itemEntity.getCollection().toUpperCase().split("AND");
                if(seasons.length==1){
                    JPQL+=" ie.collection='"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    System.out.println("2");
                    Query q=entityManager.createNativeQuery("select * from items where collection='"+seasons[0].trim()+"'");
                    Query q2=entityManager.createNativeQuery("select * from items where collection='"+seasons[1].trim()+"'");
                    boolean bool=false;
                    if(q.getResultList().isEmpty() || q2.getResultList().isEmpty()){
                        bool=true;
                    }
                    if(bool==false){
                        JPQL+=" ie.collection='"+seasons[0].trim()+"' or ie.collection='"+seasons[1].trim()+"'";
                    }
                    else{
                        JPQL+=" ie.collection='"+seasons[0].trim()+"' and ie.collection='"+seasons[1].trim()+"'";
                    }
                }
            }
            else {
                JPQL+=" ie.collection='"+itemEntity.getCollection().trim()+"'";
            }
        }
        System.out.println(itemEntity.getBrand()+"=======");
        if((itemEntity.getSeason()!=null || itemEntity.getCollection()!=null) && itemEntity.getBrand()!=null){
            JPQL+=" OR ";
        }
        if(itemEntity.getBrand()!=null){
            if(itemEntity.getBrand().toUpperCase().contains("OR")){
                String [] seasons =itemEntity.getBrand().toUpperCase().split("OR");
                if(seasons.length==1){
                    JPQL+=" ie.brand=+'"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    JPQL+=" ie.brand='"+seasons[0].trim()+"' or ie.brand='"+seasons[1].trim()+"'";
                }
            }
            else if(itemEntity.getBrand().toUpperCase().contains("AND")){
                String [] seasons =itemEntity.getBrand().toUpperCase().split("AND");
                if(seasons.length==1){
                    JPQL+=" ie.collection='"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    System.out.println("2");
                    Query q=entityManager.createNativeQuery("select * from items where brand='"+seasons[0].trim()+"'");
                    Query q2=entityManager.createNativeQuery("select * from items where brand='"+seasons[1].trim()+"'");
                    boolean bool=false;
                    if(q.getResultList().isEmpty() || q2.getResultList().isEmpty()){
                        bool=true;
                    }
                    if(bool==false){
                        JPQL+=" ie.brand='"+seasons[0].trim()+"' and ie.brand='"+seasons[1].trim()+"'";
                    }
                    else{
                        JPQL+=" ie.brand='"+seasons[0].trim()+"' and ie.brand='"+seasons[1].trim()+"'";
                    }
                }
            }
            else {
                JPQL+=" ie.brand='"+itemEntity.getBrand().trim()+"'";
            }
        }
        if((itemEntity.getSeason()!=null || itemEntity.getCollection()!=null || itemEntity.getBrand()!=null) && itemEntity.getName()!=null){
            JPQL+=" OR ";
        }
        if(itemEntity.getName()!=null){
            if(itemEntity.getName().toUpperCase().contains("OR")){ ;
                String [] seasons =itemEntity.getName().toUpperCase().split("OR");
                if(seasons.length==1){
                    JPQL+=" ie.name=+'"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    JPQL+=" ie.name='"+seasons[0].trim()+"' or ie.name='"+seasons[1].trim()+"'";
                }
            }
            else if(itemEntity.getName().toUpperCase().contains("AND")){
                System.out.println("Brand AND");
                String [] seasons =itemEntity.getName().toUpperCase().split("AND");
                if(seasons.length==1){
                    System.out.println("1 collection");
                    JPQL+=" ie.collection='"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    System.out.println("2");
                    Query q=entityManager.createNativeQuery("select * from items where name='"+seasons[0].trim()+"'");
                    Query q2=entityManager.createNativeQuery("select * from items where name='"+seasons[1].trim()+"'");
                    boolean bool=false;
                    if(q.getResultList().isEmpty() || q2.getResultList().isEmpty()){
                        bool=true;
                    }
                    if(bool==false){
                        JPQL+=" ie.name='"+seasons[0].trim()+"' and ie.name='"+seasons[1].trim()+"'";
                    }
                    else{
                        JPQL+=" ie.name='"+seasons[0].trim()+"' and ie.name='"+seasons[1].trim()+"'";
                    }
                }
            }
            else {
                System.out.println("hello in elsee brand ");
                JPQL+=" ie.name='"+itemEntity.getName().trim()+"'";
            }
        }

        if((itemEntity.getSeason()!=null || itemEntity.getCollection()!=null || itemEntity.getBrand()!=null || itemEntity.getName()!=null) && itemEntity.getGender()!=null){
            JPQL+=" OR ";
        }
        if(itemEntity.getGender()!=null){
            System.out.println("Name  "+itemEntity.getGender());
            if(itemEntity.getGender().toUpperCase().contains("OR")){
                System.out.println("Brand OR");
                String [] seasons =itemEntity.getGender().toUpperCase().split("OR");
                if(seasons.length==1){
                    System.out.println("1");
                    JPQL+=" ie.name=+'"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    System.out.println("2 collection");
                    JPQL+=" ie.gender='"+seasons[0].trim()+"' or ie.name='"+seasons[1].trim()+"'";
                }
            }
            else if(itemEntity.getGender().toUpperCase().contains("AND")){
                System.out.println("Brand AND");
                String [] seasons =itemEntity.getGender().toUpperCase().split("AND");
                if(seasons.length==1){
                    System.out.println("1 collection");
                    JPQL+=" ie.collection='"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    System.out.println("2");
                    Query q=entityManager.createNativeQuery("select * from items where gender='"+seasons[0].trim()+"'");
                    Query q2=entityManager.createNativeQuery("select * from items where gender='"+seasons[1].trim()+"'");
                    boolean bool=false;
                    if(q.getResultList().isEmpty() || q2.getResultList().isEmpty()){
                        bool=true;
                    }
                    if(bool==false){
                        JPQL+=" ie.gender='"+seasons[0].trim()+"' and ie.gender='"+seasons[1].trim()+"'";
                    }
                    else{
                        JPQL+=" ie.gender='"+seasons[0].trim()+"' and ie.gender='"+seasons[1].trim()+"'";
                    }
                }
            }
            else {
                System.out.println("hello in elsee brand ");
                JPQL+=" ie.gender='"+itemEntity.getGender().trim()+"'";
            }
        }

        if((itemEntity.getSeason()!=null || itemEntity.getCollection()!=null || itemEntity.getBrand()!=null || itemEntity.getName()!=null || itemEntity.getGender()!=null) && itemEntity.getSize()!=null){
            JPQL+=" OR ";
        }
        if(itemEntity.getSize()!=null){
            System.out.println("Name  "+itemEntity.getSize());
            if(itemEntity.getSize().toUpperCase().contains("OR")){
                System.out.println("Brand OR");
                String [] seasons =itemEntity.getSize().toUpperCase().split("OR");
                if(seasons.length==1){
                    System.out.println("1");
                    JPQL+=" ie.size=+'"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    System.out.println("2 collection");
                    JPQL+=" ie.size='"+seasons[0].trim()+"' or ie.size='"+seasons[1].trim()+"'";
                }
            }
            else if(itemEntity.getSize().toUpperCase().contains("AND")){
                System.out.println("Brand AND");
                String [] seasons =itemEntity.getSize().toUpperCase().split("AND");
                if(seasons.length==1){
                    System.out.println("1 collection");
                    JPQL+=" ie.size='"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    System.out.println("2");
                    Query q=entityManager.createNativeQuery("select * from items where size='"+seasons[0].trim()+"'");
                    Query q2=entityManager.createNativeQuery("select * from items where size='"+seasons[1].trim()+"'");
                    boolean bool=false;
                    if(q.getResultList().isEmpty() || q2.getResultList().isEmpty()){
                        bool=true;
                    }
                    if(bool==false){
                        JPQL+=" ie.size='"+seasons[0].trim()+"' and ie.size='"+seasons[1].trim()+"'";
                    }
                    else{
                        JPQL+=" ie.size='"+seasons[0].trim()+"' and ie.size='"+seasons[1].trim()+"'";
                    }
                }
            }
            else {
                System.out.println("hello in elsee brand ");
                JPQL+=" ie.size='"+itemEntity.getSize().trim()+"'";
            }
        }

        if((itemEntity.getSeason()!=null || itemEntity.getCollection()!=null || itemEntity.getBrand()!=null || itemEntity.getName()!=null ||
                itemEntity.getGender()!=null || itemEntity.getSize()!=null) && itemEntity.getTags()!=null){
            JPQL+=" OR ";
        }
        if(itemEntity.getTags()!=null){
            System.out.println("Name  "+itemEntity.getTags());
            if(itemEntity.getTags().toUpperCase().contains("OR")){
                System.out.println("Brand OR");
                String [] seasons =itemEntity.getTags().toUpperCase().split("OR");
                if(seasons.length==1){
                    System.out.println("1");
                    JPQL+=" ie.tags=+'"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    System.out.println("2 collection");
                    JPQL+=" ie.tags='"+seasons[0].trim()+"' or ie.tags='"+seasons[1].trim()+"'";
                }
            }
            else if(itemEntity.getTags().toUpperCase().contains("AND")){
                System.out.println("Brand AND");
                String [] seasons =itemEntity.getTags().toUpperCase().split("AND");
                if(seasons.length==1){
                    System.out.println("1 collection");
                    JPQL+=" ie.tags='"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    System.out.println("2");
                    Query q=entityManager.createNativeQuery("select * from items where tags='"+seasons[0].trim()+"'");
                    Query q2=entityManager.createNativeQuery("select * from items where tags='"+seasons[1].trim()+"'");
                    boolean bool=false;
                    if(q.getResultList().isEmpty() || q2.getResultList().isEmpty()){
                        bool=true;
                    }
                    if(bool==false){
                        JPQL+=" ie.tags='"+seasons[0].trim()+"' and ie.tags='"+seasons[1].trim()+"'";
                    }
                    else{
                        JPQL+=" ie.tags='"+seasons[0].trim()+"' and ie.tags='"+seasons[1].trim()+"'";
                    }
                }
            }
            else {
                System.out.println("hello in elsee brand ");
                JPQL+=" ie.tags='"+itemEntity.getTags().trim()+"'";
            }
        }

        if((itemEntity.getSeason()!=null || itemEntity.getCollection()!=null || itemEntity.getBrand()!=null || itemEntity.getName()!=null ||
                itemEntity.getGender()!=null || itemEntity.getSize()!=null || itemEntity.getTags()!=null) && itemEntity.getFitGroup()!=null){
            JPQL+=" OR ";
        }
        if(itemEntity.getFitGroup()!=null){
            System.out.println("Name  "+itemEntity.getFitGroup());
            if(itemEntity.getFitGroup().toUpperCase().contains("OR")){
                System.out.println("Brand OR");
                String [] seasons =itemEntity.getFitGroup().toUpperCase().split("OR");
                if(seasons.length==1){
                    System.out.println("1");
                    JPQL+=" ie.fit_group=+'"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    System.out.println("2 collection");
                    JPQL+=" ie.fit_group='"+seasons[0].trim()+"' or ie.fit_group='"+seasons[1].trim()+"'";
                }
            }
            else if(itemEntity.getTags().toUpperCase().contains("AND")){
                System.out.println("Brand AND");
                String [] seasons =itemEntity.getFitGroup().toUpperCase().split("AND");
                if(seasons.length==1){
                    System.out.println("1 collection");
                    JPQL+=" ie.fit_group='"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    System.out.println("2");
                    Query q=entityManager.createNativeQuery("select * from items where fit_group='"+seasons[0].trim()+"'");
                    Query q2=entityManager.createNativeQuery("select * from items where fit_group='"+seasons[1].trim()+"'");
                    boolean bool=false;
                    if(q.getResultList().isEmpty() || q2.getResultList().isEmpty()){
                        bool=true;
                    }
                    if(bool==false){
                        JPQL+=" ie.fit_group='"+seasons[0].trim()+"' and ie.fit_group='"+seasons[1].trim()+"'";
                    }
                    else{
                        JPQL+=" ie.fit_group='"+seasons[0].trim()+"' and ie.fit_group='"+seasons[1].trim()+"'";
                    }
                }
            }
            else {
                System.out.println("hello in elsee brand ");
                JPQL+=" ie.fit_group='"+itemEntity.getFitGroup().trim()+"'";
            }
        }

        if((itemEntity.getSeason()!=null || itemEntity.getCollection()!=null || itemEntity.getBrand()!=null || itemEntity.getName()!=null ||
                itemEntity.getGender()!=null || itemEntity.getSize()!=null || itemEntity.getTags()!=null || itemEntity.getFitGroup()!=null) && itemEntity.getUniqueId()!=null){
            JPQL+=" OR ";
        }
        if(itemEntity.getUniqueId()!=null){
            System.out.println("Name  "+itemEntity.getUniqueId());
            if(itemEntity.getUniqueId().toUpperCase().contains("OR")){
                System.out.println("Brand OR");
                String [] seasons =itemEntity.getUniqueId().toUpperCase().split("OR");
                if(seasons.length==1){
                    System.out.println("1");
                    JPQL+=" ie.unq_Id=+'"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    System.out.println("2 collection");
                    JPQL+=" ie.unq_Id='"+seasons[0].trim()+"' or ie.unq_Id='"+seasons[1].trim()+"'";
                }
            }
            else if(itemEntity.getTags().toUpperCase().contains("AND")){
                System.out.println("Brand AND");
                String [] seasons =itemEntity.getUniqueId().toUpperCase().split("AND");
                if(seasons.length==1){
                    System.out.println("1 collection");
                    JPQL+=" ie.unq_Id='"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    System.out.println("2");
                    Query q=entityManager.createNativeQuery("select * from items where unq_Id='"+seasons[0].trim()+"'");
                    Query q2=entityManager.createNativeQuery("select * from items where unq_Id='"+seasons[1].trim()+"'");
                    boolean bool=false;
                    if(q.getResultList().isEmpty() || q2.getResultList().isEmpty()){
                        bool=true;
                    }
                    if(bool==false){
                        JPQL+=" ie.unq_Id='"+seasons[0].trim()+"' and ie.unq_Id='"+seasons[1].trim()+"'";
                    }
                    else{
                        JPQL+=" ie.unq_Id='"+seasons[0].trim()+"' and ie.unq_Id='"+seasons[1].trim()+"'";
                    }
                }
            }
            else {
                System.out.println("hello in elsee brand ");
                JPQL+=" ie.unq_Id='"+itemEntity.getUniqueId().trim()+"'";
            }
        }

        if((itemEntity.getSeason()!=null || itemEntity.getCollection()!=null || itemEntity.getBrand()!=null || itemEntity.getName()!=null ||
                itemEntity.getGender()!=null || itemEntity.getSize()!=null || itemEntity.getTags()!=null || itemEntity.getFitGroup()!=null ||
                itemEntity.getUniqueId()!=null) && itemEntity.getYear()!=null){
            JPQL+=" OR ";
        }
        if(itemEntity.getYear()!=null){
            System.out.println("Name  "+itemEntity.getYear());
            if(itemEntity.getYear().toUpperCase().contains("OR")){
                System.out.println("Brand OR");
                String [] seasons =itemEntity.getYear().toUpperCase().split("OR");
                if(seasons.length==1){
                    System.out.println("1");
                    JPQL+=" ie.year=+'"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    System.out.println("2 collection");
                    JPQL+=" ie.year='"+seasons[0].trim()+"' or ie.year='"+seasons[1].trim()+"'";
                }
            }
            else if(itemEntity.getYear().toUpperCase().contains("AND")){
                System.out.println("Brand AND");
                String [] seasons =itemEntity.getYear().toUpperCase().split("AND");
                if(seasons.length==1){
                    System.out.println("1 collection");
                    JPQL+=" ie.year='"+seasons[0].trim()+"'";
                }
                else if(seasons.length==2){
                    System.out.println("2");
                    Query q=entityManager.createNativeQuery("select * from items where year='"+seasons[0].trim()+"'");
                    Query q2=entityManager.createNativeQuery("select * from items where year='"+seasons[1].trim()+"'");
                    boolean bool=false;
                    if(q.getResultList().isEmpty() || q2.getResultList().isEmpty()){
                        bool=true;
                    }
                    if(bool==false){
                        JPQL+=" ie.year='"+seasons[0].trim()+"' and ie.year='"+seasons[1].trim()+"'";
                    }
                    else{
                        JPQL+=" ie.year='"+seasons[0].trim()+"' and ie.year='"+seasons[1].trim()+"'";
                    }
                }
            }
            else {
                System.out.println("hello in elsee brand ");
                JPQL+=" ie.year='"+itemEntity.getYear().trim()+"'";
            }
        }

        System.out.println("jpql lasst==="+JPQL);
        Query query = entityManager.createNativeQuery(JPQL);
        List<Object []> list=query.getResultList();
        List<ItemEntity> itemEntityList=new ArrayList<>();
        for(Object[] objects : list){
            ItemEntity ie=new ItemEntity();
            for(int i =0; i<objects.length; i++){
                System.out.println(objects[i]+" -- "+i);
                if(i==0){
                    ie.setName(objects[i].toString());
                }
                else if(i==1){
                    ie.setGender(objects[i].toString());
                }
                else if(i==2){
                    ie.setSize(objects[i].toString());
                }
                else if(i==3){
                    ie.setSeason(objects[i].toString());
                }
                else if(i==4){
                    ie.setFitGroup(objects[i].toString());
                }
                else  if(i==5){
                    ie.setBrand(objects[i].toString());
                }
                else  if(i==6){
                    ie.setTags(objects[i].toString());
                }
                else  if(i==7){
                    ie.setYear(objects[i].toString());
                }
                else  if(i==8){
                    ie.setCollection(objects[i].toString());
                }
                else  if(i==9){
                    ie.setUniqueId(objects[i].toString());
                }
                else  if(i==10){
                    ie.setId(objects[i].toString());
                }
                else  if(i==11){
                    ie.setMaterial(objects[i].toString());
                }
                else  if(i==12){
                    ie.setTransMode(objects[i].toString());
                }
                else  if(i==13){
                    ie.setThicknessClass(objects[i].toString());
                }
                else  if(i==14){
                    ie.setIncId(Integer.parseInt(objects[i].toString()));
                }


            }
            itemEntityList.add(ie);
        }
        return itemEntityList;
    }
}
