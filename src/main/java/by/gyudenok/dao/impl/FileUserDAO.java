package by.gyudenok.dao.impl;

import by.gyudenok.dao.DAO;
import by.gyudenok.domain.Role;
import by.gyudenok.domain.User;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;

public class FileUserDAO implements DAO<User> {

    private static final String filePath = "C:\\Users\\DELL\\Desktop\\JavaJunior\\src\\main\\resources\\users";
    private File file = new File(filePath);
    private FileWriter fr = null;

    @Override
    public void create(User user) throws IOException {
        try {
            fr = new FileWriter(file,true);
            fr.write(user.getUserId() +
                    " " + user.getName() +
                    " " + user.getSurname() +
                    " " + user.getEmail() +
                    " ");
            for(int i = 0; i < user.getPhones().size(); i++){
                fr.write(user.getPhones().get(i) + " ");
            }
            for(int i = 0; i < user.getRoles().size(); i++){
                fr.write(user.getRoles().get(i) + " ");
            }
            fr.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User read(int id) throws IOException {
        String s = Files.readAllLines(Paths.get(filePath)).get(id);
        s = s.trim();
        List<String> sss = Arrays.asList(s.split(" "));
        User user = new User();
        user.setUserId(Integer.valueOf(sss.get(0)));
        user.setSurname(sss.get(1));
        user.setEmail(sss.get(2));
        user.setName(sss.get(3));
        int i = 4;
        ArrayList<String> arr = new ArrayList();
        while (sss.get(i).startsWith("375")){
            arr.add(sss.get(i));
            i++;
        }
        user.setPhones(arr);

        ArrayList<Role> roles = new ArrayList<>();
        while (i < sss.size()){
            roles.add(Role.valueOf(sss.get(i)));
            i++;
        }
        user.setRoles(roles);
        return user;
    }

    @Override
    public User read(User user) {
        return null;
    }

    @Override
    public User readAll() {
        return null;
    }

    @Override
    public void update(User user, int id) throws IOException {
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(User user) {

    }
}
