package by.gyudenok.controller.validator;

import by.gyudenok.domain.Role;

public class RolesValidator {

    public boolean validateRole(final String hex) {
        String str = hex.toLowerCase();
        boolean flag = false;
        for(int i = 0; i < Role.values().length; i++){
            if(str.equals(Role.getById(i).getName())){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean validateAmountOfRoles(final int count) {
        return (count > 0 && count <= 3) ? true : false;
    }
}
