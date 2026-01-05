package nexed.com.nexed.models;

import nexed.com.nexed.exceptions.InvalidUserAttributeException;

public class FamilyMember extends NexUser {
    private String[] linkedStudentIds;
    public FamilyMember(String username, String email, String[] linkedStudentIds) throws InvalidUserAttributeException {
        super(username, email);
        this.linkedStudentIds = linkedStudentIds;
    }
     // role => using abstract method from NexUser
    @Override
    public String getRolePermission() {
        return "READ_ONLY";
    }
}
