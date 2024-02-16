package edu.ucalgary.oop;

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
    private MedicalRecord[] medicalRecords;
    private FamilyRelation[] familyConnections;
    private String ENTRY_DATE;
    private Supply[] personalBelongings;
    private String gender;
    private int medicalRecordCount;
    private int familyConnectionCount;
    private int personalBelongingsCount;

    public DisasterVictim(String firstName, String ENTRY_DATE) {
        this.firstName = firstName;
        this.ENTRY_DATE = ENTRY_DATE;
        this.ASSIGNED_SOCIAL_ID = ++lastSocialID;
        this.medicalRecords = new MedicalRecord[10];
        this.familyConnections = new FamilyRelation[10];
        this.personalBelongings = new Supply[10];
    }

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
        return Arrays.copyOf(medicalRecords, medicalRecordCount);
    }

    public String getEntryDate() {
        return ENTRY_DATE;
    }

    public int getAssignedSocialID() {
        return ASSIGNED_SOCIAL_ID;
    }

    public Supply[] getPersonalBelongings() {
        return Arrays.copyOf(personalBelongings, personalBelongingsCount);
    }

    public FamilyRelation[] getFamilyConnections() {
        return Arrays.copyOf(familyConnections, familyConnectionCount);
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
        this.medicalRecords = medicalRecords;
        this.medicalRecordCount = medicalRecords.length;
    }

    public void setPersonalBelongings(Supply[] personalBelongings) {
        this.personalBelongings = personalBelongings;
        this.personalBelongingsCount = personalBelongings.length;
    }

    public void setFamilyConnections(FamilyRelation[] familyConnections) {
        this.familyConnections = familyConnections;
        this.familyConnectionCount = familyConnections.length;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void addPersonalBelonging(Supply supply) {
        if (personalBelongings.length == personalBelongingsCount) {
            personalBelongings = Arrays.copyOf(personalBelongings, personalBelongings.length * 2);
        }
        personalBelongings[personalBelongingsCount++] = supply;
    }

    public void removePersonalBelonging(Supply supply) {
        for (int i = 0; i < personalBelongingsCount; i++) {
            if (personalBelongings[i].equals(supply)) {
                for (int j = i; j < personalBelongingsCount - 1; j++) {
                    personalBelongings[j] = personalBelongings[j + 1];
                }
                personalBelongings[--personalBelongingsCount] = null;
                break;
            }
        }
    }

    public void addFamilyConnection(FamilyRelation familyConnection) {
        if (familyConnections.length == familyConnectionCount) {
            familyConnections = Arrays.copyOf(familyConnections, familyConnections.length * 2);
        }
        familyConnections[familyConnectionCount++] = familyConnection;
    }

    public void removeFamilyConnection(FamilyRelation familyConnection) {
        for (int i = 0; i < familyConnectionCount; i++) {
            if (familyConnections[i].equals(familyConnection)) {
                for (int j = i; j < familyConnectionCount - 1; j++) {
                    familyConnections[j] = familyConnections[j + 1];
                }
                familyConnections[--familyConnectionCount] = null;
                break;
            }
        }
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        if (medicalRecords.length == medicalRecordCount) {
            medicalRecords = Arrays.copyOf(medicalRecords, medicalRecords.length * 2);
        }
        medicalRecords[medicalRecordCount++] = medicalRecord;
    }

}
