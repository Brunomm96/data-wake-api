package br.com.datawake.datawakeapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.internal.util.StringHelper;

import javax.lang.model.element.Name;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "Acompanhamento_PPAP_Qualidade")
public class FtpPPAP {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CUSTOMER")
    private String customer;

    @Column(name = "PROJECT_NAME")
    private String project_Name;

    @Column(name = "BUSINESS")
    private String business;

    @Column(name = "CUSTOMER_CODE")
    private String customer_Code;

    @Column(name = "PARANOÁ_CODE")
    private String paranoa_Code;

    @Column(name = "LEVEL_CURRENT")
    private String level_current;

    @Column(name = "DAY_PPAP_SUBMISSION")
    private String day_Ppap_Submission;

    @Column(name = "DAY_PPAP_APPROVAL")
    private String day_Ppap_Approval;

    @Column(name = "COMMENT")
    private  String comment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FtpPPAP that = (FtpPPAP) o;
        return id.equals(that.id);	}

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getCustomer() {return customer;}
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getProject_Name(){ return project_Name; }
    public void setProject_Name(String project_Name) { this.project_Name = project_Name; }

    public String getBusiness() {
        return business;
    }
    public void setBusiness(String business) {
        this.business = business;
    }

    public String getCustomer_Code() {
        return customer_Code;
    }
    public void setCustomer_Code(String customer_Code) {
        this.customer_Code = customer_Code;
    }

    public String getParanoa_Code() {
        return paranoa_Code;
    }
    public void setParanoa_Code(String paranoa_Code) {
        this.paranoa_Code = paranoa_Code;
    }

    public String getLevel_current() {
        return level_current;
    }
    public void setLevel_current(String level_current) {
        this.level_current = level_current;
    }

    public String getDay_Ppap_Submission() {
        return day_Ppap_Submission;
    }
    public void setDay_Ppap_Submission(String day_Ppap_Submission) {
        this.day_Ppap_Submission = day_Ppap_Submission;
    }

    public String getDay_Ppap_Approval() {
        return day_Ppap_Approval;
    }
    public void setDay_Ppap_Approval(String day_Ppap_Approval) {
        this.day_Ppap_Approval = day_Ppap_Approval;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) { this.comment = comment; }

    public void setId(Long id) {this.id = id;}
    public Long getId() {
        return id;
    }
}

