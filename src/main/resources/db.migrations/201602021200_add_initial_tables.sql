-- tables
-- Table: documents
CREATE TABLE documents (
    id bigserial  NOT NULL,
    oid uuid  NOT NULL,
    invoice_type varchar(30)  NULL,
    invoice_number varchar(200)  NULL,
    supplier_name varchar(200)  NULL,
    supplier_bank_account varchar(30)  NULL,
    buyer_name varchar(200)  NULL,
    buyer_bank_account varchar(30)  NULL,
    buyer_email varchar(200)  NULL,
    buyer_phone varchar(30)  NULL,
    issue_date timestamp  NULL,
    issuer_name varchar(200)  NULL,
    total_ex_tax numeric(15,2)  NULL,
    total_tax numeric(15,2)  NULL,
    total_in_tax numeric(15,2)  NULL,
    third_party_code varchar(30)  NULL,
    issue_request_number varchar(200)  NULL,
    invoice_code varchar(30)  NULL,
    supplier_tax_number varchar(200)  NULL,
    create_time timestamp  NULL,
    update_time bigint  NULL,
    create_by bigint  NULL,
    update_by timestamp  NULL,
    doc_shard_id bigint  NOT NULL,
    tenant_id bigint  NOT NULL,
    data_central_id bigint  NOT NULL,
    CONSTRAINT documents_pk PRIMARY KEY (id)
);

CREATE INDEX documents_buyer_name__index on documents (buyer_name ASC);


CREATE INDEX documents_buyer_bank_account_index on documents (buyer_bank_account ASC);


CREATE INDEX documents_buyer_email_index on documents (buyer_email ASC);


CREATE INDEX documents_buyer_phone_index on documents (buyer_phone ASC);


CREATE INDEX documents_invoice_number_index on documents (invoice_number ASC);


CREATE INDEX documents_issue_date_index on documents (issue_date ASC);


CREATE INDEX documents_issue_name_index on documents (issuer_name ASC);


CREATE INDEX documents_oid_index on documents (oid ASC);


CREATE INDEX documents_dci_dsi_index on documents (data_central_id ASC,doc_shard_id ASC);




-- Table: documents_identifier_binding
CREATE TABLE documents_identifier_binding (
    id bigserial  NOT NULL,
    document_id bigint  NOT NULL,
    identifier_code varchar(30)  NOT NULL,
    identifier_value varchar(200)  NOT NULL,
    third_party_code varchar(30)  NOT NULL,
    create_time timestamp  NULL,
    update_time timestamp  NULL,
    create_by bigint  NULL,
    insert_by bigint  NULL,
    CONSTRAINT documents_identifier_binding_pk PRIMARY KEY (id)
);

CREATE INDEX dib_icode_ivalue_tpcode_index on documents_identifier_binding (identifier_code ASC,identifier_value ASC,third_party_code ASC);




-- Table: email_verification_tokens
CREATE TABLE email_verification_tokens (
    id bigserial  NOT NULL,
    email varchar(200)  NOT NULL,
    token uuid  NOT NULL,
    verified boolean  NOT NULL,
    application varchar(30)  NOT NULL,
    user_id bigint  NOT NULL,
    create_time timestamp  NULL,
    update_time timestamp  NULL,
    create_by bigint  NULL,
    update_by bigint  NULL,
    CONSTRAINT email_verification_tokens_pk PRIMARY KEY (id)
);

CREATE INDEX email_verification_tokens_email_index on email_verification_tokens (email ASC);




-- Table: mobile_verification_tokens
CREATE TABLE mobile_verification_tokens (
    id bigserial  NOT NULL,
    phone varchar(30)  NOT NULL,
    code varchar(30)  NOT NULL,
    verified varchar(30)  NOT NULL,
    user_id bigint  NOT NULL,
    create_time timestamp  NULL,
    update_time timestamp  NULL,
    create_by bigint  NULL,
    update_by bigint  NULL,
    CONSTRAINT mobile_verification_tokens_pk PRIMARY KEY (id)
);

CREATE INDEX mobile_verification_tokens_phone_index on mobile_verification_tokens (phone ASC);




-- Table: ofd_documents
CREATE TABLE ofd_documents (
    id int  NOT NULL,
    document_id bigint  NULL,
    ofd_id uuid  NULL,
    status varchar(30)  NOT NULL,
    message character varying  NULL,
    create_time timestamp  NULL,
    update_time timestamp  NULL,
    create_by bigint  NULL,
    update_by bigint  NULL,
    CONSTRAINT ofd_documents_pk PRIMARY KEY (id)
);

CREATE INDEX ofd_documents_document_id_index on ofd_documents (document_id ASC);


CREATE INDEX ofd_documents_ofd_id_index on ofd_documents (ofd_id ASC);




