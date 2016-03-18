package com.bwts.dao;
import com.bwts.model.DocumentModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface DocumentsMapper{

    //@Insert("INSERT INTO trade (tid, title)  VALUES (#{tid}, #{title})")
    DocumentModel getDocumentById(@Param("invoiceId") Long invoiceId);

}