package com.bwts.model;

import com.bwts.utils.BigDecimalAdapter;
import com.bwts.utils.TimestampAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@XmlRootElement(name = "invoiceRecord")
@XmlAccessorType(XmlAccessType.FIELD)
public class DocumentModel extends BaseObject{
    @XmlAttribute(name = "invoiceId")
    private Long invoiceId;
    @XmlAttribute(name = "documentId")
    private UUID documentId;
    @XmlAttribute(name = "pdfStatus")
    private DocumentStatus pdfStatus;
    @XmlAttribute(name = "ofdId")
    private UUID ofdId;
    @XmlAttribute(name = "ofdStatus")
    private DocumentStatus ofdStatus;
    @XmlAttribute(name = "flag")
    private boolean flag;
    @XmlAttribute(name = "invoiceType")
    private String invoiceType;
    @XmlAttribute(name = "invoiceNumber")
    private String invoiceNumber;
    @XmlAttribute(name = "invoiceCode")
    private String invoiceCode;
    @XmlAttribute(name = "invoiceIssueReqSeqNumber")
    private String invoiceIssueReqSeqNumber;
    @XmlAttribute(name = "supplierName")
    private String supplierName;
    @XmlAttribute(name = "supplierBankAccount")
    private String supplierBankAccount;
    @XmlAttribute(name = "buyerName")
    private String buyerName;
    @XmlAttribute(name = "buyerBankAccount")
    private String buyerBankAccount;
    @XmlAttribute(name = "buyerEmail")
    private String buyerEmail;
    @XmlAttribute(name = "buyerPhone")
    private String buyerPhone;
    @XmlElement(name = "Created")
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    private Timestamp issueTime;
    @XmlAttribute(name = "issuerName")
    private String issuerName;
    @XmlAttribute(name = "totalExcTax")
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    private BigDecimal totalExcTax;
    @XmlAttribute(name = "totalTax")
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    private BigDecimal totalTax;
    @XmlAttribute(name = "totalIncTax")
    @XmlJavaTypeAdapter(BigDecimalAdapter.class)
    private BigDecimal totalIncTax;
    @XmlAttribute(name = "thirdPartyCode")
    private String thirdPartyCode;
    @XmlAttribute(name = "supplierTaxNumber")
    private String supplierTaxNumber;

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public UUID getDocumentId() {
        return documentId;
    }

    public void setDocumentId(UUID documentId) {
        this.documentId = documentId;
    }

    public UUID getOfdId() {
        return ofdId;
    }

    public void setOfdId(UUID ofdId) {
        this.ofdId = ofdId;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierBankAccount() {
        return supplierBankAccount;
    }

    public void setSupplierBankAccount(String supplierBankAccount) {
        this.supplierBankAccount = supplierBankAccount;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerBankAccount() {
        return buyerBankAccount;
    }

    public void setBuyerBankAccount(String buyerBankAccount) {
        this.buyerBankAccount = buyerBankAccount;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public Timestamp getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Timestamp issueTime) {
        this.issueTime = issueTime;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public BigDecimal getTotalExcTax() {
        return totalExcTax;
    }

    public void setTotalExcTax(BigDecimal totalExcTax) {
        this.totalExcTax = totalExcTax;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public BigDecimal getTotalIncTax() {
        return totalIncTax;
    }

    public void setTotalIncTax(BigDecimal totalIncTax) {
        this.totalIncTax = totalIncTax;
    }

    public String getThirdPartyCode() {
        return thirdPartyCode;
    }

    public void setThirdPartyCode(String thirdPartyCode) {
        this.thirdPartyCode = thirdPartyCode;
    }

    public String getInvoiceIssueReqSeqNumber() {
        return invoiceIssueReqSeqNumber;
    }

    public void setInvoiceIssueReqSeqNumber(String invoiceIssueReqSeqNumber) {
        this.invoiceIssueReqSeqNumber = invoiceIssueReqSeqNumber;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getSupplierTaxNumber() {
        return supplierTaxNumber;
    }

    public void setSupplierTaxNumber(String supplierTaxNumber) {
        this.supplierTaxNumber = supplierTaxNumber;
    }

    public DocumentStatus getPdfStatus() {
        return pdfStatus;
    }

    public void setPdfStatus(DocumentStatus pdfStatus) {
        this.pdfStatus = pdfStatus;
    }

    public DocumentStatus getOfdStatus() {
        return ofdStatus;
    }

    public void setOfdStatus(DocumentStatus ofdStatus) {
        this.ofdStatus = ofdStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        DocumentModel that = (DocumentModel) o;

        if (flag != that.flag)
            return false;
        if (!invoiceId.equals(that.invoiceId))
            return false;
        if (!invoiceType.equals(that.invoiceType))
            return false;
        if (!invoiceNumber.equals(that.invoiceNumber))
            return false;
        if (!invoiceIssueReqSeqNumber.equals(that.invoiceIssueReqSeqNumber))
            return false;
        if (!invoiceCode.equals(that.invoiceCode))
            return false;
        if (supplierName != null ? !supplierName.equals(that.supplierName) : that.supplierName != null)
            return false;
        if (supplierBankAccount != null ?
                !supplierBankAccount.equals(that.supplierBankAccount) :
                that.supplierBankAccount != null)
            return false;
        if (!buyerName.equals(that.buyerName))
            return false;
        if (buyerBankAccount != null ? !buyerBankAccount.equals(that.buyerBankAccount) : that.buyerBankAccount != null)
            return false;
        if (buyerEmail != null ? !buyerEmail.equals(that.buyerEmail) : that.buyerEmail != null)
            return false;
        if (buyerPhone != null ? !buyerPhone.equals(that.buyerPhone) : that.buyerPhone != null)
            return false;
        if (issueTime != null ? !issueTime.equals(that.issueTime) : that.issueTime != null)
            return false;
        if (!issuerName.equals(that.issuerName))
            return false;
        if (!totalExcTax.equals(that.totalExcTax))
            return false;
        if (!totalTax.equals(that.totalTax))
            return false;
        if (thirdPartyCode != null ? !thirdPartyCode.equals(that.thirdPartyCode) : that.thirdPartyCode != null)
            return false;
        return totalIncTax.equals(that.totalIncTax);

    }

    @Override
    public int hashCode() {
        int result = invoiceId.hashCode();
        result = 31 * result + (flag ? 1 : 0);
        result = 31 * result + invoiceType.hashCode();
        result = 31 * result + invoiceNumber.hashCode();
        result = 31 * result + (supplierBankAccount != null ? supplierBankAccount.hashCode() : 0);
        result = 31 * result + buyerName.hashCode();
        result = 31 * result + (buyerBankAccount != null ? buyerBankAccount.hashCode() : 0);
        result = 31 * result + (buyerEmail != null ? buyerEmail.hashCode() : 0);
        result = 31 * result + (buyerPhone != null ? buyerPhone.hashCode() : 0);
        result = 31 * result + (invoiceIssueReqSeqNumber != null ? invoiceIssueReqSeqNumber.hashCode() : 0);
        result = 31 * result + (invoiceCode != null ? invoiceCode.hashCode() : 0);
        result = 31 * result + (issueTime != null ? issueTime.hashCode() : 0);
        result = 31 * result + issuerName.hashCode();
        result = 31 * result + totalExcTax.hashCode();
        result = 31 * result + totalTax.hashCode();
        result = 31 * result + totalIncTax.hashCode();
        result = 31 * result + thirdPartyCode.hashCode();
        return result;
    }

}