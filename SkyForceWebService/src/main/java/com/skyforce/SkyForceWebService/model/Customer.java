package com.skyforce.SkyForceWebService.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer extends User {

    @Column(name = "AVATAR", nullable = false)
    private URL avatar;

    @Column(name = "DOB")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name = "HALA_PREFERNECE", nullable = false)
    private boolean halaPreference;

    @Column(name = "VEG_PREFERENCE", nullable = false)
    private boolean vegPreference;

    @Column(name = "REGIONAL_PREFERENCE", nullable = false)
    private String regionalPreference;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Plan> plans = new ArrayList<>();


    public Customer() {

    }

    public Customer(Long id, String firstName, String lastName, GenderEnm gender, String email, String password, URL avatar, Date dob, boolean halaPreference, boolean vegPreference, String regionalPreference) {
        super(id, firstName, lastName, gender, email, password);
        this.avatar = avatar;
        this.dob = dob;
        this.halaPreference = halaPreference;
        this.vegPreference = vegPreference;
        this.regionalPreference = regionalPreference;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + super.getId() +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                ", gender=" + super.getGender() +
                ", email='" + super.getEmail() + '\'' +
                ", avatar=" + avatar +
                ", dob=" + dob +
                ", halaPreference=" + halaPreference +
                ", vegPreference=" + vegPreference +
                ", regionalPreference='" + regionalPreference + '\'' +
                '}';
    }


    public URL getAvatar() {
        return avatar;
    }

    public void setAvatar(URL avatar) {
        this.avatar = avatar;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isHalaPreference() {
        return halaPreference;
    }

    public void setHalaPreference(boolean halaPreference) {
        this.halaPreference = halaPreference;
    }

    public boolean isVegPreference() {
        return vegPreference;
    }

    public void setVegPreference(boolean vegPreference) {
        this.vegPreference = vegPreference;
    }

    public String getRegionalPreference() {
        return regionalPreference;
    }

    public void setRegionalPreference(String regionalPreference) {
        this.regionalPreference = regionalPreference;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    public void addPlan(Plan plan) {
        plans.add(plan);
        plan.setCustomer(this);
    }

    public void removePlan(Plan plan) {
        plans.remove(plan);
        plan.setCustomer(null);
    }
}
