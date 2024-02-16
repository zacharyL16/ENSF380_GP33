package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DisasterVictim {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String comments;
    private static int lastSocialID = 0;
    private int ASSIGNED_SOCIAL_ID;
    private ArrayList<MedicalRecord> medicalRecords;
    private ArrayList<FamilyRelation> familyConnections;
    private String ENTRY_DATE;
    private ArrayList<Supply> personalBelongings;
    private String gender;
    private static int counter;

    public DisasterVictim(String firstName, String ENTRY_DATE) {
        this.firstName = firstName;
        this.ENTRY_DATE = ENTRY_DATE;
        this.ASSIGNED_SOCIAL_ID = ++lastSocialID;
        this.medicalRecords = new ArrayList<>();
        this.familyConnections = new ArrayList<>();
        this.personalBelongings = new ArrayList<>();
    }

    // Getters and setters

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getComments() {
        return comments;
    }

    public MedicalRecord[] getMedicalRecords() {
        return medicalRecords.toArray(new MedicalRecord[0]);
    }

    public String getEntryDate() {
        return ENTRY_DATE;
    }

    public int getAssignedSocialID() {
        return ASSIGNED_SOCIAL_ID;
    }

    public Supply[] getPersonalBelongings() {
        return personalBelongings.toArray(new Supply[0]);
    }

    public FamilyRelation[] getFamilyConnections() {
        return familyConnections.toArray(new FamilyRelation[0]);
    }

    public String getGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(dateOfBirth, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format.");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setMedicalRecords(MedicalRecord[] medicalRecords) {
        this.medicalRecords = new ArrayList<>(Arrays.asList(medicalRecords));
    }

    public void setPersonalBelongings(Supply[] personalBelongings) {
        this.personalBelongings = new ArrayList<>(Arrays.asList(personalBelongings));
    }

    public void setFamilyConnections(FamilyRelation[] familyConnections) {
        this.familyConnections = new ArrayList<>(Arrays.asList(familyConnections));
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Other methods

    public void addPersonalBelonging(Supply supply) {
        personalBelongings.add(supply);
    }

    public void removePersonalBelonging(Supply supply) {
        personalBelongings.remove(supply);
    }

    public void addFamilyConnection(FamilyRelation familyConnection) {
        familyConnections.add(familyConnection);
    }

    public void removeFamilyConnection(FamilyRelation familyConnection) {
        familyConnections.remove(familyConnection);
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
    }
}
