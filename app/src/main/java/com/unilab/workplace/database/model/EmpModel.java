package com.unilab.workplace.database.model;

public class EmpModel {


    String emp_id;
    String emp_birthdate;
    String status;
    String emp_created;
    String emp_agreement;
    String emp_readterms;
    String emp_modified;

    public String getEmp_modified() {
        return emp_modified;
    }

    public void setEmp_modified(String emp_modified) {
        this.emp_modified = emp_modified;
    }




    String _id;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_birthdate() {
        return emp_birthdate;
    }

    public void setEmp_birthdate(String emp_birthdate) {
        this.emp_birthdate = emp_birthdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmp_created() {
        return emp_created;
    }

    public void setEmp_created(String emp_created) {
        this.emp_created = emp_created;
    }

    public String getEmp_agreement() {
        return emp_agreement;
    }

    public void setEmp_agreement(String emp_agreement) {
        this.emp_agreement = emp_agreement;
    }

    public String getEmp_readterms() {
        return emp_readterms;
    }

    public void setEmp_readterms(String emp_readterms) {
        this.emp_readterms = emp_readterms;
    }

    @Override
    public String toString() {
        return "EmpModel{" +
                "emp_id='" + emp_id + '\'' +
                ", emp_birthdate='" + emp_birthdate + '\'' +
                ", status='" + status + '\'' +
                ", emp_created='" + emp_created + '\'' +
                ", emp_agreement='" + emp_agreement + '\'' +
                ", emp_readterms='" + emp_readterms + '\'' +
                ", emp_modified='" + emp_modified + '\'' +
                ", _id='" + _id + '\'' +
                '}';
    }
}
