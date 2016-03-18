package com.bwts.service;

import com.bwts.dao.DocumentsMapper;
import com.bwts.model.DocumentModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;


@Service
@Transactional
public class DocumentsService {

    //private static final Logger LOGGER = LoggerFactory.getLogger(DocumentsService.class);
    @Autowired
    DocumentsMapper documentsMapper;

    /*@Inject
    public DocumentsService(DocumentsMapper documentsMapper) {
        this.documentsMapper = documentsMapper;;
    }*/

    public DocumentModel getDocumentById(Long id) {
        DocumentModel documentModel = documentsMapper.getDocumentById(id);
        return documentModel;
    }

}
