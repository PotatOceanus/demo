package com.example.demo;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.persistence.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table(name="app_user")
public class User {

    public static String getStringDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        String timestamp = df.format(new Date());
        return timestamp;
    }

    public ResponseEntity<HashMap> sendGetRequest(String Apiurl, String Name) {
        RestTemplate restTemplate = new RestTemplate();
        String url = Apiurl + Name;
        ResponseEntity<HashMap> str = restTemplate.exchange(url,HttpMethod.GET,null,HashMap.class);
        return str;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private int age;
    private String gender;
    private String nationality;
    private String tags;
    private String status = "active";
    private String created = getStringDate();
    private String updated = getStringDate();

    public Integer getId() { return id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        genAge(firstName);
        genGender(firstName);
        genNationality(firstName);
    }

    public int getAge() { return age;}
    private void genAge (String firstName){
        this.age = (int)sendGetRequest("https://api.agify.io?name=",firstName).getBody().get("age");
    }
    public void setAge (int age) {
        this.age = age;
    }

    public String getGender() { return gender;}
    private void genGender(String firstName){
        this.gender = (String)sendGetRequest("https://api.genderize.io?name=",firstName).getBody().get("gender");
    }
    public void setGender (String gender) {
        this.gender = gender;
    }

    public String getNationality() { return nationality;}
    private void genNationality(String firstName){
        List response = (List) sendGetRequest("https://api.nationalize.io?name=", firstName).getBody().get("country");
        HashMap response1;
        if (response.isEmpty()) {
            this.nationality = null;
        } else {
            response1 = (HashMap) response.get(1);
            this.nationality = (String) response1.get("country_id");
        }
    }
    public void setNationality (String nationality) {
        this.nationality = nationality;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getTags() { return tags; }
    public void setTags(List tagsIn) {
        String result = tagsIn.get(0) + ":" + tagsIn.get(1);
        this.tags = result;
    }

    public String getStatus() { return status; }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated() { return created; }
    public void setCreated() {
        this.created = getStringDate();
    }

    public String getUpdated() { return updated; }
    public void setUpdated() {
        this.updated = getStringDate();
    }
}