-- Table: pdf_documents
CREATE TABLE pdf_documents (
    id bigserial  NOT NULL,
    pdf_doc_id uuid  NULL,
    document_id bigint  NULL,
    status varchar(30)  NULL,
    create_time timestamp  NULL,
    update_time timestamp  NULL,
    create_by bigint  NULL,
    update_by bigint  NULL,
    CONSTRAINT pdf_documents_pk PRIMARY KEY (id)
);

CREATE INDEX tsd_document_id_index on pdf_documents (document_id ASC);


CREATE INDEX tsd_signed_doc_id_index on pdf_documents (pdf_doc_id ASC);




-- Table: property_config
CREATE TABLE property_config (
    id bigserial  NOT NULL,
    name varchar(200)  NULL,
    code varchar(30)  NULL,
    value varchar(200)  NULL,
    is_valid boolean  NULL,
    description character varying  NULL,
    CONSTRAINT property_config_ncv_unique UNIQUE (name, code, value) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT property_config_pk PRIMARY KEY (id)
);

CREATE INDEX property_config_name_code_index on property_config (name ASC,code ASC);




-- Table: tenant_business
CREATE TABLE tenant_business (
    id bigserial  NOT NULL,
    business_name varchar(200)  NULL,
    tenant_id bigint  NULL,
    country varchar(30)  NULL,
    state varchar(30)  NULL,
    city varchar(30)  NULL,
    district varchar(30)  NULL,
    address_line varchar(200)  NULL,
    phone varchar(30)  NULL,
    email varchar(200)  NULL,
    create_time timestamp  NULL,
    update_time timestamp  NULL,
    create_by bigint  NULL,
    update_by bigint  NULL,
    CONSTRAINT tenant_business_pk PRIMARY KEY (id)
);

CREATE INDEX tenant_business_customer_id on tenant_business (tenant_id ASC);




-- Table: tenant_credentials
CREATE TABLE tenant_credentials (
    id bigserial  NOT NULL,
    third_party_code varchar(30)  NOT NULL,
    third_party_desc varchar(200)  NOT NULL,
    secret_key varchar(200)  NOT NULL,
    tenant_id bigint  NOT NULL,
    create_time timestamp  NULL,
    update_time timestamp  NULL,
    create_by bigint  NULL,
    update_by bigint  NULL,
    CONSTRAINT tenant_credentials_pk PRIMARY KEY (id)
);

CREATE INDEX tenant_third_party_tenant_id_index on tenant_credentials (tenant_id ASC);




-- Table: tenant_identifier_binding
CREATE TABLE tenant_identifier_binding (
    id bigserial  NOT NULL,
    identifier_code varchar(30)  NOT NULL,
    identifier_value varchar(200)  NOT NULL,
    third_party_code varchar(30)  NOT NULL,
    status varchar(30)  NOT NULL,
    tenant_id bigint  NOT NULL,
    create_time timestamp  NULL,
    update_time timestamp  NULL,
    create_by bigint  NULL,
    update_by bigint  NULL,
    CONSTRAINT tenant_identifier_binding_pk PRIMARY KEY (id)
);

CREATE INDEX tib_icode_ivalue_tpcode_index on tenant_identifier_binding (identifier_code ASC,identifier_value ASC,third_party_code ASC);




-- Table: tenant_individual
CREATE TABLE tenant_individual (
    id bigserial  NOT NULL,
    first_name varchar(200)  NULL,
    last_name varchar(200)  NULL,
    birth_date date  NULL,
    gender varchar(30)  NULL,
    nick_name varchar(200)  NULL,
    tenant_id bigint  NULL,
    country varchar(30)  NULL,
    state varchar(30)  NULL,
    city varchar(30)  NULL,
    district varchar(30)  NULL,
    address_line varchar(200)  NULL,
    phone varchar(30)  NULL,
    email varchar(200)  NULL,
    create_time timestamp  NULL,
    update_time timestamp  NULL,
    create_by bigint  NULL,
    update_by bigint  NULL,
    CONSTRAINT tenant_individual_pk PRIMARY KEY (id)
);

CREATE INDEX tenant_individual_tenant_id_index on tenant_individual (tenant_id ASC);




-- Table: tenants
CREATE TABLE tenants (
    id bigserial  NOT NULL,
    oid uuid  NOT NULL,
    tenant_name varchar(30)  NULL,
    type varchar(30)  NULL,
    status varchar(30)  NULL,
    data_center_id bigint  NOT NULL,
    doc_shard_id bigint  NOT NULL,
    create_time timestamp  NULL,
    update_time timestamp  NULL,
    create_by bigserial  NULL,
    update_by bigserial  NULL,
    CONSTRAINT tenants_pk PRIMARY KEY (id)
);

CREATE INDEX tenants_oid_index on tenants (oid ASC);


CREATE INDEX tenants_dci_dsi_index on tenants (data_center_id ASC,doc_shard_id ASC);




