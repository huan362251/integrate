package com.bawangbai.elastic.search.pojo.es;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@Document(indexName = "name_do")
@ApiModel(value = "SystemLog", description = "ES系统日志实体类")
public class NameDO {

    @Id
    private Long id;

    @Field(name = "name_en",type = FieldType.Text)
    private String nameEn;

    @Field(name = "name_zn",type = FieldType.Text)
    private String nameZn;

    @Field(name = "nomi",type = FieldType.Keyword)
    private List<String> noList;

}