-- Table: ubl_documents
CREATE TABLE ubl_documents (
    id bigserial  NOT NULL,
    xml_doc_id uuid  NULL,
    document_id bigint  NULL,
    status varchar(30)  NULL,
    create_time timestamp  NULL,
    update_time timestamp  NULL,
    create_by bigint  NULL,
    update_by bigint  NULL,
    CONSTRAINT ubl_documents_pk PRIMARY KEY (id)
);

CREATE INDEX txd_xml_doc_id_index on ubl_documents (xml_doc_id ASC);


CREATE INDEX txd_document_id_index on ubl_documents (document_id ASC);




-- Table: users
CREATE TABLE users (
    id bigserial  NOT NULL,
    oid uuid  NULL,
    email varchar(200)  NULL,
    phone varchar(30)  NULL,
    password varchar(200)  NULL,
    username varchar(200)  NULL,
    kind varchar(30)  NULL,
    status varchar(30)  NULL,
    login_time timestamp  NULL,
    reset_password_time timestamp  NULL,
    tenant_id bigint  NOT NULL,
    update_time timestamp  NULL,
    create_time timestamp  NULL,
    carete_by bigint  NULL,
    update_by bigint  NULL,
    CONSTRAINT users_pk PRIMARY KEY (id)
);

CREATE INDEX users_email_index on users (email ASC);


CREATE INDEX users_phone_index on users (phone ASC);


CREATE INDEX users_tenant_id_index on users (tenant_id ASC);


CREATE INDEX users_oid_index on users (oid ASC);




-- Table: users_lookup
CREATE TABLE users_lookup (
    id bigserial  NOT NULL,
    user_name varchar(200)  NOT NULL,
    email varchar(200)  NOT NULL,
    phone varchar(30)  NOT NULL,
    data_center_id bigint  NOT NULL,
    tenant_id bigint  NOT NULL,
    create_time timestamp  NOT NULL,
    update_time timestamp  NOT NULL,
    create_by bigint  NOT NULL,
    insert_by bigint  NOT NULL,
    CONSTRAINT users_lookup_pk PRIMARY KEY (id)
);

CREATE INDEX users_lookup_email_index on users_lookup (email ASC);


CREATE INDEX users_lookup_phone_index on users_lookup (phone ASC);








-- foreign keys
-- Reference:  customers_customer_business (table: tenant_business)

ALTER TABLE tenant_business ADD CONSTRAINT customers_customer_business
    FOREIGN KEY (tenant_id)
    REFERENCES tenants (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  customers_customer_individual (table: tenant_individual)

ALTER TABLE tenant_individual ADD CONSTRAINT customers_customer_individual
    FOREIGN KEY (tenant_id)
    REFERENCES tenants (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  documents_identifier_binding_documents (table: documents_identifier_binding)

ALTER TABLE documents_identifier_binding ADD CONSTRAINT documents_identifier_binding_documents
    FOREIGN KEY (document_id)
    REFERENCES documents (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  documents_ofd_documents (table: ofd_documents)

ALTER TABLE ofd_documents ADD CONSTRAINT documents_ofd_documents
    FOREIGN KEY (document_id)
    REFERENCES documents (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  documents_tenants (table: documents)

ALTER TABLE documents ADD CONSTRAINT documents_tenants
    FOREIGN KEY (tenant_id)
    REFERENCES tenants (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  email_verification_tokens_users (table: email_verification_tokens)

ALTER TABLE email_verification_tokens ADD CONSTRAINT email_verification_tokens_users
    FOREIGN KEY (user_id)
    REFERENCES users (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  mobile_verification_tokens_users (table: mobile_verification_tokens)

ALTER TABLE mobile_verification_tokens ADD CONSTRAINT mobile_verification_tokens_users
    FOREIGN KEY (user_id)
    REFERENCES users (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  tenant_identifier_binding_tenants (table: tenant_identifier_binding)

ALTER TABLE tenant_identifier_binding ADD CONSTRAINT tenant_identifier_binding_tenants
    FOREIGN KEY (tenant_id)
    REFERENCES tenants (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  tenant_signed_documents_lp_documents (table: pdf_documents)

ALTER TABLE pdf_documents ADD CONSTRAINT tenant_signed_documents_lp_documents
    FOREIGN KEY (document_id)
    REFERENCES documents (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  tenant_third_party_tenants (table: tenant_credentials)

ALTER TABLE tenant_credentials ADD CONSTRAINT tenant_third_party_tenants
    FOREIGN KEY (tenant_id)
    REFERENCES tenants (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  tenant_xml_documents_lp_documents (table: ubl_documents)

ALTER TABLE ubl_documents ADD CONSTRAINT tenant_xml_documents_lp_documents
    FOREIGN KEY (document_id)
    REFERENCES documents (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference:  users_tenants (table: users)

ALTER TABLE users ADD CONSTRAINT users_tenants
    FOREIGN KEY (tenant_id)
    REFERENCES tenants (id)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;






-- End of file.

